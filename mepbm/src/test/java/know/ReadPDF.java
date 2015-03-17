package know;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";

    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testPrintPDF() {
        System.out.println(Reader.content(pdfA, new BufferedWriter(new OutputStreamWriter(System.out))));
    }

    @Test
    public void testPDFtoImage() {
        System.out.println(Reader.images(pdfA, DESTINATION));
    }
}
