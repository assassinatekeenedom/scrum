package know.event;

import com.thoughtworks.selenium.Selenium;
import java.util.List;
import know.Event;

public class Click extends Worker {

    @Override
    public List<Event> action(Selenium browser) {
        browser.click(getTarget());
        return super.action(browser);
    }

    public Click(String target) {
        super(target);
    }

}
