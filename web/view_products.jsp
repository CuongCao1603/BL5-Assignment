<%-- 
    Document   : view_products
    Created on : Apr 24, 2023, 10:49:34 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl" %>
<%@page import="model.ProductDtls" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="all_component/allCss.jsp" %>



    </head>
    <body style="background-color: #f0f0f2">
        <%@include file="all_component/navbar.jsp" %>
        <%
       int pid=Integer.parseInt(request.getParameter("pid"));
        ProductDAOImpl dao=new ProductDAOImpl();
        ProductDtls p=dao.getProductById(pid);
        %>
        <div class="container p-3">
            <div class="row">
                <div class="col-md-6 text-center p-5 border bg-white">
                    <img src="kithchenware/<%=p.getPhotoName()%>" style="height: 150px;width: 150px"/><br>
                    <h4 class="mt-3">Product Name:<span class="text-success"><%=p.getProductName()%></span> </h4>
                    <h4>Made in: <span class="text-success"><%=p.getMadeIn()%></span></h4>
                    <h4>Category:<span class="text-success"><%=p.getProductCategory()%></span></h4>
                </div>
                <div class="col-md-6  text-center p-5 border bg-white">
                    <h2><%=p.getProductName()%></h2>

                    <%
                    if("Old".equals(p.getProductCategory()))
                    {
                    %>
                    <h5 class="text-primary">Contact To Seller</h5>
                    <h5 class="text-primary"><i class="far fa-envelope"></i>Email: <%=p.getEmail()%></h5>
                    <%}
                    %>

                    <div class="row">
                        <div class="col-md-4 text-danger text-center p-2">
                            <i class="fas fa-money-bill-wave fa-2x"></i>
                            <p>Cash On Delivery</p>
                        </div>
                        <div class="col-md-4 text-danger text-center p-2">
                            <i class="fas fa-undo-alt fa-2x"></i>
                            <p>Return Available</p>
                        </div>
                        <div class="col-md-4 text-danger text-center p-2">
                            <i class="fas fa-truck-moving fa-2x"></i>
                            <p>Free Shipping</p>
                        </div>

                    </div>

                    <%
                   if("Old".equals(p.getProductCategory()))
                   {
                    %>
                    <div class="text-center p-3">
                        <a href="index.jsp" class="btn btn-success">
                            <i class="fas fa-cart-plus"></i>
                            Continue Shopping</a>
                        <a href="" class="btn btn-danger">200 $</a>
                    </div>

                    <%} else {
                    %>
                    <div class="text-center p-3">
                        <a href="" class="btn btn-primary">
                            <i class="fas fa-cart-plus"></i>
                            Add Cart</a>
                        <a href="" class="btn btn-danger">200 $</a>
                    </div>
                    <%}
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
