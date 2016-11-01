<div id="addTacheModal" class="modal fade" role="dialog">
  			<div class="modal-dialog">				
					<div class="modal-content">
						<div class="modal-header">
							<div class="col-md-12">
								<img src="resources/images/logoSB.png" class="img-responsive pull-left" alt="">
								<button type="button" class="close pull-right"
									data-dismiss="modal">
									<span>&times;</span>
								</button>
							</div>
						</div>
						<div class="modal-body">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#home" >Projet</a></li>
							</ul>

							<div class="tab-content container-fluid">
								<div id="home" class="tab-pane fade in active">
									<form:form id="div_add" method="post"
										action="/GestionS/tache/add"
										modelAttribute="Tach" class="form-horizontal">
										
										<div class="form-group">
											<label for="nom-de-projet">Nom de la tâche</label>
											<form:input path="nomTache" type="texte"
												class="form-control" id="nom-de-tache"
												aria-describedby="projetHelp" placeholder="Nom de la tâche" />
										</div>
										<div class="form-group">
											<label for="chef-de-projet">Projet</label>
											<form:select path="idProjet" items="${listallprojet}" itemValue="idProjet"
												 class=" form-control" id="idProjetT" itemLabel="nomProjet"/>
										</div>
										<div class="form-group">
										  <label for="example-date-input">Date de début</label>
											<form:input class="form-control" type="date"  id="datedTacheM" path="datedTache"/>
									  </div>
									  					  
										<div class="form-group">
										  <label for="example-date-input">Date de fin</label>
											<form:input class="form-control" type="date"  id="datefTacheM" path="datefTache"/>
										</div>
										<div class="form-group">
											<label for="nom-de-client">Description</label>
											<form:input path="descriptionTache" type="texte"
												class="form-control" id="nom-de-client"
												aria-describedby="clientHelp" placeholder="" />
										</div>
										<button style="margin-bottom:5px;" id="btn_tacheADDP" type="submit" class="btn btn-default cnx-btn pull-right mrg">Ajouter</button>
									</form:form>
								</div>
								
							</div>
						</div>

					</div>
				</div>
			</div>