package know;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;
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

    public static void images(String inputFile, String outputFile) {
        try {
            PDDocument pdf = PDDocument.loadNonSeq(new File(inputFile), null);
            List<PDPage> pdPages = pdf.getDocumentCatalog().getAllPages();
            int page = 0;
            for (PDPage pdPage : pdPages) {
                ++page;
                BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
                ImageIOUtil.writeImage(bim, "png", new FileOutputStream(new File(outputFile + inputFile.substring(inputFile.lastIndexOf("\\") + 1, inputFile.lastIndexOf(".pdf")) + "-" + page + ".png")), page);
            }
            pdf.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public static void content(String inputfile) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            PDDocument pdf = PDDocument.load(new File(inputfile));
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(0);
            stripper.setEndPage(pdf.getNumberOfPages());
            stripper.writeText(pdf, out);
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static final Map<String, StringBuilder> buffer = Collections.synchronizedMap(new HashMap());

    public void testPrintPDF() {
        if (pdfIn != null && pdfIn != "") {
            try {
                System.out.println("Considering: " + pdfIn);

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
                StringBuilder builder = new StringBuilder();
                PDDocument pdf = PDDocument.load(new File(pdfIn));
                Map<String, Integer> pages = pdf.getPageMap();
                System.out.println("Found Pages: " + pages);
                int page = -1;
                System.out.println("------------------");
                for (String pageKey : pages.keySet()) {
                    page = pages.get(pageKey);
                    System.out.println("\tPage [#" + page + "]");
                }
                System.out.println("------------------");
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setStartPage(0);
                stripper.setEndPage(pdf.getNumberOfPages());
                stripper.writeText(pdf, out);
                out.flush();
                out.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @GET
    @Path("/{callback}/{game}/{turn}.jsonp")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String write(@PathParam("callback") String callback, @PathParam("game") String game, @PathParam("turn") String turn) throws Exception {
        System.out.println("Find Game #" + game + " for turn #" + turn);
        return callback + "();";
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

}
