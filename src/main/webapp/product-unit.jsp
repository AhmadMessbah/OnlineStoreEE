<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>productUnit</title>
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

    <c:forEach var="productUnit" items="${sessionScope.findAllProductUnit}">
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
