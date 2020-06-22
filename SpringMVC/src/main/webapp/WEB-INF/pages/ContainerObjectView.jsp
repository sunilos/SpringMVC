<%@page import="java.util.Enumeration"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<BODY>
	<h1>Container Objects</h1>

	<HR>
	<H2>Request Attributes</H2>
	<%
		Enumeration e = request.getAttributeNames();
		String key = null;
		Object value = null;
	%>
	<table>
		<%
			while (e.hasMoreElements()) {
				key = (String) e.nextElement();
				value = request.getAttribute(key);
		%>
		<tr>
			<td><%=key%></td>
			<td><%=value%></td>
		</tr>
		<%
			}
		%>
	</table>


	<HR>
	<H2>Session Attributes</H2>
	<%
		e = session.getAttributeNames();
	%>
	<table>
		<%
			while (e.hasMoreElements()) {
				key = (String) e.nextElement();
				value = session.getAttribute(key);
		%>
		<tr>
			<td><%=key%></td>
			<td><%=value%></td>
		</tr>
		<%
			}
		%>
	</table>

	<HR>
	<H2>Application Attributes</H2>
	<%
		e = application.getAttributeNames();
	%>
	<table>
		<%
			while (e.hasMoreElements()) {
				key = (String) e.nextElement();
				value = application.getAttribute(key);
		%>
		<tr>
			<td><%=key%></td>
			<td><%=value%></td>
		</tr>
		<%
			}
		%>
	</table>
</BODY>
</HTML>
