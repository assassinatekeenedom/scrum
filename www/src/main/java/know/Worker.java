package know;

import com.thoughtworks.selenium.Selenium;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Worker extends ArrayList<Known> implements Runnable, Callable<Aspect>, Known {

    @Override
    public Aspect call() throws Exception {
        if (id > -1) {
            aspect = Aspect.get(id);
            new Thread(this).start();
            id = aspect.getId();
        }
        return aspect;
    }

    @Override
    public void run() {
        System.out.println("Working on ::: " + aspect);
    }

    @Override
    public List<Event> action(Selenium browser) {
        Event local = Event.get(Action.get(getClass().getCanonicalName()), Target.get(target), Value.get(value), Goal.get(user), Image.get(browser.captureScreenshotToString()));
        List<Event> all = new Agent("jsonp");
        all.add(local);
        for (Known command : this) {
            command.setUser(user);
            try {
                all.addAll(command.action(browser));
            } catch (Exception e) {
            }
        }
        return all;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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

    private Aspect aspect;
    private String user;
    private String target;
    private String value;
    private int id;

}
