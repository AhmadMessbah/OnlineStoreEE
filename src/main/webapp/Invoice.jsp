<%--
  Created by IntelliJ IDEA.
  User: Mohammad
  Date: 7/6/2024
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice jsp file</title>
</head>
<body>

<form action="/invoice.do" method="post">
  <input type="number" name="id">
  <input type="text" name="serial">
  <input type="text" name="customer">
  <input type="date" name="localDateTime">
  <input type="text" name="invoiceComment">
  <input type="number" name="discount">
  <input type="submit" value="save">
</form>



<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>serial</th>
    <th>customer</th>
    <th>localDateTime</th>
    <th>invoiceComment</th>
    <th>discount</th>

  </tr>
  </thead>


  <tbody></tbody>
</table>

</body>
</html>
