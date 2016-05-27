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

<title><spring:message code="editSubscriber.title"/></title>

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
					<h2 class="page-header"><spring:message code="editSubscriber.title"/></h2>
					<div class="col-sm-8">
						<form:form class="form-horizontal" role="form" modelAttribute="subscriberAttr" method="post" >
							<div class="panel panel-default">
								<div class="panel-heading"><spring:message code="editSubscriber.text"/></div>
								<div class="panel-body">
									<INPUT type="hidden" name="id" value="${subscriberAttr.id}">
									<div class="form-group">
										<label for="inputName3" class="col-sm-2 control-label"><spring:message code="subscriber.name"/>:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputName3" name="name" value="${subscriberAttr.name}" placeholder="ФИО" required="" autofocus="">
										</div>
									</div>
									<div class="form-group">
										<label for="inputAddr3" class="col-sm-2 control-label"><spring:message code="subscriber.address"/>:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputAddr3" name="address" value="${subscriberAttr.address}" placeholder="Адрес" required="">
										</div>
									</div>
									<div class="form-group">
										<label for="inputCom3" class="col-sm-2 control-label"><spring:message code="subscriber.comment"/>:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputCom3" name="comment" value="${subscriberAttr.comment}" placeholder="Примечание">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-5 col-sm-8">
											<button type="submit" formaction="editSubscriber.do" class="btn btn-primary"><spring:message code="button.save"/></button>

											<button type="submit" formaction="subscriberSearchEdit.do" class="btn btn-primary"><spring:message code="button.cancel"/></button>
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