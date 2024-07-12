<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Unit</title>

</head>
<body>

<form action="/product-unit.do" method="post">
    <input type="text" name="id">
    <input type="text" name="name">
    <input type="text" name="symbol">
    <input type="text" name="description">
    <input type="submit" value="save">
</form>

<table>

    <thead>
   <tr>
       <th>id</th>
       <th>name</th>
       <th>symbol</th>
       <th>description</th>
   </tr>
    </thead>

    <tbody>
    <c:forEach var="productUnit" items="${sessionScope.findAllProductUnits}">
    <tr>
        <td>${productUnit.id}</td>
        <td>${productUnit.name}</td>
        <td>${productUnit.symbol}</td>
        <td>${productUnit.description}</td>
    </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
