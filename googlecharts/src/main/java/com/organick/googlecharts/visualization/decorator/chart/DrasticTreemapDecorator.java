/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.impl.VisualizationDecoratorImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class DrasticTreemapDecorator extends VisualizationDecoratorImpl {

    public static final String LABEL_COLUMN = "labelcol";
    public static final String GROUP_BY_COLUMN = "groupbycol";
    public static final String VARIABLES = "variables";


    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(LABEL_COLUMN, this.getLabelColumnDecorator());
        configurations.put(GROUP_BY_COLUMN, this.getGroupByColumnDecorator());
        configurations.put(GROUP_BY_COLUMN, this.getVariablesDecorator());
        return configurations;
    }

    private String labelColumn;
    private String groupByColumn;
    private List<String> variables;

    public DrasticTreemapDecorator() {
        variables = new ArrayList<String>();
    }

    public void setGroupByColumn(String groupByColumn) {
        this.groupByColumn = groupByColumn;
    }

    public void setLabelColumn(String labelColumn) {
        this.labelColumn = labelColumn;
    }

    public void addVariable(String variable) {
        this.variables.add(variable);
    }

    public String getGroupByColumnDecorator() {
        return "'"+this.groupByColumn+"'";
    }

    public String getLabelColumnDecorator() {
        return "'"+this.labelColumn+"'";
    }

    public String getVariablesDecorator() {
        StringBuffer varString = new StringBuffer();
        varString.append("[");
        boolean previous = false;
        for(String variable : variables){
            if(previous){
                varString.append(",");
            }else{
                previous = true;
            }
            varString.append(variable);
        }
        varString.append("]");
        return varString.toString();
    }

    
    public <T extends Decorator>T getDefaultDecorator() {        
        return (T)this;
    }
}
