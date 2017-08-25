<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
</head>
<body>
    <h1>Characters</h1>
    
    <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/admin/characters/pages/${index}">${index}</a>
    </c:forEach>
    <table class="table">
        <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Edit</th>
        </thead>
        <tbody>
            <c:forEach var="character" items="${characters.content}">                 
            <tr>
                <td><c:out value="${character.fname}"></c:out></td>
                <td><c:out value="${character.lname}"></c:out></td>
                <td><a href="/admin/characters/${character.id}/edit">Edit</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a href="/admin">Go back to main page</a>
    
</body>
</html>