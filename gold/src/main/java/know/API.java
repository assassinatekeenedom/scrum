package know;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

public class API extends Application implements Runnable {

    private int id;
    private String process;
    private String origin;
    private int port;

    public API() {
    }

    public API(String process, String origin, int port) {
        this.process = process;
        this.origin = origin;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            HttpContext context = server.createContext(UriBuilder.fromUri(origin).port(server.getAddress().getPort()).build().getPath());
            context.setHandler(RuntimeDelegate.getInstance().createEndpoint(this, HttpHandler.class));
            server.start();
        } catch (Exception ex) {
        }
    }

    public String call() {
        return toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String domain) {
        this.origin = domain;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet();
        s.add(this.getClass());
        return s;
    }

}
