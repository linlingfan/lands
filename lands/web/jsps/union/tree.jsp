<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/26
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<HTML>
<HEAD>
  <TITLE> ZTREE DEMO </TITLE>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
  <style>
    body {
      background-color: white;
      margin:0; padding:0;
      text-align: center;
    }
    div, p, table, th, td {
      list-style:none;
      margin:0; padding:0;
      color:#333; font-size:12px;
    }
    #testIframe {margin-left: 10px;}
  </style>
  <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
  <script type="text/javascript" src="js/jquery.ztree.core-3.4.min.js"></script>
  <SCRIPT type="text/javascript">
    <!--
    var setting = {
      data: {
        simpleData: {
          enable: true
        }
      }
    };

    var zNodes =[
      { id:1, pId:0, name:"派单系统", open:true},
//      { id:11, pId:1, name:"商家(第三方)处理模块", open:true},
//      { id:111, pId:11, name:"家电维修", url:"http://www.baidu.com", target:"_self"},
//      { id:2, pId:0, name:"调度系统", open:true},
//      { id:21, pId:2, name:"商家(第三方)处理模块", open:true},
//      { id:211, pId:21, name:"工单查询", url:"http://www.baidu.com", click:"function(){alert(1);}"},
//      { id:212, pId:21, name:"工单维护", url:"http://www.baidu.com", target:"_self"},
//      { id:3, pId:0, name:"商家管理系统", open:true},
//      { id:31, pId:3, name:"商家(第三方)处理模块", open:true},
//      { id:311, pId:31, name:"员工信息查询", url:"http://www.baidu.com", click:"function(){alert(1);}"},
//      { id:312, pId:31, name:"商家信息维护", url:"http://www.baidu.com", target:"_self"},
//      { id:4, pId:0, name:"会员管理系统", open:true},
//      { id:41, pId:4, name:"会员信息查询", url:"http://www.baidu.com", click:"function(){alert(1);}"},
//      { id:42, pId:4, name:"会员信息维护", url:"http://www.baidu.com", target:"_self"},
//      { id:5, pId:0, name:"定位轨迹", url:"http://www.baidu.com", target:"_self"},
//      { id:6, pId:0, name:"重置密码", url:"http://www.baidu.com", target:"_self"},
//      { id:7, pId:0, name:"注销", url:"http://www.baidu.com", target:"_self"},
//      { id:8, pId:0, name:"退出", url:"http://www.baidu.com", target:"_self"}
    ];

    $(document).ready(function(){
      $.fn.zTree.init($("#tree"), setting, zNodes);
    });
    //-->
  </SCRIPT>
</HEAD>

<BODY>
<TABLE border=0 height=600px align=left>
  <TR>
    <TD width=220px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
      <ul id="tree" class="ztree" style="width:220px; overflow:auto;"></ul>
    </TD>
    <TD width=770px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC="http://www.baidu.com" ></IFRAME></TD>
  </TR>
  <tr>
    <td colspan=2 align=left>
      <ul class="info">
        <li class="title"><h2>treeNode 节点数据说明</h2>
          <ul class="list">
            <li class="highlight_red">简单模式的 JSON 数据需要使用 id / pId 表示节点的父子包含关系，如使用其他属性设置父子关联关系请参考 setting.data.simple 内各项说明
              <div><pre xmlns=""><code>例如：
                var nodes = [
                {id:1, pId:0, name: "父节点1"},
                {id:11, pId:1, name: "子节点1"},
                {id:12, pId:1, name: "子节点2"}`
                ];</code></pre></div></li>
            <li>默认展开的节点，请设置 treeNode.open 属性</li>
            <li>无子节点的父节点，请设置 treeNode.isParent 属性</li>
            <li>其他属性说明请参考 API 文档中 "treeNode 节点数据详解"</li>
            <li>open:true表示默认打开
            <li>url:表示链接指向
            <li>target:_self|_blank 打开方式，新窗口还是本窗口
            <li>click:function() 点击后产生的事件
          </ul>
        </li>
        <li class="title"><h2>3、其他说明</h2>
          <ul class="list">
            <li>Demo 中绝大部分都采用简单 JSON 数据模式，以便于大家学习</li>
          </ul>
        </li>
      </ul>
    </td>
  <tr>
</TABLE>

</BODY>
</HTML>
