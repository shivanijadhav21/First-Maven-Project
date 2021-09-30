<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="pageNumber.*, java.util.*, java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <title>Customer</title>

</head>
<body>
<div class="container">
<form id="customerform" method="post" action="addcustomer">
    <div class="customerform">

        <div class="form-group">
        <div class="Row">
            <div class="col-xs-4"></div>
            <div class="col-xs-4">
                <h2>Customer</h2>
    <div class="form-group">
    <label>First Name:</label>
    <input type="text" name="fName" class="form-control" placeholder="enter first name">
    </div>

    <div class="form-group">
        <label>last Name:</label>
        <input type="text"  class="form-control" name="lName" placeholder="enter last name">
    </div>

    <div class="form-group">
        <label>Mobile number:</label>
        <input type="number"  class="form-control" name="mob" placeholder="enter mobile number">
    </div>

    <div class="form-group">
        <label>Email:</label>
        <input type="email"  class="form-control" name="email" placeholder="enter your email">
    </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success btn-lg btn-block">ADD</button>
                <% String msg= (String)request.getAttribute("message"); %>
                                ${msg}
            </div>

        </div>

            <div class="col-xs-4"></div>

        </div>
    </div>
    </div>
</form>
</div>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>