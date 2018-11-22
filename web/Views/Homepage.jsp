<%--
  Created by IntelliJ IDEA.
  User: 986202
  Date: 11/17/2018
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome To Our Store!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="/Scripts/homepage_scripts.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <h1 class="title">Welcome To The HomePage <button class="logoutbtn">Logout</button> </h1>
                <h2>${user.username} Check Out All The Cool Stuff To Buy!</h2>
                <button id="viewcartbtn">View Cart</button>
            </div>
        </div>
        <div class="row search">Search: <input id="search" name="search" /> <button id="doSearch">Search</button></div>
        <div class="row products">
            <c:forEach items="${products}" var="product">
                <div  class="prodsummary col">
                    <span id="prod${product.id}"><c:out value="${product.name}  ${product.price}"/></span>
                    <button id="${product.id}" class="addtocart">Add To Cart</button>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
