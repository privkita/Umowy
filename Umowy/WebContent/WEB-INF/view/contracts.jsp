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
	<h1>Umowy - lista</h1>
	<table border="1">
		<tr>
			<th>Numer</th>
			<th>System</th>
			<th>Data od</th>
			<th>Data do</th>
			<th>Wynagrodzenie</th>
			<th>Rozliczenie</th>
			<th>Aktywna</th>
		</tr>
		<c:forEach var="contract" items="${contracts }">
			<tr>
				<td>${contract.id }</td>
				<td>${contract.system }</td>
				<td>${contract.startDate }</td>
				<td>${contract.endDate }</td>
				<td>${contract.amount }</td>
				<td>${contract.settlement }</td>
				<td>${contract.active }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>