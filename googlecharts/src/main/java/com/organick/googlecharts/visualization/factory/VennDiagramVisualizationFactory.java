/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.VennDiagramImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class VennDiagramVisualizationFactory {

    /**
     *
     * @param <T>
     * @param names
     * @param values
     * @param colors
     * @param interceptAB
     * @param interceptAC
     * @param interceptBC
     * @param interceptABC
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getVennDiagram(List<String> names, List<Long> values, List<String> colors, long interceptAB, long interceptAC, long interceptBC, long interceptABC, Decorator decorator) {
        VennDiagramImpl visual = new VennDiagramImpl();
        visual.setDecorations(decorator);
        long minValue = values.get(0);

        if ( minValue > values.get(1) && values.get(1) > 0 ) {
            minValue = values.get(1);
        }
        if ( minValue > values.get(2) && values.get(2) > 0) {
            minValue = values.get(2);
        }
        if (minValue > interceptAB && interceptAB > 0) {
            minValue = interceptAB;
        }

        long valueOne = values.get(0);
        if (valueOne > 0) {
            valueOne = (values.get(0) / minValue)+1;            
        }


        long valueTwo = values.get(1);
        if (valueTwo > 0) {
            valueTwo = (values.get(1) / minValue);            
        }
        
        long valueThree = values.get(2);
        if (valueThree > 0) {
            valueThree = (values.get(2) / minValue);            
        }

        long intercept = interceptAB;
        if(intercept > 0){
            intercept = (interceptAB / minValue);            
        }

        visual.addFirstElement(names.get(0), valueOne, colors.get(0));
        visual.addSecondElement(names.get(1), valueTwo, colors.get(1));
        visual.addThirdElement(names.get(2), valueThree, colors.get(2));
        visual.addFirstInterceptSecond(intercept);
        visual.addFirstInterceptThird(interceptAC);
        visual.addSecondInterceptThird(interceptBC);
        visual.addCommonIntercept(interceptABC);
        
        return (T) visual;
    }
}
