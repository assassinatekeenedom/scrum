package know.event.aspect;

import know.NIO;
import know.Virtual;
import java.util.Iterator;
import know.Aspect;
import know.Save;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Writing {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return NIO.getDataProvider();
    }

    @Test(dataProvider = "files")
    public void handle(Virtual node) {
        Aspect aspect = new Aspect();
        aspect.setFolder(node.getFolder());
        aspect.setName(node.getName());
        aspect.setType(node.getType());
        aspect.setContent(node.getContent());
        Save.setState(aspect);
        FileAspect file = new FileAspect();
        file.setId(aspect.getId());
    }

    public Writing() {
    }

}
