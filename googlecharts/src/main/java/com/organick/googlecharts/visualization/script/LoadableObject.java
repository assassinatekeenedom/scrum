/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.script;

import java.util.List;

/**
 *
 * @author nkeene
 */
public interface LoadableObject {

    public List<String> getDetails();

    public void setDetails(List<String> details);

    public String getName();

    public void setName(String name);

    public double getVersion();

    public void setVersion(double version);

    public String getContent();  

}
