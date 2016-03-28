<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
					<h2 class="page-header">Новый абонент</h2>
					<div class="col-sm-8 col-sm-offset-2">
						<form:form class="form-horizontal" role="form" modelAttribute="subscriberAttr" method="post" action="createSubscriber.do">
  <div class="form-group">
    <label for="inputName3" >ФИО абонента:</label>
       <input type="text" class="form-control" id="inputName3" name="name" placeholder="ФИО" required="" autofocus="">
  </div>
  <div class="form-group">
    <label for="inputAddr3" >Адрес:</label>
      <input type="text" class="form-control" id="inputAddr3" name="address" placeholder="Адрес" required="">
  </div>
  <div class="form-group">
    <label for="inputCom3"  >Примечание:</label>
      <input type="text" class="form-control" id="inputCom3" name="comment" placeholder="Примечание">
  </div>
   <div class="form-group">
    <div class="col-sm-offset-4 col-sm-8">
      <button type="submit" class="btn btn-primary">Сохранить</button>
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