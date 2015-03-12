    <%@ page import="com.organick.googlecharts.visualization.ScriptBuilder"%>
<%@ page import="com.organick.servlet.SkillGrowthVisualService"%>
<%@ page import="com.keene.pdfparser.mepbm.service.SVNService"%>
<%@ page import="com.keene.pdfparser.mepbm.service.NationService"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Set"%>
<%@ page import="com.keene.pdfparser.mepbm.Game"%>
<%@ page import="com.keene.pdfparser.mepbm.core.Skill"%>  
        <%
    Map<String, Game> games = new HashMap<String,Game>();
    if(request.getSession().getAttribute("games")==null){
        games = SVNService.parseGames(SVNService.getPDFFilePaths("C:\\Users\\Galen\\Desktop\\mepbm\\mepbm\\fourthAge"));
        request.getSession().setAttribute("games",games);
    }
    games = (Map<String,Game>)request.getSession().getAttribute("games");
    Set<String> gameList = games.keySet();
%>
<div id="content">
                <h3>Which <span style="font-weight: bold;">Game</span> would you like to view?</h3>
                <select name="gameSelect">
                    <option value="-1">-- SELECT --</option>
                    <%
                    for(String gameA : gameList){
                        Game theGame = games.get(gameA);
                    %>
                    <option value="<%=gameA%>"><%=gameA%></option>
                    <%
                    }
                    %>
                </select>
                <br /><br />
        </div>