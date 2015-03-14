package com.keene.mepbm.models.impl;

import com.keene.mepbm.models.Order;
import com.keene.mepbm.models.Character;
import com.keene.mepbm.models.TurnNumber;

public class OrderImpl implements Order<Character, TurnNumber> {

    private int orderId;
    private int orderNumber;
    private String orderCode;
    private String additionalInfo;
    private Character character;
    private TurnNumber turnNumber;

    public OrderImpl() {
    }

    @Override
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public Character getCharacterInfo() {
        return character;
    }

    @Override
    public void setCharacterInfo(Character character) {
        this.character = character;
    }

    @Override
    public String getOrderCode() {
        return orderCode;
    }

    @Override
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public int getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public TurnNumber getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumber turnNumber) {
        this.turnNumber = turnNumber;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("\tORDER: ");
        toString.append(" (id=");
        toString.append(this.getOrderId());
        toString.append(")\n");
        toString.append("\t\tOrder Number: ");
        toString.append(this.getOrderNumber());
        toString.append("\n");
        toString.append("\t\tOrder Code: ");
        toString.append(this.getOrderCode());
        toString.append("\n");
        toString.append("\t\tAdditional Info: ");
        toString.append(this.getAdditionalInfo());
        toString.append("\n");
        return toString.toString();
    }
}
