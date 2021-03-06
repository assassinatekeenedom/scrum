package know;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("")
public class Root extends API {

    private static final Map<String, StringBuilder> buffer = Collections.synchronizedMap(new HashMap());

    @GET
    @Path("/{callback}/{name}.{type}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String write(@PathParam("callback") String callback, @PathParam("name") String name, @PathParam("type") String type) throws Exception {
        String message = folder + "/" + name + "." + type;
        if (append) {
            if (!buffer.containsKey(message)) {
                buffer.put(message, new StringBuilder());
            }
            buffer.get(message).append(content);
            return callback + "();";
        }
        return callback + "(" + IO.write(folder, name, type, content).toPath() + ");";
    }

    @Override
    public void run() {
        setProcess(getClass().getCanonicalName());
        setOrigin("http://localhost/");
        setPort(13370);
        super.run();
    }

    public Root() {
    }

    @QueryParam("path")
    private String folder;

    @QueryParam("append")
    private boolean append;

    @QueryParam("content")
    private String content;

    public static void main(String... args) {
        new Thread(new Root()).start();
    }

    public static Iterator<Object[]> getDataProvider() {
        List<Object[]> all = new LinkedList();
        List<Virtual> files = new LinkedList();
        files.addAll(Arrays.asList(Bat.values()));
        files.addAll(Arrays.asList(Conf.values()));
        files.addAll(Arrays.asList(HTML.values()));
        files.addAll(Arrays.asList(JS.values()));
        for (Virtual file : files) {
            all.add(new Object[]{file});
        }
        return all.iterator();
    }

}
