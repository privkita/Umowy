<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Umowy</title>
</head>
<body>
	<h1>Umowy - lista systemów</h1>
	<table border="1">
		<tr>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Technologie</th>
			<th>Klient</th>
		</tr>
		<c:forEach var="system" items="${systems }">
			<tr>
				<td>${system.name_name }</td>
				<td>${system.description }</td>
				<td>${system.technologies }</td>
				<td>${system.client }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>