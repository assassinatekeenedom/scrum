package know.event;

import know.Worker;
import com.thoughtworks.selenium.Selenium;
import java.util.List;
import know.Event;

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
