package know;

import java.io.File;

public enum XML implements Virtual {

    WWW(new IO("C:/selenium/golden/target/www", "index", "html", "<html>\n<head>\n<title>IO Client</title>\n<script src=\"js/script.js\" type = \"text/javascript\"></script>\n</head>\n<body></body>\n</html>"));

    private final Virtual virtual;

    XML(Virtual start) {
        virtual = start;
    }

    @Override
    public String toString() {
        return virtual.toString();
    }

    @Override
    public String getType() {
        return virtual.getType();
    }

    @Override
    public void setType(String type) {
        virtual.setType(type);
    }

    @Override
    public String getName() {
        return virtual.getName();
    }

    @Override
    public void setName(String name) {
        virtual.setName(name);
    }

    @Override
    public String getFolder() {
        return virtual.getFolder();
    }

    @Override
    public void setFolder(String folder) {
        virtual.setFolder(folder);
    }

    @Override
    public String getContent() {
        return virtual.getContent();
    }

    @Override
    public void setContent(String content) {
        virtual.setContent(content);
    }

    @Override
    public File call() throws Exception {
        return virtual.call();
    }

    @Override
    public void run() {
        virtual.run();
    }
}
