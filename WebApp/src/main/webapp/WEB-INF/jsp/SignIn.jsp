<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>

	<center>
		<h3>Login Page</h3>
		<br />
		<form:form commandName="foo" method="POST">
		<form:errors path="*" cssClass="errorblock" element="div" />
Username:<form:input path="username" />
			<font color="red"><form:errors path="username" cssClass="error" /></font>
			<br />
			<br />
Password:<form:password path="password" />
			<font color="red"><form:errors path="password" cssClass="error"/></font>
			<br />
			<br />
			<input type="submit" value="Login" />
		</form:form>
	</center>
</body>
</html>