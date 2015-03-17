package com.keene.mepbm.pdfparser.sections;

import com.keene.mepbm.models.Allegiance;
import com.keene.mepbm.models.Game;
import com.keene.mepbm.models.Nation;
import com.keene.mepbm.models.NationTurn;
import com.keene.mepbm.models.Player;
import com.keene.mepbm.models.SNA;
import com.keene.mepbm.models.Season;
import com.keene.mepbm.models.TurnNumber;
import com.keene.mepbm.models.VictoryPoints;
import com.keene.mepbm.models.impl.AllegianceImpl;
import com.keene.mepbm.models.impl.GameImpl;
import com.keene.mepbm.models.impl.NationImpl;
import com.keene.mepbm.models.impl.NationTurnImpl;
import com.keene.mepbm.models.impl.PlayerImpl;
import com.keene.mepbm.models.impl.SNAImpl;
import com.keene.mepbm.models.impl.SeasonImpl;
import com.keene.mepbm.models.impl.TurnNumberImpl;
import com.keene.mepbm.models.impl.VictoryPointsImpl;

public final class NationMeta extends TurnPDFSection {

    private boolean eliminated = false;
    private boolean winner = false;
    private boolean specialService = false;
    private int totalVictoryPoints;
    private VictoryPoints vps = new VictoryPointsImpl();

    public NationMeta() {
    }

    @Override
    public final void process() {
        setGameInfo();
        setSpecialService();
        setVictoryPoints();
        setVictoryConditions();
        setTotalVictoryPoints();
        setSNAs();
        setNationNumber();
        setActiveTurn();
        setPlayerInfo();
        setAllegiance();
        setSeason();
        getData().nextToken();

        System.out.println(getData().getActiveNation().getGame());
    }

    /**
     * Add a Game to the MEgetData().
     * @param data
     * @param getData().getPersistence()
     */
    private void setGameInfo() {
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
        String module = getData().getToken();
        getData().nextToken();
        int gameNumber = getData().isolateRightColumnNumber(getData().getToken(), "GAME #");
        getData().nextToken();
        Game game = new GameImpl();
        game.setModule(module);
        game.setNumber(gameNumber);
        getData().setActiveGame(game);

        String name = null;

        if (getData().getToken().contains("Eliminated")) {
            eliminated = true;
            name = getData().getToken().substring(getData().getToken().indexOf("--- ") + "--- ".length(), getData().getToken().indexOf(" Eliminated"));
        } else if (getData().getToken().contains("Won")) {
            winner = true;
        } else {
            name = getData().getToken();
        }
        Nation nation = new NationImpl();
        nation.setName(name);
        nation.setGame(game);
        getData().setActiveNation(nation);
        getData().getActiveNation().setGame(getData().getActiveGame());
        getData().nextToken();
    }

    /**
     * Update SpecialService for the ActiveNationTurn
     * @param data
     */
    private void setSpecialService() {
        if (getData().getToken().contains("Special Service Turn")) {
            specialService = true;
            getData().nextToken();
        }
    }

    /**
     * Update VictoryPoints for the ActiveNationTurn.
     * @param data
     */
    private void setVictoryPoints() {

        if (getData().getToken().contains(" Victory Points")) {
            while (getData().getToken().contains(" Victory Points")) {
                if (getData().getToken().contains("Army")) {
                    getData().nextToken();
                    vps.setArmy(Integer.parseInt(getData().getToken()));
                } else if (getData().getToken().contains("Character")) {
                    getData().nextToken();
                    vps.setCharacter(Integer.parseInt(getData().getToken()));
                } else if (getData().getToken().contains("Wealth")) {
                    getData().nextToken();
                    vps.setCharacter(Integer.parseInt(getData().getToken()));
                } else if (getData().getToken().contains("Population Center")) {
                    getData().nextToken();
                    vps.setPopulationCenter(Integer.parseInt(getData().getToken()));
                } else if (getData().getToken().contains("Individual")) {
                    getData().nextToken();
                    vps.setIndividual(Integer.parseInt(getData().getToken()));
                }
                getData().nextToken();
            }
        }
        vps.setNation(getData().getActiveNation());
    }

    /**
     * Add VictoryConditions to the ActiveNation.
     * @param data
     */
    private void setVictoryConditions() {
        while (!getData().getToken().contains("Special Nation Abilities")) {
            if (getData().getToken().contains("To ")) {
                String description = getData().getToken();
//                getData().getPersistence().getVcDAO().load(description, getData().getActiveNation(), getData().getActiveGame());
            }
            getData().nextToken();
            if (getData().getToken().contains("Top")) {
                getData().nextToken();
                getData().nextToken();
                break;
            }
        }
    }

    /**
     * Add TotalVictoryPoints to the ActiveNationTurn.
     * @param data
     */
    private void setTotalVictoryPoints() {
        if (getData().getToken().contains("Victory points      :")) {
            totalVictoryPoints = getData().isolateRightColumnNumber(getData().getToken(), "Victory points      :");
        } else if (getData().getToken().contains("Victory points")) {
            totalVictoryPoints = getData().isolateRightColumnNumber(getData().getToken(), "Final Victory Points:");
        }
    }

    /**
     * Add SNAs to the ActiveNation.
     * @param data
     * @param getData().getPersistence()
     */
    private void setSNAs() {
        if (getData().getToken().contains("Special Nation Abilities")) {
            getData().nextToken();
            while (!getData().getToken().contains("Game #          :")) {
                int number = Integer.parseInt(getData().getToken().substring(getData().getToken().indexOf("#") + 1, getData().getToken().indexOf("#") + 3));
                String description = getData().getToken().substring("          #XX ".length(), getData().getToken().length());
                SNA sna = new SNAImpl();
                sna.setNumber(number);
                sna.setDescription(description);
                sna.setNation(getData().getActiveNation());
                getData().nextToken();
            }
        }
        getData().nextToken();
    }

    /**
     * Add the Nation Number to the ActiveNation
     * @param data
     */
    private void setNationNumber() {
        getData().getActiveNation().setNumber(getData().isolateRightColumnNumber(getData().getToken(), "Player #        :"));
        getData().nextToken();
    }

    /**
     * Add the TurnNumber to the ActiveNationTurn.
     * @param data
     * @param getData().getPersistence()
     */
    private void setActiveTurn() {
        int turn = getData().isolateRightColumnNumber(getData().getToken(), "Turn #          :");
        TurnNumber number = new TurnNumberImpl();
        number.setGame(getData().getActiveGame());
        number.setNumber(turn);
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();

        NationTurn nationTurn = new NationTurnImpl();
        nationTurn.setNation(getData().getActiveNation());
        nationTurn.setTurnNumber(number);
        getData().setActiveNationTurn(nationTurn);
        nationTurn.setEliminated(eliminated);
        nationTurn.setWinner(winner);
        nationTurn.setSpecialService(specialService);
        nationTurn.setTotalVictoryPoints(totalVictoryPoints);

        vps.setNationTurn(getData().getActiveNationTurn());
        getData().getActiveNationTurn().setVictoryPoints(vps);

        getData().getActiveNationTurn().setNation(getData().getActiveNation());
        getData().getActiveNationTurn().setGame(getData().getActiveGame());
    }

    /**
     * Add Player Info to the ActiveNation
     * @param data
     * @param getData().getPersistence()
     */
    private void setPlayerInfo() {
        String name = getData().getToken().substring(0, getData().getToken().lastIndexOf(" "));
        int accountNumber = getData().isolateRightColumnNumber(getData().getToken(), name);
        Player player = new PlayerImpl();
        player.setAccountNumber(accountNumber);
        player.setName(name);
        getData().getActiveNation().setPlayer(player);
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
        getData().nextToken();
    }

    /**
     *
     * @param data
     * @param getData().getPersistence()
     */
    private void setAllegiance() {
        Allegiance allegiance = new AllegianceImpl();
        if (getData().getToken().indexOf("Dark") > 0) {
            allegiance.setAllegianceName("Dark Servant");
        } else if (getData().getToken().indexOf("Free") > 0) {
            allegiance.setAllegianceName("Free People");
        } else {
            allegiance.setAllegianceName("Neutral");
        }
        getData().getActiveNationTurn().setAllegiance(allegiance);
        getData().nextToken();
    }

    /**
     *
     * @param data
     * @param getData().getPersistence()
     */
    private void setSeason() {
        Season season = new SeasonImpl();
        season.setName(getData().isolateRightColumnString(getData().getToken(), "Season :"));
        getData().getActiveNationTurn().getTurnNumber().setSeason(season);
    }
}