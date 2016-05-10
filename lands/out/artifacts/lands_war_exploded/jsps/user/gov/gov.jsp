<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/5/6
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>政府人员管理</title>
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
    </style>
</head>
<body>
<form action="<c:url value='/UserServlet'/>" method="get">
    <%--一定要用get不然使用post后台得不到分页需要url--%>
    <!--隐藏字段-->
    <input type="hidden" name="method" value="searchGov"/>

    <h1>查询工具</h1>
    账号<input type="text" name="account" value="${account}"/>
    姓名<input type="text" name="u_name" value="${u_name}"/>

    用户组<select style="width: 150px; height: 20px;" name="g_name">
    <option></option>
    <c:forEach items="${G_nameList}" var="gn">
        <option value="${gn.gid}"
                <c:if test="${gn.gid eq gid}">
                    selected="selected"
                </c:if>
                >${gn.g_name}</option>
    </c:forEach>
</select>
    <input type="submit" value="查询"><br/>
    <%--页码显示--%>
    <div id="page">
    <span id="pagenum">总共${pageBean.pall}条,
    &nbsp每页显示10条,
    &nbsp当前第${pageBean.pcode}页,&nbsp
    <a href="${pageBean.url}&pcode=1">首页</a>&nbsp|&nbsp
<c:if test="${pageBean.pcode > 1 }">
    <a href="${pageBean.url}&pcode=${pageBean.pcode-1}">上页</a>&nbsp|&nbsp
</c:if>
<c:if test="${pageBean.pcode< pageBean.precord}">
    <a href="${pageBean.url}&pcode=${pageBean.pcode+1}">下页</a>&nbsp|&nbsp
</c:if>
    <a href="${pageBean.url}&pcode=${pageBean.precord}">尾页</a>
        </span>
    </div>
    <br/>
    <%--企业员工数据显示--%>
    <table border="1" width="90%" cellspacing="0" id="">
        <tbody>
        <tr>
            <td>序号</td>
            <td>账号</td>
            <td>姓名</td>
            <td>创建时间</td>
            <td>创建人员账号</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageBean.beanList}" var="entList">
            <tr>
                <td>${entList.serialnum}</td>
                <td>${entList.account}</td>
                <td>${entList.u_name}</td>
                <td>${entList.add_date}</td>
                <td>${entList.creator}</td>
                <td><a href="<c:url value='/UserServlet?method=findGovByU_id&u_id=${entList.u_id}'/> ">查看</a>
                    <a href="<c:url value='/UserServlet?method=loadModifyGov&u_id=${entList.u_id}'/> ">修改</a>
                    <a href="<c:url value='/UserServlet?method=deleteGov&u_id=${entList.u_id}'/> ">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
