package com.keene.pdfparser.mepbm.core.hibernate;

import com.keene.pdfparser.mepbm.state.impl.GamePDFs;
import com.keene.pdfparser.mepbm.state.impl.TurnPDF;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

public class SpringHibernateTest extends TestCase {

//<<<<<<< .mine
//    private static final String svnDirectory = "/home/mepbm/fourthAge/";
//    private static final String testFile = "/home/mepbm/fourthAge/game46/turn00/g046n12t000.pdf";
    private static final String testFile = "C://Users/Galen/Desktop/mepbm/mepbm/fourthAge/game46/turn00/g046n12t000.pdf";
    private static final String svnDirectory = "C://Users/Galen/Desktop/mepbm/mepbm/fourthAge/";
//=======
    private static final String svnDirectory = "/home/mepbm/fourthAge/";
    private static final String testFile1 = "/home/mepbm/fourthAge/game46/turn00/g046n12t000.pdf";
    private static final String testFile2 = "/home/mepbm/fourthAge/game46/turn00/g046n13t000.pdf";
    private static final String testFile3 = "/home/mepbm/fourthAge/game46/turn00/g046n14t000.pdf";
    private static final String testFile4 = "/home/mepbm/fourthAge/game46/turn00/g046n15t000.pdf";
    private static final String testFile5 = "/home/mepbm/fourthAge/game46/turn00/g046n16t000.pdf";
    private static final String testFile6 = "/home/mepbm/fourthAge/game46/turn00/g046n17t000.pdf";
    private static final String testFile7 = "/home/mepbm/fourthAge/game46/turn00/g046n18t000.pdf";
    private static final String testFile8 = "/home/mepbm/fourthAge/game46/turn00/g046n19t000.pdf";
    private static final String testFile9 = "/home/mepbm/fourthAge/game46/turn00/g046n20t000.pdf";
    private static final String testFile10 = "/home/mepbm/fourthAge/game46/turn00/g046n24t000.pdf";
    private static final String testFile11 = "/home/mepbm/fourthAge/game46/turn00/g046n25t000.pdf";
//    private static final String testFile = "C://Users/Galen/Desktop/mepbm/mepbm/fourthAge/game46/turn00/g046n12t000.pdf";
//    private static final String svnDirectory = "C://Users/Galen/Desktop/mepbm/mepbm/fourthAge/";

    public SpringHibernateTest(String testName) {
        super(testName);
    }

    public void testOnePDF() {
        TurnPDF pdf = new TurnPDF();
        List<String> single = new ArrayList<String>();
        single.add(testFile1);
        single.add(testFile2);
        single.add(testFile3);
        single.add(testFile4);
        single.add(testFile5);
        single.add(testFile6);
        single.add(testFile7);
        single.add(testFile8);
        single.add(testFile9);
        single.add(testFile10);
        single.add(testFile11);
        pdf.process(single);
        assertTrue(true);
    }

    public void xtestALLPDFs() {
        GamePDFs games = new GamePDFs();
        TurnPDF pdf = new TurnPDF();
        pdf.process(games.getPDFFilePaths(svnDirectory));
        assertTrue(true);
    }

    public void xtestSeePDFs() {
        GamePDFs games = new GamePDFs();
        for (String path : games.getPDFFilePaths(svnDirectory)) {
            System.out.println(path);
        }
    }

    /*
    public void testFakeWebapp() {
    XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
    GameDAO gameDAO = (GameDAO) beanFactory.getBean("gameDAO");
    Collection<Game> games = gameDAO.getGames();
    for(Game game : games){
    System.out.println("Game : " + game.getGameId() + " - " + game.getGameNumber());
    Collection<Nation> nations = game.getNations();
    for(Nation nation : nations){
    System.out.println("\tNation: " + nation.getNationId() + " - " + nation.getName() + " - " + nation.getNationNumber());
    }
    Collection<Player> players = game.getPlayers();
    Collection<TurnNumber> turnNumbers = game.getTurnNumbers();
    Collection<GameType> types = game.getGameTypes();

    }
    assertTrue(true);
    }

    public void xtestAll() {
    this.parseGames(this.getPDFFilePaths());
    assertTrue(true);
    }

    private Map<String, Game> parseGames(List<String> files) {
    Map<String, Game> games = new HashMap<String, Game>();
    try {
    int success = 0;
    int failure = 0;
    for (String file : files) {
    //System.out.println(file);
    Game game = null;
    if (file.indexOf("game48") > -1) {
    //System.out.println(file);
    if (games.containsKey("game48")) {
    game = games.get("game48");
    } else {
    games.put("game48", new GameImpl());
    game = games.get("game48");
    }
    } else if (file.indexOf("grudge44") > -1) {
    //System.out.println(file);
    if (games.containsKey("grudge44")) {
    game = games.get("grudge44");
    } else {
    games.put("grudge44", new GameImpl());
    game = games.get("grudge44");
    }
    } else if (file.indexOf("game43") > -1) {
    //System.out.println(file);
    if (games.containsKey("game43")) {
    game = games.get("game43");
    } else {
    games.put("game43", new GameImpl());
    game = games.get("game43");
    }
    } else if (file.indexOf("game45") > -1) {
    //System.out.println(file);
    if (games.containsKey("game45")) {
    game = games.get("game45");
    } else {
    games.put("game45", new GameImpl());
    game = games.get("game45");
    }
    } else if (file.indexOf("game49") > -1) {
    //System.out.println(file);
    if (games.containsKey("game49")) {
    game = games.get("game49");
    } else {
    games.put("game49", new GameImpl());
    game = games.get("game49");
    }
    } else if (file.indexOf("game42") > -1) {
    //System.out.println(file);
    if (games.containsKey("game42")) {
    game = games.get("game42");
    } else {
    games.put("game42", new GameImpl());
    game = games.get("game42");
    }
    } else if (file.indexOf("game41") > -1) {
    //System.out.println(file);
    if (games.containsKey("game41")) {
    game = games.get("game41");
    } else {
    games.put("game41", new GameImpl());
    game = games.get("game41");
    }
    }

    try{
    HibernateTurnPDFService.process(file);
    success++;
    }catch(Exception e){
    failure++;
    }
    }
    int total = (success + failure);
    double percentSuccessful = ((double) success / (double) total) * 100;
    double percentFailure = ((double) failure / (double) total) * 100;

    System.out.println("REPORT SUMMARY:");
    System.out.println("\tTOTAL PDFs: " + total);
    System.out.println("\tTotal Success: " + success);
    System.out.println("\tTotal Failure: " + failure);
    System.out.println("\t%Successful: " + percentSuccessful);
    System.out.println("\t%Failure: " + percentFailure);
    } catch (Exception e) {
    e.printStackTrace();
    }
    return games;
    }

    
     *
     */
}
