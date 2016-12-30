<%-- 
    Document   : registerForm
    Created on : Dec 28, 2016, 11:59:46 PM
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
        <h1>Register</h1>
        
        <form method="POST">
            First Name: <input type="text" name="firstName" /> <br/>
            Last Name: <input type="text" name="lastName" /> <br/>
            Username: <input type="text" name="username" /> <br/>
            Password: <input type="password" name="password" /> <br/>
            
            <input type="submit" value="Register"/>
            <input type="reset" value="Clear"/>
        </form>
    </body>
</html>
