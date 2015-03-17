package pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.annotations.Test;

public class ReadPDF {

//    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n03t000";
//    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n04t000";
    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";
//    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n06t000";

    public ReadPDF() {
    }

    @Test
    public void testPrintPDF() {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            PDDocument pdf = PDDocument.load(new File(INPUTFILE));
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setStartPage(0);
            stripper.setEndPage(pdf.getNumberOfPages());
            stripper.writeText(pdf, out);
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
