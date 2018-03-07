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
<form:form commandName="userForm" method="POST" action="${saveURL}">
<form:hidden path="id"/>
<div class="container">
	<table>
	<tr>
	<td>
	
		<tr>
			<td><form:label path="firstname">First Name:</form:label></td>
			<td><form:input path="firstname" cssClass="form-control"/></td>
			<td><form:errors path="firstname"  cssClass="alert alert-danger"/>
		</tr>
		
		
	
	<tr>
		<td>Last Name:</td>
		<td><form:input path="lastname" cssClass="form-control"/>
		<td><form:errors path="lastname" cssClass="alert alert-danger"/>
	</tr>
	<tr>
		<td>Address:</td>
		<td><form:input path="address" cssClass="form-control"/>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Save</button>
	</tr>
</table>
</div>

</form:form>

</body>
</html>