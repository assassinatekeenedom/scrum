/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.chart;

/**
 *
 * @author nkeene
 */
public interface PieChart extends Chart{
    
    public boolean addData(String label, int value);

    public boolean addData(String label, long value);

    public boolean addData(String label, double value);

    public boolean addData(String label, float value);

    public boolean addData(String label, String value);

}
