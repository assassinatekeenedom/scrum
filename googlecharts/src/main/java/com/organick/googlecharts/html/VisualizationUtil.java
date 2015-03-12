/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.html;

/**
 *
 * @author nkeene
 */
public class VisualizationUtil {

    public static String cleanForWordCloud(String term) {
        term = term.replaceAll("\\<.*?\\>", "");
        term = term.replace("<", "");
        term = term.replace("'", " ");
        term = term.replace(">", "");
        term = term.replace("?", "");
        term = term.replace("/", "");
        term = term.replace("\\", "");
        term = term.replace("\"", "");
        term = term.replace(",", "");
        term = term.replace(";", "");
        term = term.replace("!", "");
        term = term.replace("&", "");
        term = term.replace("*", "");
        term = term.replace("(", "");
        term = term.replace(")", "");
        return term;
    }
}
