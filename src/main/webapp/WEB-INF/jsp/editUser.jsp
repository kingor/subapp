<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags" %>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="http://bootstrap-3.ru/assets/ico/favicon.ico">

<title><sping:message code="editUser.title"/></title>

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
					<h2 class="page-header"><sping:message code="editUser.title"/></h2>
					<div class="col-sm-8">
						<form:form class="form-horizontal" role="form" modelAttribute="userAttr" method="post">
							<div class="panel panel-default">
								<div class="panel-heading">Данные пользователя</div>
								<div class="panel-body">
									<div class="form-group">
										<INPUT type="hidden" name="id" value="${userAttr.id}"> <label for="inputName3" class="col-sm-2 control-label">Логин:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputName3" name="login" value="${userAttr.login}" required="">
										</div>
									</div>
									<div class="form-group">
										<label for="inputAddr3" class="col-sm-2 control-label">Пароль:</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="inputAddr3" name="password" value="${userAttr.password}" required="">
										</div>
									</div>
									<div class="form-group">
										<label for="inputCom3" class="col-sm-2 control-label">Имя:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="inputCom3" name="name" value="${userAttr.name}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputCom3" class="col-sm-2 control-label">Категория:</label>
										<div class="col-sm-10">
											<select class="form-control" name="category" value="${userAttr.category}">
												<option value="0">Пользователь</option>
												<option value="1">Оператор</option>
												<option value="2">Администратор</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-5 col-sm-8">
											<button type="submit" formaction="editUser.do" class="btn btn-primary">Сохранить</button>

											<button type="submit" formaction="userSearchEdit.do" class="btn btn-primary">Отмена</button>
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