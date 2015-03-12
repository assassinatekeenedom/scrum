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
<%@ page import="com.keene.pdfparser.mepbm.Nation"%>
<%
    Map<String, Game> games = new HashMap<String,Game>();
    if(request.getSession().getAttribute("games")==null){
        games = SVNService.parseGames(SVNService.getPDFFilePaths("C:\\Users\\Galen\\Desktop\\mepbm\\mepbm\\fourthAge"));
        request.getSession().setAttribute("games",games);
    }
    games = (Map<String,Game>)request.getSession().getAttribute("games");
    if(request.getMethod().indexOf("POST")>-1){

        String gameString = request.getParameter("game");
        String skillString = request.getParameter("skill");

        Skill skill = Skill.Core;
        if(skillString.equals(Skill.Agent.getName())){
            skill = Skill.Agent;
        } else if(skillString.equals(Skill.Emissary.getName())){
            skill = Skill.Emissary;
        } else if(skillString.equals(Skill.Mage.getName())){
            skill = Skill.Mage;
        }else if(skillString.equals(Skill.Command.getName())){
            skill = Skill.Command;
        }

        String nationString = request.getParameter(gameString);
        int starting = Integer.parseInt(request.getParameter(gameString+"starting"));
        int ending = Integer.parseInt(request.getParameter(gameString+"ending"));
        Game game = games.get(gameString);
        Map<String,Nation> nations = new HashMap<String,Nation>();

        if("ALL".equals(nationString)){
            System.out.println("SHOWING ALL!");
            nations = NationService.getNations(game);
        }else{
            System.out.println("SHOWING: " + nationString);
            nations.put(nationString, NationService.getNation(nationString, game));
        }
        ScriptBuilder scriptBuilder = SkillGrowthVisualService.getVisual(nations, starting, ending, skill);

%>
<html>
    <head>
        <title><%=gameString%></title>
        <%=scriptBuilder.getHeaderHTML()%>
    </head>
    <body>
        <h1><a href="/mepbm/characterGrowth/index.jsp">Again! Again!</a></h1>
        <h2><%=gameString%></h2>
        <%=scriptBuilder.getDisplayHTML(1000, 700)%>
        <a href="errors.jsp">KNOWN ERRORS</a>
    </body>
</html>
<%
    }else{
        Set<String> gameList = games.keySet();
%>
<html>
    <head>
        <title>Game Selection</title>
        <script>
            var previousGame;
            var previousSkill;
            var previousNation;
            function processGame(){
                var game = document.forms[0].game.value;
                document.getElementById("skill").style.display="block";
                if(game!=previousGame){
                    if(previousGame!=null){
                        document.getElementById(previous).style.display="none";
                    }
                    previousGame = game;
                }
            }
            function processSkill(){
                var skill = document.forms[0].skill.value;
                document.getElementById("skill").style.display="block";
                document.getElementById(previousGame).style.display="block";
                previousSkill = skill;
            }
            function processTurns(){
                document.getElementById(previousGame+"timeframe").style.display="block";
                document.getElementById("submit").style.display="block";
                previousSkill = skill;
            }
        </script>
    </head>
    <body>
        <div id="content">
            <a href="/mepbm/" style="font-weight: bold;">Main Menu</a>
            <h3>Which <span style="font-weight: bold;">Game</span> would you like a report on?</h3>
            <form method="POST" action="/mepbm/characterGrowth/index.jsp">
                <select name="game" onchange="processGame();">
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
                <div id="skill" style="display: none;">
                    <h3>Which <span style="font-weight: bold;">Skill</span> would you like a report on?</h3>
                    <select name="skill" onchange="processSkill();">
                        <option value="-1">-- SELECT --</option>
                        <% for(Skill skill : Skill.getCoreList()){ %>
                        <option value="<%=skill.getName()%>"><%=skill.getName()%></option>
                        <% } %>
                        <option value="<%=Skill.Core.getName()%>">ALL</option>
                    </select>
                    <div>
                        <%
                        for(String gameA : gameList){
                            Game theGame = games.get(gameA);
                            Map<String,Nation> nationsMap = NationService.getNations(theGame);
                        %>
                        <div id="<%=gameA%>" style="display:none;">
                            <h3>Which <span style="font-weight: bold;">Nation</span> would you like to report on from <span style="font-style: italic;"><%=gameA%></span> ?</h3>
                            <select name="<%=gameA%>" onchange="processTurns();">
                                <option value="-1">-- SELECT --</option>
                                <option value="ALL">ALL</option>
                                <%
                                Set<String> nationsA = nationsMap.keySet();
                                for(String nation : nationsA){
                                %>
                                <option value="<%=nation%>"><%=nation%></option>
                                <%
                                }
                                %>
                            </select><br />
                            <div id="<%=gameA%>timeframe" style="display:none;">
                                <h3>From turn
                                    <select name="<%=gameA%>starting">
                                        <% for(int x=0; x<(theGame.getTurnsRun()-1);x++){%>
                                        <option value="<%=x%>"><%=x%></option>
                                        <% } %>
                                    </select>
                                    through turn:<select name="<%=gameA%>ending">
                                        <% for(int x=theGame.getTurnsRun(); x>0;x--){%>
                                        <option value="<%=x%>"><%=x%></option>
                                        <% } %>
                                    </select>
                                </h3>
                            </div>
                        </div>
                        <%
                        }
                        %>
                        <br /><br />
                        <div id="submit" style="display:none;">
                            <input type="submit" value=" REPORT! " />
                        </div>
                    </div>
                </div>
            </form>
            <br /><br /><br />
            <a href="/mepbm/characterGrowth/errors.jsp" style="color: red; font-size: 8px;">known errors</a>
        </div>
    </body>
</html>
<%
    }
%>