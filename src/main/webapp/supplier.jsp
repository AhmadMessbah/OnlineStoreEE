<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/supplier.do" method="post">
    <input type="number" name="id_inventory">
    <input type="text" name="name_supplier">
    <input type="text" name="family_supplier">
    <input type="text" name="mobilePhone_supplier">
    <input type="text" name="nationalCode_supplier">
    <input type="email" name="email_supplier">
    <input type="text" name="companyName_supplier">
    <input type="submit" value="save">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Family</th>
        <th>Mobile Phone</th>
        <th>National Code</th>
        <th>Email</th>
        <th>Company Name</th>
    </tr>
    </thead>


    <tbody></tbody>
</table>
</body>
</html>
