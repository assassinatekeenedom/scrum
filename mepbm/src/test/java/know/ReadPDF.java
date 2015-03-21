package know;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";
    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testPDFtoImage() throws IOException {
        System.out.println(Reader.images(pdfA, DESTINATION));
        Logger custom = LogManager.getLogger("custom-name");
        Marker mark = MarkerManager.getMarker("custom-mark");
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        Layout layout = PatternLayout.createLayout(PatternLayout.SIMPLE_CONVERSION_PATTERN, config, null, null, true, true, null, null);
        Appender appender = FileAppender.createAppender("target/test.log", "false", "false", "File", "true", "false", "false", "4000", layout, null, "false", null, config);
        appender.start();
        config.addAppender(appender);
        AppenderRef ref = AppenderRef.createAppenderRef("File", null, null);
        AppenderRef[] refs = new AppenderRef[]{ref};
        LoggerConfig loggerConfig = LoggerConfig.createLogger("false", Level.INFO, "org.apache.logging.log4j", "true", refs, null, config, null);
        loggerConfig.addAppender(appender, null, null);
        config.addLogger("org.apache.logging.log4j", loggerConfig);
        ctx.updateLoggers();
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
