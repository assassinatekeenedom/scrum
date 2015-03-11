package know;

import java.io.File;
import know.io.Bat;
import know.io.Conf;
import know.io.HTML;
import know.io.JS;
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
public class NIO extends API {

    private static final Map<String, StringBuilder> buffer = Collections.synchronizedMap(new HashMap());

    public static File write(String folder, String name, String type, String content) {
        try {
            IO future = new IO(folder, name, type, content);
            return future.call();
        } catch (Exception ex) {
            System.out.println("EXCEPTION writing to file!");
            return null;
        }
    }

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
        return callback + "(" + write(folder, name, type, content).toPath() + ");";
    }

    @Override
    public void run() {
        setProcess(getClass().getCanonicalName());
        setOrigin("http://localhost/");
        setPort(13370);
        super.run();
    }

    public NIO() {
    }

    @QueryParam("path")
    private String folder;

    @QueryParam("append")
    private boolean append;

    @QueryParam("content")
    private String content;

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
