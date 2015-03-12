/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.chart.structure;

/**
 *
 * @author nkeene
 */
public class TreemapNode {

    private String self;
    private String parent;
    private Long size;
    private Long scale;

    public TreemapNode() {
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
