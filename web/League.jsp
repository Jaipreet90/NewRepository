<%-- 
    Document   : Player
    Created on : Nov 13, 2013, 5:04:46 PM
    Author     : trilok.sharma
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" uri="/WEB-INF/tlds/test" %>
<%@taglib prefix="errorTag" uri="/WEB-INF/tlds/test" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href="css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper" >

            <div class="heading">
                <h1>League Details</h1>
            </div></br>
            <div class="formContain" style="width:400px;">
                <%
                   
                     String LeagueTitle = request.getParameter("title1");
                     String LeagueSeason = request.getParameter("leagueSeason");
                     String LeagueYear = request.getParameter("year");
                     List arrayList=new LinkedList();
                     arrayList.add("summer");
                     arrayList.add("winter");
                     arrayList.add("autumn");
                     arrayList.add("spring");
                     request.setAttribute("arrayList", arrayList);
        
        
      
                  
         
                    
                %>

                <form action="selectLeague.do">

                    <div class="left">
                        <label for="leagueYear">League Year</label>
                    </div>
                    <div class="right">
                        <input type="text" name="year" value="${param["year"]}">
                    </div>
                    <div class="left" >
                        <label for = "title">Title</label>
                    </div>
                    <div class="right">
                        <input type="text" name="title1"  value="${param["title1"]}">
                    </div>
                    <div class="left">
                        <label for="leagueSeason">league Season</label>
                    </div>
                    <div class="right" >
                        <mytags:select name="leagueSeason" optionlist="${requestScope.arrayList}" />
                    </div>
                    <div class="left" >
                        <input type="submit" value="select">
                    </div>
                    
                    

                </form> 
            </div>
        </div>
        <div id="left" >
            <errorTag:errorList />
          
    </div>
</body>
</html>
