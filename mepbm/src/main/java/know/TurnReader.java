package know;

import java.io.File;
import java.io.IOException;
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
    @Path("/test.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String write() throws Exception {
        System.out.println("HELLO WORLD!");
        NationTurn turn = NationTurn.create(pdfA);
//        System.out.println("Callback (JSONP)" + callback + " of Game #" + game + " for turn #" + turn+ " for nation #" + nation);
        return  "jsonp(" + new CharacterSection(turn).call() + ");";
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
