<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<table border="1" cellspacing="2" align="center" bordercolor="black">

		<tr>
			<td colspan="2" height="100px"><tiles:insertAttribute
					name="header"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td colspan="1" height="400px" width="200"  valign="top"><tiles:insertAttribute
					name="menu" ></tiles:insertAttribute></td>
			<td colspan="1" height="400px" width="800"  valign="top"><tiles:insertAttribute
					name="body"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td colspan="2" height="80px" width="1000" align="center"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
</body>
</html>