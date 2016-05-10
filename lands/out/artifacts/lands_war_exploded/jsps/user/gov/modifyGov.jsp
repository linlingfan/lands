<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/5/6
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>查看企业员工信息</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
    <link type="text/css" rel="stylesheet" href="<c:url value='/javascript/treeview/jquery.treeview.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/treeview/jquery.treeview.js'/>"
            charset="UTF-8"></script>
    <script type="text/javascript">
        $(function () {
            $("#roleTree").treeview({
                control: "#roleControl"
            });
            $("#spTree").treeview({
                control: "#spControl"
            });
            $("#serviceTree").treeview({
                control: "#serviceControl"
            });
        })

    </script>
</head>
<body>
<form action="<c:url value='/UserServlet'/> " method="get" id="formTable">
    <input type="hidden" name="method" value="modifyGov"/>
    <input type="hidden" name="u_id" value="${user.u_id}"/>
    <input type="hidden" name="account" value="${user.account}"/>
    <input type="hidden" name="g_name" value=" ${user.groups.g_name}"/>
    <table id="detailTable">
        <caption>政府人员信息</caption>
        <tbody>
        <tr>
            <th width="15%">账号</th>
            <td width="35%">
                ${user.account}
            </td>
            <th width="15%">姓名</th>
            <td width="35%">
                <input type="text" name="u_name" value="${user.u_name}"/>
            </td>
        </tr>
        <tr>
            <th width="15%">密码</th>
            <td width="35%">
                <input type="text" name="u_pass" value="${user.u_pass}"/>
            </td>
            <th width="15%">重复密码</th>
            <td width="35%">
                <input type="text" name="reu_pass" value="${reu_pass}"/>${msg}
            </td>
        </tr>
        <tr>
            <th width="15%">联系电话</th>
            <td width="35%">
                <input type="text" name="link_phone" value="${user.link_phone}"/>
            </td>
            <th width="15%">Email</th>
            <td width="35%">
                <input type="text" name="link_email" value="${user.link_email}">
            </td>
        </tr>
        <tr>
            <th width="15%">联系地址</th>
            <td width="85%" colspan="3">
                <input type="text" name="link_addr" value="${user.link_addr}"/>
            </td>
        </tr>
        <tr>
            <th width="15%">拥有的角色</th>
            <td width="85%" colspan="3">

                <div class="scrollDiv">
                    <div id="roleControl">
                        <a href="#">折叠</a>
                        <a href="#">展开</a>
                    </div>
                    <ul id="roleTree" class="filetree">
                        <li class="closed">
                            <span class="folder">拥有的角色</span>
                            <ul>
                                <li class="closed">
												<span class="file">
                                                    ${user.groups.g_name}
                                                </span>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

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

