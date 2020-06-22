<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>
	<H1>Forgot Password Form</H1>

	<H3 style="color: green">${message }</H3>
	<H3 style="color: red">${error }</H3>

	<f:form action="" method="post" commandName="user">
		<table>
			<tr>
				<td>Email Id</td>
				<td><f:input path="login" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Get Password"
					name="operation"> <input type="submit" value="Sign In"
					name="operation"></td>
			</tr>
		</table>
	</f:form>
</BODY>
</HTML>
