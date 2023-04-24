<%-- 
    Document   : sell_product
    Created on : Apr 24, 2023, 3:22:05 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sell Product</title>
        <%@include file="all_component/allCss.jsp" %>
    </head>
    <body style="background-color: #f0f1f2">
        <%@include file="all_component/navbar.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="text-center text-primary p-1">Sell Old Book</h5>
                            <form action="" method="post"
                                  enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">
                                        Product Name*
                                    </label>
                                    <input name="pname" type="text" class="form-control"
                                           id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">
                                        Made in*
                                    </label>
                                    <input name="madein" type="text" class="form-control"
                                           id="exampleInputEmail1" aria-describedby="emailHelp">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">
                                        Price*
                                    </label>
                                    <input name="price" type="text" class="form-control"
                                           id="exampleInputPassword1">
                                </div>
<!--                                <div class="form-group">
                                    <label for="inputState">
                                        Product Categories
                                    </label>
                                    <select id="inputState" name="categories" class="form-control">
                                        <option selected="">--select--</option>
                                        <option value="New">New Product</option>
                                        <option value="Old">Old Product</option>
                                    </select>
                                </div>-->
<!--                                <div class="form-group">
                                    <label for="exampleInputEmail1">
                                        Product Status
                                    </label>
                                    <select id="inputState" name="status" class="form-control">
                                        <option selected="">--select--</option>
                                        <option value="Active">Active</option>
                                        <option value="Inactive">Inactive</option>
                                    </select>
                                </div>-->

                                <div class="form-group">   
                                    <label for="exampleFormControlFile1">
                                        Upload Photo
                                    </label>
                                    <input name="pimg" type="file" class="form-control-file"
                                           id="exampleFormControlFile1" >
                                </div>
                                <button type="submit" class="btn btn-primary">Sell</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
