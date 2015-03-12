package com.keene.mepbm.model.hibernate.dao;

import com.keene.hibernate.dao.HibernateDAO;
import com.keene.mepbm.model.Artifact;
import com.keene.mepbm.model.hibernate.ArtifactImpl;
import com.keene.mepbm.model.dao.ArtifactDAO;
import com.keene.mepbm.model.hibernate.GameImpl;
import com.keene.mepbm.model.hibernate.TurnNumberImpl;
import java.util.List;
import java.util.Properties;

public class ArtifactDAOImpl extends HibernateDAO<ArtifactImpl> implements ArtifactDAO<ArtifactImpl,GameImpl, TurnNumberImpl> {

    public ArtifactDAOImpl() {
    }

   @Override
    public List<ArtifactImpl> selectAll() {
        return getHibernateTemplate().loadAll(ArtifactImpl.class);
    }

    @Override
    public Artifact load(int artifactNumber, GameImpl game, TurnNumberImpl turnNumber) {
        Properties props = new Properties();
        props.put("number", artifactNumber);
        props.put("game_gameId", game.getGameId());
        props.put("turnNumber_turnNumberId", turnNumber.getTurnNumberId());
        ArtifactImpl artifact = new ArtifactImpl();
        artifact.setNumber(artifactNumber);
        artifact.setGame(game);
        artifact.setTurnNumber(turnNumber);
        return super.load(props, artifact);
    }
}
