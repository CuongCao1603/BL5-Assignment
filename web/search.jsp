<%-- 
    Document   : all_recent_product
    Created on : Apr 22, 2023, 9:04:35 AM
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
        <title>All Recent Product</title>
        <%@include file="all_component/allCss.jsp"%>
        <style type="text/css">

            .crd-ho:hover{
                background-color: #ededf0;
            }
        </style>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row p-3">
                <%
                    String ch=request.getParameter("ch");
                   ProductDAOImpl dao2=new ProductDAOImpl();
                   List<ProductDtls> list2=dao2.getProductBySearch(ch);
                   for(ProductDtls p:list2){
                %>

                <div class="col-md-3">
                    <div class="card crd-ho mt-2">
                        <div class="card-body text-center">
                            <img alt="" src="kithchenware/<%=p.getPhotoName()%>" style="width: 200px;height: 150px"
                                 class="img-thumblin">
                            <p><%=p.getProductName()%></p>
                            <p>Made in: <%=p.getMadeIn()%></p>
                            <%
                                if(!p.getProductCategory().equals("Old")){
                            %>
                            <p>Categories: <%=p.getProductCategory()%></p>
                            <div class="row ml-2">

                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
                                <a href="" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
                                <a href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> $</a>
                            </div>
                            <%}else{
                            %>
                            <p>Categories: <%=p.getProductCategory()%></p>
                            <div class="row ml-5">
                                <!--<a href="" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>-->
                                <a href="" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
                                <a href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> $</a>
                            </div>
                            <%
                            }%> 

                        </div>
                    </div>
                </div>
                <%
                   }
                %>
            </div>
        </div>
    </body>
</html>
