<%-- 
    Document   : Player
    Created on : Nov 13, 2013, 7:30:23 PM
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
        <h1>Player Details</h1>
         
         <form action="Player.do">
            <label for="Name">Name</label>
            <input type="text" name="Name">
             <br/><br/>
              <label for="Address">Address</label>
              <input type="text" name="Address">
              <br/><br/>
              <label for="city">City</label>
              <input type="text" name="City">
              <br/><br/>
               <label for="Province">province</label>
              <input type="text" name="Province">
              <br/><br/>
               <label for="Postalcode">Postal Code</label>
              <input type="text" name="Postalcode">
              <br/><br/>
              <input type="submit" value="select">
              
              
        </form>  
    </body>
</html>
