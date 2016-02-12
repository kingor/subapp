<%-- 
    Document   : Login
    Created on : 14.03.2015, 13:24:46
    Author     : Family_P
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title></title>
<meta name="keywords" content="">
<meta name="description" content="">
<META content="text/html; charset=windows-1251" http-equiv=Content-Type>
<LINK href="<c:url value="/resources/style/main3.css"/>" rel="stylesheet">
</head>
<body bgcolor="#e4e8ea">
	<div align="center">
		<%@include file="include/Header.jspf"%>

		<table class="width960" cellspacing=0 cellpadding=0 border=0>
			<tr>
				<%@include file="include/menu.jspf"%>

				<td width=7 bgcolor="#e4e8ea"></td>
				<td class="width753" align="center">
					<table class="width753" cellspacing=0 cellpadding=1 border=0>
						<tr>
							<td bgcolor="#aaaaaa">
								<table class="width753" cellspacing=0 cellpadding=20 border=0>
									<tr>
										<td class="content">
											<center>
												<h2>Параметры для абонента:</h2>
												<table width="600">
													<tr>
														<td width="25%">ФИО абонента:</td>
														<td class="textBold">${subscriber.name}</td>

													</tr>
													<tr>
														<td>Адрес абонента:</td>
														<td class="textBold">${subscriber.address}</td>
													</tr>
												</table>
												<h2>Параметры:</h2>
												<form:form modelAttribute="phoneAttr" method="post"
													action="createPhone">
													<!-- <form name="form5" method="post" action="createPhone"> -->
													<%--  <input type="hidden" name="subscriber_id" value="${subscriber.id}"> --%>
													
													<table width="600">
														<tr>
															<td width="25%">Номер телефона:<INPUT type="text" name="id_subscriber"
																  value="${phoneAttr.getSubscriber().getId()}"  style="width: 100%" ></td>
															<td><INPUT type="text" name="number"
																style="width: 100%"></td>
														</tr>
														<tr>
															<td>Гром полоса:</td>
															<td><INPUT type="text" name="band"
																style="width: 100%"></td>
														</tr>
														<tr>
															<td>Охрана:</td>
															<td><INPUT type="text" name="security"
																style="width: 100%"></td>
														</tr>
														<tr>
															<td>СЦВ:</td>
															<td><INPUT type="text" name="scv"
																style="width: 100%"></td>
														</tr>
														<tr>
															<td>ADSL:</td>
															<td><INPUT type="text" name="adsl"
																style="width: 100%"></td>
														</tr>
														<tr>
															<th colspan="2" width="5%"><br> <INPUT
																type="submit" name="submit" value="Сохранить"
																style="width: 20%"></th>

														</tr>
													</table>
												</form:form>
											</center>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<%@include file="include/Footer.jspf"%>
	</div>
	<br>
</body>
</html>