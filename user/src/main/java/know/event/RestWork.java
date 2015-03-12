package know.event;

import know.Aspect;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import java.net.URL;
import know.Worker;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RestWork extends Worker {

    public RestWork() {
    }

    @Override
    public Aspect call() throws Exception {
        Aspect aspect = super.call();
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
            System.out.println(ex.getCause() + " ..RestWork ERROR!!.. " + ex.getMessage());
        }
        return aspect;
    }

}
