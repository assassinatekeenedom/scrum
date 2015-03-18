package know;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.spi.LoggerContext;
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
        LoggerContext aspect = LogManager.getContext();
        Logger custom = LogManager.getLogger("custom-name");
        Marker mark = MarkerManager.getMarker("custom-mark");
        /**
         *
         * //communication aspect
         *
         * Message message = new ParameterizedMessage(pattern,params,Throwable);
         *
         * //communication role
         *
         *
         * //logging at event
         *
         * custom.log(Level, Marker, Message, Throwable);
         *
         */
    }
}
