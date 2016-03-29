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
						<form:form class="form-horizontal" role="form" modelAttribute="phoneAttr" method="post" action="createPhone">
							<div class="panel-group">
								<div class="panel panel-default">
									<div class="panel-heading">Пользователь</div>
									<div class="panel-body">
										<div class="row">
											<label class="col-sm-2 control-label" for="name">ФИО:</label>
											<div class="col-sm-10">
												<p class="form-control-static">${subscriber.name}</p>
											</div>
											<label class="col-sm-2 control-label" for="address">Адрес:</label>
											<div class="col-sm-10">
												<p class="form-control-static">${subscriber.address}</p>
											</div>

										</div>
									</div>


								</div>

								<div class="panel panel-default">
									<div class="panel-heading">Параметры линии абонента</div>
									<div class="panel-body">
										<div class="form-group form-group-sm">
											<label for="inputName3" class="col-sm-2 control-label">Номер:</label>
											<div class="col-sm-10">
												<INPUT type="hidden" name="id_subscriber" value="${phoneAttr.getSubscriber().getId()}"> <input type="text" class="form-control" id="inputName3" name="number"
													placeholder="Введите номер" required="" autofocus="">
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputAddr3" class="col-sm-2 control-label">Гром полоса:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputAddr3" name="band" placeholder="Введите громполосу" required="">
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputSecur" class="col-sm-2 control-label">Охрана:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputSecur" name="security" placeholder="Введите параметр для охраны">
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputScv" class="col-sm-2 control-label">СЦВ:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputScv" name="scv" placeholder="Введите СЦВ">
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputAdsl" class="col-sm-2 control-label">ADSL:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputAdsl" name="adsl" placeholder="Введите параметр ADSL">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-primary">Сохранить</button>
											</div>
										</div>
									</div>
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