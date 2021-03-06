package know.event;

import know.Aspect;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.net.URL;
import know.Save;
import know.Worker;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ValidWork extends Worker {

    private String folder;
    private String name;
    private String type;
    private String content;

    @Override
    public Aspect call() throws Exception {
        Aspect aspect = Aspect.get(folder, name, type, content);
        setId(aspect.getId());
        try {
            URL rest = new URL("http://localhost:121/");
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            driver.manage().window().maximize();
            Selenium browser = new WebDriverBackedSelenium(driver, rest.getProtocol() + "://" + rest.getHost() + ":" + rest.getPort() + "/");
            String user = driver.getSessionId().toString();
            setUser(user);
            StringBuilder builder = new StringBuilder();
            builder.append("!contents -R2 -g -p -f -h\n");
            builder.append("!path C:/selenium/mvc/target/*.jar\n");
            builder.append("!path C:/selenium/gold/target/*.jar\n");
            builder.append("!path C:/selenium/user/target/*.jar\n");
            builder.append("!path C:/selenium/www/target/*.jar\n");
            builder.append("!path C:/bin/hibernate/*.jar\n");
            builder.append("!path C:/bin/log4j/*.jar\n");
            builder.append("!path C:/bin/jackson/*.jar\n");
            builder.append("!path C:/bin/selenium/lib/*.jar\n");
            builder.append("!define TEST_SYSTEM {slim} \n|");
            String name = RestWork.class.getCanonicalName();
            System.out.println(Save.getJSON(aspect));
            builder.append(name);
            builder.append("|\n|id|call?|\n");
            builder.append("|");
            builder.append(aspect.getId());
            builder.append("|!-");
            builder.append(super.call());
            builder.append("-!|\n");
            String page = "/" + name + "." + user;
            add(new Open(page + "?edit"));
            add(new Type("id=pageContent", builder.toString()));
            add(new Click("name=save"));
            add(new Open(page + "?properties"));
            add(new Click("id=Test"));
            add(new Click("name=Save"));
            add(new Close());
            super.action(browser);
        } catch (Exception ex) {
            System.out.println(ex.getCause() + " .. VerifyAspect ERROR!! .. " + ex.getMessage());
        }
        return aspect;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ValidWork() {
    }

    public ValidWork(String folder, String name, String type, String content) {
        this.folder = folder;
        this.name = name;
        this.type = type;
        this.content = content;
    }

}
