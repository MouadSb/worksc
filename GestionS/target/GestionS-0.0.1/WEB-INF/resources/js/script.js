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
						//
						//window.open("index", "_self");
					},
					error : function(jqXHR, textStatus, errorThrown) {
						//alert("T4");
						//window.open("index", "_self");
					}
				}); 
			
			
			
		});