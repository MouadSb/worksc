<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="true"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link
	href="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.5.4/bootstrap-select.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="resources/css/styles.css">
<title>Administrateur</title>

<script src="resources/js/jquery-2.1.4.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/script.js"></script>
<script
	src="resources/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>



</head>
<body class="full-bg user-home-bg" style="background-image: url('resources/images/backgroundAdmin.png') ;  
	background-attachment:fixed;
    background-repeat: no-repeat;
    background-size: 100% 100%;">
	<div class="container-fluid">
		
		<div class="row" style="margin-top:200px;">
			
			<div class="col-md-4 col-md-offset-5">
				<p class="pull-left" id="pAuth" style="font-size: 30px; color:white;"> <span style="text-transform: capitalize">M. ${currentUser}</span><p>
			</div>
			 <div class="btn-group col-md-1 col-md-offset-1" style="margin-right:10px;">
		    
				   <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				   		    <img alt="profil" src="resources/images/iconeinverse.png">
		    		</a>
				    <ul class="dropdown-menu" role="menu">
				      <li><a href="#">Profil</a></li>
				      <li><a href="<c:url value="/logout" />">Deconnexion</a></li>
				    </ul>
 			 </div>
 		 </div></div>
 		 
 		 <div class="row">
 		 	<div class="container-fluid col-md-3 pull-right" style="margin-right:150px; margin-top: 150px; text-align:center; 
 		 	background-color:#f5f6f6; border-radius:4px;">
 		 		<div class="form-group" style="margin-top: 40px;">
 		 		<form action="/GestionS/admin/redirect" method="POST">
 		 		
 		 			<select id="selectCat" name="selectCat" class="form-control">
 		 				<c:forEach var="cat" items="${listModule}">
 		 					<option value="${cat.nomModule}">${cat.nomModule}</option>
						</c:forEach>
 		 			</select>
 		 			
 		 			<button style="margin-bottom:10px;" type="submit" class="btn btn-default cnx-btn pull-right mrg">Suivant</button>
 		 		</form>

				</div>
 		 	</div>
 		 </div>
 		
 	 

</body>
</html>