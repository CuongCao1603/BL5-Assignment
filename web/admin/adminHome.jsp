<%-- 
    Document   : home
    Created on : Apr 18, 2023, 3:43:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin: Home</title>
        <%@include file="allCss.jsp" %>
        <style type="text/css">
            a{
                text-decoration: none;
                color: black;
            }
            a:hover{
                text-decoration: none;
                color: black;
            }

        </style>

    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container">
            <div class="row p-5">
                <div class="col-md-3">

                    <a href="add_products.jsp">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fas fa-plus-square fa-3x text-primary"></i><br>
                                <h4>Add Product</h4>
                                -------------------
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-md-3">

                    <a href="all_products.jsp">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fas fa-book-open fa-3x text-danger"></i><br>
                                <h4>All Product</h4>
                                -------------------
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-md-3">
                    <a href="all_order.jsp">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fas fa-box-open fa-3x text-warning"></i><br>
                                <h4>Orders</h4>
                                -------------------
                            </div>
                        </div>
                    </a>
                </div>

                <div class="col-md-3">
                    <a href="#">
                        <div class="card">
                            <div class="card-body text-center">
                                <i class="fas fa-sign-out-alt fa-3x text-primary"></i><br>
                                <h4>Logout</h4>
                                -------------------
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div style="margin-top: 200px">
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
