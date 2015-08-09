package know;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripper;

@Path("")
public class TurnReader extends API {

    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

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
                toons.add(new Character(name, Integer.parseInt(com.trim()), Integer.parseInt(agent.trim()), Integer.parseInt(emissary.trim()), Integer.parseInt(mage.trim())));
            }
        }
        return toons;
    }

    @Override
    public void run() {
        setProcess(getClass().getCanonicalName());
        setOrigin("http://localhost/");
        setPort(13370);
        System.out.println("-----");
        super.run();
        System.out.println("-----");
    }

    @GET
    @Path("/{game}/{turn}/{nation}.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String write(@PathParam("game") String game, @PathParam("turn") String turn, @PathParam("nation") String file) throws Exception {
        String path = "C:\\mepbm\\games\\fourthage\\" + game + "\\" + turn + "\\" + file + ".pdf";
        System.out.println("HELLO WORLD ... path ...! " + path);
//        System.out.println("Callback (JSONP)" + callback + " of Game #" + game + " for turn #" + turn+ " for nation #" + nation);
        return "jsonp(" + TurnReader.toons(TurnReader.read(path)) + ");";
    }

    public TurnReader() {
    }

    @QueryParam("pdf")
    private String pdfIn;

    @QueryParam("png")
    private String pngOut;

    public static void main(String... args) {
        new Thread(new TurnReader()).start();
    }

    public static String text(String inputFile, String outputFile) throws IOException {
        List<PDPage> pdPages;
        try (PDDocument pdf = PDDocument.loadNonSeq(new File(inputFile), null)) {
            pdPages = pdf.getDocumentCatalog().getAllPages();
            int page = 0;
            for (PDPage pdPage : pdPages) {
                new Page(new File(outputFile + inputFile.substring(inputFile.lastIndexOf("\\") + 1, inputFile.lastIndexOf(".pdf")) + "-" + ++page + ".png"), pdPage, page, inputFile).run();
            }
            pdf.close();
        }
        return "{'pdf':'" + inputFile + "', 'img':'" + outputFile + "', 'pages':" + pdPages.size() + "}";
    }

    public static String images(String inputFile, String outputFile) throws IOException {
        List<PDPage> pdPages;
        try (PDDocument pdf = PDDocument.loadNonSeq(new File(inputFile), null)) {
            pdPages = pdf.getDocumentCatalog().getAllPages();
            int page = 0;
            for (PDPage pdPage : pdPages) {
                new Page(new File(outputFile + inputFile.substring(inputFile.lastIndexOf("\\") + 1, inputFile.lastIndexOf(".pdf")) + "-" + ++page + ".png"), pdPage, page, inputFile).run();
            }
        }
        return "{'pdf':'" + inputFile + "', 'img':'" + outputFile + "', 'pages':" + pdPages.size() + "}";
    }

}
