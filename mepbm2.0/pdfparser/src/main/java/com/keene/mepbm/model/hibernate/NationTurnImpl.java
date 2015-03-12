package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.NationTurn;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="NationTurn")
public class NationTurnImpl implements Serializable, NationTurn<AllegianceImpl, NationImpl, TurnNumberImpl, VictoryPointsImpl, ResourceDetailsImpl, GameImpl, UpkeepImpl>, HibernateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nationTurnId;
    @Column
    private boolean eliminated;
    @Column
    private boolean winner;
    @Column
    private int totalVictoryPoints;
    @Column
    private long runOnDate;
    @Column
    private boolean specialService;
    @Column
    private int warships;
    @Column
    private int transports;
    @OneToOne
    private GameImpl game;

    @OneToOne
    private NationImpl nation;

    @OneToOne
    private ResourceDetailsImpl resourceDetails;

    @OneToOne
    private UpkeepImpl upkeep;

    @OneToOne
    private TurnNumberImpl turnNumber;
    
    @OneToOne
    private AllegianceImpl allegiance;

    @OneToOne
    private VictoryPointsImpl victoryPoints;

    public NationTurnImpl() {
    }

    @Override
    public AllegianceImpl getAllegiance() {
        return allegiance;
    }

    @Override
    public void setAllegiance(AllegianceImpl allegiance) {
        this.allegiance = allegiance;
    }

    @Override
    public int getNationTurnId() {
        return nationTurnId;
    }

    @Override
    public void setNationTurnId(int nationTurnId) {
        this.nationTurnId = nationTurnId;
    }

    @Override
    public TurnNumberImpl getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumberImpl turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public boolean isEliminated() {
        return eliminated;
    }

    @Override
    public void setEliminated(boolean eliminated) {
        this.eliminated = eliminated;
    }

    @Override
    public boolean isWinner() {
        return winner;
    }

    @Override
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    @Override
    public long getRunOnDate() {
        return runOnDate;
    }

    @Override
    public void setRunOnDate(long runOnDate) {
        this.runOnDate = runOnDate;
    }

    @Override
    public boolean isSpecialService() {
        return specialService;
    }

    @Override
    public void setSpecialService(boolean specialService) {
        this.specialService = specialService;
    }

    @Override
    public int getTotalVictoryPoints() {
        return totalVictoryPoints;
    }

    @Override
    public void setTotalVictoryPoints(int totalVictoryPoints) {
        this.totalVictoryPoints = totalVictoryPoints;
    }

    @Override
    public VictoryPointsImpl getVictoryPoints() {
        return victoryPoints;
    }

    @Override
    public void setVictoryPoints(VictoryPointsImpl victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    @Override
    public NationImpl getNation() {
        return nation;
    }

    @Override
    public void setNation(NationImpl nation) {
        this.nation = nation;
    }

    @Override
    public ResourceDetailsImpl getResourceDetails() {
        return resourceDetails;
    }

    @Override
    public void setResourceDetails(ResourceDetailsImpl resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    @Override
    public GameImpl getGame() {
        return game;
    }

    @Override
    public void setGame(GameImpl game) {
        this.game = game;
    }

    @Override
    public UpkeepImpl getUpkeep() {
        return upkeep;
    }

    @Override
    public void setUpkeep(UpkeepImpl upkeep) {
        this.upkeep = upkeep;
    }

    @Override
    public int getTransports() {
        return transports;
    }

    @Override
    public void setTransports(int transports) {
        this.transports = transports;
    }

    @Override
    public int getWarships() {
        return warships;
    }

    @Override
    public void setWarships(int warships) {
        this.warships = warships;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tNATION TURN INFO:");
        toString.append(" (id=");
        toString.append(this.getNationTurnId());
        toString.append(")\n");
        toString.append("\t\tEliminated? ");
        toString.append(this.isEliminated());
        toString.append("\n");
        toString.append("\t\tWinner? ");
        toString.append(this.isWinner());
        toString.append("\n");
        toString.append("\t\tTotal Victory Points: ");
        toString.append(this.getTotalVictoryPoints());
        toString.append("\n");
        toString.append("\t\tRun On Date: ");
        toString.append(this.getRunOnDate());
        toString.append("\n");
        toString.append("\t\tSpecial Service? ");
        toString.append(this.isSpecialService());
        toString.append("\n");
        toString.append(this.getVictoryPoints());
        toString.append(this.getUpkeep());
        toString.append(this.getResourceDetails());
        toString.append(this.getAllegiance());
        toString.append(this.getNation());
        return toString.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NationTurnImpl)) {
            return false;
        }
        NationTurnImpl toon = (NationTurnImpl) obj;
        if (this.getNationTurnId() == toon.getNationTurnId()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME * this.getNationTurnId();
    }
}
