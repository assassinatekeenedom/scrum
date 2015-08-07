package know;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";
    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testPDFtoImage() throws Exception {
        System.out.println(NationTurn.create(pdfA));
    }
}
