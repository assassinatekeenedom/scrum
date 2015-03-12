package know.event;

import know.NIO;
import java.util.Iterator;
import org.testng.annotations.DataProvider;

public class WriteProvider {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return NIO.getDataProvider();
    }

    public WriteProvider() {
    }

}
