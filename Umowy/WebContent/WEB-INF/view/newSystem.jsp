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
				<li><a href="/Umowy/index">START</a></li>
				<li><a href="/Umowy/contracts?filtr=wszystkie">UMOWY</a></li>
				<li><a href="/Umowy/systems">SYSTEMY</a></li>
				<li><a href="/Umowy/newSystem">NOWY</a></li>
				<li><a href="/Umowy/about">O APLIKACJI</a></li>
			</ul>
		</div>
		<div class="content">
		<form method="post">
			<h1>Nowy system</h1>
			<h4>${message }</h4>
			<table>
				<tr>
					<th>Nazwa</th>
					<th>Opis</th>
					<th>Technologie</th>
					<th>Klient</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="setName" maxlength="30" size="15">
					</td>
					<td>${system.description }
						<input type="text" name="setDescription" maxlength="400">
					</td>
					<td>${system.technologies }
						<input type="text" name="setTechnologies" maxlength="200">
					</td>
					<td>${system.client }
						<input type="text" name="setClient" maxlength="30" size="15">
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" class="button" value="Zapisz">
		</form>
		</div>
		<div class="footer">
			&copy; Copyright 2018
		</div>
	</div>
</body>
</html>>