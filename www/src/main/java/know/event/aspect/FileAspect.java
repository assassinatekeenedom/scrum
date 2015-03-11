package know.event.aspect;

import know.Aspect;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.net.URL;
import know.Save;
import know.event.Worker;
import know.event.Click;
import know.event.Close;
import know.event.Open;
import know.event.Select;
import know.event.Type;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FileAspect extends Worker {

    public int setId(int id) {
        Aspect aspect = Save.getAspect(id);
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
        return aspect.getId();
    }

    public FileAspect() {
    }

}
