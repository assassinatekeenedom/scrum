package com.keene.mepbm;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.keene.mepbm.pdfparser.reader.METurnReader;
import java.io.IOException;
import org.junit.Test;

public class PDFReaderTest {

//    private static String INPUTFILE = "C:\\selenium\\gmepbm\\game143\\Turn00\\g143n03t000";
//    private static String INPUTFILE = "C:\\selenium\\gmepbm\\game143\\Turn00\\g143n04t000";
//    private static String INPUTFILE = "C:\\selenium\\gmepbm\\game143\\Turn00\\g143n05t000";
    private static String INPUTFILE = "C:\\selenium\\gmepbm\\game143\\Turn00\\g143n06t000";
//    private static String INPUTFILE = "C:\\mepbm\\fourthage\\game143\\Turn03\\g143n03t003";

    public PDFReaderTest() {
    }

    @Test
    public void testPrintPDF() {
        try {

            PdfReader reader = new PdfReader(INPUTFILE);
            int n = reader.getNumberOfPages();
            int i = 1;
            while (i <= n) {
                String output = PdfTextExtractor.getTextFromPage(reader, i);
                System.out.println(output);
                i++;
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testNationMetadata() {
        METurnReader reader = new METurnReader(INPUTFILE);
        reader.process();
    }
}
