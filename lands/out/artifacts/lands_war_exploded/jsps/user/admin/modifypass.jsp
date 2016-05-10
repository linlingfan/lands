<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/5/8
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>查看个人信息</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
</head>
<body>
<form action="<c:url value='/AdminServlet'/> " method="get" id="formTable">
    <input type="hidden" name="method" value="modifyPass"/>
    <table id="detailTable">
        <caption>个人信息</caption>
        <tbody>
        <tr>
            <th width="15%">旧密码</th>
            <td width="35%" colspan="3">
                <input type="text" name="oldpass" value="${list[0]}"/>${msg1}
            </td>
        </tr>
        <tr>
            <th width="15%">新密码</th>
            <td width="35%" colspan="3">
                <input type="text" name="newpass" value="${list[1]}"/>${msg2}
            </td>
        </tr>
        <tr>
            <th width="15%">确认密码</th>
            <td width="85%" colspan="3">
                <input type="text" name="repass" value="${list[2]}"/>${msg3}
            </td>
        </tr>
        <tr>
            <td width="100%" colspan="4">
                <div style="margin-left:380px;margin-right:auto;width: 230px">
                    <input type="submit" value="提交"/>
                    <input type="button" onclick="location.href='javascript:history.go(-1)'" value="取消"/>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    ${success}
</form>
</body>
</html>

