<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" language="java"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login - FPS</title>
</head>
<body>
<h2>Login</h2>

<c:if test="${user.auth == 3}">
<h1>Correct</h1>
<c:out value="${user.name}"/>
<c:out value="${user.lastname}"/>
<c:out value="${user.username}"/>
<c:out value="${user.password}"/>
<c:out value="${user.email}"/>
<c:out value="${user.phone}"/>
<c:out value="${user.adress}"/>
<c:out value="${user.auth}"/>
<c:redirect url="/"></c:redirect>
</c:if>

<c:if test="${user.auth != 3}">

<h1>Wrong</h1>
</c:if>

</body>
</html>