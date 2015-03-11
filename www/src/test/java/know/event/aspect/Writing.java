package know.event.aspect;

import know.NIO;
import know.Virtual;
import java.util.Iterator;
import know.Resource;
import know.event.Save;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Writing {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return NIO.getDataProvider();
    }

    @Test(dataProvider = "files")
    public void handle(Virtual node) {
        Resource aspect = new Resource();
        aspect.setFolder(node.getFolder());
        aspect.setName(node.getName());
        aspect.setType(node.getType());
        aspect.setContent(node.getContent());
        Save.set(aspect);
        FileResource file = new FileResource();
        file.setId(aspect.getId());
    }

    public Writing() {
    }

}
