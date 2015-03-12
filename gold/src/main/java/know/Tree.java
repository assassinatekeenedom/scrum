package know;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

@Path("")
public class Tree extends API {

    {
        try {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(2);
            stripper.setEndPage(3);
            File in = new File("C:\\mepbm\\fourthage\\game143\\Turn06\\g143n03t006.pdf");
            File out = new File("output");
            stripper.writeText(new PDDocument(new COSDocument(in)),new FileWriter(out));
        } catch (IOException ex) {

        }
    }

    @GET
    @Path("/{callback}/open.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String open(@PathParam("callback") String callback, @PathParam("action") String action) throws UnsupportedEncodingException, MalformedURLException, Exception {
        System.out.println("OPEN CALLED");
        return "opened";
    }

    @GET
    @Path("/{callback}/close.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String close(@PathParam("callback") String callback, @PathParam("action") String action) throws UnsupportedEncodingException, MalformedURLException, Exception {
        System.out.println("CLOSE CALLED");
        return "closed";
    }

    @GET
    @Path("/{callback}/select.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String select(@PathParam("callback") String callback, @PathParam("action") String action) throws UnsupportedEncodingException, MalformedURLException, Exception {
        System.out.println("SELECT CALLED");
        return "selected";
    }

    @GET
    @Path("/{callback}/type.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String type(@PathParam("callback") String callback, @PathParam("action") String action) throws UnsupportedEncodingException, MalformedURLException, Exception {
        System.out.println("TYPE CALLED");
        return "typed";
    }

    @GET
    @Path("/{callback}/click.js")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String click(@PathParam("callback") String callback, @PathParam("action") String action) throws UnsupportedEncodingException, MalformedURLException, Exception {
        System.out.println("CLICK CALLED");
        return "click";
    }

    public static void main(String... args) {
        new Thread(new Root()).start();
    }

    public Tree() {
        super();
    }

    @QueryParam("target")
    private String target;

    @QueryParam("value")
    private String value;

    @Override
    public void run() {
        setProcess(getClass().getCanonicalName());
        setOrigin("http://localhost/");
        setPort(13371);
        super.run();
    }

}
