<%-- 
    Document   : home
    Created on : Apr 18, 2023, 3:42:54 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User:Home</h1>
        <c:if test="${not empty userobj}">
            <h1>Name:${userobj.name}</h1>
            <h1>Email:${userobj.email}</h1>
    </c:if>
    </body>
</html>
