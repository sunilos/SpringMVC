<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>

<h1>Marksheet Form</h1>

<H2 style="color: red">${error }</H2>
<H2 style="color: green">${message }</H2>

<form:form  method="post" modelAttribute="marksheetForm">

	<form:hidden path="id" />

	<table>
		<tr>
			<td>RollNo:</td>
			<td><form:input path="rollNo" /></td>
			<td><form:errors path="rollNo" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Physics:</td>
			<td><form:input path="physics" /></td>
			<td><form:errors path="physics" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Chemistry:</td>
			<td><form:input path="chemistry" /></td>
			<td><form:errors path="chemistry" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Maths:</td>
			<td><form:input path="maths" /></td>
			<td><form:errors path="maths" cssClass="error" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="Save"name="operation"> | 
				<s:if test="${ marksheetForm.id > 0}">
					<input type="submit" value="Delete" name="operation"> |
				</s:if> 
				<input type="submit" value="Cancel" name="operation">
			</td>
		</tr>
	</table>
</form:form>
