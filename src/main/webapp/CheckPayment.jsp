<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CheckPayment</title>
</head>
<body>
<h1>Check Payment Panel</h1>
<form action="/Check.do" method="post">
    <p>Payment Price</p><input type="number" name="payment-price">
    <p>Check Number</p><input type="number" name="card-number">
    <p>Payment Date Time</p><input type="datetime-local" name="payment-date-time">
    <p>Description</p><input type="text" name="description">
    <br>
    <input type="submit" value="Submit" class="submit">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Payment Price</th>
        <th>Check Number</th>
        <th>Payment Date Time</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </tbody>
</table>
</body>
</html>
