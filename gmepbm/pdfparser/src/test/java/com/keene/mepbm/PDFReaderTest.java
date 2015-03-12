package com.keene.mepbm;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.keene.mepbm.pdfparser.reader.METurnReader;
import java.io.IOException;
import org.junit.Test;

public class PDFReaderTest {

    private static String INPUTFILE = "/home/nate/Desktop/svn/mepbm/fourthAge/game47/Turn18/g047n12t018";

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
