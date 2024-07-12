<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Group</title>

    <link rel="stylesheet" href="assets/css/bootstrap.rtl.min.css">
    <link rel="stylesheet" href="assets/css/all.css">
    <link rel="stylesheet" href="assets/css/index.css">

</head>
<body>

<h2 style="color: #dcb12c; margin-top: 100px; margin-left: 40px">Product Group Panel</h2>


<div style="margin-left: 50px; margin-top: 185px">
    <img src="productgroup-pic.jpg" alt="Image not found!!!" width="300" height="300">
</div>

<div style="margin-left: 400px; margin-top: -470px; background-color: #dcb12c; height: 60%; width: 20%; padding-top: 50px; padding-left: 40px;">

    <form action="/product-group.do" method="post">

<%--        <input type="text" name="id" placeholder="ID" style="display: block; margin-bottom: 30px">--%>
        <input type="text" name="name" placeholder="Name" style="display: block; margin-bottom: 30px">

        <select name="status" id="1" style="display: block; margin-bottom: 30px">
            <option value="true">active</option>
            <option value="false">not active</option>
        </select>

        <select name="parent" id="2" style="display: block; margin-bottom: 30px">
            <c:forEach var="productGroup" items="${sessionScope.findAllProductGroups}">

                <option>${productGroup.name}</option>

            </c:forEach>
        </select>

        <input type="text" name="description" placeholder="Description" style="display: block; margin-bottom: 30px">
        <input type="submit" value="Save" style="display: block">


    </form>

</div>

<div style="margin-left: 50%; margin-top: -30%">

    <table class="table-light" style="margin: 50px; width: 450px">
        <thead style="background-color: #75b798">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Status</th>
            <th>Parent Group</th>
            <th>Description</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="productGroup" items="${sessionScope.findAllProductGroups}">
            <tr>
                <td>${productGroup.id}</td>
                <td>${productGroup.name}</td>
                <td>${productGroup.status}</td>
                <td>${productGroup.parentGroup.name}</td>
                <td>${productGroup.description}</td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

</div>



<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/all.js"></script>

</body>
</html>
