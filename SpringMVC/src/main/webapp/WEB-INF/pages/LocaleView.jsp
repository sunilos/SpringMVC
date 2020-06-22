<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>

<HTML>
<head>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<BODY>

	<a href="${pageContext.request.contextPath}"> Home </a>

	<H1>${welcome}</H1>

	<H2>${message}</H2>

	<H2>
		<spring:message code="message.view" />
	</H2>

	<H2>Form Input Validation Error message</H2>

	<form:form commandName="localeForm" method="GET">

		Change Language: 
		<form:select path="lang">
			<form:options items="${map}" />
		</form:select>
		<input type="submit" value="Go">

		<HR>
		Name : <form:input path="name" />
		<BR>
		<form:errors path="name" cssClass="error" />
	</form:form>



</BODY>
</HTML>
