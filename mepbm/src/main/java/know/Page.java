package know;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;

public class Page implements Runnable {

    private final File file;
    private final PDPage pdPage;
    private final int page;

    public Page(File file, PDPage pdPage, int page) {
        this.file = file;
        this.pdPage = pdPage;
        this.page = page;
    }

    @Override
    public void run() {
        try {
            BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
            ImageIOUtil.writeImage(bim, "png", new FileOutputStream(file), page);
        } catch (IOException ex) {
        }
    }
}
