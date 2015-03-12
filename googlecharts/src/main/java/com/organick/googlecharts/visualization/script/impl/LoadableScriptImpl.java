/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.script.impl;

import com.organick.googlecharts.visualization.script.LoadableScript;

/**
 *
 * @author nkeene
 */
public class LoadableScriptImpl implements LoadableScript {

    private String src;

    public LoadableScriptImpl() {
    }

    public String getScriptElement() {
        return src;
    }

    public void setSrc(String src) {
        this.src = "<script type=\"text/javascript\" src=\""+src+"\"></script>";
    }

}
