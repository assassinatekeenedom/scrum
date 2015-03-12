package know.event;

import know.NIO;
import know.Virtual;
import java.util.Iterator;
import know.Aspect;
import know.Save;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WriteStory {

    @DataProvider(name = "files", parallel = true)
    public static Iterator<Object[]> files() {
        return NIO.getDataProvider();
    }

    @Test(dataProvider = "files")
    public void handle(Virtual node) throws Exception {
        Aspect aspect = new Aspect();
        aspect.setFolder(node.getFolder());
        aspect.setName(node.getName());
        aspect.setType(node.getType());
        aspect.setContent(node.getContent());
        Save.set(aspect);
        RestWork rest = new RestWork();
        rest.setId(aspect.getId());
        System.out.println(rest.call());
    }

    public WriteStory() {
    }

}
