<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="css-include.jsp"/>
</head>
<body>
<div class="container-fluid vh-100">
    <div>
        <jsp:include page="navbar.jsp"/>
    </div>

    <div class="main-content">
        <form action="person.do" method="post">
            <input type="number" name="id">
            <input type="text" name="name">
            <input type="text" name="family">
            <%--           <input type="text" name="phone">--%>
            <%--           <input type="text" name="email">--%>
            <%--           <input type="text" name="image">--%>
            <%--           <input type="text" name="csrf_token" value="${sessionScope.csrf_token}" hidden="hidden">--%>
            <input type="submit" value="save">
        </form>

        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Family</th>
                <%--               <th>PhoneNumber</th>--%>
                <%--               <th>NationalId</th>--%>
                <%--               <th>Email</th>--%>
                <%--               <th>Image</th>--%>
            </tr>
            </thead>

            <%--           <img src="${sessionScope.person.attachment.image}" alt="تصویر موجود نیست">--%>

            <tbody></tbody>
        </table>
    </div>

    <jsp:include page="footer.jsp"/>
</div>

<jsp:include page="js-include.jsp"/>
</body>
</html>

