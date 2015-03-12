/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.RotatingCloudImpl;
import com.organick.googlecharts.visualization.Visualization;
import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class RotatingCloudVisualizationFactory {

    /**
     * 
     * @param <T>
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getRotatingCloud(List<String> words, List<String> urls, Decorator decorator) {
        RotatingCloudImpl visual = new RotatingCloudImpl();
        visual.setDecorations(decorator);
        if (words != null && urls != null) {
            if (words.size() == urls.size()) {
                for (int x = 0; x < words.size(); x++) {
                    String word = words.get(x);
                    String url = urls.get(x);
                    visual.addWord(word, url);
                }
            }
        }
        return (T) visual;
    }
}
