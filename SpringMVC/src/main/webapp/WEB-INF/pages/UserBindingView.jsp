<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</HEAD>

<BODY>

	<H1>User Form</H1>

	<H3 style="color: green">${message}</H3>
	<H3 style="color: red">${error}</H3>

	<f:form action="../FormBinding/user" method="post"
		commandName="userForm">

		<table>
			<tr>
				<td>ID</td>
				<td><f:input path="id" /> <f:errors path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><f:input path="firstName" /> <f:errors path="firstName"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><f:input path="lastName" /> <f:errors path="lastName"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><f:input path="gender" /> <f:errors path="gender"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><f:input path="age" /> <f:errors path="age"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date Of Birth (dd/MM/yyyy)</td>
				<td><f:input path="dateOfBirth" /></td>
			</tr>

			<tr>
				<td>Mobile</td>
				<td><f:input path="mobileNo" /> <f:errors path="mobileNo"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email (youremail@gmail.com)</td>
				<td><f:input path="email" /> <f:errors path="email"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Url (http://www.yahoo.com)</td>
				<td><f:input path="url" /> <f:errors path="url"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"
					name="operation"></td>
			</tr>

		</table>

	</f:form>
</BODY>
</HTML>
