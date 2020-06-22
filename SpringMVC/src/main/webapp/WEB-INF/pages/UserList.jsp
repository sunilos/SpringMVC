<%@page import="com.sunilos.dto.UserDTO"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>
	<%= ((UserDTO)session.getAttribute("userContext")).getLogin()%>
	<H1>Welcome ${userContext.login}</H1>
	<H1>User List Page</H1>
</BODY>
</HTML>
