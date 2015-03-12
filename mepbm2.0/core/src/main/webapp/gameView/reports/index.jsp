<%@ page import="com.organick.servlet.GameNationsService"%>
<%@ page import="com.keene.pdfparser.mepbm.Nation"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.keene.pdfparser.mepbm.Game"%>
This is the report.
<% 
Integer.parseInt(request.getParameter("reportType"));
request.getParameter("gameSelect");
Map<String, Game> games = (Map<String, Game>)request.getSession().getAttribute("games");
for(Nation nation : GameNationsService.getNationsInGame(games, request.getParameter("gameSelect"))) 
{
 %>
 <ul>
     <li><%= nation.getNationName() %></li>
 </ul>
 <%
 }
%>
