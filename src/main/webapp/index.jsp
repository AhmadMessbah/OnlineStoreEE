<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>Home</h1>
<c:forEach var="i" begin="1" end="5" step="1">
    <h1> ${i}</h1>
</c:forEach>
</body>
</html>
