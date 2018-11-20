<%--
  Created by IntelliJ IDEA.
  User: 986202
  Date: 11/17/2018
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart</title>
    <script src="/Scripts/homepage_scripts.js"></script>
</head>
<body>
    <h1>Shopping Cart</h1>
    <c:forEach var="item" items="${products}" >
        <p><c:out value="${item.name} : ${item.price}"/></p>
        <button id=${item.id}>Remove From Cart</button>
    </c:forEach>
</body>
</html>
