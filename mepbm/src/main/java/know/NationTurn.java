package know;

import java.io.File;
import java.util.concurrent.Callable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class NationTurn implements Callable<String>, Runnable {

    private String pdf;
    private String content;

    public NationTurn() {
    }

    public NationTurn(String pdf) {
        this.pdf = pdf;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static NationTurn create(String pdf) {
        NationTurn turn = new NationTurn(pdf);
        turn.run();
        return turn;
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
            content = call();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
