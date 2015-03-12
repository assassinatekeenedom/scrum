/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.impl;

import com.organick.googlecharts.base.Column;
import com.organick.googlecharts.base.DataTable;
import com.organick.googlecharts.base.Row;
import com.organick.googlecharts.visualization.ScriptBuilder;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.script.LoadableObject;
import com.organick.googlecharts.visualization.script.LoadableScript;
import com.organick.googlecharts.visualization.script.LoadableStylesheet;
import com.organick.googlecharts.visualization.script.ScriptMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class ScriptBuilderImpl implements ScriptBuilder {

    List<Visualization> visuals;

    public ScriptBuilderImpl() {
        visuals = new ArrayList<Visualization>();
    }

    public void addVisualization(Visualization visual) {
        this.visuals.add(visual);
    }

    @Override
    public String getHeaderHTML() {
        StringBuffer headerHTML = new StringBuffer();
        for (Visualization visual : visuals) {
            Decorator decorator = visual.getDecorations();
            if ("DIV".equals(decorator.getDecoratorType())) {
                ScriptMetaData metaData = visual.getScriptMetaData();
                Map<String, String> collisions = new HashMap<String, String>();
                List<LoadableStylesheet> styles = metaData.getLoadableStylesheets();
                for (LoadableStylesheet stylesheet : styles) {
                    String linkElement = stylesheet.getLinkElement();
                    if (collisions.get(linkElement) == null) {
                        headerHTML.append(linkElement);
                        collisions.put(linkElement, linkElement);
                    }
                }
                List<LoadableScript> scripts = metaData.getLoadableScripts();
                for (LoadableScript script : scripts) {
                    String scriptElement = script.getScriptElement();
                    if (collisions.get(scriptElement) == null) {
                        headerHTML.append(scriptElement);
                        collisions.put(scriptElement, scriptElement);
                    }
                }
                headerHTML.append("<script type=\"text/javascript\">");
                List<LoadableObject> packages = metaData.getLoadableObjects();
                for (LoadableObject apackage : packages) {
                    headerHTML.append(apackage.getContent());
                }
                String uniqueId = visual.getUniqueId();
                DataTable dataTable = visual.getDataTable();
                headerHTML.append("google.setOnLoadCallback(" + uniqueId + ");");
                headerHTML.append("function " + uniqueId + "() {");
                headerHTML.append("var data = new " + dataTable.getDataType() + "();");
                List<Column> columns = dataTable.getColumns();
                for (Column column : columns) {
                    headerHTML.append("data.addColumn(" + column.getColumnType() + "," + column.getColumnName() + ");");
                }
                List<Row> rows = dataTable.getRows();
                for (Row row : rows) {
                    List<String> rowData = row.getColumnValues();
                    headerHTML.append("data.addRow([");
                    boolean previous = false;
                    for (String data : rowData) {
                        if (previous) {
                            headerHTML.append(",");
                        } else {
                            previous = true;
                        }
                        headerHTML.append(data);
                    }
                    headerHTML.append("]);");
                }
                headerHTML.append("var outputDiv = document.getElementById('" + uniqueId + "');");
                headerHTML.append("var chart = new " + dataTable.getChartType() + "(outputDiv);");
                headerHTML.append("chart.draw(data, " + decorator.getDecoratorString() + ");");
                headerHTML.append("}");
                headerHTML.append("</script>");
            }
        }

        return headerHTML.toString();
    }

    public String getDisplayHTML() {
        StringBuffer displayHTML = new StringBuffer();
        for (Visualization visual : visuals) {
            Decorator decorator = visual.getDecorations();
            String decoratorType = visual.getDecorations().getDecoratorType();
            if ("DIV".equals(decoratorType)) {
                displayHTML.append("<div id=\"" + visual.getUniqueId() + "\" style=\"width: 100%; height: 100%;\"></div>");
            } else if ("URL".equals(decoratorType)) {
                displayHTML.append("<img src=\"http://chart.apis.google.com/chart" + decorator.getDecoratorString() + "\" />");
            } else {
                displayHTML.append("<h1>ERROR - unknown chart type: " + decoratorType + "</h1>");
            }
        }
        return displayHTML.toString();
    }
    public String getDisplayHTML(String style) {
        StringBuffer displayHTML = new StringBuffer();
        for (Visualization visual : visuals) {
            Decorator decorator = visual.getDecorations();
            String decoratorType = visual.getDecorations().getDecoratorType();
            if ("DIV".equals(decoratorType)) {
                displayHTML.append("<div id=\"" + visual.getUniqueId() + "\" style=\""+style+"\"></div>");
            } else if ("URL".equals(decoratorType)) {
                displayHTML.append("<img src=\"http://chart.apis.google.com/chart" + decorator.getDecoratorString() + "\" />");
            } else {
                displayHTML.append("<h1>ERROR - unknown chart type: " + decoratorType + "</h1>");
            }
        }
        return displayHTML.toString();
    }
    public String getDisplayHTML(int width, int height) {
        StringBuffer displayHTML = new StringBuffer();
        for (Visualization visual : visuals) {
            Decorator decorator = visual.getDecorations();
            String decoratorType = visual.getDecorations().getDecoratorType();
            if ("DIV".equals(decoratorType)) {
                displayHTML.append("<div id=\"" + visual.getUniqueId() + "\" style=\"width: "+width+"px; height:"+height+"px;\"></div>");
            } else if ("URL".equals(decoratorType)) {
                displayHTML.append("<img src=\"http://chart.apis.google.com/chart" + decorator.getDecoratorString() + "\" />");
            } else {
                displayHTML.append("<h1>ERROR - unknown chart type: " + decoratorType + "</h1>");
            }
        }
        return displayHTML.toString();
    }
}
