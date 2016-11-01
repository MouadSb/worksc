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
		<form:form id="div_addco" method="post"
			action="/MedicalGap/admin/addCongresses" modelAttribute="congresse"
			class="form-horizontal">

			<form:input path="id" type="hidden" class="form-control" id="id"
				placeholder="id" />
			<div class="col-md-10 col-sm-8">
				<div class="form-group">
					<label class="col-md-4 control-label">Nouveau type de congresses :</label>
					<div class="col-md-5 ">
						<form:input path="congresseType" type="text"
							class="form-control input-md" id="congresseType"
							placeholder="Type de congresse" />
							<label  id="errorC"><c:out value="${param.eltnc}" /></label>
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
		<form:form id="div_modifyco" modelAttribute="congresse"
			class="form-horizontal">

			<form:input path="id" type="hidden" class="form-control" id="ide"
				placeholder="idco" />
			<div class="col-md-10 col-sm-8">
				<div class="form-group">
					<label class="col-md-4 control-label">Nouveau type de
						congresses :</label>
					<div class="col-md-5">
						<form:input path="congresseType" type="text"
							class="form-control input-md" id="congresseTypee"
							placeholder="Type de congresse" />
						<label  id="errorC" class="errorCC"><c:out value="${param.eltngm}" /></label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">Cat�gorie :</label>
					<div class="col-md-5">
						<input type="text" id="oldCategorieco" class="form-control" disabled="disabled" ></input>
					</div>
				</div>
				 
				<div class="form-group">
					<label class="col-md-4 control-label">Nouvelle categorie :</label>
					<div class="col-md-5 selectContainer">
						<form:select path="nomCategorie" items="${listCategorie}"
							itemValue="name" itemLabel="name" class=" form-control"
							id="nomCategorieco" />
					</div>
				</div>
				<div class=" col-md-2 pull-right">
					<button id="btn_form_modco" type="button"
						class="btn  btn-add btn-lg">
						<img alt="delete"
							src="/MedicalGap/resources/images/icone_edit.png"
							style="max-height: 14px; max-width: 14px;"> Modifier
					</button>
				</div>
			</div>

		</form:form>
	</div>
</div>