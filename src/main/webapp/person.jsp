<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="person.do" method="post">
    <input type="text" name="name">
    <input type="text" name="family">
    <input type="submit" value="save">
</form>

<c:if test="${not empty sessionScope.personList}">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Family</th>
            <th>Operation</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="person" items="${sessionScope.personList}">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.family}</td>
                <td>
                    <button onclick="editPerson(${person.id})">Edit</button>
                    <button onclick="removePerson(${person.id})">Remove</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<%--<c:if test="${fn:length(sessionScope.personList)}">--%>
<%--<c:if test="${fn:contains(sessionScope.personList, 'ali')}">--%>
<%--<c:if test="${fn:indexOf(sessionScope.personList, 'ali')}">--%>


<%--<c:if test="${fn:length(sessionScope.personList) gt 5}">--%>
<%--<c:if test="${fn:length(sessionScope.personList) lt 5}">--%>

<%--<c:choose >--%>
<%--    <c:when test="a=1"></c:when>--%>
<%--    <c:when test="a=2"></c:when>--%>
<%--    <c:otherwise >--%>
<%----%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>


<c:if test="${empty sessionScope.personList}">
    <h1>No Content</h1>
</c:if>


<script>
    function editPerson(id) {
        window.location.replace("/person.do?edit=" + id);
    }

    function removePerson(id) {
        fetch("/rest/person/" + id, {
            method: "DELETE"
        }).then(() => {
            window.location = "/person.do"
        })
    }


</script>
</body>
</html>
