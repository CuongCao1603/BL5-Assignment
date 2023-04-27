<%-- 
    Document   : order
    Created on : Apr 24, 2023, 4:17:00 PM
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
        <title>Order Product</title>
        <%@include file="all_component/allCss.jsp" %>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        <c:if test="${empty userobj}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <div class="container p-1">
            <h3 class="text-center text-primary">Your Order</h3>
            <table class="table table-striped mt-3">
                <thead class="bg-primary text-white">
                    <tr>
                        <th scope="col">Order Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Made in</th>
                        <th scope="col">Price</th>
                        <th scope="col">Payment Type</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        User u =(User)session.getAttribute("userobj");
                        ProductOrderImpl dao=new ProductOrderImpl();
                        List<Product_Order> plist=dao.getProduct(u.getEmail());
                        for(Product_Order p:plist)
                    {%>

                    <tr>
                        <th scope="row"><%=p.getOrderId()%></th>
                        <td><%=p.getUserName()%></td>
                        <td><%=p.getProductName()%></td>
                        <td><%=p.getMadeIn()%></td>
                        <td><%=p.getPrice()%></td>
                        <td><%=p.getPaymentType()%></td>
                    </tr>

                    <%}
                    %>


                </tbody>
            </table>
        </div>
    </body>
</html>
