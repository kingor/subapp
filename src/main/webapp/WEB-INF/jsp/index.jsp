<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

		<div class="container-fluid">
			<div class="row">
				<%@include file="include/menu.jspf"%>


				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h1 class="page-header">Главная часть документа</h1>

					<div class="row placeholders">
						<div class="col-xs-6 col-sm-3 placeholder">
							<h4>Label</h4>
							<span class="text-muted">Something else</span>
						</div>
						<div class="col-xs-6 col-sm-3 placeholder">
							<h4>Label</h4>
							<span class="text-muted">Something else</span>
						</div>
					</div>

					<h2 class="sub-header">Section title</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>#</th>
									<th>Header</th>
									<th>Header</th>
									<th>Header</th>
									<th>Header</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1,001</td>
									<td>Lorem апрапрапр</td>
									<td>ipsum</td>
									<td>dolor апрапрап апрапр</td>
									<td>sit</td>
								</tr>
								<tr>
									<td>1,002</td>
									<td>amet</td>
									<td>consectetur апрапр</td>
									<td>adipiscing</td>
									<td>elit</td>
								</tr>

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