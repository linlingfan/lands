<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/19
  Time: 23:16
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
<form action="<c:url value='/EnterpriseServlet'/>" method="get">
    <%--一定要用get不然使用post后台得不到分页需要url--%>
    <!--隐藏字段-->
    <input type="hidden" name="method" value="searchByEnname"/>

    <h1>查询工具</h1>
    名称<input type="text" name="enname" value="${enname}"/>
    <input type="submit" value="查询"><br/>
    <%--页码显示--%>
    <div id="page">
        <span id="add">
        <input type="button" value="增加" style="width: 80px;height: 25px;background-color: #74d2d9"/>
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
    <%--产地数据显示--%>
    <table border="1" width="90%" cellspacing="0" id="">
        <tbody>
        <tr>
            <td>序号</td>
            <td>企业名称</td>
            <td>状态</td>
            <td>法人代表</td>
            <td>联系电话</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageBean.beanList}" var="enterpriseList">
            <tr>
                <td>${enterpriseList.serialnum}</td>
                <td>${enterpriseList.enname}</td>
                <c:choose>
                    <c:when test="${enterpriseList.flag eq 2}">
                        <td>正常</td>
                    </c:when>
                    <c:when test="${enterpriseList.flag eq 3}">
                        <td>暂停</td>
                    </c:when>
                </c:choose>
                <td>${enterpriseList.contacts}</td>
                <td>${enterpriseList.phone}</td>
                <div id="button">
                    <td>
                        <a href="<c:url value='/EnterpriseServlet?method=enterpriseDetail&en_id=${enterpriseList.en_id}'/>">
                            <input type="button" value="查看"/></a>
                        <c:if test="${enterpriseList.flag eq 2}">
                            <a href="<c:url value='/EnterpriseServlet?method=loadModifyEnterprise&en_id=${enterpriseList.en_id}'/>">
                                <input type="button" value="修改"/></a>
                            <a href="<c:url value='/EnterpriseServlet?method=changeState&flag=3&en_id=${enterpriseList.en_id}'/>">
                                <input type="button" value="暂停"/></a>
                            <a href="<c:url value='/EnterpriseServlet?method=changeState&flag=4&en_id=${enterpriseList.en_id}'/>">
                                <input type="button" value="注销"/></a>
                        </c:if>
                        <c:if test="${enterpriseList.flag eq 3}">
                            <a href="<c:url value='/EnterpriseServlet?method=changeState&flag=2&en_id=${enterpriseList.en_id}'/>">
                                <input type="button" value="恢复"/></a>
                        </c:if>
                    </td>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
