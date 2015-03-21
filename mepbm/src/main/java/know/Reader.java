package know;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
        return callback + "(" + images(pdfIn, pngOut) + ", " + content(pdfIn, new BufferedWriter(new OutputStreamWriter(System.out))) + ");";
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

    public static String images(String inputFile, String outputFile) throws IOException {
        List<PDPage> pdPages;
        try (PDDocument pdf = PDDocument.loadNonSeq(new File(inputFile), null)) {
            pdPages = pdf.getDocumentCatalog().getAllPages();
            int page = 0;
            for (PDPage pdPage : pdPages) {
                new Thread(new Page(new File(outputFile + inputFile.substring(inputFile.lastIndexOf("\\") + 1, inputFile.lastIndexOf(".pdf")) + "-" + ++page + ".png"), pdPage, page)).start();
            }
        }
        return "{'pdf':'" + inputFile + "', 'img':'" + outputFile + "', 'pages':" + pdPages.size() + "}";
    }

    public static String content(String inputFile, Writer out) {
        try {
            PDDocument pdf = PDDocument.load(new File(inputFile));
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(0);
            stripper.setEndPage(pdf.getNumberOfPages());
            stripper.writeText(pdf, out);
            out.flush();
            out.close();
            return "{'pdf':'" + inputFile + "', 'pages':" + pdf.getNumberOfPages() + "}";
        } catch (IOException ex) {
            return "{'IOException': '" + ex.getMessage() + "'}";
        }
    }

}
