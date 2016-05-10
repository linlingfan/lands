<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/17
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>供应商信息</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
</head>
<body>
<form action="#" method="post" id="formTable">
    <table id="detailTable">
        <caption>供应商信息</caption>
        <tbody>
        <tr>
            <th width="15%">供应商名称</th>
            <td width="35%">
                ${supplier.sname}
            </td>
            <th width="15%">供应商联系人</th>
            <td width="35%">
                ${supplier.contacts}
            </td>
        </tr>
        <tr>
            <th width="15%">供应商类型</th>
            <td width="35%">
                ${supplier.type}
            </td>
            <th width="15%">联系电话</th>
            <td width="35%">
                ${supplier.phone}
            </td>
        </tr>
        <tr>
            <th width="15%">联系人身份证</th>
            <td width="35%">
                ${supplier.id_code}
            </td>
            <th width="15%">邮编</th>
            <td width="35%">
                ${supplier.zipcode}
            </td>
        </tr>
        <tr>
            <th width="15%">供应茶叶类型</th>
            <td width="85%" colspan="3">
            </td>
        </tr>
        <tr>
            <th width="15%">供应企业</th>
            <td width="85%" colspan="3">
                ${supplier.enterprise.enname}
            </td>
        </tr>
        <tr>
            <th width="15%">通讯地址</th>
            <td width="85%" colspan="3">
                ${supplier.address}
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
