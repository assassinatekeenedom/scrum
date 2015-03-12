package com.keene.mepbm.model.dao;

import com.keene.dao.DAO;
import com.keene.mepbm.model.Artifact;
import com.keene.mepbm.model.Game;
import com.keene.mepbm.model.TurnNumber;

public interface ArtifactDAO<A extends Artifact, G extends Game, N extends TurnNumber> extends DAO<A>{

    public Artifact load(int artifactNumber, G game, N turnNumber);
}
