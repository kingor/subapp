<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title><spring:message code="createPhone.title"/></title>

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
					<h2 class="page-header"><spring:message code="createPhone.title"/></h2>
					<div class="col-sm-8">
						<form:form class="form-horizontal" role="form" modelAttribute="phoneAttr" method="post" action="createPhone">
							<div class="alert alert-info">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<i class="glyphicon glyphicon-info-sign"></i> <spring:message code="createPhone.message"/>
							</div>
							<div class="panel-group">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse1">${subscriber.name}</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse">
										<ul class="list-group">
											<li class="list-group-item"><strong><spring:message code="subscriber.address"/>:</strong> ${subscriber.address}</li>
											<li class="list-group-item"><strong><spring:message code="subscriber.comment"/>:</strong> ${subscriber.comment}</li>
										</ul>
									</div>
								</div>
<!-- 								<div class="alert alert-info">Добавьте телефон для этого абонента</div> -->
								<div class="panel panel-default">
									<div class="panel-heading"><spring:message code="createPhone.text"/></div>
									<div class="panel-body">
										<div class="form-group form-group-sm">
											<label for="inputName3" class="col-sm-2 control-label"><spring:message code="phone.number"/>:</label>
											<div class="col-sm-10">
												<INPUT type="hidden" name="id_subscriber" value="${phoneAttr.getSubscriber().getId()}"> 
												<form:input class="form-control" path="number" placeholder="Введите номер" required="" autofocus=""/>
												<form:errors class="label label-danger" path="number"></form:errors>
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputAddr3" class="col-sm-2 control-label"><spring:message code="phone.band"/>:</label>
											<div class="col-sm-10">
												<form:input class="form-control" path="band" placeholder="Введите громполосу" required=""/>
												<form:errors class="label label-danger" path="band"></form:errors>
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputSecur" class="col-sm-2 control-label"><spring:message code="phone.security"/>:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputSecur" name="security" placeholder="Введите параметр для охраны">
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputScv" class="col-sm-2 control-label"><spring:message code="phone.scv"/>:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputScv" name="scv" placeholder="Введите СЦВ">
											</div>
										</div>
										<div class="form-group form-group-sm">
											<label for="inputAdsl" class="col-sm-2 control-label"><spring:message code="phone.adsl"/>:</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" id="inputAdsl" name="adsl" placeholder="Введите параметр ADSL">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-5 col-sm-4">
												<button type="submit" class="btn btn-primary"><spring:message code="button.save"/></button>
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