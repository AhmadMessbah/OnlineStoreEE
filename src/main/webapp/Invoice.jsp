
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice jsp file</title>
</head>
<body>

<form action="/invoice.do" method="post">
  <input type="number" name="id" placeholder="ID">
  <input type="text" name="serial" placeholder="Serial">
  <input type="number" name="customer" placeholder="Customer ID">
  <input type="datetime-local" name="localDateTime" placeholder="Local DateTime">
  <input type="text" name="invoiceComment" placeholder="Invoice Comment">
  <input type="number" name="discount" placeholder="Discount">
  <input type="submit" value="Save">
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
