/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.visualization.factory;

import com.organick.googlecharts.chart.impl.OrgChartImpl;
import com.organick.googlecharts.visualization.Visualization;

import com.organick.googlecharts.visualization.decorator.base.Decorator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author nkeene
 */
public class OrgChartVisualizationFactory {

    /**
     *
     * @param <T>
     * @param root
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getRootOrgChart(String root, List<String> words, Decorator decorator) {
        OrgChartImpl visual = new OrgChartImpl();
        visual.setDecorations(decorator);
        Map<String, String> rootMap = new HashMap<String, String>();
        root = root.toLowerCase();
        rootMap.put(root, root);
        visual.addWord(root, null, root);
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(root, " ", false);
        while (tokenizer.hasMoreTokens()) {
            tokenizer.nextToken();
            count++;
        }
        Map<String, String> children = new HashMap<String, String>();
        for (String word : words) {
            if(word.indexOf(root)>-1){
                String child = word.substring(word.indexOf(root)+root.length(), word.length());
                if (rootMap.get(child) == null) {
                    visual.addWord(child, root, word);
                    children.put(child, child);
                }
            }
        }

        return (T) visual;
    }

    /**
     * 
     * @param <T>
     * @param leaf
     * @param words
     * @param decorator
     * @return
     */
    public static <T extends Visualization> T getLeafOrgChart(String leaf, List<String> words, Decorator decorator) {
        OrgChartImpl visual = new OrgChartImpl();
        visual.setDecorations(decorator);
        Map<String, String> leafMap = new HashMap<String, String>();
        StringTokenizer tokenizer = new StringTokenizer(leaf, " ", false);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().toLowerCase();
            leafMap.put(token, token);
        }
        Map<String, String> children = new HashMap<String, String>();
        for (String word : words) {
            tokenizer = new StringTokenizer(word, " ", false);
            String parent = null;
            while (tokenizer.hasMoreTokens()) {
                String child = tokenizer.nextToken().toLowerCase();
                if (parent != null && leafMap.get(parent) == null && leafMap.get(child) != null) {
                    visual.addWord(parent + " " + child, null, word);
                    children.put(child, (parent + " " + child));
                }
                parent = child;
            }
        }
        return (T) visual;
    }
}
