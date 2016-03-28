<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon"
	href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title>Система учета абонентов</title>

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

		<div class="container-fluid ">
			<div class="row">
				<%@include file="include/menu.jspf"%>
				<div
					class="col-xs-10 col-xs-offset-2 col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 main">
					<h2 class="page-header">Просмотр абонентов в базе</h2>
					<div class="table-responsive">
						<table class="table table-condensed table-bordered">
							<thead>
								<tr>
									<th><a href="subscribers.do?sort=name&order=desc"> 
										<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> ФИО абонента <a href="subscribers.do?sort=name&order=asc">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th><a href="subscribers.do?sort=address&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Адрес абонента <a href="subscribers.do?sort=address&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th><a href="subscribers.do?sort=comment&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Примечание <a href="subscribers.do?sort=comment&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th>Подробнее</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="subscriber" items="${subscribers}">
									<tr>
										<form method="post" action="subscriberFull.do">
											<td>${subscriber.name}</td>
											<td>${subscriber.address}</td>
											<td>${subscriber.comment}</td>
											<th>
												<div>
													<input type="hidden" name="subscriberSelect"
														value="${subscriber.id}">
													<button type="submit" class="btn btn-primary btn-xs">
														<i class="glyphicon glyphicon-share-alt"></i>
													</button>
												</div>
											</th>
										</form>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
		<div class="push"></div>
	</div>
	<%@include file="include/Footer.jspf"%>
</body>
</html>