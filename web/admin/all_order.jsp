<%-- 
    Document   : all_products
    Created on : Apr 19, 2023, 11:25:51 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.CartDAOImpl" %>
<%@page import="DAO.ProductOrderImpl" %>
<%@page import="model.Cart" %>
<%@page import="model.User" %>
<%@page import="model.Product_Order" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: All Products</title>
        <%@include file="allCss.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <c:if test="${empty userobj}">
            <c:redirect url="../login.jsp"/>
        </c:if>
        <h3 class="text-center">Hello Admin</h3>
        <table class="table table-striped">
            <thead class="bg-primary text-white">
                <tr>
                    <th scope="col">Order Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">EMail</th>
                    <th scope="col">Address</th>
                    <th scope="col">Ph No</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Made in</th>
                    <th scope="col">Price</th>
                    <th scope="col">Payment type</th>
                </tr>
            </thead>
            <tbody>
                <%
                       User u =(User)session.getAttribute("userobj");
                       ProductOrderImpl dao=new ProductOrderImpl();
                       List<Product_Order> plist=dao.getAllOrder();
                       for(Product_Order p:plist){%>

                <tr>
                    <th scope="row"><%=p.getOrderId()%></th>
                    <td><%=p.getUserName()%></td>
                    <td><%=p.getEmail()%></td>
                    <td><%=p.getFulladd()%></td>
                    <td><%=p.getPhno()%></td>
                    <td><%=p.getProductName()%></td>
                    <td><%=p.getMadeIn()%></td>
                    <td><%=p.getPrice()%></td>
                    <td><%=p.getPaymentType()%></td>
                </tr>

                <%}
                %>

            </tbody>
        </table>
    </body>
</html>
