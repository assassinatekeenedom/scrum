package com.keene.pdfparser.mepbm.persistence;

import com.keene.mepbm.core.Persistence;
import com.keene.mepbm.model.dao.AllegianceDAO;
import com.keene.mepbm.model.dao.ArmyDAO;
import com.keene.mepbm.model.dao.ArtifactDAO;
import com.keene.mepbm.model.dao.CharacterDAO;
import com.keene.mepbm.model.dao.ClimateDAO;
import com.keene.mepbm.model.dao.GameDAO;
import com.keene.mepbm.model.dao.HexDAO;
import com.keene.mepbm.model.dao.MarketDAO;
import com.keene.mepbm.model.dao.MarketPricesDAO;
import com.keene.mepbm.model.dao.NationDAO;
import com.keene.mepbm.model.dao.MessageDAO;
import com.keene.mepbm.model.dao.NationRelationDAO;
import com.keene.mepbm.model.dao.NationTurnDAO;
import com.keene.mepbm.model.dao.OrderDAO;
import com.keene.mepbm.model.dao.PlayerDAO;
import com.keene.mepbm.model.dao.PopulationCenterDAO;
import com.keene.mepbm.model.dao.RelationDAO;
import com.keene.mepbm.model.dao.ResourceDetailsDAO;
import com.keene.mepbm.model.dao.SNADAO;
import com.keene.mepbm.model.dao.SeasonDAO;
import com.keene.mepbm.model.dao.SpellDAO;
import com.keene.mepbm.model.dao.TerrainDAO;
import com.keene.mepbm.model.dao.TroopsDAO;
import com.keene.mepbm.model.dao.TurnNumberDAO;
import com.keene.mepbm.model.dao.UpkeepDAO;
import com.keene.mepbm.model.dao.VictoryConditionDAO;
import com.keene.mepbm.model.dao.VictoryPointsDAO;

public interface MEPersistence extends Persistence{
    
    public AllegianceDAO getAllegianceDAO();
    public GameDAO getGameDAO();
    public NationDAO getNationDAO();
    public NationTurnDAO getNationTurnDAO();
    public PlayerDAO getPlayerDAO();
    public SeasonDAO getSeasonDAO();
    public SNADAO getSnaDAO();
    public TurnNumberDAO getTurnNumberDAO();
    public VictoryConditionDAO getVcDAO();
    public NationRelationDAO getNationRelationDAO();
    public RelationDAO getRelationDAO();
    public ArmyDAO getArmyDAO();
    public ArtifactDAO getArtifactDAO();
    public CharacterDAO getCharacterDAO();
    public MessageDAO getMessageDAO();
    public OrderDAO getOrderDAO();
    public PopulationCenterDAO getPopulationCenterDAO();
    public HexDAO getHexDAO();
    public ResourceDetailsDAO getResourceDetailsDAO();
    public ClimateDAO getClimateDAO();
    public TerrainDAO getTerrainDAO();
    public MarketDAO getMarketDAO();
    public MarketPricesDAO getMarketPricesDAO();
    public TroopsDAO getTroopsDAO();
    public VictoryPointsDAO getVictoryPointsDAO();
    public SpellDAO getSpellDAO();
    public UpkeepDAO getUpkeepDAO();

}
