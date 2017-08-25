<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add pick to ${deadpool.name}</title>
</head>
<body>
	<fieldset>
		<legend>Add pick</legend>
		<c:if test="${usersPicksInDeadpool.size() < 11}">
			<form:form method="POST" action="users/deadpool/${deadpool.id}/addpicks" ModelAttribute="pick">
				<p><select name="killerId">
					<c:forEach items="${allCharacters}" var="character">
						<option value="${character.id}">${character.fname} ${character.lname}</option>
					</c:forEach>
				</select>
				 Kills 
				 <select name="VictimId">
					<c:forEach items="${allCharacters}" var="character">
						<option value="${character.id}">${character.fname} ${character.lname}</option>
					</c:forEach>
				</select>
				</p>
				<input type="hidden" value="{currentUser.id}">
				<input type="submit" value="Update scores!">
			</form:form>
		</c:if>
	</fieldset>
</body>
</html>