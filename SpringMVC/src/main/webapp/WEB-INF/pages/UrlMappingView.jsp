<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>
	<h1>URL Test View</h1>
	<H1 style="color: green">${message }</H1>
	
	<f:form action="UrlMapping" method="post">
	
		<input type="submit" value="Send Post Request" name="operation">
	
	</f:form>
	
	<b>See Console to check output. </b>
</BODY>
</HTML>
