
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SGP - App</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.3.1-dist/css/bootstrap.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/style/main.css">
	</head>
	<body>
		<div class="header">
			<h1 class="jumbotron">Les collaborateurs</h1>
		</div>
		<div class="container">
			<form action="" method="post" class="sectionRecherche">
				<div class="row">
					<div class="col-sm-4">Rechercher un nom qui commance par : </div>
					<div class="col-sm-2">
						<input type="text" name="rechercherNom" class="form-control">
					</div>
					<div class="col-sm-2">
						<input type="submit" value="Rechercher" class="btn-default center">
					</div>
				</div>
			</form>
			<br>
			<div class="d-flex flex-wrap">
			<% List<Collaborateur> listCollab = (List<Collaborateur>) request.getAttribute("listCollaborateurs");
			if(listCollab.size() > 0){
				int i = 0;
				for(Collaborateur collab : listCollab){
					%>
					<div class="card">
		                <div class="card-horizontal">
		                    <div class="img-square-wrapper">
		                        <img class="card-img-" src="<%=listCollab.get(i).getPhoto() %>" alt="Card image" style="width:100%">
		                    </div>
		                    <div class="card-body">
		                        <h4 class="card-title"><%=listCollab.get(i).getNom() %> <%=listCollab.get(i).getPrenom() %></h4>
								<p class="card-text"><%=listCollab.get(i).getMatricule() %></p>
								<p class="card-text"><%=listCollab.get(i).getEmailPro() %></p>
		                    </div>
		                </div>
		            </div>
					<%
					i++;
				}
			}
			%>
			<!--
			<c:set var="listCollab" scope="session" value="${param.listCollab}" />
			<c:forEach items="${ listCollab }" var="collab">
				<p><c:out value="${ collab.getNom() }" /></p>
			</c:forEach>  -->
			</div>		
		</div>
	</body>
</html>