<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/25
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>会员详情</title>
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
  <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
  <style type="text/css">
  </style>
</head>
<body>
<form action="<c:url value='/UnionServlet'/> " method="post" id="formTable">
  <input type="hidden" name="method" value="changeState"/>
  <input type="hidden" name="en_id" value="${e_union.enterprise.en_id}"/>
  <input type="hidden" name="u_id" value="${u_id}"/>
  <table id="detailTable">
    <caption>会员详情</caption>
    <tbody>
    <tr>
      <th width="15%">所属协会</th>
      <td width="85%" colspan="3">
        ${unname}
      </td>
    </tr>

    <tr>
      <th width="15%">会员名称</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.enname}
      </td>
    </tr>

    <tr>
      <th width="15%">工商登记证号</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.ba_certificate_code}
      </td>
    </tr>

    <tr>
      <th width="15%">税务登记证号</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.tax_certificate_code}
      </td>
    </tr>
    <tr>
      <th width="15%">qs食品安全认证号</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.qs_code}
      </td>
    </tr>
    <tr>
      <th width="15%">年缴税金额</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.tax_amount}
      </td>
    <tr>
      <th width="15%">茶山(园)面积</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.tea_land_area}
      </td>
      </td>
    </tr>
    <tr>
      <th width="15%">联系人</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.contacts}
      </td>
    </tr>
    <tr>
      <th width="15%">联系电话</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.phone}
      </td>
    </tr>
    <tr>
      <th width="15%">邮政编号</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.zipcode}
      </td>
    </tr>
    <tr>
      <th width="15%">地址</th>
      <td width="85%" colspan="3">
        ${e_union.enterprise.address}
      </td>
    </tr>

    <tr>
      <th width="15%">审核状态</th>
      <td width="85%" colspan="3">
        <select name="state">
          <option value="1">通过</option>
          <option value="3">不通过</option>
        </select>
      </td>
    </tr>

    <tr>
      <th width="15%">审核意见</th>
      <td width="85%" colspan="3">
        <input type="text" name="idea" value=""/>(必填)
      </td>
    </tr>
    <tr>
      <td width="100%" colspan="4">
        <div style="margin-left:380px;margin-right:auto;width: 230px"> <!--div里的内容居中-->
          <input type="submit" value="提交"/>
          <input type="button" onclick="location.href='javascript:history.go(-1)'" value="返回"/>
        </div>
      </td>
    </tr>
    </tbody>
  </table>
</form>
</body>
</html>

