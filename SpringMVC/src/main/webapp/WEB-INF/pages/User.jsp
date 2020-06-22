<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>
	<H1>User Registration</H1>
	<H2 style="color: red">${error }</H2>
	<H2 style="color: green">${message }</H2>

	<f:form action="" method="post" commandName="user">
	
		<f:hidden path="id" />
		<table>
			<tr>
				<td>First Name</td>
				<td><f:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><f:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Login</td>
				<td><f:input path="login" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><f:input path="password" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><f:select path="roleId">
						<f:option value="0">None</f:option>
						<f:options items="${roleList}" itemLabel="name" itemValue="id" />
					</f:select></td>
			</tr>

		</table>
		<input type="submit" value="SignIn" name="operation">
	</f:form>
</BODY>
</HTML>
