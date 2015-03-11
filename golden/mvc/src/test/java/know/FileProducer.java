package know;

import java.util.Iterator;
import org.testng.annotations.DataProvider;

public class FileProducer {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return NIO.getDataProvider();
    }

    static {
        new Thread(new NIO()).start();
    }

    public FileProducer() {
    }

}
