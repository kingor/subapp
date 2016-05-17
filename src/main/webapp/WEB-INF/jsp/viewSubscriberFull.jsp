<%@page import="java.util.List"%>
<%@page import="by.telecom.subapp.model.Phone"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title><sping:message code="viewSubscriberFull.title"/></title>

<!-- Bootstrap core CSS -->
<LINK href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/dashboard.css"/>" rel="stylesheet">

<style id="holderjs-style" type="text/css"></style>
</head>

<body>
	<div class=" wrapper">
		<%@include file="include/Header.jspf"%>

		<div class="container-fluid">
			<div class="row">
				<%@include file="include/menu.jspf"%>
				<div class="col-xs-10 col-xs-offset-2 col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 main">
					<h2 class="page-header"><sping:message code="viewSubscriberFull.title"/></h2>
					<div class=" col-sm-8">
						<div class="row">

							<form class="form-horizontal" role="form">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse1">${subscriber.name}</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse">
										<ul class="list-group">
											<li class="list-group-item"><strong>Адрес:</strong> ${subscriber.address}</li>
											<li class="list-group-item"><strong>Примечание:</strong> ${subscriber.comment}</li>
										</ul>
									</div>
									
								</div>
							</form>
						</div>


						<c:if test="${!phones.isEmpty()}">
							<h3><sping:message code="phone.title"/></h3>
							<div class="table-responsive">
								<table class="table table-condensed table-bordered">
									<thead>
										<tr>
											<th><sping:message code="phone.number"/></th>
											<th><sping:message code="phone.band"/></th>
											<th><sping:message code="phone.security"/></th>
											<th><sping:message code="phone.scv"/></th>
											<th><sping:message code="phone.adsl"/></th>
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
							<div class="alert alert-warning">
								<i class="glyphicon glyphicon-info-sign"></i> <sping:message code="subscriber.info"/>
							</div>
						</c:if>
						<div class="row">
							<a class="nav" href="subscribers.do"><i class="glyphicon glyphicon-arrow-left"></i> <sping:message code="subscriber.back"/></a>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="push"></div>
	</div>

	<%@include file="include/Footer.jspf"%>

</body>
</html>