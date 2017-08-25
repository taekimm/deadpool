<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	<h1>Welcome ${currentUser.fname }!</h1>
	<a href="/users/createPool">Create Deadpool</a>
	<fieldset>
		<legend>Your deadpool invites</legend>
			<c:forEach items="${currentUser.getInvitedDeadpools() }" var="deadpool">
				${deadpool.name } | <a href="/users/deadpool/${deadpool.id}/accept">Accept Invite</a>
			</c:forEach>
	</fieldset>
	
	<fieldset>
		<legend>Your active deadpools</legend>
			<ul>
			<c:forEach items="${currentUser.getActiveDeadpools() }" var="deadpool">
				<li><a href="/users/deadpool/${deadpool.id}">${deadpool.name}</a></li>
			</c:forEach>
			</ul>
	</fieldset>
</body>
</html>