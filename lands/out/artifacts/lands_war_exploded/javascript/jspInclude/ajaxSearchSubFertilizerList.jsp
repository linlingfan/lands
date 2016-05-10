<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:select list="searchSubFertilizerList" listValue="name" listKey="id" 
	headerKey="-1" headerValue="请选择" theme="simple" 
	name="searchSubFertilizer" id="searchSubFertilizer"/>