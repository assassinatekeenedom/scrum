package pdf;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.ImageIOUtil;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.annotations.Test;

public class ReadPDF {

//    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n03t000";
//    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n04t000";
    private static String INPUTFILE = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";
    private static String DESTINATION = "C:\\selenium\\mepbm\\www\\";
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

    @Test
    public void testPDFtoImage() {
        try {
            PDDocument document = PDDocument.loadNonSeq(new File(INPUTFILE), null);
            List<PDPage> pdPages = document.getDocumentCatalog().getAllPages();
            int page = 0;
            for (PDPage pdPage : pdPages) {
                ++page;
                BufferedImage bim = pdPage.convertToImage(BufferedImage.TYPE_INT_RGB, 300);
                ImageIOUtil.writeImage(bim, "png", new FileOutputStream(new File(DESTINATION + INPUTFILE.substring(INPUTFILE.lastIndexOf("\\"), INPUTFILE.lastIndexOf(".pdf")) + "-" + page + ".png")), page);
            }
            document.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
