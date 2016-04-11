<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<h2 class="page-header">Просмотр абонентов в базе</h2>

					
					<div class="table-responsive">
						<table class="table table-condensed table-bordered">
							<thead>
								<tr>
									<th class="col-sm-1 col-md-1"><a
										href="logSearch.do?sort=name&order=desc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> Имя <a
										href="logSearch.do?sort=name&order=asc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-3 col-md-3"><a
										href="logSearch.do?sort=date&order=desc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a>Дата <a
										href="logSearch.do?sort=date&order=asc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-1 col-md-1"><a
										href="logSearch.do?sort=type&order=desc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> Тип <a
										href="logSearch.do?sort=type&order=asc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-7 col-md-7"><a
										href="logSearch.do?sort=comment&order=desc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> Примечание <a
										href="logSearch.do?sort=comment&order=asc&name=${name}&dateStart=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />&dateEnd=<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />&type=${type}&comment=${comment}">
											<i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-1 col-md-1"></th>
								</tr>
								<tr>
									<form name="form3" method="get" action="logSearch.do">
										<td><INPUT type="text" name="user" value="${user}" class="form-control"></td>
										<td>
											<div class="row">
												<div class="col-sm-6">
													<INPUT type="date" name="dateStart" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${dateStart}" />" class="form-control">
												</div>
												<div class="col-sm-6">
													<INPUT type="date" name="dateEnd" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${dateEnd}" />" class="form-control" />
												</div>
											</div>
										</td>
										<td><INPUT type="text" name="type" value="${type}" class="form-control"></td>
										<td><INPUT type="text" name="comment" value="${comment}" class="form-control"></td>
										<th>
											<button type="submit" class="btn btn-primary ">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</th>
									</form>
								</tr>
							</thead>

							<c:if test="${!logSearch.isEmpty()}">
								<tbody>
									<c:forEach var="log" items="${logSearch}">
										<tr>
											<td>${log.user}</td>
											<td><fmt:formatDate pattern="dd.MM.yyyy --- hh:mm" value="${log.date}" /></td>
											<td>${log.type}</td>
											<td>${log.comment}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>
					<!-- Single button -->
					<div class="btn-group">
						<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
							<span class="glyphicon glyphicon-download"></span>
							Скачать отчет<!-- <span class="caret"></span> -->
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">PDF</a></li>
							<li><a href="#">XLS</a></li>
							<li><a href="#">HTML</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<div class="push"></div>
	</div>
	<%@include file="include/Footer.jspf"%>
</body>
</html>