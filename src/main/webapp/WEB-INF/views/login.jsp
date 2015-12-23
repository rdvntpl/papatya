<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" language="java"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login - FPS</title>
</head>
<body>
<c:if test="$(user.name == 'admin')">
<c:out value="${user.name}"/>
<c:out value="${user.lastname}"/>
<c:out value="${user.username}"/>
<c:out value="${user.password}"/>
</c:if>

<c:if test="$(user.name != 'admin')">
<jsp:forward page = "/manager/" />
</c:if>

</body>
</html>