<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CardPayment</title>
</head>
<body>
<h1>Card Payment Panel</h1>
<form action="/card.do" method="post">
    <p>Payment Price</p><input type="number" name="payment-price">
    <p>Card Number</p><input type="number" name="card-number">
    <p>Bank Name</p><input type="text" name="bank-name">
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
        <th>Card Number</th>
        <th>Bank Name</th>
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
        <td></td>
    </tr>
    </tbody>
</table>
</body>
</html>