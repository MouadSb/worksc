<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Medicalgap - Bienvenue</title>

<link rel="stylesheet" type="text/css"
	href="/MedicalGap/resources/css/bootstrap.min.css">
</head>
<style>
.input_s {
	background-color: #0394e3;
	width: 280px;
}


#backgroundLogin{
	background-image: url('/MedicalGap/resources/images/background_welcome.png');
}

@media only screen 
and (min-device-width : 768px) 
and (max-device-width : 1024px) 
and (orientation : landscape) {
  #backgroundLogin {
    	background-image: url('/MedicalGap/resources/images/ipad.png');
  }
}



#bodyCat{ 
	margin-right: 120px;
}

@media only screen 
and (min-device-width : 768px) 
and (max-device-width : 1024px) {
  #bodyCat {
    margin-right: 10px; 
  }
}

#imageID{
content:url(/MedicalGap/resources/images/welcomeimage.jpg);
}

@media only screen 
and (min-device-width : 768px) 
and (max-device-width : 1024px) {
  #imageID {
		content:url(/MedicalGap/resources/images/welcomeimageIpad.png);
  }
}


</style>

<body onload='document.loginForm.username.focus();'>

	<img  alt="welcome"
		style="width: 100%; height: 100%; opacity: 1;" id="imageID">


	<div id="divlogin" style="display: none;">

		<img src="/MedicalGap/resources/images/HeaderWelcome.png"
			alt="Medical Gap" style="max-height: 100%; max-width: 100%;">
		<div id="backgroundLogin"
			style="width: 100%; height: 100%;  background-repeat: no-repeat; background-size: cover; background-position: center;">


			<div class="container-fluid pull-right" id="bodyCat"
				style="height: 395px; width: 348px; margin-top: 150px;  background-image: url('/MedicalGap/resources/images/395.png'); background-repeat: no-repeat; background-size: 100% 100%;">
				<div class="container-fluid"
					style="margin-top: 150px; text-align: center;">

					<form name='loginForm'
						action="<c:url value='/j_spring_security_check' />" method='POST'>

						<table>
							<tr>
								<td><input type='text' name='username'
									placeholder="Nom d'utilisateur"
									class="form-control input_s col-xs-3"
									style="margin-bottom: 12%"></td>
							</tr>
							<tr>
								<td><input type='password' name='password'
									placeholder="Mot de passe"
									class="form-control input_s col-xs-3 "
									style="margin-bottom: 8%" /></td>
							</tr>
							<tr>
								<td colspan='2'><input name="submit" type="submit"
									id="btn_valid" class="btn  btn-add btn-lg pull-right"
									value="Connexion" /></td>
							</tr>
							
						</table>
						<a href="#" id="hrf_forgot">Mot de passe oublié?</a>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="forms/passwordform.jsp"%>
	<script type="text/javascript" charset="utf8"
		src="/MedicalGap/resources/js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8"
		src="/MedicalGap/resources/js/bootstrap.min.js"></script>
		
	<script>
	 	setTimeout(function() {
			document.getElementById('imageID').style.display = 'none';
			document.getElementById('divlogin').style.display = 'block';
			document.body.style.overflow = 'hidden';
		}, 10 * 200); 
	</script>
	<script>
	
	$("#hrf_forgot").click(function(e) {
		
			$('#modalForgotten').modal('show');

	});


	$("#btn_reg").click(function(){

		$.post("/MedicalGap/passwordforget", {
			"usname" : document.getElementById("usernamef").value,
			"emaile" : document.getElementById("emailf").value,
		}, function(data) {
			
		});
		});

	</script>
</body>
</html>