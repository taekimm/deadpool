<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Character</title>
</head>
<body>
    <fieldset>
        <legend>Edit an character</legend>
        <form:form method="POST" action="/admin/characters/${character.id}/edit" modelAttribute="character">
        
            <p>
                <form:label path="fname">First Name:</form:label>
                <form:input path="fname"/>
            </p>
            <p>
                <form:label path="lname">Last Name:</form:label>
                <form:input path="lname"/>
            </p>
            
            <p>
            		<p>Alive?</p>
            		<form:label path="alive">
            			<form:radiobutton path="alive" value="1" /> True
            			<form:radiobutton path="alive" value="0" /> False
            		</form:label>
                
            </p>
            
            <input type="submit" value="Edit">
        </form:form>
    </fieldset>
    
    
    <a href="/admin">Go back to main page</a>
</body>
</html>