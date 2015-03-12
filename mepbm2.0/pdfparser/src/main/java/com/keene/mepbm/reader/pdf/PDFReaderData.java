package com.keene.mepbm.reader.pdf;

import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfReader;
import com.keene.mepbm.model.Climate;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.Hex;
import com.keene.mepbm.model.Nation;
import com.keene.mepbm.model.NationTurn;
import com.keene.mepbm.model.Terrain;
import com.keene.mepbm.reader.METurnFileData;
import com.keene.mepbm.reader.METurnReaderData;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFReaderData extends METurnFileData {

    private Game activeGame;
    private NationTurn activeNationTurn;
    private Nation activeNation;
    
    private static final Pattern pattern = Pattern.compile("[^\\x20-\\x7e]");
    private static final String REPLACE = "?";
    private Parser parser;

    public PDFReaderData(METurnReaderData data) {
        super(data);
        parser = new Parser();
        try {            
            parser.setReader(new PdfReader(getPath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public String getPath(){
        return super.getPath()+".pdf";
    }

    public String nextToken() {
        return parser.nextToken();
    }

    public String getToken() {
        return parser.getToken();
    }

    public Nation getActiveNation() {
        return activeNation;
    }

    public void setActiveNation(Nation nation) {
        this.activeNation = nation;
    }

    public NationTurn getActiveNationTurn() {
        return activeNationTurn;
    }

    public void setActiveNationTurn(NationTurn nationTurn) {
        this.activeNationTurn = nationTurn;
    }

    public Game getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }
    public String removeSpecialCharacters(String string) {
        Matcher m = pattern.matcher(string);
        string = m.replaceAll(REPLACE);
        return string;
    }

    public int isolateRightColumnNumber(String token, String delete) {
        token = token.replaceAll(delete, "");
        token = token.replaceAll(" ", "");
        if (token.contains("(")) {
            token = token.substring(0, token.indexOf("("));
        }
        if (token.contains("+")) {
            token = token.substring(0, token.indexOf("+"));
        }
        char[] nbspCheck = token.substring(token.length() - 1).toCharArray();
        if (((int) nbspCheck[0]) == 160) {
            token = token.substring(0, token.length() - 1);
        }
        return Integer.parseInt(token);
    }

    public String isolateRightColumnString(String token, String delete) {
        token = token.replaceAll(delete, "");
        return token;
    }

    public final Hex parseLocation() {
        String token = parser.getToken();
        int hexNumber = (Integer.parseInt(token.substring(token.indexOf("Location : @ ") + 13, token.indexOf(" in "))));
        Terrain terrain = this.getPersistence().getTerrainDAO().load(token.substring(token.indexOf(" in ") + 4, token.indexOf("  Climate is")));
        Climate climate = this.getPersistence().getClimateDAO().load(token.substring(token.indexOf("Climate is ") + 11, token.length()));
        Hex hex = this.getPersistence().getHexDAO().load(hexNumber, climate, terrain);
        return hex;
    }

    private final class Parser implements Serializable {

        private PdfReader reader;
        private int activePage;
        private PRTokeniser tokenizer;
        private String currentToken;
        private Date dateRunOn;

        public Parser() {
        }

        public void setReader(PdfReader reader) {
            this.reader = reader;
            this.activePage = 0;
            this.nextPage();
            this.nextPage();
            this.currentToken = this.nextToken();
        }

        public final String nextToken() {
            try {
                while (this.tokenizer.nextToken()) {
                    String token = this.checkToken();
                    if (token != null) {
                        return token;
                    }
                }
                this.nextPage();
                if (this.tokenizer != null) {
                    return this.nextToken();
                }
            } catch (InvalidPdfException e) {
                return this.nextToken();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.currentToken = null;
            this.reader = null;
            this.tokenizer = null;
            return null;
        }

        private String checkToken() {
            if (this.tokenizer.getTokenType() == PRTokeniser.TokenType.STRING) {
                String token = this.tokenizer.getStringValue();
                if (token != null) {
                    return this.processToken(token);
                }
            }
            return null;
        }

        private String processToken(String token) {
            if (token.contains(" Game ") && token.contains(" Player ") && token.contains(" Turn ") && token.contains(" Page ")) {
                if (dateRunOn == null) {
                    this.calculateDate(token);
                }
                return this.nextToken();
            }
            this.currentToken = token;
            return this.currentToken;
        }

        private void calculateDate(String token) {
            String date = token.substring(token.indexOf("  "), token.indexOf("  Game "));
            date = date.replaceAll(" ", "");
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            try {
                this.dateRunOn = format.parse(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final void nextPage() {
            try {
                this.tokenizer = new PRTokeniser(reader.getPageContent(this.activePage));
                this.activePage++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public final String getToken() {
            return currentToken;
        }

        public final Date getDateRunOn() {
            return dateRunOn;
        }
    }
}
