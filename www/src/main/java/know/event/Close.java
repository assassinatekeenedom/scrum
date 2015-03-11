package know.event;

import com.thoughtworks.selenium.Selenium;
import java.util.List;
import know.Event;

public class Close extends Worker {

    @Override
    public List<Event> action(Selenium browser) {
        List<Event> all = super.action(browser);
        browser.close();
        browser.stop();
        return all;
    }

    public Close() {
        super();
    }

}
