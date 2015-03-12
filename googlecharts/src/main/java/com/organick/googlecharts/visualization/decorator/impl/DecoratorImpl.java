/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.impl;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nkeene
 */
public abstract class DecoratorImpl implements Decorator {

    private String decoratorString;

    public String getDecoratorString() {
        this.buildDecoratorString();
        return this.decoratorString;
    }

    public void setDecoratorString(String decorators) {
        this.decoratorString = decorators;
    }

    public void buildDecoratorString() {
        if ("DIV".equals(this.getDecoratorType())) {
            Map<String, String> decorations = this.getDecoratorMap();
            if (decorations == null || decorations.isEmpty()) {
                this.setDecoratorString("null");
            } else {
                Set<String> keys = decorations.keySet();
                boolean previous = false;
                StringBuffer decoratorBuffer = new StringBuffer();
                decoratorBuffer.append("{");
                for (String key : keys) {
                    if (previous) {
                        decoratorBuffer.append(",");
                    } else {
                        previous = true;
                    }
                    decoratorBuffer.append(key + ":" + decorations.get(key));
                }
                decoratorBuffer.append("}");
                this.setDecoratorString(decoratorBuffer.toString());
            }
        }else if("URL".equals(this.getDecoratorType())){
            Map<String, String> decorations = this.getDecoratorMap();
            if (decorations == null || decorations.isEmpty()) {
                this.setDecoratorString("");
            } else {
                Set<String> keys = decorations.keySet();
                StringBuffer decoratorBuffer = new StringBuffer();
                boolean first = true;
                for (String key : keys) {
                    if(first){
                        decoratorBuffer.append("?");
                        first = false;
                    }else{
                        decoratorBuffer.append("&");
                    }                    
                    decoratorBuffer.append(key + "=" + decorations.get(key));
                }
                this.setDecoratorString(decoratorBuffer.toString());
            }
        }
    }   
}
