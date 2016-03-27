<%-- 
    Document   : Login
    Created on : 14.03.2015, 13:24:46
    Author     : Family_P
--%>
<%@page import="java.util.List"%>
<%@page import="by.telecom.subapp.model.Phone"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title>Полная информация о абоненте</title>

<!-- Bootstrap core CSS -->
<LINK href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/dashboard.css"/>"
	rel="stylesheet">

<style id="holderjs-style" type="text/css"></style>
</head>

<body>
<div class=" wrapper">
	<%@include file="include/Header.jspf"%>

	<div class="container-fluid">
		<div class="row">
			<%@include file="include/menu.jspf"%>


			<div
				class="col-xs-9 col-xs-offset-3 col-sm-9 col-sm-offset-3  col-md-10 col-md-offset-2 main">
				<h2 class="page-header">Подробные данные:</h2>

				<div class="row">
					<dl class="dl-horizontal">
						<dt>ФИО абонента:</dt>
						<dd>${subscriber.name}</dd>
						<dt>Адрес абонента:</dt>
						<dd>${subscriber.address}</dd>
						<dt>Примечание:</dt>
						<dd>${subscriber.comment}</dd>
					</dl>
				</div>

				<c:if test="${!phones.isEmpty()}">
					<h3>Технические параметры:</h3>
					<div class="table-responsive">
						<table class="table table-condensed table-bordered">
							<thead>
								<tr>
									<th>Номер</th>
									<th>Гром полоса</th>
									<th>Охрана</th>
									<th>СЦВ</th>
									<th>ADSL</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="phone" items="${phones}">
									<tr>
										<td>${phone.number}</td>
										<td>${phone.band}</td>
										<td>${phone.security}</td>
										<td>${phone.scv}</td>
										<td>${phone.adsl}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
				<c:if test="${phones.isEmpty()}">
					<div class="alert alert-warning" role="alert">
						<h3>Данных для текущего пользователя нет!</h3>
					</div>
				</c:if>
				<div class="row">
					<a class="nav" href="subscribers.do"><i
						class="glyphicon glyphicon-arrow-left"></i> Назад</a>
				</div>
			</div>
		</div>
		
	</div>
	<div class="push"></div>
</div>
	
	<%@include file="include/Footer.jspf" %>

</body>
</html>