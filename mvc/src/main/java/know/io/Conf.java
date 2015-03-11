package know.io;

import know.IO;
import java.io.File;
import know.Virtual;

public enum Conf implements Virtual {

    APACHE(new IO("C:/bin/apache/conf", "apache", "conf",
            "Listen 80\n"
            + "NameVirtualHost *:80\n"
            + "<VirtualHost *:80>\n"
            + "	ServerName localhost\n"
            + "	DocumentRoot C:/selenium/golden/target/www\n"
            + "	<Directory \"C:/selenium/golden/target/www\">\n"
            + "		Options Indexes FollowSymLinks\n"
            + "		AllowOverride None\n"
            + "		Order allow,deny\n"
            + "		Allow from all\n"
            + "	</Directory>\n"
            + "	ProxyPass /io/ http://localhost:13370/\n"
            + "	ProxyPassReverse /io http://localhost:13370\n"
            + "	ProxyPass /user/ http://localhost:13371/\n"
            + "	ProxyPassReverse /user http://localhost:13371\n"
            + "	ProxyPass /session/ http://localhost:13372/\n"
            + "	ProxyPassReverse /session http://localhost:13372\n"
            + "	ProxyPass /user-story/ http://localhost:82/\n"
            + "	ProxyPassReverse /user-story http://localhost:82\n"
            + "</VirtualHost>\n"
            + "Listen 82\n"
            + "NameVirtualHost *:82\n"
            + "<VirtualHost *:82>\n"
            + "	ServerName localhost\n"
            + "	DocumentRoot C:/selenium/golden/target/user-story\n"
            + "	<Directory \"C:/selenium/golden/target/user-story\">\n"
            + "		Options Indexes FollowSymLinks\n"
            + "		AllowOverride None\n"
            + "		Order allow,deny\n"
            + "		Allow from all\n"
            + "	</Directory>\n"
            + "</VirtualHost>\n"));

    private final Virtual virtual;

    Conf(Virtual start) {
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
}
