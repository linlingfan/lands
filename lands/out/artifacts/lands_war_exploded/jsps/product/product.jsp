<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/17
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>产品批次管理</title>
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
<form action="<c:url value='/ProductServlet'/>" method="get">
  <%--一定要用get不然使用post后台得不到分页需要url--%>
  <!--隐藏字段-->
  <input type="hidden" name="method" value="findProductByPname"/>
  <h1>查询工具</h1>
  名称<input type="text" name="pname" value="${pname}"/>
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
  <%--产地数据显示--%>
  <table border="1" width="90%" cellspacing="0" id="">
    <tbody>
    <tr>
      <td>序号</td>
      <td>产品名称</td>
      <td>所属地块</td>
      <td>产品类型</td>
      <td>产品状态</td>
      <td>出产日期</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${pageBean.beanList}" var="productList">
      <tr>
        <td>${productList.serialnum}</td>
        <td>${productList.pname}</td>
        <td>${productList.land.lname}</td>
        <td>${productList.elements.elname}</td>
        <td>${productList.flag}</td>
        <td>${productList.production_date}</td>
        <td><a href="<c:url value='/ProductServlet?method=productDetail&pid=${productList.pid}'/>">查看</a></td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</form>
</body>
</html>
