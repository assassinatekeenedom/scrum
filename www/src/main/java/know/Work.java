package know;

import com.thoughtworks.selenium.Selenium;
import java.util.List;

public interface Work {

    public List<Event> action(Selenium action);

    public String getUser();

    public String getTarget();

    public String getValue();

    public void setUser(String url);

    public void setTarget(String target);

    public void setValue(String value);

}
