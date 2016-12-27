<%-- 
    Document   : home
    Created on : Dec 27, 2016, 2:31:50 PM
    Author     : pjaraba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spittr</title>
        
    </head>
    <body>
        <h1>Welcome to Spittr</h1>
        <a href="<c:url value="/spittles" />">Spittles</a> |
        <a href="<c:url value="/spitter/register" />">Register</a>
    </body>
</html>
