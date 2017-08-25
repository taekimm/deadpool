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
		<c:forEach items="${ud}" var="ud2">
		<c:if test="${ud2.getDeadpool().getId() == deadpool.getId()}">
        		<ul class="list-group">
            		<li class="user"><b>${ud2.getUser().fname} ${ud2.getUser().lname}</b> | Total Score: ${ud2.totalScore}</li>
            		<ol>
            			<c:forEach items="${ud2.getUser().getUserPicks() }" var="pick">
            				<li>${pick.getKiller().fname} ${pick.getKiller().lname} kills ${pick.getVictim().fname } ${pick.getVictim().lname } | Score: ${pick.getScore() }</li>
            			</c:forEach>
            		</ol>
        		</ul>
    		</c:if>
		</c:forEach>
        <c:if test="${ host.getId() == currentUser.getId() }">
            <form method="POST" action="/users/addUser">
                <select name="invitedUserId">
                    <c:forEach items="${allUsers }" var="user">
                            <option name="invitedUserId" value="${user.getId() }">${user.fname} ${user.lname}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="xq${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" value="${deadpool.getId() }" name="deadpoolId">
                <input type="submit" value="Invite User">
            </form>
        </c:if>  
	</fieldset>
	 <c:forEach items="${allUsersInPool }" var="user">
        <c:if test="${user == currentUser }">
            <a href="/users/deadpool/${deadpool.id}/addpicks">Add picks</a>
        </c:if>
    </c:forEach>
</body>
</html>
