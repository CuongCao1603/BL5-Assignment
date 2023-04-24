<%-- 
    Document   : old_product
    Created on : Apr 24, 2023, 11:13:02 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl" %>
<%@page import="model.ProductDtls" %>
<%@page import="model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User: Old Product</title>
        <%@include file="all_component/allCss.jsp"%>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        <div class="container p-5">

            <c:if test="${not empty succMsg}">
                <div class="alert alert-success text-center">
                    ${succMsg}
                </div>
                <c:remove var="succMsg" scope="session"/>
            </c:if>
            <table class="table table-striped">
                <thead class="bg-primary text-white">
                    <tr>
                        <th scope="col">Product Name</th>
                        <th scope="col">Made in</th>
                        <th scope="col">Price</th>
                        <th scope="col">Category</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        User u=(User)session.getAttribute("userobj");
                        String email=u.getEmail();
                        
                        ProductDAOImpl dao=new ProductDAOImpl();
                        List<ProductDtls> list=dao.getProductByOld(email,"Old");
                        for(ProductDtls p:list)
                        {%>
                    <tr>
                        <td><%=p.getProductName()%></td>
                        <td><%=p.getMadeIn()%></td>
                        <td><%=p.getPrice()%></td>
                        <td><%=p.getProductCategory()%></td>
                        <td><a href="delete_old_product?em=<%=email%>&&id=<%=p.getProductId()%>" class="btn btn-sm btn-danger">Delete</a></td>
                    </tr>
                    <%}
                    %>

                </tbody>
            </table>
        </div>
    </body>
</html>
