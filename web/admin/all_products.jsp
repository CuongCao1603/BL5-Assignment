<%-- 
    Document   : all_products
    Created on : Apr 19, 2023, 11:25:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl" %>
<%@page import="model.ProductDtls" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: All Products</title>
        <%@include file="allCss.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <h3 class="text-center">Hello Admin</h3>
        <table class="table table-striped">
            <thead class="bg-primary text-white">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Made in</th>
                    <th scope="col">Price</th>
                    <th scope="col">Categories</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                
                <%
                ProductDAOImpl dao=new ProductDAOImpl();
                List<ProductDtls> list=dao.getAllProduct();
                for(ProductDtls b:list){
                %>
                <tr>
                    <td><%=b.getProductId()%></td>
                    <td><img src="../kithchenware/<%=b.getPhotoName()%>"
                             style="width: 50px;height: 50px;"></td>
                    <td><%= b.getProductName()%></td>
                    <td><%=b.getMadeIn()%></td>
                    <td><%= b.getPrice()%></td>
                    <td><%= b.getStatus()%></td>
                    <td>
                        <a href="#" class="btn btn-sm btn-primary">Edit</a>
                        <a href="#" class="btn btn-sm btn-danger">Delete</a>
                    </td>

                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
