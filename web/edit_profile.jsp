<%-- 
    Document   : edit_profile
    Created on : Apr 24, 2023, 3:50:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
        <%@include file="all_component/allCss.jsp" %>
    </head>
    <body style="background-color: #f0f2f2">
        <%@include file="all_component/allCss.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="text-center text-primary">Edit Profile</h4>
                            <form action="register" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Enter Full Name</label>
                                    <input type="text" class="form-control" id="exampleInputEmail1"
                                           aria-describedby="emailHelp" required="" name="fname">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email Address</label>
                                    <input type="email" class="form-control" id="exampleInputEmail1" 
                                           aria-describedby="emailHelp" required="" name="email">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputEmail1">Phone No</label>
                                    <input type="number" class="form-control" id="exampleInputEmail1" 
                                           aria-describedby="emailHelp" required="" name="phno">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1" required="" name="password">
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
