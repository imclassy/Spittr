<%-- 
    Document   : spittles
    Created on : Dec 28, 2016, 6:20:14 PM
    Author     : pjaraba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spittles</title>
    </head>
    <body>
        <c:forEach items="${spittleList}" var="spittle">
            <li id="spittle_<c:out value="spittle.id"/>">
                <div class="spittleMessage">
                    <c:out value="${spittle.message}" />
                </div>

                <div>
                    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                    <span class="spittleLocation"> (<c:out value="${spittle.latitude}" />,<c:out value="${spittle.longitude}" />)</span>
                </div>
            </li>
        </c:forEach>
    </body>
</html>
