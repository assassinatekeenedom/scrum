/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.chart;

/**
 *
 * @author nkeene
 */
public interface VennDiagram {

    public boolean addFirstElement(String name,long size, String color);
    public boolean addSecondElement(String name,long size, String color);
    /**
     * 0 if no third sphere
     * @param size
     * @return
     */
    public boolean addThirdElement(String name,long size, String color);
    public boolean addFirstInterceptSecond(long size);
    /**
     * 0 if no third sphere
     * @param size
     * @return
     */
    public boolean addFirstInterceptThird(long size);
    /**
     * 0 if no third sphere.
     * @param size
     * @return
     */
    public boolean addSecondInterceptThird(long size);
    public boolean addCommonIntercept(long size);

}
