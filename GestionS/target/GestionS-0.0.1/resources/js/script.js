/************************************************ Utiliasteur buttons function ***********************************************/
/**** Button update Projet Admin ****/
$("#btn_tacheT").click(
		function() {
			var e = document.getElementById("statusM");
			var strUser = e.options[e.selectedIndex].value;
			 var json = {
					"idProjet" : document.getElementById('nomProjetMT').value,
					"idTache" : document.getElementById('idTacheEdit').value,
					"nomTache" : document.getElementById('nomTacheM').value,
					"statu" : strUser,
					"dateD" : document.getElementById('datedTacheM').value,
					"dateF" : document.getElementById('datefTacheM').value,

				}; 
			
			
				$.ajax({
					type : "POST",
					dataType : 'json',
					url : "/GestionS/tache/edit",
					data : json, // Note it is important
					success : function(result) {
						window.open("projets", "_self");
					},
					error : function(jqXHR, textStatus, errorThrown) {
						window.open("projets", "_self");
					}
				}); 
			
			
			
		});



/************************************************ Administrateur buttons function ***********************************************/

			/**** Button update Projet Admin ****/
$("#btn_projetA").click(
		function() {
			var e = document.getElementById("statutP");
			var strUser = e.options[e.selectedIndex].value;
			var chef = $("#proprietaireP").val();
			var json = {
					"idProjet" : document.getElementById('idProjet').value,
					"nomProjet" : document.getElementById('nomProjet').value,
					"proprietaire" : chef,
					"dateD" : document.getElementById('date-de-debutP').value,
					"dateF" : document.getElementById('date-de-finP').value,
					"statu" : strUser,	
					"description" : document.getElementById('description').value
				};
				$.ajax({
					type : "POST",
					dataType : 'json',
					url : "/GestionS/projetA/edit",
					data : json, // Note it is important
					success : function(result) {
						window.open("projets", "_self");
					},
					error : function(jqXHR, textStatus, errorThrown) {
						window.open("projets", "_self");
					}
				}); 
			
			
			
		});

		/**** Charges les tâches pour Admin ****/
var cpt_d=0;
function tacheDetails(){
	if(cpt_d==0){
	var json = {
			"idProjet" :document.getElementById('idProjet').value,
		};
	
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "/GestionS/tacheA/getAll",
		data : json, // Note it is important
		success : function(result) {
			              var table = $('#tachDetailT').DataTable( {
			                  data: result
			              } );    
			              cpt_d=1;
		},
		error: function(jqXHR, textStatus, errorThrown) {
			  alert("t"+errorThrown);
			  
			}
	});  
			
	
	 }};

	 $('#policy').on('hidden.bs.modal', function () {
		 cpt_d=0;
		 window.open("projets", "_self");
		});


	 
/** Charge details d'un projet**/
		function projectDetails(id){
			
			var json = {
					"id" :id,
				};
			
			$.ajax({
				type : "POST",
				dataType : 'json',
				url : "/GestionS/admin/getProjet",
				data : json, // Note it is important
				success : function(result) {
					$('#nomProjet').val(result.nomProjet);
					$('#proprietaireP').val(result.proprietaireP);
					$('#date-de-debutP').val(result.dateD);
					$('#date-de-finP').val(result.dateF);
					$('#statutP').val(result.statutP);
					$('#description').val(result.description); 
					$('#idProjet').val(id); 
				},
				error: function(jqXHR, textStatus, errorThrown) {
					  alert(errorThrown);
					}
			});  
					
			
			 };
/** Supprimer un projet par admin **/
			 function deleteRow() {
				
					
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
							url : "/GestionS/projetA/remove/" + id,
							dataType : 'json',
							async : true,
							success : function(result) {
								 window.open("projets", "_self");
							},
							error : function(jqXHR, textStatus, errorThrown) {
								 window.open("projets", "_self");
							}
						}); 
					}

				}

/*************************************** END Administrateur button function ***********************************************/

			 
			 
			 // DatatableJS
$(document).ready(function() {
	var table = $('#tableA').DataTable({
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
                "previous":   "Precedent"
            },
            "aria": {
                "sortAscending":  ": Activer pour trier la colonne ascendante",
                "sortDescending": ": Activer pour trier la colonne descendante"
            }
        },
		 //  dom: 'l<"toolbar">frtip',
		   initComplete: function(){
		      $("div.dataTables_length")
		      .append('<div class="col-sm-4 col-md-6 pull-left id="divSearch"><select type="search" class="form-control select-table-filter" data-table="tableA"><option id="optionList" value="">Tout les projets</option>  <c:forEach var="listptache" items="${listptache}"><option id="optionList" value="${listptache.nomProjet}">${listptache.nomProjet}</option></c:forEach><select></div>');         
		   }			 
		});	
	var data = table.row( 0 ).data();
//	$(".divSearch").css( "pull-right" );
	$( ".dataTables_filter" ).parent().parent().removeClass("row");
	$( ".dataTables_length" ).parent().css( "background-color", "#23c0e3" );
	$( ".dataTables_filter" ).parent().css( "background-color", "#23c0e3" );
	$(".dataTables_filter").children("label").css("color","white");
	//$("div.toolbar").html('<b>Custom tool bar! Text/images etc.</b>');
});

