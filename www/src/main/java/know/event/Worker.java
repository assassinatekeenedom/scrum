package know.event;

import com.thoughtworks.selenium.Selenium;
import java.util.ArrayList;
import java.util.List;
import know.Action;
import know.Agent;
import know.Event;
import know.Goal;
import know.Image;
import know.Target;
import know.Value;

public class Worker extends ArrayList<Work> implements Work {

    @Override
    public List<Event> action(Selenium browser) {
        Event local = Event.get(Action.get(getClass().getCanonicalName()), Target.get(target), Value.get(value), Goal.get(user), Image.get(browser.captureScreenshotToString()));
        List<Event> all = new Agent("jsonp");
        all.add(local);
        for (Work command : this) {
            command.setUser(user);
            try {
                all.addAll(command.action(browser));
            } catch (Exception e) {
            }
        }
        return all;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public Worker() {
        this("", "");
    }

    public Worker(String target) {
        this(target, "");
    }

    public Worker(String target, String value) {
        this.target = target;
        this.value = value;
    }

    private String user;
    private String target;
    private String value;

}
