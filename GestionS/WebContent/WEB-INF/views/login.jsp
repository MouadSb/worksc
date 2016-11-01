<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/GestionS/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/GestionS/resources/css/styles.css">
  <title>SphereBleue</title>
  <link href="//db.onlinewebfonts.com/c/d141fcbd9641ce533f79343c85d2a2e2?family=Frutiger+LT+45+Light" rel="stylesheet" type="text/css"/>
<link href="//db.onlinewebfonts.com/c/5a8bb20d28cf79705dad87a1d67bc14a?family=Frutiger+LT+Com" rel="stylesheet" type="text/css"/>

</head>
<body class="full-bg auth-bg" style="background-image: url('resources/images/background.png') ;  
	background-attachment:fixed;
    background-repeat: no-repeat;
    background-size: 100% 100%;">

<div class="container-fluid">
	<div class="row">
			
	</div>
	<div class="row">
			<div class="col-md-6 col-md-offset-6 no-padding " style="margin-top: 230px;">
				<div class="col-md-10 col-md-offset-2 ">
					<div class="col-md-10 pull-left">
						<p id="pAuth" style="font-size: 39.4px;margin-left: 12px;">Page d'authentification</p>
					</div>
					
					<div class="col-md-12 pull-left" >
						<p id="pAuth2" style="font-size: 31.08px;margin-top:-10px;margin-left: -6px;">pour les employés et l'administrateur</p>
					</div>
				</div>
			</div>
	</div>
	<div class="row" style="margin-top: 80px;">
		<div class="col-md-4 col-md-offset-8 no-padding">
			<div class="col-md-8  fields-holder">
				
				<div class="input-group"  id="divLogin" style="margin-top:10px;">
					 <form name='loginForm' id="formLogin"
					action="<c:url value='/j_spring_security_check' />" method='POST'>
					<input type="text" class="form-control " name="username" placeholder="Nom d'utilisateur" aria-describedby="basic-addon1"/>
					<input type="password" class="form-control" name="password" placeholder="Mot de passe" aria-describedby="basic-addon1"/>
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
					<button id="btn_connect" type="submit" class="btn btn-default cnx-btn pull-right">Connexion</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						</form>
				</div>
			</div>	
		</div>
	</div>
	<div class="row">
			<div class="col-md-6 col-md-offset-6 no-padding " style="margin-top: 60px;">
			<div class="col-md-12 ">
				<div class="col-md-10  col-md-offset-2">
					<h5 id="msgFoot" style="font-size: 20px"><strong id="bvn">Bienvenue</strong> sur l'application de gestion SPHEREBLEUE</h5>
				</div>
				</div>
			</div>
	</div>

</div>

 
  
<script src="/GestionS/resources/js/jquery-2.1.4.min.js"></script>
<script src="/GestionS/resources/js/bootstrap.min.js"></script>
<script src="/GestionS/resources/js/script.js"></script>
</body>
</html>