/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.script.impl;

import com.organick.googlecharts.visualization.script.LoadableStylesheet;

/**
 *
 * @author nkeene
 */
public class LoadableStylesheetImpl implements LoadableStylesheet {

    private String href;

    public LoadableStylesheetImpl() {
    }

    public String getLinkElement() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = "<link href=\""+href+"\" type=\"text/css\" rel=\"stylesheet\">";
    }


}
