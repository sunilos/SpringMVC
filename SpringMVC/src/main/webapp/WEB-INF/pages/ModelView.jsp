<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>

	<h1>Test Models</h1>

	<H2 style="color: green">${message }</H2>
	<H2 style="color: black">${preload }</H2>

	<br>

	<H1>Form</H1>
	<H4>Form is the example of request parameter binding with method
		parameters.</H4>
	<f:form action="../ModelCtl/Submit" method="post" commandName="form">
	
		Name <input type="text" name="name" size="50">
		<br>
		Age  <input type="text" name="age" size="50">
		<br>
		<input type="submit" value="Go" name="operation">
	</f:form>

</BODY>
</HTML>
