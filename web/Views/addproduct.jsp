<%--
  Created by IntelliJ IDEA.
  User: KevinJustice
  Date: 11/22/2018
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/Style/css.css" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <form method="post" action="/addproduct">
            <div class="form-group row">
                <label for="name">Product Name:</label>
                <input class="form-control" type="text" id="name" name="name"/>
            </div>
            <div class="form-group row">
                <label for="desc">Product Description:</label>
                <input class="form-control" type="text" id="desc" name="desc"/>
            </div>
            <div class="form-group row">
                <label for="price">Product Price:</label>
                <input class="form-control" type="text" id="price" name="price"/>
            </div>
            <div class="form-group row">
                <button type="submit">Add Product!</button>
            </div>

        </form>
    </div>
</body>
</html>
