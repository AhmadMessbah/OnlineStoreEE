<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/person.do" method="post">
    <input type="number" name="id">
    <input type="text" name="name">
    <input type="text" name="family">
    <input type="text" name="phone">
    <input type="text" name="email">
    <input type="text" name="image">
    <input type="submit" value="save">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Family</th>
        <th>PhoneNumber</th>
        <th>NationalId</th>
        <th>Email</th>
        <th>Image</th>
    </tr>
    </thead>

    <img src="${sessionScope.person.attachment.image}" alt="تصویر موجود نیست">

    <tbody></tbody>
</table>
</body>
</html>
