package know.event.aspect;

import know.NIO;
import know.Virtual;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyWriting {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return NIO.getDataProvider();
    }

    @Test(dataProvider = "files")
    public void handle(Virtual node) {
        new VerifyResource(node.getFolder(), node.getName(), node.getType(), node.getContent()).run();
    }

    public VerifyWriting() {
    }


}
