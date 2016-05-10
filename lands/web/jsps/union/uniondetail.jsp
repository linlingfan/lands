<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/21
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>协会信息</title>
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
<body>
<form action="#" method="post" id="formTable">
    <table id="detailTable">
        <caption>协会信息</caption>
        <tbody>
        <tr>
            <th width="15%">协会名称</th>
            <td width="85%" colspan="3">
                ${union.unname}
            </td>
        </tr>

        <tr>
            <th width="15%">协会联系人</th>
            <td width="35%">
                ${union.contacts}
            </td>
            <th width="15">联系人电话</th>
            <td width="35">
                ${union.phone}
            </td>
        </tr>

        <tr>
            <th width="15%">通信地址</th>
            <td width="85%" colspan="3">
                ${union.address}
            </td>
        </tr>
        <tr>
            <td width="100%" colspan="4">
                <div style="margin-left:380px;margin-right:auto;width: 230px">
                    <input type="button" onclick="location.href='javascript:history.go(-1)'" value="返回"/>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<br/>
<br/>
<form action="<c:url value='/UnionServlet'/>" method="get">
    <%--一定要用get不然使用post后台得不到分页需要url--%>
    <%--页码显示--%>
    <div id="page">
        <span id="add">
        <input type="button" value="增加" style="width: 80px;height: 25px;background-color: #74d2d9"
               onclick="window.location.href='<c:url value="/jsps/union/addvip.jsp"/>'"/>
        </span>
    </div>
    <br/>
    <%--协会数据显示--%>
    <table border="1" width="90%" cellspacing="0" id="">
        <tbody>
        <tr>
            <td>序号</td>
            <td>会员ID</td>
            <td>会员名称</td>
            <td>会员状态</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${union.e_unionList}" var="enList">
            <tr>
                <td>${enList.enterprise.serialnum}</td>
                <td>${enList.enterprise.en_id}</td>
                <td>${enList.enterprise.enname}</td>
                <c:choose>
                    <c:when test="${enList.state eq 1}">
                        <td>审核通过</td>
                    </c:when>
                    <c:when test="${enList.state eq 2}">
                        <td>申请</td>
                    </c:when>
                    <c:when test="${enList.state eq 3}">
                        <td>审核不通过</td>
                    </c:when>
                </c:choose>
                <div id="button">
                    <td>
                        <a href="<c:url value='/UnionServlet?method=en_unDetail&unname=${union.unname}&en_id=${enList.enterprise.en_id}&u_id=${union.u_id}'/>">
                            <input type="button" value="查看"/></a>
                        <a href="<c:url value='/UnionServlet?method=loadModifyEnterprise&unname=${union.unname}&en_id=${enList.enterprise.en_id}&u_id=${union.u_id}'/>">
                            <input type="button" value="审核"/></a>
                        <a href="<c:url value='/UnionServlet?method=deleteEnterprise&u_id=${union.u_id}&en_id=${enList.enterprise.en_id}'/>">
                            <input type="button" value="删除"/></a>
                    </td>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>

</body>
</html>

