package know;

import java.util.List;
import org.testng.annotations.Test;

public class ReadPDF {

    private static final String DESTINATION = "C:\\selenium\\mepbm\\www\\";
    private static final String pdfA = "C:\\selenium\\game\\game143\\Turn00\\g143n05t000.pdf";

    public ReadPDF() {
    }

    @Test
    public void testNationTurn() throws Exception {
        NationTurn turn = NationTurn.create(pdfA);
        List<Character> toons = new CharacterSection(turn).call();
        System.out.println(toons);
    }
}
