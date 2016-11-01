<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</style>


<div class="container-fluid">
	<div class="row">
		<form:form id="div_addp" method="post"
			action="/MedicalGap/admin/addPresse" modelAttribute="presse"
			class="form-horizontal">

			<form:input path="id" type="hidden" class="form-control" id="id"
				placeholder="id" />
			<div class="col-md-10 col-sm-8">
				<div class="form-group">
					<label class="col-md-4 control-label">Nouveau type de
						presse :</label>
					<div class="col-md-5">
						<form:input path="typePresse" type="text"
							class="form-control input-md" id="typePresse"
							placeholder="Type de presse" />
							<label  id="errorC"><c:out value="${param.eltnp}" /></label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Cat�gorie :</label>
					<div class="col-md-5 selectContainer">
						<form:select path="nomCategorie" items="${listCategorie}"
							itemValue="name" itemLabel="name" class=" form-control"
							id="categorie" />
					</div>
				</div>
				<div class="col-md-2 pull-right">
					<button type="submit" class="btn  btn-add btn-lg">
						<img alt="add" src="/MedicalGap/resources/images/icone_add.png"
							style="max-height: 14px; max-width: 14px;"> Ajouter
					</button>
				</div>
			</div>
		</form:form>
		<form:form id="div_modifyp" modelAttribute="presse"
			class="form-horizontal">
			<form:input path="id" type="hidden" class="form-control" id="id"
				placeholder="ide" />
			<div class="col-md-10 col-sm-8">
				<div class="form-group">
					<label class="col-md-4 control-label">Nouveau type de
						presse :</label>
					<div class="col-md-5">
						<form:input path="typePresse" type="text"
							class="form-control input-md" id="typePressee"
							placeholder="Type de presse" />
					<label  id="errorC" class="errorCP"><c:out value="${param.eltnpm}" /></label>
							
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Cat�gorie :</label>
					<div class="col-md-5">
						<input type="text" id="oldCategoriep" class="form-control" disabled="disabled" ></input>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Nouvelle categorie :</label>
					<div class="col-md-5 selectContainer">
						<form:select path="nomCategorie" items="${listCategorie}"
							itemValue="name" itemLabel="name" class=" form-control"
							id="nomCategoriep" />
					</div>
				</div>
				<div class=" col-md-2 pull-right">
					<button id="btn_form_modp" type="button" class="btn  btn-add btn-lg">
						<img alt="update"
							src="/MedicalGap/resources/images/icone_edit.png"
							style="max-height: 14px; max-width: 14px;"> Modifier
					</button>
				</div>
			</div>
		</form:form>
	</div>
</div>