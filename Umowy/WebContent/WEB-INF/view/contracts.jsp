<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Umowy</title>
<link rel="stylesheet" href="assets/css/styles.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1 class="header-heading">UMOWA 5000</h1>
		</div>
		<div class="nav-bar">
			<ul class="nav">
				<li><a href="/Umowy/contracts?filtr=aktywne">AKTYWNE</a></li>
				<li><a href="/Umowy/contracts?filtr=wszystkie">WSZYSTKIE</a></li>
				<li><a href="/Umowy/systems">SYSTEMY</a></li>
				<li><a href="#">O APLIKACJI</a></li>
			</ul>
		</div>
		<div class="content">
			<h1>Umowy: ${param.filtr }</h1>
			<table>
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
		</div>
		<div class="footer">
			&copy; Copyright 2018
		</div>
	</div>
</body>
</html>