package assassinate;

import java.io.File;
import java.io.IOException;
import assassinate.bat.AsynchronousSocket;
import assassinate.bat.VirtualSocket;
import assassinate.bat.www.host.HTML;
import assassinate.bat.www.host.JSONP;

public class WWW {

    private static final File home = new File("C:/selenium/resource/target/virtual/www/js/");

    static {
        home.mkdirs();
    }

    private class HTML13371 extends AsynchronousSocket {

        @Override
        public void setCurrent(Virtual server) {
            setRoot(server.getRoot());
            setContext(server.getContext());
            setSocket(server.getSocket());
            super.setCurrent(server);
            run();
        }

        @Override
        public void run() {
            super.run();
            try {
                Process process = new ProcessBuilder(toString()).start();
                process.destroy();
            } catch (IOException ex) {
            }
        }
    }

    private class WWW13371 extends HTML {

        private VirtualSocket host = new VirtualSocket();
        private HTML13371 html = new HTML13371();

        @Override
        public void run() {
            host.setRoot("C:");
            host.setContext("/selenium/resource/target/virtual/");
            host.setSocket(13371);
            host.setCurrent(this);
            host.run();
            super.run();
        }

        @Override

        public void setCurrent(Virtual server) {
            super.setCurrent(server);
        }

    }

    private class JSONP13372 extends AsynchronousSocket {

        @Override
        public void run() {
            super.run();
            try {
                Process process = new ProcessBuilder(toString()).start();
                process.destroy();
            } catch (IOException ex) {
            }
        }
    }

    private class WWW13372 extends JSONP {

        @Override
        public void run() {
            setRoot("C:");
            setContext("/selenium/resource/target/virtual/");
            setSocket(13372);
            WWW13372 www = new WWW13372();
            setCurrent(www);
            super.run();
            JSONP13372 future = new JSONP13372();
            future.setRoot(getRoot());
            future.setContext(getContext());
            future.setSocket(getSocket());
            future.setCurrent(www);
            future.run();
        }
    }

}
