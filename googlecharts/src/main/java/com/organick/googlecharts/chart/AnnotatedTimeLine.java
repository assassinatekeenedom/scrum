/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.chart;

import java.util.Date;
import java.util.List;

/**
 *
 * @author nkeene
 */
public interface AnnotatedTimeLine extends Chart{
    
    public boolean addEvent(Date date, List<Long> values, List<String> labels, List<String> details);

}
