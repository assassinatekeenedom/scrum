package know.event;

import com.thoughtworks.selenium.Selenium;
import java.util.List;
import know.Event;

public class Select extends Worker {

    @Override
    public List<Event> action(Selenium browser) {
        browser.select(getTarget(), getValue());
        return super.action(browser);
    }

    public Select(String target, String value) {
        super(target, value);
    }

}
