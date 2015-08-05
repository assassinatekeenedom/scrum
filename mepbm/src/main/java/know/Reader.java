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
public class Reader extends API {

    @Override
    public void run() {
        setProcess(getClass().getCanonicalName());
        setOrigin("http://localhost/");
        setPort(13377);
        super.run();
    }

    @GET
    @Path("/{callback}.jsonp")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String write(@PathParam("callback") String callback) throws Exception {
        System.out.println("Find Game #" + pdfIn + " for turn #" + pngOut);
        return callback + "(" + images(pdfIn, pngOut) + ", " + images(pdfIn, pngOut) + ");";
    }

    public Reader() {
    }

    @QueryParam("pdf")
    private String pdfIn;

    @QueryParam("png")
    private String pngOut;

    public static void main(String... args) {
        new Thread(new Root()).start();
    }

    public static String text(String inputFile, String outputFile) throws IOException {
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

    public static String images(String inputFile, String outputFile) throws IOException {
        List<PDPage> pdPages;
        try (PDDocument pdf = PDDocument.loadNonSeq(new File(inputFile), null)) {
            
            PDFTextStripper extract = new PDFTextStripper();
            extract.setStartPage(0);
            extract.setEndPage(pdf.getNumberOfPages());
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            System.out.println(extract.getText(pdf));
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            pdPages = pdf.getDocumentCatalog().getAllPages();
            int page = 0;
            for (PDPage pdPage : pdPages) {
                new Page(new File(outputFile + inputFile.substring(inputFile.lastIndexOf("\\") + 1, inputFile.lastIndexOf(".pdf")) + "-" + ++page + ".png"), pdPage, page, inputFile).run();
            }
        }
        return "{'pdf':'" + inputFile + "', 'img':'" + outputFile + "', 'pages':" + pdPages.size() + "}";
    }

}
