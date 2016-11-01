<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="policy" >
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="col-md-12">
					<img src="../resources/images/logoSB.png"
						class="img-responsive pull-left" alt="">
					<button type="button" class="close pull-right" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
			</div>
			<div class="modal-body">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home">Projet</a></li>
					<li><a data-toggle="tab" href="#menu1"
						onclick="tacheDetails()">Tache</a></li>
				</ul>

				<div class="tab-content">
					<div id="home" class="tab-pane fade in active">
						<form>
							<div class="row">

								<input type="hidden" id="idProjet">
								<div class="form-group col-md-6">
									<label for="proprietaire">Nom de projet</label> <input
										type="text" class="form-control" id="nomProjet"
										placeholder="Nom de projet">
								</div>

								<div class="form-group col-md-6">
									<label>Chef de projet</label>
									<select id="proprietaireP" name="chefProjet" class="form-control">
				 		 				<c:forEach var="us" items="${chefList}">
				 		 					<option value="${us.nom} ${us.prenom}">${us.nom} ${us.prenom}</option>
										</c:forEach>
				 		 			</select>
								</div>

								<div class="form-group col-md-6">
									<label for="nom-de-projet">Date de debut</label> <input
										type="date" class="form-control" id="date-de-debutP"
										placeholder="Nom de projet">
								</div>
								<div class="form-group col-md-6">
									<label for="nom-de-projet">Date de fin</label> <input
										type="date" class="form-control" id="date-de-finP"
										placeholder="Nom de projet">
								</div>
								<!--  	  <div class="form-group col-md-6">
						<label for="proprietaire">Categorie</label>
						<input type="texte" class="form-control" id="proprietaire" aria-describedby="emailHelp" placeholder="Propriétaire">
					  </div>

					 
					   <div class="form-group col-md-6">
						<label for="nom-de-projet">Budget</label>
						<input type="texte" class="form-control" id="nom-de-projet" aria-describedby="emailHelp" placeholder="Nom de projet">
					  </div> 
					  
					   <div class="form-group col-md-6">
						<label for="nom-de-projet">Budget en cours</label>
						<input type="texte" class="form-control" id="nom-de-projet" aria-describedby="emailHelp" placeholder="Nom de projet">
					  </div>
					  
				-->
								<div class="form-group col-md-6">
									<label for="Status">Status</label> <select class="form-control"
										id="statutP">
										<option value="Non démarée">Non démarée</option>
										<option value="En cours">En cours</option>
										<option value="En attente de validation interne">En
											attente de validation interne</option>
										<option value="En attente de validation client">En
											attente de validation client</option>
										<option value="Finalisée et remis">Finalisée et remis</option>
									</select>
								</div>



								<div class="form-group col-md-12">
									<label for="description" style="margin-left: 17px;">Description</label>
									<textarea class="form-control" id="description" rows="3"></textarea>
								</div>

								<button style="margin-bottom: 5px;" id="btn_projetA"
									type="submit" class="btn btn-default cnx-btn pull-right mrg">Modifier</button>

							</div>
						</form>
					</div>

					<div id="menu1" class="tab-pane fade">


<!-- IcI -->
						<table id="tachDetailT" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
						    <thead id="detailTacheth">
						        <tr>
						            <th>Nom Tâche</th>
						            <th>Date de debut</th>
						            <th>Date de fin</th>
						            <th>Description</th>
						            <th>Statut</th>
						            <th>Employé</th>
						            <th>Numero Tâche</th>
						        </tr>
						    </thead>
						    <tbody id="detailTachtb">
						    </tbody>
						</table>
						
<!-- La -->
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<script src="../resources/js/script.js"></script>