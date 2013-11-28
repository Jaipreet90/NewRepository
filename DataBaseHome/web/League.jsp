<%-- 
    Document   : Player
    Created on : Nov 13, 2013, 5:04:46 PM
    Author     : trilok.sharma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>League Details</h1>


      

            
              <form action="selectLeague.do">
            <label for="leagueYear">League Year</label>
            <input type="text" name="year"><br/><br/>
            
            

            <label for="leagueSeason">league Season</label>
            <select name="leagueSeason">
                <option value="spring">spring</option>
                <option value="autum">autumn</option>
                <option value="summer">summer</option>
                <option value="winter">winter</option>
            </select>
            <br/><br/>
            <label for = "title">Title</label>
            <input type="text" name="title1"><br/><br/>
            <input type="submit" value="select">
        </form>  
    </body>
</html>
