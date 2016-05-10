<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>查看个人信息</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/detailTable.css'/>" />
	<script type="text/javascript" src="<c:url value='/javascript/jquery/jquery-1.4.3.js'/>" charset="UTF-8"></script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/javascript/treeview/jquery.treeview.css'/>" />
	<script type="text/javascript" src="<c:url value='/javascript/treeview/jquery.treeview.js'/>" charset="UTF-8"></script>
	<script type="text/javascript">
		$(function(){
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
<form action="#" method="post" id="formTable">
	<table id="detailTable">
		<caption>个人信息</caption>
		<tbody>
		<tr>
			<th width="15%">账号</th>
			<td width="35%">
				sys
			</td>
			<th width="15%">姓名</th>
			<td width="35%">
				马三
			</td>
		</tr>
		<tr>
			<th width="15%">所属用户组</th>
			<td width="85%" colspan="3">
				系统管理员组
			</td>

		</tr>
		<tr>
			<th width="15%">联系电话</th>
			<td width="35%">
				13311111111
			</td>
			<th width="15%">Email</th>
			<td width="35%">
				00@189.cn

			</td>
		</tr>
		<tr>
			<th width="15%">联系地址</th>
			<td width="85%" colspan="3">
				18900000000@189.cn
			</td>
		</tr>
		<tr>
			<th width="15%">添加时间</th>
			<td width="35%">
				2011-10-12
			</td>
			<th width="15%">添加人员账号</th>
			<td width="35%">
				sys
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
				                            		系统管理员
												</span>
								</li>

							</ul>
						</li>
					</ul>
				</div>

			</td>
		</tr>
		</tbody>
	</table>
</form>
</body>
</html>