<%-- 
    Document   : Login
    Created on : 14.03.2015, 13:24:46
    Author     : Family_P
--%>
<%@page import="java.util.List"%>
<%@page import="by.telecom.subapp.model.Phone"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="by.telecom.subapp.model.Subscriber"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
            <%@include file="include/Header.jspf" %>

            <table class="width960" cellspacing=0 cellpadding=0 border=0>
                <tr>
                    <%@include file="include/menu.jspf" %>

                    <td width=7 bgcolor="#e4e8ea"></td>
                    <td class="width753"  align="center">
                        <table class="width753" cellspacing=0 cellpadding=1 border=0>
                            <tr>
                                <td bgcolor="#aaaaaa">
                                    <table class="width753" cellspacing=0 cellpadding=20 border=0>
                                        <tr>
                                            <td class="content">
                                                <center>
                                                    <h2>Изменение данных абонента:</h2>
                                                    <form:form modelAttribute="subscriberAttr" method="post" action="editSubscriber.do">
                                                    <!-- <form name="form5" method="post" action="editSubscriber.do"> -->
                                                        <INPUT type="hidden" name="id" value="${subscriberAttr.id}">
                                                    <table class=AllWidth>
                                                        <tr>
                                                            <td width="20%">ФИО абонента:</td> 
                                                            <td class="textBold"><INPUT type="text" name="name" value="${subscriberAttr.name}" style="width:100%" ></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Адрес абонента:</td> 
                                                            <td class="textBold"><INPUT type="text" name="address" value="${subscriberAttr.address}" style="width:100%" ></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Примечание:</td> 
                                                            <td class="textBold"><INPUT type="text" name="comment" value="${subscriberAttr.comment}" style="width:100%" ></td>
                                                        </tr>
                                                        <th colspan="2" width="5%">
                                                                <br>
                                                                <INPUT type="submit" name="submit" value="Сохранить" style="width:20%">
                                                        </th>
                                                    </table>
                                                    </form:form>
                                                   <%--  </form> --%>
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
            <%@include file="include/Footer.jspf" %>
        </div>
        <br> 
    </body>
</html>