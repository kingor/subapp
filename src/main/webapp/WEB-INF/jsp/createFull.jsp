<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title>Система учета абонентов</title>

<!-- Bootstrap core CSS -->
<LINK href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/dashboard.css"/>" rel="stylesheet">

<style id="holderjs-style" type="text/css"></style>
</head>

<body>
	<div class=" wrapper">
		<%@include file="include/Header.jspf"%>

		<div class="container-fluid ">
			<div class="row">
				<%@include file="include/menu.jspf"%>
				<div class="col-xs-10 col-xs-offset-2 col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 main">
					<h2 class="page-header">Новый телефон</h2>
					<div class="col-sm-8">
						<form class="form-horizontal" role="form" method="post" action="addPhone.do">
<!-- 							<div class="row"> -->
								<label class="col-sm-4 control-label" for="name">ФИО:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${subscriber.name}</p>
								</div>
								</div>
								<div class="col-sm-12">
								<label class="col-sm-4 control-label" for="address">Адрес:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${subscriber.address}</p>
								</div>
<!-- 							</div> -->
							<h3 class="col-sm-8 col-sm-offset-4">Параметры линии абонента</h3>
							<div class="form-group form-group-sm">
								<label for="inputName3" class="col-sm-4 control-label">Номер:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${phone.number}</p>
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="inputAddr3" class="col-sm-4 control-label">Гром полоса:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${phone.band}</p>
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="inputSecur" class="col-sm-4 control-label">Охрана:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${phone.security}</p>
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="inputScv" class="col-sm-4 control-label">СЦВ:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${phone.scv}</p>
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="inputAdsl" class="col-sm-4 control-label">ADSL:</label>
								<div class="col-sm-8">
									<p class="form-control-static">${phone.adsl}</p>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<input type="hidden" name="id" value="${subscriber.id}">
									<button type="submit" class="btn btn-primary">Добавить новый телефон</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
		<div class="push"></div>
	</div>
	<%@include file="include/Footer.jspf"%>
</body>
</html>