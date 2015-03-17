package know;

import org.testng.annotations.Test;

public class ReadPDF {

    private static final String TARGET = "C:\\selenium\\game\\game143\\Turn00\\";
    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";

    private static final String pdfA = "g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testPrintPDF() {
        Reader.content(TARGET + pdfA);
    }

    @Test
    public void testPDFtoImage() {
        Reader.images(TARGET + pdfA, DESTINATION);
    }
}
