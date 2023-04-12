<%-- 
    Document   : index
    Created on : Apr 12, 2023, 10:47:54 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        </style>
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        <div class="container-fluid back-img">
            <h2 class="text-center text-danger">KitchenWare Shop</h2>
        </div>
        <div class="container-fluid">
            <h3>Recent Book</h3>
            <div class="row">
                <div class="col-md-3">
                    <div class="card-body">
                        <img alt="" src="kithchenware/lovisong.jpg">
                        <p>Lò vi sóng</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
