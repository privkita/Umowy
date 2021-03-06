<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Umowy</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
	<div class="container">
		<div class="header">
			<h1 class="header-heading">UMOWA 5000</h1>
		</div>
		<div class="nav-bar">
			<ul class="nav">
				<li><a href="/Umowy/index">START</a></li>
				<li><a href="/Umowy/contracts?filtr=aktywne">AKTYWNE</a></li>
				<li><a href="/Umowy/contracts?filtr=wszystkie">WSZYSTKIE</a></li>
				<li><a href="/Umowy/newContract">NOWA</a></li>
				<li><a href="/Umowy/import">IMPORT</a></li>
				<li><a href="/Umowy/systems">SYSTEMY</a></li>
				<li><a href="/Umowy/about">O APLIKACJI</a></li>
			</ul>
		</div>
		<div class="content">
		<form method="post">
			<h1>Import umów z pliku</h1>
			<h4>${message }</h4>
			<br>
			<h5>Przed importem danych proszę się upewnić, że Systemy których dotyczą umowy są zdefiniowane w bazie programu.</h5>
			<br>
			Podaj pełną ścieżkę do pliku:
			<input type="text" name="path" size="50">
			<br>
			<br> 
			<input type="submit" class="button" value="Importuj">
		</form>
		</div>
		<div class="footer">&copy; Copyright 2018</div>
	</div>
</body>
</html>