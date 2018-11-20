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
    <title>Title</title>
</head>
<body>
    <div class="mainContainer">
        <h1><c:out value="Product Name: ${selectedProduct.name}     Price: $${selectedProduct.price} USD"/></h1>
        <h2><c:out value="Product Details: ${selectedProduct.description}"/></h2>
    </div>
</body>
</html>
