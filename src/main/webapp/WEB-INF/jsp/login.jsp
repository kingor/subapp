<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title>Авторизация в системе</title>

<!-- Bootstrap core CSS -->
<LINK href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<LINK href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">
</head>

<body>

	<div class="container">
		<c:url value="/telecom/j_spring_security_check" var="loginUrl" />
		<form class="form-signin" method="post" action="${loginUrl}">
			<h2 class="form-signin-heading">Введите логин и пароль</h2>
			<div class="form-group">
				<input type="text" name="j_username" class="form-control" placeholder="Login" required="" autofocus="">
			</div>
			<div class="form-group">
				<input type="password" name="j_password" class="form-control" placeholder="Password" required="">
			</div>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
		</form>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>