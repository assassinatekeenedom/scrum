package know;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CharacterSection implements Callable<List<Character>>, Runnable {

    private NationTurn turn;

    public CharacterSection() {
    }

    public CharacterSection(NationTurn turn) {
        this.turn = turn;
    }

    public NationTurn getTurn() {
        return turn;
    }

    public void setTurn(NationTurn turn) {
        this.turn = turn;
    }

    @Override
    public List<Character> call() throws Exception {
        String pdf = turn.getContent();
        String ending = pdf.substring(pdf.indexOf("ORDERS GIVEN"), pdf.length());
        String[] lines = ending.split("\n");
        List toons = new ArrayList<Character>();
        for (String line : lines) {
            if (line.indexOf("Ranks") > 0) {
                String name = line.substring(0, line.indexOf(" Ranks"));
                String com = line.substring(line.indexOf("Command"), line.indexOf("Agent"));
                String agent = line.substring(line.indexOf("Agent"), line.indexOf("Emissary"));
                String emissary = line.substring(line.indexOf("Emissary"), line.indexOf("Mage"));
                String mage = line.substring(line.indexOf("Mage"), line.length());
                com = com.replaceAll("Command", "");
                agent = agent.replaceAll("Agent", "");
                emissary = emissary.replaceAll("Emissary", "");
                mage = mage.replaceAll("Mage", "");
                toons.add(new Character(name, Integer.parseInt(com.trim()), Integer.parseInt(agent.trim()), Integer.parseInt(emissary.trim()), Integer.parseInt(mage.trim())));
            }
        }
        return toons;
    }

    @Override
    public void run() {
        try {
            call();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
