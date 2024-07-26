<%--
  Created by IntelliJ IDEA.
  User: computer
  Date: 7/12/2024
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager</title>
</head>
<body>
<form action="/manager.do" method="post">
    <input type="number"name="id">
    <input type="text"name="name">
    <input type="text"name="family">
    <input type="text"name="username">
    <input type="password"name="password">
    <input type="email"name="email">
    <input type="tel"name="phon">
    <input type="text"name="national_id">
    <input type="text"name="address">
    <select name disabled="status" id="">
        <option value="">New</option>
        <option value="">Active</option>
        <option value="">Blocked</option>
        <option value="">Banned</option>
    </select>

    <input type="submit" value="save">
</form>
</body>
</html>
