<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page isELIgnored="false"%>


<a href="<c:url value="/index.jsp"/>" >Home</a>

<h1>College List</h1>

<form:form modelAttribute="collegeForm" method="post">

	<form:hidden path="pageNo" />
	<form:hidden path="pageSize" />

	Name : <form:input path="name" />

	<input type="submit" value="Search" name="operation">
	
	<table border="1" >

		<tr>
			<th><input type="checkbox"></th>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>State</th>
			<th>City</th>
			<th>Phone</th>
			<th>Edit</th>
		</tr>

		<c:forEach items="${list}" var="college" varStatus="loop">
			<tr>
				<td><input type="checkbox" name="ids" value="${college.id}"></td>
				<td>${loop.index + 1 + ((collegeForm.pageNo -1) *
					collegeForm.pageSize)}</td>
				<td>${college.name}</td>
				<td>${college.address}</td>
				<!-- You can also use c:out tag to display a value -->
				<td><c:out value="${college.state}" /></td>
				<td><c:out value="${college.city}" /></td>
				<td><c:out value="${college.phoneNo}"></c:out></td>
				<td><a href="../College?id=${college.id}">Edit</a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="8">
					<H2 style="color: red">Records not found</H2>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2"><input type="submit" value="Previous" name="operation"></td>
			<td align="center" colspan="4">
				<input type="submit" value="Delete" name="operation">
				<input type="submit" value="New" name="operation">
			</td>
			<td colspan="2" align="right"><input type="submit" value="Next" name="operation"></td>

		</tr>
	</table>
</form:form>
