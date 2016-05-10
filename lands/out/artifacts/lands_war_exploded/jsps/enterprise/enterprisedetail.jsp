<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/19
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>注册企业信息</title>
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
      <th width="15%">名称</th>
      <td width="85%" colspan="3">
        ${enterprise.enname}
      </td>
    </tr>

    <tr>
      <th width="15%">工商登记证号</th>
      <td width="85%" colspan="3">
      ${enterprise.ba_certificate_code}
      </td>
    </tr>

    <tr>
      <th width="15%">税务登记证号</th>
      <td width="85%" colspan="3">
        ${enterprise.tax_certificate_code}
      </td>
    </tr>
    <tr>
      <th width="15%">qs食品安全认证号</th>
      <td width="85%" colspan="3">
        ${enterprise.qs_code}
      </td>
    </tr>
    <tr>
      <th width="15%">年缴税金额</th>
      <td width="35%">
        ${enterprise.tax_amount}
      <th width="15%">茶山(园)面积</th>
      <td width="35%">
        ${enterprise.tea_land_area}
      </td>
      </td>
    </tr>
    <tr>
      <th width="15%">联系人</th>
      <td width="85%" colspan="3">
        ${enterprise.contacts}
      </td>
    </tr>
    <tr>
      <th width="15%">联系电话</th>
      <td width="85%" colspan="3">
        ${enterprise.phone}
      </td>
    </tr>
    <tr>
      <th width="15%">邮政编号</th>
      <td width="85%" colspan="3">
        ${enterprise.zipcode}
      </td>
    </tr>
    <tr>
      <th width="15%">地址</th>
      <td width="85%" colspan="3">
        ${enterprise.address}
      </td>
    </tr>
    <tr>
      <th width="15%">简介</th>
      <td width="85%" colspan="3">
        ${enterprise.description}
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
