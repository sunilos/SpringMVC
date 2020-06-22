<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>

<BODY>

	<H1>Login Form</H1>

	<H3 style="color: green">${loginForm.message }</H3>

	<f:form action="../FormBinding/login" method="post" commandName="loginForm">
	
		<table>
			<tr>
				<td>Login</td>
				<td><f:input path="login" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><f:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SignIn"
					name="operation"> | <input type="submit" value="SignUp"
					name="operation"></td>
			</tr>

		</table>

	</f:form>
</BODY>
</HTML>
