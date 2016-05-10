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
    <title>供应商信息管理</title>
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
<form action="<c:url value='/SupplierServlet'/>" method="get">
    <%--一定要用get不然使用post后台得不到分页需要url--%>
    <!--隐藏字段-->
    <input type="hidden" name="method" value="searchSupplier"/>

    <h1>查询工具</h1>
    供应商名称<input type="text" name="sname" value="${sname}"/>
    供应商类型<select style="width: 150px; height: 20px;" name="type">
    <%--<option>请选择</option>--%>
    <option value="1"
            <c:if test="${1 eq type}">
                selected="selected"
            </c:if>
            >个人
    </option>
    <option value="2"
            <c:if test="${ 2 eq type}">
                selected="selected"
            </c:if>
            >单位
    </option>

</select>
    所供应企业<select style="width: 150px; height: 20px;" name="enname">
    <%--<option>请选择</option>--%>
    <c:forEach items="${ennameList}" var="el">
        <option value="${el.en_id}"
                <c:if test="${el.en_id eq en_id}">
                    selected="selected"
                </c:if>
                >${el.enname}</option>
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
    <br/>
    <%--供应商数据显示--%>
    <table border="1" width="90%" cellspacing="0" id="">
        <tbody>
        <tr>
            <td>序号</td>
            <td>供应商名称</td>
            <td>供应商类型</td>
            <td>供应商联系人</td>
            <td>所供应企业</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageBean.beanList}" var="supplierList">
            <tr>
                <td>${supplierList.serialnum}</td>
                <td>${supplierList.sname}</td>
                <c:choose>
                    <c:when test="${supplierList.type eq 1}">
                        <td>个人</td>
                    </c:when>
                    <c:when test="${supplierList.type eq 2}">
                        <td>单位</td>
                    </c:when>
                </c:choose>
                    <%--<td>${supplierList.type}</td>--%>
                <td>${supplierList.contacts}</td>
                <td>${supplierList.enterprise.enname}</td>
                <td><a href="<c:url value='/SupplierServlet?method=supplierDetail&sid=${supplierList.sid}'/> ">查看</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
