<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/2/2024
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form">
    <input type="text" name="id" value="${sessionScope.person.id}">
    <input type="text" name="name" value="${sessionScope.person.name}">
    <input type="text" name="family" value="${sessionScope.person.family}">
    <input type="submit">Edit</input>
</form>

<script>
    function handleSubmit(event) {
        event.preventDefault();

        const fromData = new FormData(event.target);
        const jsonData = Object.fromEntries(fromData.entries());

        fetch("rest/person",{
            method:"PUT",
            body:JSON.stringify(jsonData),
            headers:{
                "Content-Type":"application/json"
            }
        })

    }

    const form = document.querySelector("#form");
    form.addEventListener('submit', handleSubmit);
</script>
</body>
</html>
