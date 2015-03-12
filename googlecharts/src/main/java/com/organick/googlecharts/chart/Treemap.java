/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.chart;

/**
 *
 * @author nkeene
 */
public interface Treemap extends Chart{
    
    public boolean addEntry(String category, String topic, Long size, Long scale);

}
