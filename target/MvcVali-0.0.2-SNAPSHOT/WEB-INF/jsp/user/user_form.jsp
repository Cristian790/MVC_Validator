<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
</head>
<body>

<spring:url value="/user/save" var="saveURL"/>
<form:form modelAttribute="userForm" method="POST" action="${saveURL}">
<form:hidden path="id"/>
<table>
	<tr>
		<td>First Name:</td>
		<td><form:input path="firstname"/>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td><form:input path="lastname"/>
	</tr>
	<tr>
		<td>Address:</td>
		<td><form:input path="address"/>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Save</button>
	</tr>
</table>
</form:form>

</body>
</html>