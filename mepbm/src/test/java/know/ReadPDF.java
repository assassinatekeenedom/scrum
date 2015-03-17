package know;

import org.testng.annotations.Test;

public class ReadPDF {

    private static final String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";
    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";

    public ReadPDF() {
    }

    @Test
    public void testPrintPDF() {
        Reader.content(INPUTFILE);
    }

    @Test
    public void testPDFtoImage() {
        Reader.images(INPUTFILE, DESTINATION);
    }
}
