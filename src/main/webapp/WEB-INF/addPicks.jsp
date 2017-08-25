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
		<legend><h2>Add pick</h2></legend>
			<form:form method="POST" action="/users/deadpool/${deadpool.id}/addpicks" modelAttribute="pick">
				<p><select name="killerId">
					<c:forEach items="${allCharacters}" var="character">
						<option value="${character.id}">${character.fname} ${character.lname}</option>
					</c:forEach>
				</select>
				 kills 
				 <select name="victimId">
					<c:forEach items="${allCharacters}" var="character">
						<option value="${character.id}">${character.fname} ${character.lname}</option>
					</c:forEach>
				</select>
				</p>
				<input type="submit" value="Make pick!">
			</form:form>
	</fieldset>
	<a href="/users/deadpool/${deadpool.id}">Back</a>
</body>
</html>