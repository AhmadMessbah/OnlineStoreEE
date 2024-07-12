<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/inventory-transaction.do" method="post">
    <input type="number" name="id_inventory">
<%--    <input type="text" name="name_inventory">--%>
<%--    <input type="text" name="description_inventory">--%>
<%--    <input type="number" name="count_inventory">--%>
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Product Id</th>
        <th>Delivery Person</th>
        <th>Receiver Person</th>
    </tr>
    </thead>


    <tbody></tbody>
</table>
</body>
</html>
