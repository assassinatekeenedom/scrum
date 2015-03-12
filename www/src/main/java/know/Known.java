package know;

import com.thoughtworks.selenium.Selenium;
import java.util.List;
import java.util.concurrent.Callable;

public interface Known extends Runnable, Callable<Aspect> {

    public int getId();

    public void setId(int id);

    public List<Event> action(Selenium action);

    public String getUser();

    public String getTarget();

    public String getValue();

    public void setUser(String url);

    public void setTarget(String target);

    public void setValue(String value);

}
