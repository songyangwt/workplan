<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
    <title>My JSP 'authorityfailed.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
	<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	 
    </script>
  <style type="text/css">
  .as {
	text-align: center;
}
b{
	color:red;
}
  </style>
  </head>
  
  <body>
    <c:if test="${authoD=='D'}"> 
    <form name="filename1" action="importwctj.action" method="post"  enctype="multipart/form-data">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>上传排班数据</strong></p>
        <table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		<tr>
    			<td class="as">
    				上传附件<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				文件：<input type="file" name="file" /><br/>
    			 	
    			</td>
    		</tr>
    		
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input style="width:70px" type="submit" value="提  交"/><b>请保存成Excel2003格式上传</b> <br>
    				<a href="<%=path%>/templet/weekplan.xls">下载【一周排班数据】模板</a>
    			</td>
    		</tr>
    	</table>
    </form>
      </c:if>
    <c:if test="${authoE=='E'}">  
        <form name="filename2" action="importjiediao.action" method="post"  enctype="multipart/form-data">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>上传借调人员数据</strong></p>
        <table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		<tr>
    			<td class="as">
    				上传附件<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				文件：<input type="file" name="file" /><br/>
    			 	
    			</td>
    		</tr>
    		
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input style="width:70px" type="submit" value="提  交"/><b>请保存成Excel2003格式上传</b> <br>
    				<a href="<%=path%>/templet/jiediaoplan.xls">下载【借调人员表】模板</a>
    			</td>
    		</tr>
    	</table>
    </form>
    </c:if>
    <c:if test="${authoD=='D'}"> 
        <form name="filename3" action="importleaveinfo.action" method="post"  enctype="multipart/form-data">
    	  <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>上传休假人员数据</strong></p>
        <table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		<tr>
    			<td class="as">
    				上传附件<b>*</b>
    			</td>
    			<td colspan="3" id="p">
    				文件：<input type="file" name="file" /><br/>
    			 	
    			</td>
    		</tr>
    		
    		<tr>
    			<td>
    				&nbsp;
    			</td>
    			<td colspan="3">
    				<input style="width:70px" type="submit" value="提  交"/><b>请保存成Excel2003格式上传</b> <br>
    				<a href="<%=path%>/templet/leaveplan.xls">下载【休假人员表】模板</a>
    			</td>
    		</tr>
    	</table>
    </form>
      </c:if>
  </body>
</html>
