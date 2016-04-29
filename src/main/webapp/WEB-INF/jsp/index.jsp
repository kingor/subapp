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

					<div id="carousel-example-generic" class="carousel slide col-sm-offset-2" data-ride="carousel">
                  <!-- Маркеры слайдов -->
                  <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                  </ol>
 
                  <!-- Содержимое слайдов -->
                  <div class="carousel-inner">
                 
                    <div class="item active">
                      <img src="<c:url value="/resources/image/1.jpg"/>" alt="...">
                      <div class="carousel-caption">
                        <h3>Учет</h3>
                        <p>Ведение базы данных абонентов компании.</p>
                        <p>Зарегистрированно абонентов: ${countOfSubscribers}</p> 
                      </div>
                    </div>
                     
                    <div class="item">
                      <img src="<c:url value="/resources/image/2.jpg"/>" alt="...">
                      <div class="carousel-caption">
                        <h3>Поиск</h3>
                        <p>Возможность найти нужного абонента в кратчайшие сроки</p>
                        <p>Зарегистрированно телефонов: ${countOfPhones}</p> 
                      </div>
                    </div>
                     
                    <div class="item">
                      <img src="<c:url value="/resources/image/3.jpg"/>" alt="...">
                      <div class="carousel-caption">
                        <h3>Доступ</h3>
                        <p>Разделение прав доступа по группам</p>
                      </div>
                    </div>
                  </div>
 
                  <!-- Controls -->
                  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                  </a>
                  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                  </a>
                </div>
	
			
		<div class="container-fluid">
			<div class="row">
				<%@include file="include/menu.jspf"%>   
				<div class="col-xs-10 col-xs-offset-2 col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 main">
				</div>
			</div>
		</div>
		<div class="push"></div>
	</div>

	<%@include file="include/Footer.jspf"%>

</body>
</html>