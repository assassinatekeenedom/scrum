/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.visualization.factory;



import com.organick.googlecharts.chart.impl.WordCloudImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class WordCloudVisualizationFactory {

    /**
     * 
     * @param <T>
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getWordCloud(List<String> words, Decorator decorator) {
        WordCloudImpl visual = new WordCloudImpl();
        visual.setDecorations(decorator);
        for(String word : words){
            visual.addWord(word);
        }        
        return (T) visual;
    }

}
