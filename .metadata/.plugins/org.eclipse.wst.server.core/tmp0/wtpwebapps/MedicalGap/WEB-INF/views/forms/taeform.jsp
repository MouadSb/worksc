<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
.form-horizontal .control-label {
	text-align: left;
}

.btn-add {
	color: white;
	background-color: #0394e3;
}

.btn-add:hover {
	background-color: #0077d0;
	border: 2px solid #0077d0;
}
.btn-info, .btn-warning, .btn-danger{
	color: white;
	background-color: #0394e3;
	border-color: transparent;
}

</style>



<div class="container-fluid" style="  width: 90%;
    height: auto;
    margin: 0 auto;
    padding: 10px;
    position: relative;">
	<div class="row">
		<form:form id="div_add" method="post" action="/MedicalGap/tae/add"
			modelAttribute="tae" class="form-horizontal">

			<form:input path="idTae" type="hidden" class="form-control"
				id="idTae" placeholder="idTae" />

			<div class="col-xs-6">
				
				<div class="form-group">
					<label class="col-md-4 control-label">Date :</label>
					<div class="col-md-5">
						<form:input path="date" type="date" class="form-control" id="date" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Nombre de
						publications ${categorieSession} :</label>
					<div class="col-md-5">
						<form:input path="nbrePubBc" type="number" class="form-control"
							id="nbrePubBc" placeholder="nbrePubBc" />
					</div>
				</div>

				<div class="form-group">

					<label class="col-md-4 control-label">Nombre de
						publications Total :</label>
					<div class="col-md-5">
						<form:input path="nbreTot" type="number" class="form-control"
							id="nbreTot" placeholder="nbreTot" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Titre HCP :</label>
					<div class="col-md-5">
						<form:input path="titreHcp" type="text" class="form-control"
							id="titreHcp" placeholder="titreHcp" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Type TAE :</label>
					<div class="col-md-5">
						<form:select path="type" items="${listtypetae}"
							itemValue="typeTae" itemLabel="typeTae" class=" form-control"
							id="typeTae" />
					</div>
				</div>
				<div class="form-group">

					<label class="col-md-4 control-label">Essai clinique :</label>
					<div class="col-md-5">
						<form:input path="essaiClinique" type="text" class="form-control"
							id="essaiClinique" placeholder="Essai clinique" />
					</div>
				</div>
			</div>
			<div class="col-xs-6">
				

				<div class="form-group">
					<label class="col-md-5 control-label">Proprietaire :</label>
					<div class="col-md-5">
						<form:input path="proprietaire" type="text" class="form-control"
							id="proprietaire" placeholder="proprietaire" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-5 control-label">Conclusion :</label>
					<div class="col-md-5">
						<form:textarea path="conclusion" rows="4" cols="70"
							class="form-control" id="conclusion"
							placeholder="conclusion" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-5 control-label">Gaps, Insight ou
						Recommendation :</label>
					<div class="col-md-5">
						<form:textarea path="gapsInsightReco" rows="4" cols="90"
							class="form-control" id="gapsInsightReco"
							placeholder="gapsInsightReco" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-5 control-label">Responsable :</label>
					<div class="col-md-5">
						<form:input path="responsable" type="text" class="form-control"
							id="responsable" placeholder="responsable" />
					</div>
				</div>
				<div class="pull-right"
				style=" bottom: 5px; right: 1px; margin-top:2px;">
				<button type="submit" class="btn  btn-add btn-lg">
					<img alt="delete" src="/MedicalGap/resources/images/icone_add.png"
						style="max-height: 14px; max-width: 14px;"> Ajouter
				</button>

			</div>
			</div>
			
		</form:form>
		<form:form id="div_modify" modelAttribute="tae"
			class="form-horizontal">

			<form:input path="idTae" type="hidden" class="form-control"
				id="idTae" placeholder="idTae" />

			<div class="col-xs-6">

				<div class="form-group">
					<label class="col-md-4 control-label">Date :</label>
					<div class="col-md-5">
						<form:input path="date" type="date" class="form-control"
							id="date_m" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Nombre de
						publications ${categorieSession} :</label>
					<div class="col-md-5">
						<form:input path="nbrePubBc" type="number" class="form-control"
							id="nbrePubBc_m" placeholder="nbrePubBc" />
					</div>
				</div>

				<div class="form-group">

					<label class="col-md-4 control-label">Nombre de
						publications Total :</label>
					<div class="col-md-5">
						<form:input path="nbreTot" type="number" class="form-control"
							id="nbreTot_m" placeholder="nbreTot" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label">Titre HCP :</label>
					<div class="col-md-5">
						<form:input path="titreHcp" type="text" class="form-control"
							id="titreHcp_m" placeholder="titreHcp" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Type TAE :</label>
					<div class="col-md-5">
						<form:select path="type" items="${listtypetae}"
							itemValue="typeTae" itemLabel="typeTae" class=" form-control"
							id="typeTae_m" />
					</div>
				</div>
				
				<div class="form-group">

					<label class="col-md-4 control-label">Essai clinique :</label>
					<div class="col-md-5">
						<form:input path="essaiClinique" type="text" class="form-control"
							id="essaiClinique_m" placeholder="Essai clinique" />
					</div>
				</div>

				
			</div>
			<div class="col-xs-6">
				
				<div class="form-group">
					<label class="col-md-5 control-label">Proprietaire :</label>
					<div class="col-md-5">
						<form:input path="proprietaire" type="text" class="form-control"
							id="proprietaire_m" placeholder="proprietaire" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-5 control-label">Conclusion :</label>
					<div class="col-md-5">
						<form:textarea path="conclusion" rows="4" cols="70"
							class="form-control" id="conclusion_m"
							placeholder="conclusion" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-5 control-label">Gaps, Insight ou
						Recommendation :</label>
					<div class="col-md-5">
						<form:textarea path="gapsInsightReco" rows="4" cols="90"
							class="form-control" id="gapsInsightReco_m"
							placeholder="gapsInsightReco" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-5 control-label">Responsable :</label>
					<div class="col-md-5">
						<form:input path="responsable" type="text" class="form-control"
							id="responsable_m" placeholder="responsable" />
					</div>
				</div>
			
			<div class="pull-right"
				style=" bottom: 5px; right: 1px; margin-top:2px;">
				<button id="btn_form_mod" type="button" class="btn  btn-add btn-lg">
					<img alt="delete" src="/MedicalGap/resources/images/icone_edit.png"
						style="max-height: 14px; max-width: 14px; margin-top: 7%">
					Modifier
				</button>

			</div>
			</div>
		</form:form>

	</div>
</div>