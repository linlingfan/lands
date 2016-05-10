<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/15
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产地明细</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>

</head>
<body>
<form action="#" method="post" id="formTable">
    <table id="detailTable">
        <caption>地块明细</caption>
        <tbody>
        <tr>
            <th width="15%">地块名称</th>
            <td width="35%">
                ${requestScope.landList.lname}
            </td>
            <th width="15%">种植面积</th>
            <td width="35%">
                ${requestScope.landList.plantarea}
            </td>
        </tr>

        <tr>
            <th width="15%">所属地区</th>
            <td width="35%">
                ${requestScope.landList.area}
            </td>
            <th width="15%">地块位置</th>
            <td width="35%">
                ${requestScope.landList.position}
            </td>
        </tr>

        <tr>
            <th width="15%">二维码</th>
            <td width="85%" colspan="3">
                ${requestScope.landList.dimensional_id}
            </td>
        </tr>
        <tr>
            <th width="15%">类型描述</th>
            <td width="85%" colspan="3">
                ${requestScope.landList.description}
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
