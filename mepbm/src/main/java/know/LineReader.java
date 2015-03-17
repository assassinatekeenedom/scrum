package know;

import java.io.File;
import java.util.concurrent.Callable;

public interface LineReader extends Callable<File>, Runnable {

    public File getFile();

    public void setFile(File file);

}
