<div class="modal" id="update">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header"> 
			<div class="col-md-12">
				<img src="resources/images/logoSB.png" class="img-responsive pull-left" alt="">
				<button type="button" class="close pull-right" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			</div>
			<div class="modal-body">
				<ul class="nav nav-tabs">
				  <li class="active"><a data-toggle="tab" href="#menuEdit" id="menuM">Tâches</a></li>
				</ul>

				<div class="tab-content">
				  <div id="homeEdit" class="tab-pane fade in active">
					<form>
						<input type="text" id="idTacheEdit" hidden="hidden">
						<div class="form-group">
							<label for="nom-de-tache">Nom de tache</label>
							<input type="text" class="form-control" id="nomTacheM" aria-describedby="emailHelp" placeholder="Nom de tache">
						  </div> 
						  <div class="form-group">
								<label for="Status">Status</label>
								<select class="form-control" id="statusM">
								  <option value="Non démarée">Non démarée</option>
								  <option value="En cours">En cours</option>
								  <option value="En attente de validation interne">En attente de validation interne</option>
								  <option value="En attente de validation client">En attente de validation client</option>	  
								  <option value="Finalisée et remis">Finalisée et remis</option> 
								</select>
						  </div>
						  <div class="form-group row">
							  <label for="example-date-input" class="col-xs-4 col-form-label">Date de début</label>
							  <div class="col-xs-12">
								<input class="form-control" type="date"  id="datedTacheM">
							  </div>
						  </div>
						  					  
							<div class="form-group row">
							  <label for="example-date-input" class="col-xs-4 col-form-label">Date de fin</label>
							  <div class="col-xs-12">
								<input class="form-control" type="date"  id="datefTacheM">
							  </div>
							</div>
						  <div class="form-group">
								<label for="chef-de-projet">Nom de projet</label>
								<select class="form-control" id="nomProjetMT">
									 <c:forEach var="listptachev" items="${listptache}">
											<option value="${listptachev.nomProjet}">${listptachev.nomProjet}</option>
									</c:forEach>
								</select>
							</div>
						 
						  <button style="margin-bottom:5px;" id="btn_tacheT" type="submit" class="btn btn-default cnx-btn pull-right mrg">Modifier</button>
					</form>
				  </div>
				  <div id="menuEdit" class="tab-pane fade">
					
				  </div> 
				</div>
			</div>
			 
		</div>
	</div>
</div>
<script src="resources/js/script.js"></script>