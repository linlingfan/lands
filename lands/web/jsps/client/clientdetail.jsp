<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/18
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户详细信息</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
    <style type="text/css">
    </style>
</head>
<body>
<form action="#" method="post" id="formTable">
    <table id="detailTable">
        <caption>客户详细信息</caption>
        <tbody>
        <tr>
            <th width="15%">客户名称</th>
            <td width="85%" colspan="3">
                ${client.clname}
            </td>
        </tr>

        <tr>
            <th width="15%">客户类型</th>
            <td width="85%" colspan="3">
                <c:choose>
                    <c:when test="${client.type eq 1}">
                        个人
                    </c:when>

                    <c:when test="${client.type eq 2}">
                        单位
                    </c:when>
                </c:choose>
            </td>
        </tr>

        <tr>
            <th width="15%">联系人</th>
            <td width="85%" colspan="3">
                ${client.contacts}
            </td>
        </tr>
        <tr>
            <th width="15%">联系电话</th>
            <td width="85%" colspan="3">
                ${client.phone}
            </td>
        </tr>
        <tr>
            <th width="15%">邮编</th>
            <td width="85%" colspan="3">
                ${client.zipcode}
            </td>
        </tr>
        <tr>
            <th width="15%">通讯地址</th>
            <td width="85%" colspan="3">
                ${client.address}
            </td>
        </tr>
        <tr>
            <td width="100%" colspan="4">
                <div style="margin-left:380px;margin-right:auto;width: 230px"> <!--div里的内容居中-->
                    <input type="button" onclick="location.href='javascript:history.go(-1)'" value="返回"/>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</form>