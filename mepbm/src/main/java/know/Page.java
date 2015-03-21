package know;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;
import org.apache.pdfbox.util.PDFTextStripper;

public class Page implements Runnable {

    private final File file;
    private final PDPage pdPage;
    private final int page;
    private final String inputFile;
    private final Writer out = new BufferedWriter(new OutputStreamWriter(System.out));

    public Page(File file, PDPage pdPage, int page, String inputFile) {
        this.file = file;
        this.pdPage = pdPage;
        this.page = page;
        this.inputFile = inputFile;
    }

    /**
     *
     */
    @Override
    public void run() {
        try {
            BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
            ImageIOUtil.writeImage(bim, "png", new FileOutputStream(file), page);
            PDDocument pdf = PDDocument.load(new File(inputFile));
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(page);
            stripper.setEndPage(page);
            stripper.writeText(pdf, out);
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
