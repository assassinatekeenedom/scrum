package know;

import know.pdf.Character;
import java.util.List;
import know.pdf.Turn;
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";
    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn01\\g143n04t001.pdf";
//    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t004.pdf";

    public ReadPDF() {
    }

    @Test
    public void testNationTurn() throws Exception {
        List<Character> toons = Turn.toons(TurnReader.read(pdfA));
        System.out.println(toons);
    }
}
