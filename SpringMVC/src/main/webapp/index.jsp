<html>
<body>

	<h2>SUNRAYS Spring MVC examples!</h2>

	<Table border=1 width="100%">
		<caption>Quick Links</caption>
		<TR>
			<TD colspan="2"><b> Welcome Spring MVC<b></TD>
		</TR>

		<TR>
			<TD>Welcome Page</TD>
			<TD><a href="Welcome">http://localhost:8080/SpringMVC/Welcome</a></TD>
		</TR>
		<TR>
			<TD colspan="2"><b> Test URL Mapping @RequestMapping <b></TD>
		</TR>

		<TR>
			<TD>@RequestMapping(value = "/UrlMapping" method =
				RequestMethod.GET)</TD>
			<TD>Click <a href="UrlMapping">http://localhost:8080/SpringMVC/UrlMapping</a>
				and see console.
			</TD>
		</TR>
		<TR>
			<TD>@RequestMapping(value = "/UrlMapping/search" method =
				RequestMethod.GET)</TD>
			<TD>Click <a href="UrlMapping/search">http://localhost:8080/SpringMVC/UrlMapping/search</a>
				and see console.
			</TD>
		</TR>
		<TR>
		<TR>
			<TD>Receive request parameter using @RequestParam annotation.</TD>
			<TD>Click <a
				href="UrlMapping/param?message=Message
					is received as reuqest param">http://localhost:8080/SpringMVC/UrlMapping/param?message=Message
					is received as reuqest param</a> and see console.
			</TD>
		</TR>


		<TR>
			<TD colspan="2"><B>Model Examples</B></TD>
		</TR>

		<TR>
			<TD>ModelAndView object</TD>
			<TD>Click <a href="ModelCtl/ModelAndView">http://localhost:8080/SpringMVC/ModelCtl/ModelAndView</a></TD>
		</TR>

		<TR>
			<TD>Model object</TD>
			<TD>Click <a href="ModelCtl/Model">http://localhost:8080/SpringMVC/ModelCtl/Model</a></TD>
		</TR>

		<TR>
			<TD colspan="2"><B> Request parameter binding</B></TD>
		</TR>
		<TR>
			<TD>Param Binding</TD>
			<TD><a href="ReqBinding/param?message=Hi, This is sunrays">http://localhost:8080/SpringMVC/ReqBinding/param?message=Hi,
					This is sunrays</a> <br> <a
				href="ReqBinding/param1?message=Hi, This is sunrays">http://localhost:8080/SpringMVC/ReqBinding/param1?message=Hi,
					This is sunrays</a> <br> <a
				href="ReqBinding/param2?message=Hi, This is sunrays">http://localhost:8080/SpringMVC/ReqBinding/param2?message=Hi,
					This is sunrays</a> <br></TD>
		</TR>
		<TR>
			<TD>Different Param Name</TD>
			<TD><a href="ReqBinding/param3?msg=Hi, This is sunrays">http://localhost:8080/SpringMVC/ReqBinding/param3?msg=Hi,
					This is sunrays</a></TD>
		</TR>
		<TR>
			<TD>Optional Param</TD>
			<TD><a href="ReqBinding/param4?message=Hi, This is sunrays">http://localhost:8080/SpringMVC/ReqBinding/param4?message=Hi,
					This is sunrays</a><br> <a href="ReqBinding/param4">http://localhost:8080/SpringMVC/ReqBinding/param4</a></TD>
		</TR>
		<TR>
			<TD>Type conversion</TD>
			<TD><a href="ReqBinding/param5?id=99">http://localhost:8080/SpringMVC/ReqBinding/param5?id=99</a></TD>
		</TR>
		<TR>
			<TD colspan="2"><B>Form bean - bind Request parameters to
					Form bean</B></TD>
		</TR>

		<TR>
			<TD>LoginForm</TD>
			<TD>Click <a href="FormBinding/login">http://localhost:8080/SpringMVC/FormBinding/login</a></TD>
		</TR>

		<TR>
			<TD>UserForm with Input Validation</TD>
			<TD>Click <a href="FormBinding/user">http://localhost:8080/SpringMVC/FormBinding/user</a></TD>
		</TR>


		<TR>
			<TD colspan="2"><B>Binding URL Path Variables</B></TD>
		</TR>

		<TR>
			<TD>Send 99 as part of Path "/get/{id}"</TD>
			<TD>Click <a href="PathVariable/get/99">http://localhost:8080/SpringMVC/PathVariable/get/99</a></TD>
		</TR>


		<TR>
			<TD>Multiple Path Variable "/get/{deptId}/{empId}"</TD>
			<TD>Click <a href="PathVariable/get/11/89">http://localhost:8080/SpringMVC/PathVariable/get/11/89</a></TD>
		</TR>
		<TR>
			<TD colspan="2"><B>Response Body html/text/json body content</B></TD>
		</TR>

		<TR>
			<TD>HTML Response</TD>
			<TD>Click <a href="ResponseBody">http://localhost:8080/SpringMVC/ResponseBody</a></TD>
		</TR>

		<TR>
			<TD>Plain Text Response</TD>
			<TD>Click <a href="ResponseBody/plain">http://localhost:8080/SpringMVC/ResponseBody/plain</a></TD>
		</TR>

		<TR>
			<TD>JSON Response</TD>
			<TD>Click <a href="ResponseBody/json">http://localhost:8080/SpringMVC/ResponseBody/json</a></TD>
		</TR>

		<TR>
			<TD colspan="2"><B>Inject Container Objects </B></TD>
		</TR>

		<TR>
			<TD>Inject Request and Response</TD>
			<TD>Click <a href="ContainerObj/Request">http://localhost:8080/SpringMVC/ContainerObj/Request</a></TD>
		</TR>
		<TR>
			<TD>Inject Session</TD>
			<TD>Click <a href="ContainerObj/Session">http://localhost:8080/SpringMVC/ContainerObj/Session</a></TD>
		</TR>
		<TR>
			<TD>Inject All</TD>
			<TD>Click <a href="ContainerObj/All">http://localhost:8080/SpringMVC/ContainerObj/All</a></TD>
		</TR>

		<TR>
			<TD colspan="2"><B>College Module</B></TD>
		</TR>
		<TR>
			<TD>Add/Edit College</TD>
			<TD>Click <a href="College">http://localhost:8080/SpringMVC/College</a></TD>
		</TR>
		<TR>
			<TD>College List</TD>
			<TD>Click <a href="College/search">http://localhost:8080/SpringMVC/College/search</a></TD>
		</TR>

		<TR>
			<TD colspan="2"><B>Marksheet Module with Tiles</B></TD>
		</TR>
		<TR>
			<TD>Add/Edit Marksheet</TD>
			<TD>Click <a href="Marksheet">http://localhost:8080/SpringMVC/Marksheet</a></TD>
		</TR>
		<TR>
			<TD>Marksheet List</TD>
			<TD>Click <a href="Marksheet/search">http://localhost:8080/SpringMVC/Marksheet/search</a></TD>
		</TR>

		<TR>
			<TD colspan="2"><B>Internationalization/Localization :
					Multilanguage support</B></TD>
		</TR>
		<TR>
			<TD>English</TD>
			<TD>Click <a href="Locale">http://localhost:8080/SpringMVC/Locale</a></TD>
		</TR>
		<TR>
			<TD>Hindi</TD>
			<TD>Click <a href="Locale?lang=hi">http://localhost:8080/SpringMVC/Locale?lang=hi</a></TD>
		</TR>
		
		<TR>
			<TD colspan="2"><B>Spring Tags</B></TD>
		</TR>
		<TR>
			<TD>Form Tag</TD>
			<TD>Click <a href="Tag?lang=hi">http://localhost:8080/SpringMVC/Tag</a></TD>
		</TR>


		<TR>
			<TD colspan="2"><B>Login Controller</B></TD>
		</TR>

		<TR>
			<TD>Login</TD>
			<TD><a href="Login/">See</a></TD>
		</TR>
		<TR>
			<TD>User Registration</TD>
			<TD><a href="Login/register">See</a></TD>
		</TR>
		<TR>
			<TD>Forgot Password</TD>
			<TD><a href="Login/forgotPassword">See</a></TD>
		</TR>
		<TR>
			<TD colspan="2"><b>User Controller</b></TD>
		</TR>
		<TR>
			<TD>View User</TD>
			<TD><a href="User/99">Go</a></TD>
		</TR>
		<TR>
			<TD>Add User</TD>
			<TD><a href="User/edit/0">Go</a></TD>
		</TR>
		<TR>
			<TD>Edit User</TD>
			<TD><a href="User/edit/99">Go</a></TD>
		</TR>
		<TR>
			<TD>Add College</TD>
			<TD><a href="College">Go</a></TD>
		</TR>

	</Table>
</body>
</html>
