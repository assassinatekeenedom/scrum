/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.mepbm.rest;

import com.keene.pdfparser.mepbm.Game;
import com.keene.pdfparser.mepbm.service.SVNService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("serve")
public class MEPBMRest {

    @Context
    private ServletContext context;
    @Context
    private HttpServletRequest request;

    @POST
    @Path("/parse")
    @Produces("text/plain")
    public Response parseGames() throws Exception {
        System.out.println("PARSE!");
        Map<String, Game> games = new HashMap<String, Game>();
        if (request.getSession().getAttribute("games") == null) {
            games = SVNService.parseGames(SVNService.getPDFFilePaths("/home/rnkeene/Desktop/mepbm/fourthAge"));
            request.getSession().setAttribute("games", games);
        }
        games = (Map<String, Game>) request.getSession().getAttribute("games");
        Set<String> gameList = games.keySet();
        StringBuilder toString = new StringBuilder();
        for (String gameA : gameList) {
            toString.append("<td><div class='gameSelect' id='");
            toString.append(gameA);
            toString.append("'");
            toString.append("><br />");
            toString.append(gameA);
            toString.append("</div></td>");
        }
        return Response.ok(toString.toString()).build();
    }

    @POST
    @Path("/load")
    @Produces("text/plain")
    public Response loadGames() throws Exception {
        System.out.println("LOAD!");
        return Response.ok("<div class='gameSelect'>Some Game</div>").build();
    }
}
