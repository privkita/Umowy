<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<li><a href="/Umowy/newContract">DODAJ</a></li>
				<li><a href="/Umowy/systems">SYSTEMY</a></li>
				<li><a href="#">O APLIKACJI</a></li>
			</ul>
		</div>
		<div class="content">

			<form method="post">

				<h1>Edycja umowy: ${param.id }</h1>
				<h3>${message }</h3>
				<table>
					<tr>
						<th>numer</th>
						<th>system</th>
						<th>data od / do</th>
						<th>wpływy</th>
						<th>okres</th>
						<th>aktywna</th>
					</tr>
					<tr>
						<td>${contract.id }</td>
						<td>
							<select name="setSystem">
								<option value="${contract.system }">${contract.system }</option>
								<option value="">-------</option>
								<c:forEach var="system" items="${systems }">
									<option value="${system.name }">${system.name }</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<input type="date" name="setStartDate"
							value="${contract.startDate }"> 
							<br> <br> 
							<input type="date" name="setEndDate" value="${contract.endDate }">
						</td>
						<td>
							<input type="text" name="setAmount" maxlength="10"
							size="7" value="${contract.amount }">
						</td>
						<td>
							<input type="text" name="setSettlement" maxlength="15"
							 size="7" value="${contract.settlement }">
						</td>
						<td>
							<select name="setActive">
								<option value="${contract.active }">${contract.active }</option>
								<option value="">-------</option>
								<option value="tak">tak</option>
								<option value="nie">nie</option>
							</select>
						</td>
					</tr>
				</table>
				<br> 
				<input type="submit" class="button" value="Zapisz">
			</form>
		</div>
		<div class="footer">&copy; Copyright 2018</div>
	</div>
</body>
</html>