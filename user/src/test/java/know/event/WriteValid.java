package know.event;

import know.Virtual;
import org.testng.annotations.Test;

public class WriteValid {

    @Test(dataProvider = "files", dataProviderClass = WriteProvider.class)
    public void handle(Virtual node) throws Exception {
        new ValidWork(node.getFolder(), node.getName(), node.getType(), node.getContent()).call();
    }

    public WriteValid() {
    }

}
