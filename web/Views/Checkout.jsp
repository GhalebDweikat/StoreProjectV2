<%--
  Created by IntelliJ IDEA.
  User: 986202
  Date: 11/17/2018
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Checkout Time</h1>
    <table id="tbl_products">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="total" value="0.0" scope="page"/>
        <c:forEach items="${products}" var="product">
            <c:set var="total" scope="page" value="${total + product.price}"/>
            <tr>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.price}" /></td>
            </tr>
        </c:forEach>
            <tr>
                <td>Total Price:$ ${total} USD</td>
                <td></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
