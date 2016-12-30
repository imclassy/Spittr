<%-- 
    Document   : spittle
    Created on : Dec 28, 2016, 11:33:51 PM
    Author     : pjaraba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spittle</title>
    </head>
    <body>
        <div class="spittleView">
            <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}" /></span>
            </div>
        </div>
    </body>
</html>
