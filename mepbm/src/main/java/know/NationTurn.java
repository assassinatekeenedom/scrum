package know;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class NationTurn implements Callable<String>, Runnable {

    private final String pdf;

    public NationTurn(String pdf) {
        this.pdf = pdf;
    }

    public static String create(String path) {
        try {
            return new NationTurn(path).call();
        } catch (Exception ex) {
            return "ROOT failure of NationTurn created";
        }
    }

    @Override
    public String call() throws Exception {
        PDDocument xpdf = PDDocument.loadNonSeq(new File(pdf), null);
        PDFTextStripper extract = new PDFTextStripper();
        extract.setStartPage(0);
        extract.setEndPage(xpdf.getNumberOfPages());
        return extract.getText(xpdf);
    }

    @Override
    public void run() {
        try {
            call();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("FAILED TO run");
        }
    }
}
