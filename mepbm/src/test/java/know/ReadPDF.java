package know;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";
    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testPDFtoImage() throws IOException {
        PDFTextStripper extract = new PDFTextStripper();
        extract.setStartPage(0);
        extract.setEndPage(pdf.getNumberOfPages());
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println(extract.getText(pdf));
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println("--------------------------");
    }
}
