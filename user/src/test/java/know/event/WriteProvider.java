package know.event;

import know.IO;
import java.util.Iterator;
import org.testng.annotations.DataProvider;

public class WriteProvider {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return IO.getDataProvider();
    }

    public WriteProvider() {
    }

}
