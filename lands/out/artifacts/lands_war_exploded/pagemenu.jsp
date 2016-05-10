<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="GBK">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>菜单项</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>

    <link type="text/css" rel="stylesheet" href="<c:url value='/css/main.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/javascript/mymenu/mymenu.css'/>"/>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value='/javascript/jquery/jquery.messager.js'/>"
            charset="UTF-8"></script>
    <script type="text/javascript" src="<c:url value='/javascript/mymenu/mymenu.js'/>" charset="UTF-8"></script>
    <script type="text/javascript">

        $(function () {
            $("#mymenu").MyMenu({
                collapsed: false,
                oneMenuOnly: false,
                target: "page_content"
            });
        });
    </script>
</head>
<body style="width:170px;padding-left:10px;">

<div id="main">
    <div id="controlBar">
        <div id="mymenu" class="mymenu">
            <div>
                <span>溯源信息管理</span>

                <div>
                    <a href="<c:url value='/LandServlet?method=findAllLand'/>" target="page_content">地块管理</a>
                    <a href="<c:url value='/LandServlet?method=findAllLand'/>" target="page_content">溯源信息管理</a>
                    <a href="<c:url value='/ProductServlet?method=findAllProduct'/>" target="page_content">产品批次管理</a>

                </div>
            </div>
            <div>
                <span>信息管理</span>

                <div>
                    <a href="<c:url value='/SupplierServlet?method=findAllSupplier'/>" target="page_content">供应商信息管理</a>
                    <a href="<c:url value='/ClientServlet?method=findAllClient'/>" target="page_content">客户信息管理</a>
                    <a href="<c:url value='/EnterpriseServlet?method=findAllEnterprise'/>"
                       target="page_content">供货企业管理</a>
                </div>
            </div>
            <div>
                <span>协会管理</span>

                <div>
                    <a href="<c:url value='/UnionServlet?method=findAllUnion'/>" target="page_content">协会管理</a>
                </div>
            </div>

            <div>
                <span>系统管理</span>

                <div>
                    <a href="<c:url value='/UserServlet?method=findAllEnt'/>" target="page_content">企业人员管理</a>
                    <a href="<c:url value='/UserServlet?method=findAllGov'/>" target="page_content">政府人员管理</a>
                </div>
            </div>


            <div>
                <span>个人信息管理</span>

                <div>
                    <a href="<c:url value='/AdminServlet?method=findAdminByU_id'/>" target="page_content">个人基本信息查看</a>
                    <a href="<c:url value='/AdminServlet?method=loadModifyAdmin'/>" target="page_content">个人基本信息修改</a>
                    <a href="jsps/user/admin/modifypass.jsp" target="page_content">密码修改</a>
                    <a href="function.jsp" target="page_content">注销</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
