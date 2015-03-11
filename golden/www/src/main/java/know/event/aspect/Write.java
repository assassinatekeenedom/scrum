package know.event.aspect;

import know.Aspect;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.net.URL;
import know.Worker;
import know.event.Click;
import know.event.Close;
import know.event.Open;
import know.event.Select;
import know.event.Type;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Write extends Worker implements Runnable {

    private String folder;
    private String name;
    private String type;
    private String content;

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

    @Override
    public void run() {
        Aspect aspect = Aspect.get(folder, name, type, content);
        try {
            URL rest = new URL("http://localhost/");
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            driver.manage().window().maximize();
            Selenium browser = new WebDriverBackedSelenium(driver, rest.getProtocol() + "://" + rest.getHost());
            setUser(driver.getSessionId().toString());
            add(new Open(rest.getPath()));
            add(new Select("//select[1]", "Add a new path."));
            add(new Type("//input", aspect.getFolder()));
            add(new Select("//select[2]", "Add a new path."));
            add(new Type("//input", aspect.getName() + "." + aspect.getType()));
            add(new Type("//textarea", aspect.getContent()));
            add(new Click("//input[@value=' Write ']"));
            add(new Close());
            super.action(browser);
        } catch (Exception ex) {
            System.out.println(ex.getCause() + " ..write.. " + ex.getMessage());
        }
    }

    public Write() {
    }

    public Write(String folder, String name, String type, String content) {
        this.folder = folder;
        this.name = name;
        this.type = type;
        this.content = content;
    }
}
