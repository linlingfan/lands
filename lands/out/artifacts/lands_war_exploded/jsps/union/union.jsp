<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/21
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>供货企业管理</title>
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
      right: 250px;
    }

  </style>
</head>
<body>
<form action="<c:url value='/UnionServlet'/>" method="get">
  <%--一定要用get不然使用post后台得不到分页需要url--%>
  <!--隐藏字段-->
  <input type="hidden" name="method" value="searchByUnname"/>

  <h1>查询工具</h1>
  名称<input type="text" name="unname" value="${unname}"/>
  <input type="submit" value="查询"><br/>
  <%--页码显示--%>
  <div id="page">
        <span id="add">
        <input type="button" name="Button" value="增加" style="width: 80px;height: 25px;background-color: #74d2d9"
               onclick="window.location.href='<c:url value="/jsps/union/add.jsp"/>'"/>
        </span>
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
  <%--协会数据显示--%>
  <table border="1" width="90%" cellspacing="0" id="">
    <tbody>
    <tr>
      <td>序号</td>
      <td>协会ID</td>
      <td>协会名称</td>
      <td>协会联系人</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${pageBean.beanList}" var="unionList">
      <tr>
        <td>${unionList.serialnum}</td>
        <td>${unionList.u_id}</td>
        <td>${unionList.unname}</td>
        <td>${unionList.contacts}</td>
        <div id="button">
          <td>
            <a href="<c:url value='/UnionServlet?method=unionDetail&u_id=${unionList.u_id}'/>">
              <input type="button" value="查看"/></a>
              <a href="<c:url value='/UnionServlet?method=loadModifyUnion&u_id=${unionList.u_id}'/>">
                <input type="button" value="修改"/></a>
              <a href="<c:url value='/UnionServlet?method=deleteUnion&u_id=${unionList.u_id}'/>">
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