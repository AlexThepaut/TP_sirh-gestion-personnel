<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SGP - App</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
	</head>
	<body>
		<div class="header">
			<h1 class="jumbotron">Nouveau collaborateur</h1>
		</div>
		<div class="container">
			<form action="/sgp/collaborateurs/nouveau" method="post">
				<div class="row">
					<div class="col-sm-4">
						Nom
					</div>
					<div class="col-sm-8">
						<input type="text" name="inputNom" class="form-control">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-4">
						Prénom
					</div>
					<div class="col-sm-8">
						<input type="text" name="inputPrenom" class="form-control">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-4">
						Date de naissance
					</div>
					<div class="col-sm-8">
						<input type="date" name="inputDateNaissance" class="form-control">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-4">
						Adresse
					</div>
					<div class="col-sm-8">
						<input class="form-control" name="inputAdresse">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-4">
						Numéro de sécurité sociale
					</div>
					<div class="col-sm-8">
						<input type="number" name="inputNumSecu" class="form-control">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-11"></div>
					<div class="col-sm-1">
						<input type="submit" value="Créer" class="btn-default float-right">
					</div>
				</div>
			</form>
		</div>
	</body>
</html>