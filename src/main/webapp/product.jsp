
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <input type="submit" value="save">
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


    <tbody></tbody>
</table>
</body>
</html>
