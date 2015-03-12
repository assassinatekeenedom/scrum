package com.keene.pdfparser.mepbm.persistence.hibernate;

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
import com.keene.pdfparser.mepbm.persistence.MEPersistence;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringHibernatePersistence implements MEPersistence {

    private final GameDAO gameDAO;
    private final PlayerDAO playerDAO;
    private final NationDAO nationDAO;
    private final NationTurnDAO nationTurnDAO;
    private final SeasonDAO seasonDAO;
    private final SNADAO snaDAO;
    private final TurnNumberDAO turnNumberDAO;
    private final AllegianceDAO allegianceDAO;
    private final VictoryConditionDAO vcDAO;
    private final NationRelationDAO nationRelationDAO;
    private final RelationDAO relationDAO;
    private final PopulationCenterDAO populationCenterDAO;
    private final CharacterDAO characterDAO;
    private final ArmyDAO armyDAO;
    private final ArtifactDAO artifactDAO;
    private final MessageDAO messageDAO;
    private final OrderDAO orderDAO;
    private final HexDAO hexDAO;
    private final ResourceDetailsDAO resourceDetailsDAO;
    private final ClimateDAO climateDAO;
    private final TerrainDAO terrainDAO;
    private final MarketDAO marketDAO;
    private final MarketPricesDAO marketPricesDAO;
    private final TroopsDAO troopsDAO;
    private final VictoryPointsDAO victoryPointsDAO;
    private final SpellDAO spellDAO;
    private final UpkeepDAO upkeepDAO;

    public SpringHibernatePersistence() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        gameDAO = (GameDAO) beanFactory.getBean("gameDAO");
        playerDAO = (PlayerDAO) beanFactory.getBean("playerDAO");
        nationDAO = (NationDAO) beanFactory.getBean("nationDAO");
        nationTurnDAO = (NationTurnDAO) beanFactory.getBean("nationTurnDAO");
        seasonDAO = (SeasonDAO) beanFactory.getBean("seasonDAO");
        snaDAO = (SNADAO) beanFactory.getBean("snaDAO");
        turnNumberDAO = (TurnNumberDAO) beanFactory.getBean("turnNumberDAO");
        allegianceDAO = (AllegianceDAO) beanFactory.getBean("allegianceDAO");
        vcDAO = (VictoryConditionDAO) beanFactory.getBean("victoryConditionDAO");
        nationRelationDAO = (NationRelationDAO) beanFactory.getBean("nationRelationDAO");
        relationDAO = (RelationDAO) beanFactory.getBean("relationDAO");
        populationCenterDAO = (PopulationCenterDAO) beanFactory.getBean("populationCenterDAO");
        characterDAO = (CharacterDAO) beanFactory.getBean("characterDAO");
        armyDAO = (ArmyDAO) beanFactory.getBean("armyDAO");
        artifactDAO = (ArtifactDAO) beanFactory.getBean("artifactDAO");
        messageDAO = (MessageDAO) beanFactory.getBean("messageDAO");
        orderDAO = (OrderDAO) beanFactory.getBean("orderDAO");
        hexDAO = (HexDAO) beanFactory.getBean("hexDAO");
        resourceDetailsDAO = (ResourceDetailsDAO) beanFactory.getBean("resourceDetailsDAO");
        climateDAO = (ClimateDAO) beanFactory.getBean("climateDAO");
        terrainDAO = (TerrainDAO) beanFactory.getBean("terrainDAO");
        marketDAO = (MarketDAO) beanFactory.getBean("marketDAO");
        marketPricesDAO = (MarketPricesDAO) beanFactory.getBean("marketPricesDAO");
        troopsDAO = (TroopsDAO) beanFactory.getBean("troopsDAO");
        victoryPointsDAO = (VictoryPointsDAO) beanFactory.getBean("victoryPointsDAO");
        spellDAO = (SpellDAO) beanFactory.getBean("spellDAO");
        upkeepDAO = (UpkeepDAO) beanFactory.getBean("upkeepDAO");
    }

    @Override
    public AllegianceDAO getAllegianceDAO() {
        return allegianceDAO;
    }

    @Override
    public GameDAO getGameDAO() {
        return gameDAO;
    }

    @Override
    public NationDAO getNationDAO() {
        return nationDAO;
    }

    @Override
    public NationTurnDAO getNationTurnDAO() {
        return nationTurnDAO;
    }

    @Override
    public PlayerDAO getPlayerDAO() {
        return playerDAO;
    }

    @Override
    public SeasonDAO getSeasonDAO() {
        return seasonDAO;
    }

    @Override
    public SNADAO getSnaDAO() {
        return snaDAO;
    }

    @Override
    public TurnNumberDAO getTurnNumberDAO() {
        return turnNumberDAO;
    }

    @Override
    public VictoryConditionDAO getVcDAO() {
        return vcDAO;
    }

    @Override
    public NationRelationDAO getNationRelationDAO() {
        return nationRelationDAO;
    }

    @Override
    public RelationDAO getRelationDAO() {
        return relationDAO;
    }

    @Override
    public ArmyDAO getArmyDAO() {
        return armyDAO;
    }

    @Override
    public ArtifactDAO getArtifactDAO() {
        return artifactDAO;
    }

    @Override
    public CharacterDAO getCharacterDAO() {
        return characterDAO;
    }

    @Override
    public MessageDAO getMessageDAO() {
        return messageDAO;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    @Override
    public PopulationCenterDAO getPopulationCenterDAO() {
        return populationCenterDAO;
    }

    @Override
    public HexDAO getHexDAO() {
        return hexDAO;
    }

    @Override
    public ResourceDetailsDAO getResourceDetailsDAO() {
        return resourceDetailsDAO;
    }

    @Override
    public ClimateDAO getClimateDAO() {
        return climateDAO;
    }

    @Override
    public TerrainDAO getTerrainDAO() {
        return terrainDAO;
    }

    @Override
    public MarketDAO getMarketDAO() {
        return marketDAO;
    }

    @Override
    public MarketPricesDAO getMarketPricesDAO() {
        return marketPricesDAO;
    }

    @Override
    public TroopsDAO getTroopsDAO() {
        return troopsDAO;
    }

    @Override
    public VictoryPointsDAO getVictoryPointsDAO() {
        return victoryPointsDAO;
    }

    @Override
    public SpellDAO getSpellDAO() {
        return spellDAO;
    }

    @Override
    public UpkeepDAO getUpkeepDAO() {
        return upkeepDAO;
    }


}
