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
<html>
    <head>
        <title>Reports</title>
        <script>
            var previousGame;
        </script>
    </head>
    <body>
        <% 
        System.out.println("Loading Page:" + request.getMethod());
        if(request.getMethod().indexOf("POST")>-1){
            %>
            <jsp:include page="/reports/" />
            <% } else { %>
        <form method="POST" action="index.jsp">
            <a href="/mepbm/" style="font-weight: bold;">Main Menu</a>
        <jsp:include page="gameSelect.jsp" />
        <jsp:include page="reportType.jsp" />
        <input type="submit">
    </form>
    <br /><br />
        <a href="/mepbm/gameView/errors.jsp" style="color: red; font-size: 8px;">known errors</a>
    <% } %>
    </body>
</html>