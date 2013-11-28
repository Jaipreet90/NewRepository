
<%-- 
    Document   : Player
    Created on : Nov 13, 2013, 7:30:23 PM
    Author     : trilok.sharma
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="test" uri="/WEB-INF/tlds/test" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="myBean" scope="session" class="beans.MyBean" >
            <jsp:setProperty name="myBean" property="fname" value="yahoo"></jsp:setProperty>
        </jsp:useBean>
        <test:ankur ></test:ankur>
        <br/>
        <%
            List l = new ArrayList();
            l.add("erro1");
            l.add("erro2");
            request.setAttribute("errorList", l);
            
            %>
        <c:if test="true">
            
            ${2+3}<br/>
            ${sessionScope.myBean.fname}
            <c:forEach items="${requestScope.errorList}" var="item" >
                <br/>Error - ${item}
            </c:forEach>
            <br/>
            
            
        </c:if>
        <div class="wrapper" style="width:800px;margin-left: 219px;padding: 50px" >
            <h1>Player Details</h1>
            <div class="formContain" style="width:400px;">
                <form action="Player.do">
                    <div class="left" style="width:200px;height:25px;float:left;">
                        <label for="Name">Name</label></div>

                    <div class="right" style="width:200px;float:right;">
                        <input type="text" name="Name"></div>
                    
                    <div class="left" style="width:200px;height:25px;float:left;">
                        <label for="Address">Address</label></div>
                    
                    <div class="right" style="width:200px;float:right;">
                        <input type="text" name="Address"></div>
                    
                    <div class="left" style="width:200px;height:25px;float:left;">
                        <label for="city">City</label></div>
                    
                    <div class="right" style="width:200px;float:right;">
                        <input type="text" name="City"></div>
                    
                    <div class="left" style="width:200px;height:25px;float:left;">
                        <label for="Province">province</label></div>
                    
                    <div class="right" style="width:200px;float:right;">  
                        <input type="text" name="Province"></div>
                    
                    <div class="left" style="width:100px;height:25px;float:left;">
                        <label for="Postalcode">Postal Code</label></div>
                    
                    <div class="right" style="width:201px;height: 100px;float:right;">   
                        <input type="text" name="Postalcode"></div>
                    
                    <div class="left" style="width:200px;height:25px;float:left;">
                        <input type="submit" value="select"></div>
                     
                    </div>

                </form> 
            </div>
        </div>
        <div class="left" style="width:200px ; height:100px;padding: 50px">
            
            <c:if test="${not empty requestScope.errorMsgs}">
                <p>
                    <font color='red'>Please correct the following errors:
                <ul>
                    <c:forEach items="${requestScope.errorMsgs}" var="item" >
                        <li>Error - ${item}</li>
                        </c:forEach>
                </ul>
            </p>
            </c:if>
        </div>


                </form>  
            </div></div>
    </body>
</html>
