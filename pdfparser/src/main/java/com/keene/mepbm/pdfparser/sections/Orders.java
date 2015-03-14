package com.keene.mepbm.pdfparser.sections;

import com.keene.mepbm.models.Order;
import com.keene.mepbm.models.impl.OrderImpl;

public final class Orders extends TurnPDFSection {

    public Orders() {
    }

    @Override
    public final void process() {
        this.getData().nextToken();
        if (this.getData().getToken().contains("None")) {
            this.getData().nextToken();
            return;
        }
        this.getData().nextToken();
        boolean keepgoing = true;
        while (keepgoing) {
            char tokenP = this.getData().getToken().charAt(0);
            if (this.getData().getToken().length() > 2) {
                char tokenB = this.getData().getToken().charAt(1);
                try {
                    if (tokenP >= 'A' && tokenP <= 'Z' && tokenB >= 'a' && tokenB <= 'z') {
                        System.out.println(Save.getJSON(Save.set(this.parseOrder())));
                    }
                } catch (Exception e) {
                    return;
                }
            } else if (this.getData().getToken().length() == 1 && this.getData().getToken().charAt(0) >= 'A' && this.getData().getToken().charAt(0) >= 'Z') {
                return;
            }
            if (this.getData().nextToken().length() == 1) {
                if (this.getData().getToken().charAt(0) >= 'A' && this.getData().getToken().charAt(0) <= 'Z') {
                    break;
                }
            }
        }
    }

    private Order parseOrder() {
        Order order = new OrderImpl();
        order.setTurnNumber(this.getData().getActiveNationTurn().getTurnNumber());
        String name = this.getData().getToken().substring(0, this.getData().getToken().indexOf("  "));
//        Character character = this.getData().getPersistence().getCharacterDAO().load(name, this.getData().getActiveGame(), this.getData().getActiveNationTurn().getTurnNumber());
//        order.setCharacterInfo(character);
        String token = this.getData().getToken().replace(name, "");
        while (token.indexOf(" ") == 0) {
            token = token.replaceFirst(" ", "");
        }
        int orderNumber = 0;
        if (!token.contains("NoOrder")) {
            orderNumber = Integer.parseInt(token.substring(0, 3));
            token = token.substring(4, token.length());
        } else {
            token = token.replaceFirst("NoOrder", "");
        }
        order.setOrderNumber(orderNumber);

        while (token.indexOf(" ") == 0) {
            token = token.replaceFirst(" ", "");
        }
        String orderShort = token.substring(0, token.indexOf(" "));
        order.setOrderCode(orderShort);
        token = token.replaceFirst(orderShort, "");
        while (token.indexOf(" ") == 0) {
            token = token.replaceFirst(" ", "");
        }
        order.setAdditionalInfo(token);
        return order;
    }
}
