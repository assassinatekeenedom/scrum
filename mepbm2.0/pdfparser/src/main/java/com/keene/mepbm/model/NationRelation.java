package com.keene.mepbm.model;

public interface NationRelation<T extends TurnNumber, R extends Relation, N extends Nation, E extends NationTurn> {

    public int getNationRelationId();

    public void setNationRelationId(int nationTurnId);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);

    public R getRelation();

    public void setRelation(R relation);

    public N getDestination();

    public void setDestination(N destination);

    public N getSource();

    public void setSource(N source);

    public E getNationTurn();

    public void setNationTurn(E nationTurn);
}
