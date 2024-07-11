
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin.do" method="post">
    <input type="number" name="id">
    <input type="text" name="name">
    <input type="text" name="family">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="text" name="phone">
    <input type="number" name="address id">
    <input type="text" name="email">
    <input type="text" name="nationalCode">
    <input type="submit" value="save">
</form>

<table>
    <thead>
    <tr>
        <th>Id: </th>
        <th>Name: </th>
        <th>Family: </th>
        <th>username: </th>
        <th>password: </th>
        <th>PhoneNumber: </th>
        <th>Address_id: </th>
        <th>Email: </th>
        <th>NationalCode: </th>
    </tr>
    </thead>


    <tbody></tbody>
</table>
</body>
</html>
