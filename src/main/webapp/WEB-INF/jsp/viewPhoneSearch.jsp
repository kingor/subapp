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
								<c:url value="phoneSearch.do?sort=adsl&order=desc&number=${number}&band=${band}&security=${security}&scv=${scv}&adsl=${adsl}&name=${name}" var="lUrl" />
									<th class="col-sm-2 col-md-2"><a href="${lUrl}"> 
										<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> Номер <a href="${lUrl}">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-2 col-md-2"><a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Громпол. <a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-2 col-md-2"><a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Охрана <a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-1 col-md-1"><a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										СЦВ <a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-1 col-md-1"><a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										Adsl <a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									<th class="col-sm-4 col-md-4">
									<a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes-alt"></i></a>
										ФИО <a href="${lUrl}">
									<i class="glyphicon glyphicon-sort-by-attributes"></i></a>
									</th>
									
								</tr>
								<tr>
								<form name="form3" method="get" action="phoneSearch.do">
								
									
									<td > <INPUT type="text" name="number" value="${number}" class="form-control"></td>
                                    <td > <INPUT type="text" name="band" value="${band}" class="form-control"></td>
                                    <td > <INPUT type="text" name="security" value="${security}" class="form-control"></td>
                                    <td > <INPUT type="text" name="scv" value="${scv}" class="form-control"></td>
                                    <td > <INPUT type="text" name="adsl" value="${adsl}" class="form-control"></td>
                                    <td >
                                    <div class="input-group"> 
                                    <INPUT type="text" name="name" value="${name}" class="form-control col-sm-10 col-md-10">
                                     <span class="input-group-btn">
									<button type="submit" class="btn btn-primary ">
											<i class="glyphicon glyphicon-search"></i>
									</button>
									</span>
									</div>
									</td>
									
								</form>
								</tr>
							</thead>
							
							<c:if test="${!phoneSearch.isEmpty()}">
							<tbody>
								<c:forEach var="phone" items="${phoneSearch}">
									<tr>
										
											<td >${phone.number}</td>
                                            <td >${phone.band}</td>
                                            <td >${phone.security}</td>
                                            <td >${phone.scv}</td>
                                            <td >${phone.adsl}</td>
                                            <td >${phone.subscriber.name}</td>
											
									</tr>
								</c:forEach>
							</tbody>
							</c:if>
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