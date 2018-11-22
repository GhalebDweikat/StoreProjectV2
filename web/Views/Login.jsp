<%--
  Created by IntelliJ IDEA.
  User: KevinJustice
  Date: 11/15/2018
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="web/Scripts/script.js"></script>
    <title>Happy Fun Store</title>
</head>
<body>
<div id="container">
    <h1 id="page-heading">Happy Fun Shopping</h1>
        <div id="row">
            <form action="login" method="post">
                <div class="row form-group">
                    <label class="">Enter User Name: </label>
                    <input id="userbox" name="username" placeholder="abc123" value="${cookie.user.value}" required pattern="[A-Za-z0-9\-@$!_]+">
                </div>
                <div class="row form-group">
                    <label>Enter Password: </label>
                    <input id="passwordbox" name="password" type="password" required pattern="[a-zA-z0-9]+">
                </div>
                <label for="remember">Remember Me:</label><input id="remember" name="remember" value="yes" type="checkbox" <c:if test="${cookie.containsKey('user')}">checked</c:if>/>
                <button class="btn btn-success" id="loginbutton">Log In</button>
            </form>
            <span id="errormsg">${err_msg}</span>

        </div>
    <div>
        <%--SHOW PRODUCTS HERE--%>
    </div>
    <div>
        <%--SHOW FOOTER STUFF / VERIFICATIONS--%>
    </div>
</div>
</body>
</html>