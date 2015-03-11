package know;

import org.testng.annotations.Test;

public class RealFile {

    public RealFile() {
    }

    @Test(dataProvider = "files", dataProviderClass = FileProducer.class)
    public void setVirtual(Virtual node) throws Exception {
        node.call();
    }

}
