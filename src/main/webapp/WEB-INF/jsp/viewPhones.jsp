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
					<h2 class="page-header">Просмотр технических параметров</h2>
					<div class="table-responsive">
						<table class="table table-condensed table-bordered">
							<thead>
								<tr>
									<c:url value="phones.do?sort=number&order=desc" var="lUrl" />
									<th class="col-sm-2 col-md-2"><a href="phones.do?sort=number&order=desc"> 
										<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> Номер <a href="phones.do?sort=number&order=asc">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-2 col-md-2"><a href="phones.do?sort=band&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Громпол. <a href="phones.do?sort=band&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-2 col-md-2"><a href="phones.do?sort=security&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Охрана <a href="phones.do?sort=security&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-1 col-md-1"><a href="phones.do?sort=scv&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										СЦВ <a href="phones.do?sort=scv&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-1 col-md-1"><a href="phones.do?sort=adsl&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Adsl <a href="phones.do?sort=adsl&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-4 col-md-4"><a href="phones.do?sort=name&order=desc">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										ФИО <a href="phones.do?sort=name&order=asc">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
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
                                        <td>${phone.subscriber.name}</td>
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