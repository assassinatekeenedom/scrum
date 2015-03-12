/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.decorator.chart;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import com.organick.googlecharts.visualization.decorator.impl.VisualizationDecoratorImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nkeene
 */
public class WordCloudDecorator extends VisualizationDecoratorImpl {

    public static final String STOP_WORDS = "stopWords";

    public Map<String, String> getDecoratorMap() {
        Map<String, String> configurations = new HashMap<String, String>();
        configurations.put(STOP_WORDS, this.getStopWordsDecorator());
        return configurations;
    }
    private List<String> stopWords;

    public WordCloudDecorator() {
        stopWords = new ArrayList<String>();
    }

    private String getStopWordsDecorator() {
        StringBuffer stopWordsDecorator = new StringBuffer();
        stopWordsDecorator.append("'");
        boolean previous = false;
        for (String word : stopWords) {
            if (previous) {
                stopWordsDecorator.append(" ");
            } else {
                previous = true;
            }
            stopWordsDecorator.append(word);
        }

        stopWordsDecorator.append("'");
        return stopWordsDecorator.toString();
    }

    public void addStopWord(String stopWord) {
        stopWords.add(stopWord);
    }
    
    public <T extends Decorator>T getDefaultDecorator() {
        this.addStopWord("a");
        this.addStopWord("the");
        this.addStopWord("is");
        this.addStopWord("are");
        this.addStopWord("and");
        this.addStopWord("it");
        return (T)this;
    }
}
