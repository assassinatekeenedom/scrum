package know;

import know.API;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("")
public class Story extends API {
    
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
    
    public Story() {
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
