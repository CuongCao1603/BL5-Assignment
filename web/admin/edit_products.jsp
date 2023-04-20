<%-- 
    Document   : add_product
    Created on : Apr 19, 2023, 11:25:20 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="DAO.ProductDAOImpl"%>
<%@page import="model.ProductDtls"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Edit Product</title>
        <%@include file="allCss.jsp" %>
    </head>
    <body style="background-color: #f0f2f2">
        <%@include file="navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="text-center">Edit Books</h4>

                            <%
                            int id=Integer.parseInt(request.getParameter("id"));
                            ProductDAOImpl dao = new ProductDAOImpl();
                            ProductDtls p=dao.getProductById(id);
                            %>   

                            <form action="../editproducts" method="post"
                                  >
                                <input type="hidden" name="id" value="<%=p.getProductId()%>"/>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">
                                        Product Name*
                                    </label>
                                    <input name="pname" type="text" class="form-control"
                                           id="exampleInputEmail1" aria-describedby="emailHelp"
                                           value="<%=p.getProductName()%>">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">
                                        Made in*
                                    </label>
                                    <input name="madein" type="text" class="form-control"
                                           id="exampleInputEmail1" aria-describedby="emailHelp"
                                           value="<%=p.getMadeIn()%>">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">
                                        Price*
                                    </label>
                                    <input name="price" type="text" class="form-control"
                                           id="exampleInputPassword1"
                                           value="<%=p.getPrice()%>">
                                </div>
                                <div class="form-group">
                                    <label for="inputState">
                                        Product Categories
                                    </label>
                                    <select id="inputState" name="categories" class="form-control">
                                         <%
                                            if("New".equals(p.getProductCategory())){
                                        %>
                                        <option value="New">New Product</option>
                                        <option value="Old">Old Product</option>
                                         <%
                                            }else{
                                        %>
                                        <option value="Old">Old Product</option>
                                         <option value="New">New Product</option>
                                           <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">
                                        Product Status
                                    </label>
                                    <select id="inputState" name="status" class="form-control">
                                        <%
                                            if("Active".equals(p.getStatus())){
                                        %>
                                        <option value="Active">Active</option>
                                        <option value="Inactive">Inactive</option>
                                        <%
                                            }else{
                                        %>
                                        <option value="Inactive">Inactive</option>
                                        <option value="Active">Active</option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
