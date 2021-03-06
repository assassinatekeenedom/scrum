package know.pdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class Turn {

    public static String read(String path) {
        try {
            PDDocument xpdf = PDDocument.loadNonSeq(new File(path), null);
            PDFTextStripper extract = new PDFTextStripper();
            extract.setStartPage(0);
            extract.setEndPage(xpdf.getNumberOfPages());
            return extract.getText(xpdf);
        } catch (IOException ex) {
        }
        return "Failed to read PDF at path: " + path;
    }

    public static List<Character> toons(String pdf) throws Exception {
        String ending = pdf.substring(pdf.indexOf("ORDERS GIVEN"), pdf.length());
        String[] lines = ending.split("\n");
        List toons = new ArrayList<Character>();
        for (String line : lines) {
            if (line.indexOf("Ranks") > 0) {
                String name = line.substring(0, line.indexOf(" Ranks"));
                String com = line.substring(line.indexOf("Command"), line.indexOf("Agent"));
                String agent = line.substring(line.indexOf("Agent"), line.indexOf("Emissary"));
                String emissary = line.substring(line.indexOf("Emissary"), line.indexOf("Mage"));
                String mage = line.substring(line.indexOf("Mage"), line.length());
                com = com.replaceAll("Command", "");
                agent = agent.replaceAll("Agent", "");
                emissary = emissary.replaceAll("Emissary", "");
                mage = mage.replaceAll("Mage", "");
                if (com.indexOf("(") > 0) {
                    com = com.substring(com.indexOf("(") + 1, com.indexOf(")"));
                }
                if (agent.indexOf("(") > 0) {
                    agent = agent.substring(agent.indexOf("(") + 1, agent.indexOf(")"));
                }
                if (emissary.indexOf("(") > 0) {
                    emissary = emissary.substring(emissary.indexOf("(") + 1, emissary.indexOf(")"));
                }
                if (mage.indexOf("(") > 0) {
                    mage = mage.substring(mage.indexOf("(") + 1, mage.indexOf(")"));
                }
                toons.add(new Character(name, Integer.parseInt(com.trim()), Integer.parseInt(agent.trim()), Integer.parseInt(emissary.trim()), Integer.parseInt(mage.trim())));

            }

        }
        return toons;
    }
}
