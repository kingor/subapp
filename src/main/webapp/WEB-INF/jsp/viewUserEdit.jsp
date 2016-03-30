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
							<form name="form3" method="get" action="userSearchEdit.do">
								<thead>
									<tr>
										<th class="col-sm-4 col-md-4"><a href="userSearchEdit.do?sort=login&order=desc&login=${login}&name=${name}&category=${category}"> <i
												class="glyphicon glyphicon-sort-by-attributes-alt"></i>
										</a>Логин<a href="userSearchEdit.do?sort=login&order=asc&login=${login}&name=${name}&category=${category}"> <i class="glyphicon glyphicon-sort-by-attributes"></i>
										</a></th>
										<th class="col-sm-4 col-md-4"><a href="userSearchEdit.do?sort=name&order=desc&login=${login}&name=${name}&category=${category}"> <i
												class="glyphicon glyphicon-sort-by-attributes-alt"></i></a> Имя<a href="userSearchEdit.do?sort=name&order=asc&login=${login}&name=${name}&category=${category}"> <i
												class="glyphicon glyphicon-sort-by-attributes"></i></a></th>
										<th class="col-sm-3 col-md-3"><a href="userSearchEdit.do?sort=category&order=desc&login=${login}&name=${name}&category=${category}"> <i
												class="glyphicon glyphicon-sort-by-attributes-alt"></i></a> Категория <a href="userSearchEdit.do?sort=category&order=asc&login=${login}&name=${name}&category=${category}"> <i
												class="glyphicon glyphicon-sort-by-attributes"></i></a></th>
										<th colspan="2" class="col-sm-1 col-md-1"></th>
									</tr>
									<tr>

										<td><INPUT type="text" name="login" value="${login}" class="form-control"></td>
										<td><INPUT type="text" name="name" value="${name}" class="form-control"></td>
										<td><INPUT type="text" name="category" value="${category}" class="form-control"></td>
										<th colspan="2">

											<button type="submit" class="btn btn-primary ">
												<i class="glyphicon glyphicon-search"></i>
											</button>

										</th>

									</tr>
								</thead>
							</form>
							<c:if test="${!userSearchEdit.isEmpty()}">
								<tbody>
									<c:forEach var="user" items="${userSearchEdit}">
										<tr>

											<td>${user.login}</td>
											<td>${user.name}</td>
											<td>${user.category}</td>
											<th>

												<form method="post" action="editUserView.do">
													<input type="hidden" name="userSelect" value="${user.id}">
													<button type="submit" class="btn btn-primary btn-xs">
														<i class="glyphicon glyphicon-pencil"></i>
													</button>
												</form>

											</th>
											<th>

												<form method="post" action="deleteUser.do">
													<input type="hidden" name="userSelect" value="${user.id}">
													<button type="submit" class="btn btn-primary btn-xs">
														<i class="glyphicon glyphicon-trash"></i>
													</button>
												</form>

											</th>

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