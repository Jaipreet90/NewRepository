<%-- 
    Document   : division
    Created on : 15 Nov, 2013, 3:58:29 PM
    Author     : jaipreet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="wrapper" style="width:800px;margin-left: 219px;" >
            <div class="heading">
                <h1>Please enter Division</h1>
                <div class="formContain" style="width:400px;">
                    <form action="Division.do">
                        <div class="left" style="width:200px;height:25px;float:left;">
                            <label for="Division">Enter Division</label></div>
                        <div class="right" style="width:200px;float:right;">
                            <input type="text" name="Division"></div>
                        <div class="left" style="width:200px;height:25px;float:left;">
                            <input type="submit" value="select"></div>
                    </form></div></div>
            <c:if test="${not empty requestScope.errorMsg}">
                <p><font color='red'>Please correct the following errors:
                                    </p>
                                    ${errorMsg}
            </c:if>
    </body>
</html>
