<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${deadpool.name }</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
	<fieldset>
		<legend><h2>Deadpool: ${deadpool.name }</h2></legend>
		<c:forEach items="${deadpool.usersInDeadpool}" var="user">
        		<ul class="list-group">
            		<li class="user">${user.fname} ${user.lname}</li>
        		</ul>
    		</c:forEach>
		
		<form method="POST" action="/users/addUser">
			<select name="invitedUserId">
				<c:forEach items="${allUsers }" var="user">
                    	<option name="invitedUserId" value="${user.getId() }">${user.fname} ${user.lname}</option>
                </c:forEach>
			</select>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="hidden" value="${deadpool.getId() }" name="deadpoolId">
			<input type="submit" value="Invite User">
		</form>
	</fieldset>
	
	<a href="/users/deadpool/${deadpool.id}/addpicks">Add picks</a>
</body>
</html>
