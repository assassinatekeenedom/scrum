/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.visualization.ScriptBuilder;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.impl.ScriptBuilderImpl;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class ScriptBuilderFactory {

    public static <T extends ScriptBuilder>T getScriptBuilder(Visualization visual){
        ScriptBuilderImpl scriptBuilder = new ScriptBuilderImpl();
        scriptBuilder.addVisualization(visual);
        return (T)scriptBuilder;
    }

    public static <T extends ScriptBuilder>T getScriptBuilder(List<Visualization> visuals){
        ScriptBuilderImpl scriptBuilder = new ScriptBuilderImpl();
        for(Visualization visual : visuals){
            scriptBuilder.addVisualization(visual);
        }
        return (T)scriptBuilder;
    }
}
