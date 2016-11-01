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

<div class="container-fluid"
	style="width: 90%; height: auto; margin: 0 auto; padding: 10px; position: relative;">
	<div class="row">
		<form:form id="div_add" method="post"
			action="/MedicalGap/medicaleactivities/add"
			modelAttribute="medicaleactivities" class="form-horizontal">

			<form:input path="idMa" type="hidden" class="form-control" id="idMa"
				placeholder="idMa" />

			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-md-4 control-label">Date</label>
					<div class="col-md-5">
						<form:input path="date" type="date" class="form-control" id="date" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Titre</label>
					<div class="col-md-5">
						<form:input path="titre" type="text" class="form-control"
							id="titre" placeholder="titre" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Auteur interne</label>
					<div class="col-md-5">
						<form:input path="auteur" type="text" class="form-control"
							id="auteur" placeholder="auteur" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">HCPs impliqués</label>
					<div class="col-md-5">
						<form:input path="hcp" type="text" class="form-control" id="hcp"
							placeholder="hcp" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Produit</label>
					<div class="col-md-5">
						<form:input path="produits" type="text" class="form-control"
							id="produits" placeholder="produits" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Impact</label>
					<div class="col-md-5">
						<form:input path="impact" type="text" class="form-control"
							id="impact" placeholder="impact" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Type de guidline :</label>
					<div class="col-md-5">
						<form:select path="type" items="${listtypema}"
							itemValue="typeMedical" itemLabel="typeMedical"
							class=" form-control" id="typeMedical" />
					</div>
				</div>

			</div>
			<div class="col-xs-6">
				<div class="form-group">
					<label class="col-md-5 control-label">Reference</label>
					<div class="col-md-5">
						<form:input path="reference" type="text" class="form-control"
							id="reference" placeholder="reference" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-5 control-label">Conclusion :</label>
					<div class="col-md-5">
						<form:textarea path="conclusion" rows="4" cols="70"
							class="form-control" id="conclusion" placeholder="conclusion" />
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
					<label class="col-md-5 control-label">Responsable</label>
					<div class="col-md-5">
						<form:input path="responsable" type="text" class="form-control"
							id="responsable" placeholder="responsable" />
					</div>
				</div>
			</div>
			<div 
				style="position: absolute; bottom: 5px; right: 1px;">
				<button type="submit" class="btn  btn-add btn-lg">
					<img alt="delete" src="/MedicalGap/resources/images/icone_add.png"
						style="max-height: 14px; max-width: 14px;"> Ajouter
				</button>

			</div>
		</form:form>
		<form:form id="div_modify" modelAttribute="medicaleactivities"
			class="form-horizontal">

			<form:input path="idMa" type="hidden" class="form-control" id="idMa"
				placeholder="idMa" />

			<div class="col-xs-6">
				
				<div class="form-group">
					<label class="col-md-4 control-label">Date</label>
					<div class="col-md-5">
						<form:input path="date" type="date" class="form-control"
							id="date_m" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Titre</label>
					<div class="col-md-5">
						<form:input path="titre" type="text" class="form-control"
							id="titre_m" placeholder="titre" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Auteur interne</label>
					<div class="col-md-5">
						<form:input path="auteur" type="text" class="form-control"
							id="auteur_m" placeholder="auteur" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">HCPs impliqués</label>
					<div class="col-md-5">
						<form:input path="hcp" type="text" class="form-control" id="hcp_m"
							placeholder="hcp" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Produit</label>
					<div class="col-md-5">
						<form:input path="produits" type="text" class="form-control"
							id="produit_m" placeholder="produits" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label">Type de guidline :</label>
					<div class="col-md-5">
						<form:select path="type" items="${listtypema}"
							itemValue="typeMedical" itemLabel="typeMedical"
							class=" form-control" id="typeMedical_m" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label">Impact</label>
					<div class="col-md-5">
						<form:input path="impact" type="text" class="form-control"
							id="impact_m" placeholder="impact" />
					</div>
				</div>

			</div>
			<div class="col-xs-6">
				
			
				<div class="form-group">
					<label class="col-md-5 control-label">Reference</label>
					<div class="col-md-5">
						<form:input path="reference" type="text" class="form-control"
							id="reference_m" placeholder="reference" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-5 control-label">Conclusion :</label>
					<div class="col-md-5">
						<form:textarea path="conclusion" rows="4" cols="70"
							class="form-control" id="conclusion_m" placeholder="conclusion" />
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
					<label class="col-md-5 control-label">Responsable</label>
					<div class="col-md-5">
						<form:input path="responsable" type="text" class="form-control"
							id="responsable_m" placeholder="responsable" />
					</div>
				</div>
			</div>
			<div 
				style="position: absolute; bottom: 5px; right: 1px;">
				<button id="btn_form_mod" type="button" class="btn  btn-add btn-lg"
					style="margin-top: 20%">
					<img alt="delete" src="/MedicalGap/resources/images/icone_edit.png"
						style="max-height: 14px; max-width: 14px;"> Modifier
				</button>

			</div>
		</form:form>
	</div>
</div>