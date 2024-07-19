<%--
  Created by IntelliJ IDEA.
  User: mohammad
  Date: 7/18/2024
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address Saving Form</title>
    <link rel="stylesheet" href="assets/css/Address.css">
</head>
<body>
<h1>Address Saving Form</h1>
<form action="/address.do" method="post">
    <div class="container">
        <div class="row">
            <div class="col-10">
                <label for="countryName">Country Name:</label>
            </div>
            <div class="col-90">
                <input type="text" id="countryName" name="countryName" placeholder="Enter your country name" maxlength="30" required>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="stateName">State Name:</label>
            </div>
            <div class="col-90">
                <input type="text" id="stateName" name="stateName" placeholder="Enter your state name" maxlength="30" required>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label>Place:</label>
            </div>
            <div class="col-90">
                <input type="radio" id="city" name="places[]" value="city"/>City
                <input type="radio" id="village" name="places[]" value="village"/>Village
            </div>
        </div>

        <div class="row">
            <div class="col-10">
                <label for="cityName">City Name:</label>
            </div>
            <div class="col-90">
                <input type="text" id="cityName" name="cityName" placeholder="Enter your city name" maxlength="30">
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="villageName">Village Name:</label>
            </div>
            <div class="col-90">
                <input type="text" id="villageName" name="villageName" placeholder="Enter your village name" maxlength="30">
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="regionName">Region Name:</label>
            </div>
            <div class="col-90">
                <input type="text" id="regionName" name="regionName" placeholder="Enter your region name" maxlength="30">
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="streetAddress">Street Address:</label>
            </div>
            <div class="col-90">
                <textarea name="streetAddress" id="streetAddress" cols="30" rows="15" placeholder="Enter your street address and name here... (only 150 characters are allowed)" maxlength="150"></textarea>
            </div>
        </div>

        <div class="row">
            <div class="col-10">
                <label for="platesNumber">Plates Number:</label>
            </div>
            <div class="col-90">
                <input type="text" id="platesNumber" name="platesNumber" placeholder="Enter the plates number of your home" maxlength="5">
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="floorNumber">Floor Number:</label>
            </div>
            <div class="col-90">
                <input type="number" id="floorNumber" name="floorNumber" placeholder="Enter your floor number" maxlength="5">
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="homeUnit">Home Unit:</label>
            </div>
            <div class="col-90">
                <input type="text" id="homeUnit" name="homeUnit" placeholder="Enter the home unit of your home" maxlength="5">
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <label for="postalCode">Postal Code:</label>
            </div>
            <div class="col-90">
                <input type="number" id="postalCode" name="postalCode" placeholder="only 10 digits are allowed" maxlength="10" required >
            </div>
        </div>
    </div>
    <div class="row">
        <input type="submit" value="Save">
    </div>

</form>
</body>
</html>
