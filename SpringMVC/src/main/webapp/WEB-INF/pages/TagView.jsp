<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

	<a href="${pageContext.request.contextPath}"> Home </a>

	<h1>Spring Form Tag Example</h1>

	<H2>Form 1: &lt;form:checkbox:</H2>

	<form:form method="GET" commandName="tagForm">

		<table>
			<tr>
				<td>Want Java?</td>
				<td><form:checkbox path="name" value="Yes" /></td>
				<td>Simple Value is bound <b> (${tagForm.name}) </b></td>
			</tr>
			<tr>
				<td>Agreed:</td>
				<td><form:checkbox path="agreed" /></td>
				<td>Boolean value is bound <b>(${tagForm.agreed})</b></td>
			</tr>
			<tr>
				<td>Skills:</td>
				<td><form:checkbox path="selectedSkills" value="Java" /> Java
					<form:checkbox path="selectedSkills" value="PHP" /> PHP <form:checkbox
						path="selectedSkills" value="Android" /> ANDROID</td>
				<td>String Array is bound</td>
			</tr>

			<tr>
				<td>Courses:</td>
				<td><form:checkbox path="selectedCourses" value="BE" /> BE <form:checkbox
						path="selectedCourses" value="MCA" /> MCA <form:checkbox
						path="selectedCourses" value="MBA" /> MBA</td>
				<td>Collection List is bound</td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" name="operation"></td>
			</tr>
		</table>
	</form:form>

	<H2>Form 2 : &lt;form:checkboxes:</H2>

	<form:form method="GET" commandName="tagForm">
		<table>
			<tr>
				<td>Skills:</td>
				<td><form:checkboxes path="selectedSkills"
						items="${skillArray}" /></td>
				<td>Sring array is bound</td>
				<th>You Checked : <jstl:if
						test="${!empty tagForm.selectedSkills}">
						<jstl:forEach items="${tagForm.selectedSkills}" var="skill">
					      ${skill},
					   </jstl:forEach>
					</jstl:if>
				</th>
			</tr>
			<tr>
				<td>Courses:</td>
				<td><form:checkboxes path="selectedCourses"
						items="${coursesList}" /></td>
				<td>Collection list is bound</td>
				<th>You Checked : <jstl:if
						test="${!empty tagForm.selectedCourses}">
						<jstl:forEach items="${tagForm.selectedCourses}" var="course">
					      ${course},
					   </jstl:forEach>
					</jstl:if>
				</th>
			</tr>
			<tr>
				<td>Languages:</td>
				<td><form:checkboxes path="selectedLanguages"
						items="${languagesMap}" /></td>
				<td>Collection Map is bound</td>
				<th>You Checked : <jstl:if
						test="${!empty tagForm.selectedLanguages}">
						<jstl:forEach items="${tagForm.selectedLanguages}" var="lang">
					      ${lang},
					   </jstl:forEach>
					</jstl:if>
				</th>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="Save"
					name="operation"></td>
			</tr>
		</table>
	</form:form>


	<H2>
		Form 3: &lt;form:radiobutton:
		</H1>

		<form:form method="GET" commandName="tagForm">

			<table>
				<tr>
					<td>Gender</td>
					<td><form:radiobutton path="gender" value="Male" /> Male <form:radiobutton
							path="gender" value="Female" /> Female</td>
					<td>Selected value: <b> ${tagForm.gender} </b></td>
				</tr>

				<tr>
					<td>Skill:</td>
					<td><form:radiobuttons path="skill" items="${skillArray}" /></td>
					<td>Selected value: <b> ${tagForm.skill} </b></td>
				</tr>
				<tr>
					<td>Course:</td>
					<td><form:radiobuttons path="course" items="${coursesList}" />
					</td>
					<td>Selected value: <b> ${tagForm.course} </b></td>
				</tr>
				<tr>
					<td>Lang:</td>
					<td><form:radiobuttons path="lang" items="${languagesMap}" />
					</td>
					<td>Selected value: <b> ${tagForm.lang} </b></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" name="operation"></td>
				</tr>
			</table>
		</form:form>

		<H2>
			Form 4: &lt;form:select:
			</H1>

			<form:form method="GET" commandName="tagForm">

				<table>
					<tr>
						<td>Gender</td>
						<td><form:select path="gender">
								<form:option value="Male" />
								<form:option value="Female" />
							</form:select></td>
						<td>Selected value: <b> ${tagForm.gender} </b></td>
					</tr>

					<tr>
						<td>Skill:</td>
						<td><form:select path="skill" items="${skillArray}" /></td>
						<td>Selected value: <b> ${tagForm.skill} </b></td>
					</tr>

					<tr>
						<td>Course:</td>
						<td><form:select path="course">
								<form:option value="-" label="--Please Select" />
								<form:options items="${coursesList}" />
							</form:select></td>
						<td>Selected value: <b> ${tagForm.course} </b></td>
					</tr>
					<tr>
						<td>Lang:</td>
						<td><form:select path="lang" items="${languagesMap}" /></td>
						<td>Selected value: <b> ${tagForm.lang} </b></td>
					</tr>
					<tr>
						<td>Role:</td>
						<td><form:select path="role" items="${roleList}"
								itemValue="id" itemLabel="name" /></td>
						<td>Selected value: <b> ${tagForm.role} </b></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save" name="operation"></td>
					</tr>
				</table>
			</form:form>
</body>
</html>