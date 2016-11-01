<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">


<title>Administrateur</title>

<script src="../resources/js/jquery-2.1.4.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>

</head>
<body class="full-bg ">
	<div id="wrapper" class="">
	<%@include file="forms/projetDetail.jsp"%>
	<%@include file="forms/modelAdd.jsp"%>
	
		<link
			href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
			rel="stylesheet" />
		<link
			href="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css"
			rel="stylesheet" />

		<script
			src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
		<script
			src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
		<link rel="stylesheet" href="../resources/css/styles.css">
		<link rel="stylesheet" href="../resources/css/simple-sidebar.css">
		<%@include file="forms/modalConfirm.jsp"%>
		<div class="container-fluid">

			<div class="row">
				<div class="col-md-4">
					<div id="sidebar-wrapper">
						<ul class="sidebar-nav">
							<li class="sidebar-brand"><a href="#"> Administration </a></li>
							<li><a href="#">Projets</a></li>
							<li><a href="#">Catégories</a></li>
							<li><a href="#">Clients</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-12">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <a href="#menu-toggle"
						class="btn btn-default pull-left" id="menu-toggle"><span
						class="glyphicon glyphicon-hand-left" aria-hidden="true"></span>
					</a> 
				</div>
			</div>

		<div class="col-md-11 col-md-offset-1 no-padding">
			<div class="row" style="margin-top:70px; margin-bottom:70px;">

				<div class="btn-group col-md-1 col-md-offset-10">
				    
				   <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				   		    <img alt="profil" src="../resources/images/icone_profil.png">
		    		</a>
				    <ul class="dropdown-menu" role="menu">
				      <li><a href="#">Profil</a></li>
				      <li><a href="<c:url value="/logout" />">Deconnexion</a></li>
				    </ul>
		 	 	</div>
			</div>
		</div>

		<div class="row" style="margin-top:80px;">
		

			<div class="col-md-10 col-md-offset-1 no-padding">
			
				<table id="tableA" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th class="hidden-sm hidden-md hidden-lg hidden-xs">ID Projet</th>
							<th>Nom de projet</th>
							<th>Chef de projet</th>
							<th>Statut</th>
							<th>Date de début</th>
							<th>Date de fin</th>
							<th>Client</th>
							<th>Sélectionner</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="listProjet" items="${listsprojets}">
							<tr id="${listProjet.idProjet}">
								<td class="hidden-sm hidden-md hidden-lg hidden-xs">${listProjet.idProjet}</td>
								<td><a id="${listProjet.idProjet}" href="#" data-toggle="modal"
								data-target="#policy" onclick="projectDetails(this.id)">${listProjet.nomProjet}</a></td>
								<td>${listProjet.nomChef}</td>
								<td>${listProjet.statutP}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${listProjet.dateDP}"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${listProjet.dateFP}" /></td>
								<td>${listProjet.nomClient}</td>
								<td> <input type="radio" name="rads" id="${listProjet.nomProjet}"
								value="${listProjet.idProjet}"></td> 
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
			<div class="row">
				<div class="col-md-6 col-md-offset-3 no-padding">

					<div class="btn-group btn-group-justified" role="group"
						aria-label="...">
						<div class="btn-group functions-btn-holder" role="group">
							<button type="button" class="btn btn-default" data-toggle="modal" 
							data-target="#addProjectModal">Ajouter</button>
						</div>
						<div class="btn-group functions-btn-holder" role="group">
							<button id="btn_ARemove" type="button" class="btn btn-default" onclick="deleteRow();">Supprimer</button>
						</div>
					</div>

				</div>
			</div>
		</div>

		
	</div>
<script>
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});
		
</script>	
	
</body>
</html>