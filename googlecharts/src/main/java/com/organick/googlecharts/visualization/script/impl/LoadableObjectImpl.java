/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.script.impl;

import com.organick.googlecharts.visualization.script.LoadableObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class LoadableObjectImpl implements LoadableObject {

    private String name;
    private double version;
    private List<String> details;

    public LoadableObjectImpl() {
        details = new ArrayList<String>();
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getContent() {
        StringBuffer content = new StringBuffer();
        double version = this.getVersion();
        if(version%version==0){
            content.append("google.load(\"" + this.getName() + "\",\"" + (int)version + "\"");
        }else{
            content.append("google.load(\"" + this.getName() + "\",\"" + version + "\"");
        }
        content.append(getDetailsContent(this.getDetails()));
        content.append(");");
        return content.toString();
    }

    private String getDetailsContent(List<String> details) {
        StringBuffer content = new StringBuffer();
        content.append(",{packages:[");
        boolean previous = false;
        String next = "";
        for (String apackage : details) {
            if (previous) {
                next = ",";
            } else {
                previous = true;
            }
            content.append(next + "\"" + apackage + "\"");
            previous = true;
        }
        content.append("]}");
        return content.toString();
    }
}
