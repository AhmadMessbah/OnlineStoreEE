<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/inventory.do" method="post">
    <input type="number" name="id_inventory">
    <input type="text" name="name_inventory">
    <input type="text" name="description_inventory">
    <input type="number" name="count_inventory">
    <input type="text" name="loction_inventory">
    <input type="submit" value="save">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Count</th>
        <th>Loction</th>
    </tr>
    </thead>


    <tbody></tbody>
</table>
</body>
</html>
