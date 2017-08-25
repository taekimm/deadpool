<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Pool</title>
</head>
<body>
	<h2>Create your deadpool!</h2>
	<form:form method="POST" action="/users/processPool" modelAttribute="deadpool">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
		
	<input type="hidden" value="${host.id}" name="hostId">
	<input type="submit" value="Create Pool">
	</form:form>
	
</body>
</html>