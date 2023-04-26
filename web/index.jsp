<%-- 
    Document   : index
    Created on : Apr 12, 2023, 10:47:54 PM
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
        <title>Kitchenware</title>
        <%@include file="all_component/allCss.jsp"%>
        <style type="text/css">
            .back-img{
                background: url("img/kw2.avif");
                margin-top: 10px;
                height: 50vh;
                width: 100%;
                background-size: cover;
                background-repeat: no-repeat;
            }
            .crd-ho:hover{
                background-color: #ededf0;
            }
        </style>
    </head>
    <body style="background-color: #f0f0f2">
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid back-img">
            <h2 class="text-center text-danger">KitchenWare Shop</h2>
        </div>


        <!--Start Recent Product-->
        <div class="container">
            <h3 class="text-center">Recent Product</h3>
            <div class="row">
                <%
                   ProductDAOImpl dao2=new ProductDAOImpl();
                   List<ProductDtls> list2=dao2.getRecentProducts();
                   for(ProductDtls p:list2){
                %>

                <div class="col-md-3">
                    <div class="card crd-ho">
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
                                <a href="view_products.jsp?pid=<%=p.getProductId()%>" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
                                <a href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> $</a>
                            </div>
                            <%}else{
                            %>
                            <p>Categories: <%=p.getProductCategory()%></p>
                            <div class="row ml-5">
                                <a href="view_products.jsp?pid=<%=p.getProductId()%>" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
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
            </div >
            <div class="text-center mt-1">
                <a href="all_recent_product.jsp" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>

        <!--End Recent Product-->
        <hr>
        <!--Start New Product-->
        <div class="container">
            <h3 class="text-center">New Product</h3>
            <div class="row">
                <%
                    ProductDAOImpl dao=new ProductDAOImpl();
                    List<ProductDtls> list=dao.getNewProducts();
                    for(ProductDtls p:list){
                %>
                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="kithchenware/<%=p.getPhotoName()%>" style="width: 200px;height: 150px"
                                 class="img-thumblin">
                            <p><%=p.getProductName()%></p>
                            <p>Made in: <%= p.getMadeIn()%></p>
                            <p>Categories: <%=p.getProductCategory()%></p>
                            <div class="row ml-1">
                                <a href="" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
                                <a href="view_products.jsp?pid=<%=p.getProductId()%>" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
                                <a href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> $</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div >
            <div class="text-center mt-1">
                <a href="all_new_product.jsp" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>

        <!--End New Product-->

        <!--Start Old Product-->
        <div class="container">
            <h3 class="text-center">Old Product</h3>
            <div class="row">
                <%
                 ProductDAOImpl dao3=new ProductDAOImpl();
                 List<ProductDtls> list3=dao3.getOldProducts();
                 for(ProductDtls p:list3){
                %>

                <div class="col-md-3">
                    <div class="card crd-ho">
                        <div class="card-body text-center">
                            <img alt="" src="kithchenware/<%=p.getPhotoName()%>" style="width: 200px;height: 150px"
                                 class="img-thumblin">
                            <p><%=p.getProductName()%></p>
                            <p>Made in: <%=p.getMadeIn()%></p>
                            <p>Categories: <%=p.getProductCategory()%></p>
                            <div class="row ml-5">

                                <a href="view_products.jsp?pid=<%=p.getProductId()%>" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
                                <a href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> $</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                                   }
                %>
            </div >
            <div class="text-center mt-1">
                <a href="all_old_product.jsp" class="btn btn-danger btn-sm text-white">View All</a>
            </div>
        </div>

        <!--End Old Product-->
        <%@include file="all_component/footer.jsp" %>
    </body>
</html>
