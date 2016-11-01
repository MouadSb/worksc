<div id="addProjectModal" class="modal fade" role="dialog">
  			<div class="modal-dialog">				
					<div class="modal-content">
						<div class="modal-header">
							<div class="col-md-12">
								<img src="../resources/images/logoSB.png" class="img-responsive pull-left">
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
										action="/GestionS/projet/add"
										modelAttribute="projetModel" class="form-horizontal">

										<div class="form-group">
											<label for="nom-de-projet">Nom de projet</label>
											<form:input path="nomProjet" type="text"
												class="form-control" id="nom-de-projet"
												aria-describedby="projetHelp" placeholder="Nom de projet" />
										</div>
										<div class="form-group">
											<label for="chef-de-projet">Chef de projet</label>
											<form:select path="idChef" items="${chefList}" itemValue="id"
												itemLabel="nomComplet" class=" form-control" id="idChef" />
										</div>
										<div class="form-group">
											<label for="nom-de-client">Nom de client</label>
											<form:input path="nomClient" type="text"
												class="form-control" id="nom-de-client"
												aria-describedby="clientHelp" placeholder="Nom de client" />
										</div>
										<button style="margin-bottom:5px;" id="btn_tacheADDP" type="submit" class="btn btn-default cnx-btn pull-right mrg">Ajouter</button>
									</form:form>
								</div>
								
							</div>
						</div>

					</div>
				</div>
			</div>