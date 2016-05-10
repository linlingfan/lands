<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/26
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加会员信息</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
    <style type="text/css">
        #page {
            background: #D1ECFF;
            height: 30px;
            width: 90%;
            text-align: center;
            border-top: 5px solid #A3CEEE;
        }

        #pagenum {
            font-size: 15px;
            line-height: 25px;
        }

        #add {
            position: relative;
            right: 400px;
        }

    </style>
</head>
<form action="#" method="post" id="formTable">
    <table id="detailTable">
        <caption>协会信息</caption>
        <tbody>
        <tr>
            <th width="15%">所属协会</th>
            <td width="85%" colspan="3">
                ${union.unname}
            </td>
        </tr>
        <tr>
            <th width="15%">选择会员</th>
            <td width="85%" colspan="3">
                ${union.unname}
            </td>
        </tr>
        <tr>
            <td width="100%" colspan="4">
                <div style="margin-left:380px;margin-right:auto;width: 230px">
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
