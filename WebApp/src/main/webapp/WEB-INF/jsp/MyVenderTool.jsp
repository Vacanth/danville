<%@ page session="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="/spring" %>
<html>
<head>
<title>Spring Sample - Successful Login</title>
</head>
<body>
<center>
<h1>Welcome <core:out value="${name}"/></h1><br>
<a href="login.html">Back</a>
</center>
</body>
</html>