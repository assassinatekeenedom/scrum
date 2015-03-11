package know.event;

import com.thoughtworks.selenium.Selenium;
import java.util.List;
import know.Event;
import know.Worker;

public class Open extends Worker {

    @Override
    public List<Event> action(Selenium browser) {
        browser.open(getTarget());
        browser.waitForPageToLoad("100000");
        return super.action(browser);
    }

    public Open(String target) {
        super(target);
    }

}
