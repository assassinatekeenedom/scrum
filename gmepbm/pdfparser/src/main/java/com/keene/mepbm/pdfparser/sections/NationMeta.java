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
        this.setGameInfo();
        this.setSpecialService();
        this.setVictoryPoints();
        this.setVictoryConditions();
        this.setTotalVictoryPoints();
        this.setSNAs();
        this.setNationNumber();
        this.setActiveTurn();
        this.setPlayerInfo();
        this.setAllegiance();
        this.setSeason();
        this.getData().nextToken();

        System.out.println(this.getData().getActiveNation().getGame());
    }

    /**
     * Add a Game to the MEthis.getData().
     * @param data
     * @param this.getData().getPersistence()
     */
    private void setGameInfo() {
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        String module = this.getData().getToken();
        this.getData().nextToken();
        int gameNumber = this.getData().isolateRightColumnNumber(this.getData().getToken(), "GAME #");
        this.getData().nextToken();
        Game game = new GameImpl();
        game.setModule(module);
        game.setNumber(gameNumber);
        this.getData().setActiveGame(game);

        String name = null;

        if (this.getData().getToken().contains("Eliminated")) {
            eliminated = true;
            name = this.getData().getToken().substring(this.getData().getToken().indexOf("--- ") + "--- ".length(), this.getData().getToken().indexOf(" Eliminated"));
        } else if (this.getData().getToken().contains("Won")) {
            winner = true;
        } else {
            name = this.getData().getToken();
        }
        Nation nation = new NationImpl();
        nation.setName(name);
        nation.setGame(game);
        this.getData().setActiveNation(nation);
        this.getData().getActiveNation().setGame(this.getData().getActiveGame());
        this.getData().nextToken();
    }

    /**
     * Update SpecialService for the ActiveNationTurn
     * @param data
     */
    private void setSpecialService() {
        if (this.getData().getToken().contains("Special Service Turn")) {
            specialService = true;
            this.getData().nextToken();
        }
    }

    /**
     * Update VictoryPoints for the ActiveNationTurn.
     * @param data
     */
    private void setVictoryPoints() {

        if (this.getData().getToken().contains(" Victory Points")) {
            while (this.getData().getToken().contains(" Victory Points")) {
                if (this.getData().getToken().contains("Army")) {
                    this.getData().nextToken();
                    vps.setArmy(Integer.parseInt(this.getData().getToken()));
                } else if (this.getData().getToken().contains("Character")) {
                    this.getData().nextToken();
                    vps.setCharacter(Integer.parseInt(this.getData().getToken()));
                } else if (this.getData().getToken().contains("Wealth")) {
                    this.getData().nextToken();
                    vps.setCharacter(Integer.parseInt(this.getData().getToken()));
                } else if (this.getData().getToken().contains("Population Center")) {
                    this.getData().nextToken();
                    vps.setPopulationCenter(Integer.parseInt(this.getData().getToken()));
                } else if (this.getData().getToken().contains("Individual")) {
                    this.getData().nextToken();
                    vps.setIndividual(Integer.parseInt(this.getData().getToken()));
                }
                this.getData().nextToken();
            }
        }
        vps.setNation(this.getData().getActiveNation());
    }

    /**
     * Add VictoryConditions to the ActiveNation.
     * @param data
     */
    private void setVictoryConditions() {
        while (!this.getData().getToken().contains("Special Nation Abilities")) {
            if (this.getData().getToken().contains("To ")) {
                String description = this.getData().getToken();
//                this.getData().getPersistence().getVcDAO().load(description, this.getData().getActiveNation(), this.getData().getActiveGame());
            }
            this.getData().nextToken();
            if (this.getData().getToken().contains("Top")) {
                this.getData().nextToken();
                this.getData().nextToken();
                break;
            }
        }
    }

    /**
     * Add TotalVictoryPoints to the ActiveNationTurn.
     * @param data
     */
    private void setTotalVictoryPoints() {
        if (this.getData().getToken().contains("Victory points      :")) {
            totalVictoryPoints = this.getData().isolateRightColumnNumber(this.getData().getToken(), "Victory points      :");
        } else if (this.getData().getToken().contains("Victory points")) {
            totalVictoryPoints = this.getData().isolateRightColumnNumber(this.getData().getToken(), "Final Victory Points:");
        }
    }

    /**
     * Add SNAs to the ActiveNation.
     * @param data
     * @param this.getData().getPersistence()
     */
    private void setSNAs() {
        if (this.getData().getToken().contains("Special Nation Abilities")) {
            this.getData().nextToken();
            while (!this.getData().getToken().contains("Game #          :")) {
                int number = Integer.parseInt(this.getData().getToken().substring(this.getData().getToken().indexOf("#") + 1, this.getData().getToken().indexOf("#") + 3));
                String description = this.getData().getToken().substring("          #XX ".length(), this.getData().getToken().length());
                SNA sna = new SNAImpl();
                sna.setNumber(number);
                sna.setDescription(description);
                sna.setNation(this.getData().getActiveNation());
                this.getData().nextToken();
            }
        }
        this.getData().nextToken();
    }

    /**
     * Add the Nation Number to the ActiveNation
     * @param data
     */
    private void setNationNumber() {
        this.getData().getActiveNation().setNumber(this.getData().isolateRightColumnNumber(this.getData().getToken(), "Player #        :"));
        this.getData().nextToken();
    }

    /**
     * Add the TurnNumber to the ActiveNationTurn.
     * @param data
     * @param this.getData().getPersistence()
     */
    private void setActiveTurn() {
        int turn = this.getData().isolateRightColumnNumber(this.getData().getToken(), "Turn #          :");
        TurnNumber number = new TurnNumberImpl();
        number.setGame(this.getData().getActiveGame());
        number.setNumber(turn);
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();

        NationTurn nationTurn = new NationTurnImpl();
        nationTurn.setNation(this.getData().getActiveNation());
        nationTurn.setTurnNumber(number);
        this.getData().setActiveNationTurn(nationTurn);
        nationTurn.setEliminated(eliminated);
        nationTurn.setWinner(winner);
        nationTurn.setSpecialService(specialService);
        nationTurn.setTotalVictoryPoints(totalVictoryPoints);

        vps.setNationTurn(this.getData().getActiveNationTurn());
        this.getData().getActiveNationTurn().setVictoryPoints(vps);

        this.getData().getActiveNationTurn().setNation(this.getData().getActiveNation());
        this.getData().getActiveNationTurn().setGame(this.getData().getActiveGame());
    }

    /**
     * Add Player Info to the ActiveNation
     * @param data
     * @param this.getData().getPersistence()
     */
    private void setPlayerInfo() {
        String name = this.getData().getToken().substring(0, this.getData().getToken().lastIndexOf(" "));
        int accountNumber = this.getData().isolateRightColumnNumber(this.getData().getToken(), name);
        Player player = new PlayerImpl();
        player.setAccountNumber(accountNumber);
        player.setName(name);
        this.getData().getActiveNation().setPlayer(player);
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
        this.getData().nextToken();
    }

    /**
     *
     * @param data
     * @param this.getData().getPersistence()
     */
    private void setAllegiance() {
        Allegiance allegiance = new AllegianceImpl();
        if (this.getData().getToken().indexOf("Dark") > 0) {
            allegiance.setAllegianceName("Dark Servant");
        } else if (this.getData().getToken().indexOf("Free") > 0) {
            allegiance.setAllegianceName("Free People");
        } else {
            allegiance.setAllegianceName("Neutral");
        }
        this.getData().getActiveNationTurn().setAllegiance(allegiance);
        this.getData().nextToken();
    }

    /**
     *
     * @param data
     * @param this.getData().getPersistence()
     */
    private void setSeason() {
        Season season = new SeasonImpl();
        season.setName(this.getData().isolateRightColumnString(this.getData().getToken(), "Season :"));
        this.getData().getActiveNationTurn().getTurnNumber().setSeason(season);
    }
}