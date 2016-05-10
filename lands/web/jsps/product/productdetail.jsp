<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/17
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品明细</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
    <style type="text/css">
    </style>
</head>
<body>
<form action="#" method="post" id="formTable">
    <table id="detailTable">
        <caption>产品信息</caption>
        <tbody>
        <tr>
            <th width="15%">名称</th>
            <td width="35%">
                ${product.pname}
            </td>
        </tr>

        <tr>
            <th width="15%">地块名称</th>
            <td width="35%">
                ${product.land.lname}
            </td>
        </tr>

        <tr>
            <th width="15%">产量</th>
            <td width="35%" colspan="3">
                ${product.quantity}
            </td>
        </tr>
        <tr>
            <th width="15%">茶叶类型</th>
            <td width="35%" colspan="3">
                ${product.elements.elname}
            </td>
        </tr>
        <tr>
            <th width="15%">生产日期</th>
            <td width="35%" colspan="3">
                ${product.production_date}
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

</body>
</html>
