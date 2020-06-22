<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" >

<html>
<head>
	<style>
		.error {
			color: red;
			font-weight: bold;
		}
</style>
</head>

<body>
	<h1>College Form</h1>

	<H2 style="color: red">${error }</H2>
	<H2 style="color: green">${message }</H2>

	<form:form method="post" modelAttribute="collegeForm">

		<table>
			<form:hidden path="id" />
			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:input path="state" /></td>
				<td><form:errors path="state" cssClass="error" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td>PhoneNo:</td>
				<td><form:input path="phoneNo" /></td>
				<td><form:errors path="phoneNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Save"name="operation"> | 
					<jstl:if test="${ collegeForm.id > 0}">
						<input type="submit" value="Delete" name="operation"> |
					</jstl:if> 
					<input type="submit" value="Cancel" name="operation">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>