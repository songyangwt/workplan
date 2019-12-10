<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
<style type="text/css">
  .as {
	text-align: center;
}
 span{
	color:red;
  }
  </style>
    <script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 


 });
 

	


 </script>
	</head>
	<body>
		<form action="<%=path%>/subjiediaomodify.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>借调人员明细修改</b>
				</div>
               <table width="600"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				${wc.name}
    				<input type="hidden" id="name" name="name" value="${wc.name}"/> 
    			</td>
    			
    		</tr>
    		
    	
    		  
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">开始日期</span>
    			</td>
    			<td width="400" class="as">
    			<!-- <input style="width:380px"  type="text" id="begindate" name="begindate"  value="${wc.begindate}" />  -->
    			<input style="width:380px" type="text" name="begindate" id="begindate" class="Wdate"   value="${wc.begindate}" >	
    			</td>
    			
    		</tr>
    		
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">结束日期</span>
    			</td>
    			<td width="400" class="as">
    			<!-- <input style="width:380px"  type="text" id="enddate" name="enddate"  value="${wc.enddate}" /> -->
    			<input style="width:380px" type="text" name="enddate" id="enddate" class="Wdate"   value="${wc.enddate}" >	
    			</td>
    			
    		</tr>
    		
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">借调地点</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="location" name="location"  value="${wc.location}" /> 
    				
    			</td>
    			
    		</tr>
    		<tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">借调理由</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="reason" name="reason" value="${wc.reason}"  /> 
    				
    			</td>
    			
    		</tr>
    		
    		<tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">借调单位</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="department" name="department" value="${wc.department}"  /> 
    				
    			</td>
    			
    		</tr>
    		
    		
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				<input style="width: 80px" type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   <input style="width: 80px" type="submit" class="but" value="提交" />
    				
    			</td>
    			
    		</tr>
    		 <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
   
    	</table>
				
					
		
		    <input type="hidden" id="jiediaoid" name="jiediaoid" value="${jiediaoid}"/> 
		   
		</form>
	</body>

</html>


