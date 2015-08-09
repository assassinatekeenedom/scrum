package know;

import java.util.List;
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";
    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n04t000.pdf";
//    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testNationTurn() throws Exception {
        List<Character> toons = TurnReader.toons(TurnReader.read(pdfA));
        System.out.println(toons);
    }
}
