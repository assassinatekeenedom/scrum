/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.servlet;

import com.keene.pdfparser.mepbm.Game;
import com.keene.pdfparser.mepbm.Nation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Galen
 */
public class GameNationsService {

    public static List<Nation> getNationsInGame(Map<String, Game> games, String gameName) {
        List<Nation> nationList = new ArrayList<Nation>();
        Game game = games.get(gameName);
        for(Integer key : game.getNationKeys()){
            nationList.add(game.getNation(key));
        }
        return nationList;
    }
}