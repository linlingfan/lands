<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>通信助理欢迎您</title>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8">
</head>
<frameset border=0 frameSpacing="0" frameBorder="NO" rows="120,*,40">
	<frame name="page_top" src="<c:url value='/pagetop.jsp'/>" frameBorder=0
		   noResize scrolling=no>
	<frameset cols="180,*" border="0" frameSpaceing="0" frameBorder="no">
		<frame name="page_menu" src="<c:url value='/pagemenu.jsp'/>" frameBorder=0
			   noResize>
		<frame name="page_content" id="page_content" src="<c:url value='/welcome.jsp'/>"
			   frameBorder=0 noResize>
	</frameset>
	<frame name="page_bottom" src="<c:url value='/pagebottom.jsp'/>" frameBorder=0
		   noResize scrolling=no>
</frameset>
</html>