package com.keene.mepbm.models;

public interface Order<C extends Character, T extends TurnNumber> {

    public String getAdditionalInfo();

    public void setAdditionalInfo(String additionalInfo);

    public C getCharacterInfo();

    public void setCharacterInfo(C character);

    public String getOrderCode();

    public void setOrderCode(String orderCode);

    public int getOrderNumber();

    public void setOrderNumber(int orderNumber);

    public int getOrderId();

    public void setOrderId(int orderId);

    public T getTurnNumber();

    public void setTurnNumber(T turnNumber);
}
