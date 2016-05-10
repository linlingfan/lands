<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/20
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>修改企业数据</title>
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
  <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
  <style type="text/css">
  </style>
</head>
<body>
<h1>${success}</h1>
<form action="<c:url value='/EnterpriseServlet'/>" method="post" id="formTable">
  <input type="hidden" name="method" value="modifyEnterprise"/>
  <!--设置一个隐藏字段保存en_id-->
  <input type="hidden" name="en_id" value="${enterprise.en_id}"/>
  <table id="detailTable">
    <caption>客户详细信息</caption>
    <tbody>
    <tr>
      <th width="15%">名称</th>
      <td width="85%" colspan="3">
        <input type="text" style="width: 50%" name="enname" value="${enterprise.enname}"/>(必填)
      </td>
    </tr>
    <tr>
      <th width="15%">联系人</th>
      <td width="85%" colspan="3">
        <input type="text" style="width: 50%" name="contacts" value="${enterprise.contacts}"/>(必填)
      </td>
    </tr>
    <tr>
      <th width="15%">联系电话</th>
      <td width="85%" colspan="3">
        <input type="text" style="width: 50%" name="phone" value="${enterprise.phone}"/>(必填)
      </td>
    </tr>
    <tr>
      <th width="15%">邮政编号</th>
      <td width="85%" colspan="3">
        <input type="text" style="width: 50%" name="zipcode" value="${enterprise.zipcode}"/>(选填)
      </td>
    </tr>
    <tr>
      <th width="15%">地址</th>
      <td width="85%" colspan="3">
        <input type="text" style="width: 50%" name="address" value="${enterprise.address}"/>(选填)
      </td>
    </tr>
    <tr>
      <th width="15%">简介</th>
      <td width="85%" colspan="3">
        <textarea style="width: 80%;height: 90px" name="description">
          ${enterprise.description}
        </textarea>(选填)
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="4">
        <div style="margin-left:380px;margin-right:auto;width: 230px"> <!--div里的内容居中-->
          <input type="submit" value="提交"/>
          <%--onclick="javascript:window.location.href=''"--%>
          <input type="button" onclick="location.href='javascript:history.go(-1)'" value="返回"/>
        </div>
      </td>
    </tr>
    </tbody>
  </table>
</form>

