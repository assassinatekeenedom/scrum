/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.visualization;

import java.io.Serializable;

/**
 *
 * @author nkeene
 */
public interface ScriptBuilder extends Serializable {

    public String getHeaderHTML();

    public String getDisplayHTML();
    public String getDisplayHTML(String style);
    public String getDisplayHTML(int width, int height);

}
