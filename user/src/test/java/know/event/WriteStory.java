package know.event;

import know.Virtual;
import know.Aspect;
import know.IO;
import know.Save;
import org.testng.annotations.Test;

public class WriteStory {

    static {
        new Thread(new IO()).start();
    }

    @Test(dataProvider = "files", dataProviderClass = WriteProvider.class)
    public void handle(Virtual node) throws Exception {
        Aspect aspect = new Aspect();
        aspect.setFolder(node.getFolder());
        aspect.setName(node.getName());
        aspect.setType(node.getType());
        aspect.setContent(node.getContent());
        Save.set(aspect);
        RestWork rest = new RestWork();
        rest.setId(aspect.getId());
        rest.call();
    }

    public WriteStory() {
    }

}
