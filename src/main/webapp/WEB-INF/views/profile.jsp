<%-- 
    Document   : profile
    Created on : Dec 29, 2016, 11:49:20 PM
    Author     : pjaraba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1>Spitter Profile</h1>
        <c:out value="${spitter.username}" /> <br>
        <c:out value="${spitter.firstName}" />
        <c:out value="${spitter.lastName}" />
    </body>
</html>
