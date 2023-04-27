<%-- 
    Document   : all_recent_product
    Created on : Apr 22, 2023, 9:04:35 AM
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
        <title>All New Product</title>
        <%@include file="all_component/allCss.jsp"%>
        <style type="text/css">

            .crd-ho:hover{
                background-color: #ededf0;
            }
            #toast{
                min-width: 300px;
                position: fixed;
                bottom: 30px;
                left: 50%;
                margin-left: -125px;
                background: #333;
                padding: 10px;
                color: white;
                text-align: center;
                z-index: 1;
                font-size: 18px;
                visibility: hidden;
                box-shadow: 0px 0px 100px #000;
            }
            #toast.display{
                visibility: visible;
                animation: fadeIn 0.5,fadeOut 0.5s 2.5s;
            }
            @keyframes fadeIn{
                from{
                    bottom:0;
                    opacity:0;
                }
                to{
                    bottom:30px;
                    opacity:1;
                }
            }
            @keyframes fadeOut{
                from{
                    bottom:30px;
                    opacity:1;
                }
                to{
                    bottom:0;
                    opacity:0;
                }
            }
        </style>
    </head>
    <body>
        <%
           User u=(User)session.getAttribute("userobj");
        %>

        <c:if test="${not empty addCart}">
            <div id="toast">${addCart}</div>
            <script type="text/javascript">
                showToast();
                function showToast(content) {
                    $('#toast').addClass("display");
                    $('#toast').html(content);
                    setTimeout(() => {
                        $("#toast").removeClass("display");
                    }, 2000)
                }
                }
            </script>

            <c:remove var="addCart" scope="session"/>
        </c:if>

        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row p-3">
                <%
                     ProductDAOImpl dao=new ProductDAOImpl();
                     List<ProductDtls> list=dao.getAllNewProduct();
                     for(ProductDtls p:list){
                %>
                <div class="col-md-3">
                    <div class="card crd-ho mt-2">
                        <div class="card-body text-center">
                            <img alt="" src="kithchenware/<%=p.getPhotoName()%>" style="width: 200px;height: 150px"
                                 class="img-thumblin">
                            <p><%=p.getProductName()%></p>
                            <p>Made in: <%= p.getMadeIn()%></p>
                            <p>Categories: <%=p.getProductCategory()%></p>
                            <div class="row ml-1">
                                <%if(u==null){
                                %>
                                <a href="login.jsp" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
                                <%}else{%>
                                <a href="cart?pid=<%=p.getProductId()%>&&uid=<%=u.getId()%>" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>
                                <%}
                                %>
                                <!--<a href="" class="btn btn-danger btn-sm ml-2"><i class="fas fa-cart-plus"></i> Add Cart</a>-->
                                <a href="" class="btn btn-success btn-sm ml-1">View</a><!-- comment -->
                                <a href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%> $</a>
                            </div>
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
