<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title><sping:message code="viewSubscriberSearch.title"/></title>

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
					<h2 class="page-header"><sping:message code="viewSubscriberSearch.title"/></h2>
					<div class="table-responsive">
						<table class="table table-condensed table-striped">

							<thead>
								<tr>
									<th class="col-sm-4 col-md-4"><a href="subscriberSearch.do?sort=name&order=desc&name=${name}&address=${address}&comment=${comment}"> <i
											class="glyphicon glyphicon-sort-by-attributes-alt"></i>
									</a> <sping:message code="subscriber.name"/> <a href="subscriberSearch.do?sort=name&order=asc&name=${name}&address=${address}&comment=${comment}"> <i class="glyphicon glyphicon-sort-by-attributes"></i>
									</a></th>
									<th class="col-sm-4 col-md-4"><a href="subscriberSearch.do?sort=address&order=desc&name=${name}&address=${address}&comment=${comment}"> <i
											class="glyphicon glyphicon-sort-by-attributes-alt"></i></a> 
											<sping:message code="subscriber.address"/> <a href="subscriberSearch.do?sort=address&order=asc&name=${name}&address=${address}&comment=${comment}"> <i
											class="glyphicon glyphicon-sort-by-attributes"></i></a></th>
									<th class="col-sm-3 col-md-3"><a href="subscriberSearch.do?sort=comment&order=desc&name=${name}&address=${address}&comment=${comment}"> <i
											class="glyphicon glyphicon-sort-by-attributes-alt"></i></a> 
											<sping:message code="subscriber.comment"/> <a href="subscriberSearch.do?sort=comment&order=asc&name=${name}&address=${address}&comment=${comment}"> <i
											class="glyphicon glyphicon-sort-by-attributes"></i></a></th>
									<th class="col-sm-1 col-md-1"></th>
								</tr>
								<tr>
									<form name="form3" method="get" action="subscriberSearch.do">
										<th><INPUT type="text" name="name" value="${name}" class="form-control"></th>
										<th><INPUT type="text" name="address" value="${address}" class="form-control"></th>
										<th><INPUT type="text" name="comment" value="${comment}" class="form-control"></th>
										<th><button type="submit" class="btn btn-primary ">
												<i class="glyphicon glyphicon-search"></i>
											</button></th>
									</form>
								</tr>
							</thead>

							<c:if test="${!subscriberSearch.isEmpty()}">
								<tbody>
									<c:forEach var="subscriber" items="${subscriberSearch}">
										<tr>
											<form method="post" action="subscriberFull.do">
												<td>${subscriber.name}</td>
												<td>${subscriber.address}</td>
												<td>${subscriber.comment}</td>
												<th>
													<div>
														<input type="hidden" name="subscriberSelect" value="${subscriber.id}">
														<button type="submit" class="btn btn-primary btn-xs">
															<i class="glyphicon glyphicon-share-alt"></i>
														</button>
													</div>
												</th>
											</form>
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