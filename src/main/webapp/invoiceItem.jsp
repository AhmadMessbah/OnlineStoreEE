<%--
  Created by IntelliJ IDEA.
  User: Mohammad
  Date: 7/2/2024
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>invoice Item jsp page</title>
</head>
<body>

<form action="/person.do" method="post">
    <input type="number" name="id">
    <input type="text" name="product">
    <input type="number" name="count">
    <input type="number" name="price">
    <input type="number" name="invoice_id">
    <input type="submit" value="save">
</form>


</body>
</html>
