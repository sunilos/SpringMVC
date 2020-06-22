<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>
	<H1>User Details</H1>
	<H2 style="color: red">${error }</H2>
	<H2 style="color: green">${message }</H2>


	<table>
		<tr>
			<td>ID</td>
			<td>${user.id }</td>
		</tr>

		<tr>
			<td>First Name</td>
			<td>${user.firstName }</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${user.lastName }</td>
		</tr>
		<tr>
			<td>Login</td>
			<td>${user.login }</td>
		</tr>
	</table>
	<input type="submit" value="Go" name="operation">
	
</BODY>
</HTML>
