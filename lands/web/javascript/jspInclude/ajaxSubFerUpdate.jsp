<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:select list="subFerUpdateList" listValue="name" listKey="id" 
	headerValue="请选择"  headerKey="-1" theme="simple"  
	value="%{fertilizerRecord.baseData.id}"
	name="subFerUpdate" id="subFerUpdate"/>
<span id="subFerUpdateTip"></span>