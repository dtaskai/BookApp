<%@ tag language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Book Application</title>
</head>
<body>
<div>
    <h1>Welcome to the Book-App!</h1>
    <h2>Menu</h2>
    <div>
        <a href="${pageContext.request.contextPath}/add">Add a new book</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/list">Book list</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>
<div>
    <jsp:doBody/>
</div>
</body>
</html>
