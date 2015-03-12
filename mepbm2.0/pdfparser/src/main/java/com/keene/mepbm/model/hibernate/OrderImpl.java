package com.keene.mepbm.model.hibernate;

import com.keene.hibernate.dao.HibernateModel;
import com.keene.mepbm.model.Order;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name="Order")
public class OrderImpl implements Serializable, Order<CharacterImpl,TurnNumberImpl>, HibernateModel {

    @Id
    // optionally could customize @Column(name = "meAllegianceId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Column
    private int orderNumber;
    @Column
    private String orderCode;
    @Column
    private String additionalInfo;
    @OneToOne()
    private CharacterImpl character;
    @OneToOne
    private TurnNumberImpl turnNumber;

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
    public CharacterImpl getCharacterInfo() {
        return character;
    }

    @Override
    public void setCharacterInfo(CharacterImpl character) {
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
    public TurnNumberImpl getTurnNumber() {
        return turnNumber;
    }

    @Override
    public void setTurnNumber(TurnNumberImpl turnNumber) {
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
