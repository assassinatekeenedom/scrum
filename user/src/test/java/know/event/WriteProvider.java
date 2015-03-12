package know.event;

import java.util.Iterator;
import know.Root;
import org.testng.annotations.DataProvider;

public class WriteProvider {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return Root.getDataProvider();
    }

    public WriteProvider() {
    }

}
