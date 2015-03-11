package know.event;

import com.thoughtworks.selenium.Selenium;
import java.util.List;
import know.Event;
import know.Worker;

public class Type extends Worker {

    @Override
    public List<Event> action(Selenium browser) {
        browser.type(getTarget(), getValue());
        return super.action(browser);
    }

    public Type(String target, String value) {
        super(target, value);
    }

}
