<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<form action="/product.do" method="post">
    <input type="number" name="id">
    <input type="text" name="name">
    <input type="text" name="description">
    <input type="checkbox" name="status">
    <input type="text" name="brand">
    <input type="text" name="unit">
    <input type="text" name="productGroup">
    <input type="text" name="barcode">
    <input type="submit" value="save" name="save">
    <input type="submit" value="Edit"  name="edit" >
    <input type="submit" value="Remove" name="delete">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>IsActive</th>
        <th>Brand</th>
        <th>Unit</th>
        <th>ProductGroup</th>
        <th>Barcode</th>
    </tr>
    </thead>


    <tbody>
    <c:forEach var="product" items="${sessionScope.findAllProduct}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.status}</td>
            <td>${product.brand}</td>
            <td>${product.unit}</td>
            <td>${product.productGroup}</td>
            <td>${product.barcode}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
