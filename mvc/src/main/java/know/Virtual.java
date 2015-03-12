package know;

import java.io.File;
import java.util.concurrent.Callable;

public interface Virtual extends Callable<File>, Runnable {

    public String getType();

    public void setType(String type);

    public String getName();

    public void setName(String name);

    public String getFolder();

    public void setFolder(String folder);

    public String getContent();

    public void setContent(String content);
}
