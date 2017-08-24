<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create a New Character</title>
</head>
<body>
	
	<form:form action="/admin/characters/new" method="POST" modelAttribute="char">
		
		<p>
			<form:label path="fname"> First Name:
				<form:errors path="fname"/>
				<form:input path="fname"/>
			</form:label>
		</p>
		
		<p>
			<form:label path="lname"> Last Name:
				<form:errors path="lname"/>
				<form:input path="lname"/>
			</form:label>
		</p>
		
		<p>
			<form:label path="alive"> Alive? 
				<form:errors path="alive"/>
				<form:input path="alive"/>
			</form:label>
		</p>	
		
		<input type="Submit" value="Create New Character" />	
		
	</form:form>
	
</body>
</html>