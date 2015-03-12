/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.io.Serializable;

/**
 *
 * @author nkeene
 */
public interface Chart extends Serializable {
    public Decorator getDecorator();
    public void setDecorator(Decorator decorator);
}
