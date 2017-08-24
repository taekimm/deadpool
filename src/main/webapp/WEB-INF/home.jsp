<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>GoT  &#128128; &#128169;l</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
		<h1>Game of Thrones &#128128; &#128169;L</h1>
		<h2>Hello user!</h2>
		
		<div id="myPools">
			<table class="table table-striped table-bordered table-sm" width="50%;">
				<thead>
					<tr>
						<th>Pool name</th>
						<th>Host</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${yourPools}" var="pool">
							<td>"${pool.name}"</td>
							<td>"${pool.host.fname}" "${pool.host.lname}" test</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Test</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>Test</td>
						<td>Test</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div id="invitePools">
			<table class="table table-striped table-bordered table-sm">
				<thead>
					<tr>
						<th>Pool name</th>
						<th>Host</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${yourPools}" var="pool">
							<td>"${pool.name}"</td>
							<td>"${pool.host.fname}" "${pool.host.lname}" test</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Test</td>
						<td>Test</td>
					</tr>
					<tr>
						<td>Test</td>
						<td>Test</td>
					</tr>
				</tbody>
			</table>
		</div>
</body>
</html>