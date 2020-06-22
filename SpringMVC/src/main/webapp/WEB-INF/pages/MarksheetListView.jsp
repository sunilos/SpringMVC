<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<h1>Marksheet List</h1>

<form:form modelAttribute="marksheetForm" method="post">

	<form:hidden path="pageNo" />
	<form:hidden path="pageSize" />

	Roll No: <form:input path="rollNo" />
	Name: <form:input path="name" />
	<input type="submit" value="Search" name="operation">

	<table border="1">

		<tr>
			<th><input type="checkbox"></th>
			<th>ID</th>
			<th>RollNo</th>
			<th>Name</th>
			<th>Physics</th>
			<th>Chemistry</th>
			<th>Maths</th>
			<th>Edit</th>
		</tr>

		<s:forEach items="${list}" var="marksheet" varStatus="loop">
			<tr>
				<td><input type="checkbox" name="ids" value="${marksheet.id}"></td>
				<td>${loop.index + 1 + ((marksheetForm.pageNo -1) *
					marksheetForm.pageSize)}</td>
				<td><s:out value="${marksheet.rollNo}" /></td>
				<td><s:out value="${marksheet.name}" /></td>
				<td><s:out value="${marksheet.physics}" /></td>
				<td><s:out value="${marksheet.chemistry}" /></td>
				<td><s:out value="${marksheet.maths}" /></td>
				<td><a href="../Marksheet?id=${marksheet.id}">Edit</a></td>
			</tr>
		</s:forEach>

		<s:if test="${empty list}">
			<tr>
				<td colspan="8">
					<H2 style="color: red">Records not found</H2>
				</td>
			</tr>
		</s:if>
		<tr>
			<td colspan="2"><input type="submit" value="Previous"
				name="operation"></td>
			<td align="center" colspan="4"><input type="submit"
				value="Delete" name="operation"> <input type="submit"
				value="New" name="operation"></td>
			<td colspan="2" align="right"><input type="submit" value="Next"
				name="operation"></td>
		</tr>
	</table>
</form:form>
