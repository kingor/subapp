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
						<form:form class="form-horizontal" role="form" method="post" action="addPhone.do">
							<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong><i class="glyphicon glyphicon-ok"></i> Успешно! </strong>Телефон добавлен
							</div>
							<div class="panel-group">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse1"><strong>Абонент:</strong> ${subscriber.name}</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse">
										<ul class="list-group">
											<li class="list-group-item"><strong>Адрес:</strong> ${subscriber.address}</li>
											<li class="list-group-item"><strong>Примечание:</strong> ${subscriber.comment}</li>
										</ul>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse2"><strong>Номер:</strong> ${phone.number}</a>
										</h4>
									</div>
									<div id="collapse2" class="panel-collapse collapse">
										<ul class="list-group">
											<li class="list-group-item"><strong>Гром полоса:</strong> ${phone.band}</li>
											<li class="list-group-item"><strong>Охрана:</strong> ${phone.security}</li>
											<li class="list-group-item"><strong>СЦВ:</strong> ${phone.scv}</li>
											<li class="list-group-item"><strong>ADSL:</strong> ${phone.adsl}</li>
										</ul>
									</div>
								</div>
</div>
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-4">
										<input type="hidden" name="id" value="${subscriber.id}">
										<button type="submit" class="btn btn-primary">Дабавить новый телефон</button>
									</div>
								</div>


							
						</form:form>
					</div>
				</div>
			</div>

		</div>
		<div class="push"></div>
	</div>
	<%@include file="include/Footer.jspf"%>
</body>
</html>