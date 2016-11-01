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
<title>Home</title>

<script src="resources/js/jquery-2.1.4.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>



<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.5.4/bootstrap-select.min.css"
	rel="stylesheet" />
<script
	src="resources/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>	
<link rel="stylesheet" href="resources/css/styles.css">


</head>
<body class="full-bg user-home-bg" style="background-image: url('resources/images/backgroundUser.png') ;  
	background-attachment:fixed;
    background-repeat: no-repeat;
    background-size: 100% 100%;">

	<div class="container-fluid">
		
		<div class="row" style="margin-top:150px;">
			<%@include file="forms/modelAdd.jsp"%>
			<%@include file="forms/modelEdit.jsp"%>
			<%@include file="forms/modalConfirm.jsp"%>
			<%@include file="forms/modelAddTache.jsp" %>
			 <div class="btn-group col-md-1 col-md-offset-10">
		    
		   <a class="dropdown-toggle" data-toggle="dropdown" href="#">
		   		    <img alt="profil" src="resources/images/icone_profil.png">
    		</a>
		    <ul class="dropdown-menu" role="menu">
		      <li><a href="#">Profil</a></li>
		      <li><a href="<c:url value="/logout" />">Deconnexion</a></li>
		    </ul>
  </div>
		</div>
		
		<div class="row" style="margin-top:10px;">

			<div class="col-md-6 col-md-offset-1 no-padding">
				<div class=" col-md-12">
						<p class="pull-left" id="pAuth" style="font-size: 30px; color:#363636;"> <span style="text-transform: capitalize">Bienvenue ${currentUser}</span><p>
				</div>
				<div class="pull-left col-md-12" style="margin-top: -10px;">
						<p class="pull-left" id="pAuth2" style="font-size: 14px; color:#363636; letter-spacing: 1.5px;"> sur l'application gestion des activités SPHEREBLEUE <p>				
				</div>
			</div>
		</div>
		 
		<div class="row" style="margin-top:80px;">
			<div class="col-md-10 col-md-offset-1 no-padding">
				
			</div>
			<div class="col-md-10 col-md-offset-1 no-padding">
			
				<table id="table" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th class="hidden-sm hidden-md hidden-lg hidden-xs">ID Tache</th>
							<th class="hidden-sm hidden-md hidden-lg hidden-xs">ID Projet</th>
							<th>Nom de projet</th>
							<th>Nom de client</th>
							<th>Les tâches</th>
							<th>Date de début</th>
							<th>Date de fin</th>
							<th>Statut</th>
							<th>Chef de projet</th>
							<th>Sélectionner</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="listProjet" items="${listProjet}">
							<tr id="${listProjet.idTache}">
								<td class="hidden-sm hidden-md hidden-lg hidden-xs">${listProjet.idTache}</td>
								<td class="hidden-sm hidden-md hidden-lg hidden-xs">${listProjet.idProjet}</td>
								<td>${listProjet.nomProjet}</td>
								<td>${listProjet.nomClient}</td>
								<td>${listProjet.nomTache}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${listProjet.datedTache}"/></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd" value="${listProjet.datefTache}"/></td>
								<td>${listProjet.statutTache}</td>
								<td>${listProjet.chefProjet}</td>
								<td> <input type="radio" name="rads" id="${listProjet.nomProjet}"
								value="${listProjet.idTache}"></td> 
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-10 col-md-offset-1 no-padding">

				<div class="btn-group btn-group-justified" role="group"
					aria-label="...">
					<div class="btn-group functions-btn-holder" role="group">
						<button type="button" class="btn btn-default" data-toggle="modal"
							data-target="#addTacheModal" id="btn_addTache">Ajouter</button>
					</div>
					<div class="btn-group functions-btn-holder" role="group">
						<button type="button" class="btn btn-default"  id="btn_edit">Modifier</button>
					</div>
					<div class="btn-group functions-btn-holder" role="group">
						<button id="btn_deleteL" type="button" class="btn btn-default">Supprimer</button>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			var table = $('#table').DataTable({
				"language": {
		            "lengthMenu": "Afficher _MENU_ enregistrements",
		            "zeroRecords": "Aucun enregistrement à afficher.",
		            "info": "Page _PAGE_ sur _PAGES_",
		            "infoEmpty": "Aucun enregistrement disponible",
		            "infoFiltered": "(filtré _MAX_ nombre total d'enregistrements)",
		            "loadingRecords": "Chargement...",
		            "processing":     "En traitement...",
		            "search":         "Rechercher:",
		            "paginate": {
		                "first":      "Premier",
		                "last":       "Dernier",
		                "next":       "Suivant",
		                "previous":   "Précédent"
		            },
		            "aria": {
		                "sortAscending":  ": Activer pour trier la colonne ascendante",
		                "sortDescending": ": Activer pour trier la colonne descendante"
		            }
		        },
				 //  dom: 'l<"toolbar">frtip',
				   initComplete: function(){
				      $("div.dataTables_length")
				      .append('<div class="col-sm-4 col-md-6 pull-left id="divSearch"><select type="search" class="form-control select-table-filter" data-table="table"><option id="optionList" value="">Tout les projets</option>  <c:forEach var="listptache" items="${listptache}"><option id="optionList" value="${listptache.nomProjet}">${listptache.nomProjet}</option></c:forEach><select></div>');         
				   }			 
				});	
			var data = table.row( 0 ).data();
			document.getElement
		//	$(".divSearch").css( "pull-right" );
			$( ".dataTables_filter" ).parent().parent().removeClass("row");
			$( ".dataTables_length" ).parent().css( "background-color", "#23c0e3" );
			$( ".dataTables_filter" ).parent().css( "background-color", "#23c0e3" );
			$(".dataTables_filter").children("label").css("color","white");
			//$("div.toolbar").html('<b>Custom tool bar! Text/images etc.</b>');
		});
		

		$("#btn_edit").click(
				function() {
					 var idProjetEdit=0,
					 idTacheEdit=0,nomProjetEdit=0,chefProjetM=0,nomClientM=0,nomTacheM=0,
					 statusM=0,nomProjetMT=0,idatefTacheM=0;
						var iidTacheEdit = $('#idTacheEdit');
						var iidProjetEdit = $('#idProjetEdit');
						var inomProjetEdit = $('#nomProjetEdit');
						var ichefProjetM = $('#chefProjetM');
						var inomClientM = $('#nomClientM');
						var inomTacheM = $('#nomTacheM');
						var istatusM = $('#statusM');
						var inomProjetMT = $('#nomProjetMT');
						var idatedTacheM = $('#datedTacheM');
						var datedTacheM;
						var datefTacheM;
						//var idatefTacheM = $('#datefTacheM');
					 
					var choix = document.getElementsByName('rads');
					var id=0;
					for(var i = 0; i < choix.length; i++){
					    if(choix[i].checked){
					        id = choix[i].value;
					    }
					}
					if(id == 0){
						$('#myModal').modal('show');	
					}else{
						$('#update').modal('show');
						$("#"+id+"").each(function() {
							idTacheEdit = $(this).find("td:nth-child(1)").html(); 
							idProjetEdit = $(this).find("td:nth-child(2)").html();    
							nomProjetEdit = $(this).find("td:nth-child(3)").html(); // deux fields
							nomProjetMT = $(this).find("td:nth-child(3)").html(); 
							nomClientM = $(this).find("td:nth-child(4)").html(); 
							nomTacheM = $(this).find("td:nth-child(5)").html(); 
							datedTacheM = $(this).find("td:nth-child(6)").html(); 
							datefTacheM = $(this).find("td:nth-child(7)").html(); 
							statusM = $(this).find("td:nth-child(8)").html(); 
							chefProjetM = $(this).find("td:nth-child(9)").html(); 
						});

						iidTacheEdit.val(idTacheEdit);
						iidProjetEdit.val(idProjetEdit);
						inomProjetEdit.val(nomProjetEdit);
						//document.getElementById('chefProjetM').value = chefProjetM;
						//document.getElementById("chefProjetM").value = chefProjetM;
						inomClientM.val(nomClientM);
						inomTacheM.val(nomTacheM);
						document.getElementById("statusM").value = statusM.capitalize();
						document.getElementById('nomProjetMT').value = nomProjetEdit;
						document.getElementById('nomTacheM').value = nomTacheM;
						document.getElementById("datefTacheM").value = datefTacheM;
						document.getElementById("datedTacheM").value = datedTacheM;

						//idatefTacheM.val(datefTacheM);
						}
				});

		String.prototype.capitalize = function() {
		    return this.charAt(0).toUpperCase() + this.slice(1);
		}

				function selectItemByValue(elmnt, value){

					  for(var i=0; i < elmnt.options.length; i++)
					  {
					    if(elmnt.options[i].value === value) {
					      elmnt.selectedIndex = i;
					      break;
					    }
					  }
					}


	
/*
	
	$("#btn_tacheT").click(	
			function() { 			
				var json = {
						"idTacheEdit" : document.getElementById('idTacheEdit').value,
						"nomTacheM" : document.getElementById('nomTacheM').value,
						"statusM" : document.getElementById('statusM').value,
						"datefTacheM" : document.getElementById('datefTacheM').value,
						"nomProjetMT" : document.getElementById('nomProjetMT').value
					};


					$.ajax({
						type : "POST",
						dataType : 'json',
						url : "/GestionS/tache/edit",
						data : json, // Note it is important
						success : function(result) {
							window.open("index", "_self");
						},
						error : function(x, e) {
							window.open("index", "_self");
						}
					}); 


				});
*/

	$("#btn_deleteL").click(function(e) {
		e.preventDefault();
		//var t = $("#table tr.selected td:first").html();
		var choix = document.getElementsByName('rads');
		var id=0;
		for(var i = 0; i < choix.length; i++){
		    if(choix[i].checked){
		        id = choix[i].value;
		    }
		}
		if (id == 0) {
			$('#myModal').modal('show');	
		} else {
			$.ajax({
				type : 'DELETE',
				url : "/GestionS/tache/remove/" + id,
				dataType : 'json',
				async : true,
				success : function(result) {
					window.open("index", "_self");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					window.open("index", "_self");
				}
			}); 
		}

	});


	(function(document) {
		'use strict';

		var LightTableFilter = (function(Arr) {

			var _input;
	    var _select;

			function _onInputEvent(e) {
				_input = e.target;
				var tables = document.getElementsByClassName(_input.getAttribute('data-table'));
				Arr.forEach.call(tables, function(table) {
					Arr.forEach.call(table.tBodies, function(tbody) {
						Arr.forEach.call(tbody.rows, _filter);
					});
				});
			}
	    
			function _onSelectEvent(e) {
				_select = e.target;
				var tables = document.getElementsByClassName(_select.getAttribute('data-table'));
				Arr.forEach.call(tables, function(table) {
					Arr.forEach.call(table.tBodies, function(tbody) {
						Arr.forEach.call(tbody.rows, _filterSelect);
					});
				});
			}

			function _filter(row) {
	      
				var text = row.textContent.toLowerCase(), val = _input.value.toLowerCase();
				row.style.display = text.indexOf(val) === -1 ? 'none' : 'table-row';

			}
	    
			function _filterSelect(row) {
	     
				var text_select = row.textContent.toLowerCase(), val_select = _select.options[_select.selectedIndex].value.toLowerCase();
				row.style.display = text_select.indexOf(val_select) === -1 ? 'none' : 'table-row';

			}

			return {
				init: function() {
					var inputs = document.getElementsByClassName('light-table-filter');
					var selects = document.getElementsByClassName('select-table-filter');
					Arr.forEach.call(inputs, function(input) {
						input.oninput = _onInputEvent;
					});
					Arr.forEach.call(selects, function(select) {
	         select.onchange  = _onSelectEvent;
					});
				}
			};
		})(Array.prototype);

		document.addEventListener('readystatechange', function() {
			if (document.readyState === 'complete') {
				LightTableFilter.init();
			}
		});

	})(document);


		
	</script>
</body>
</html>