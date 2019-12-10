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
var leavetype=document.getElementById("paraleavetype").value;
$('#leavetype').attr('value',leavetype);

 });
 



 </script>
	</head>
	<body>
		<form action="<%=path%>/subleavemodify.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>休假人员明细修改</b>
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
    				<span style="font-size:12pt;color:black">休假类型</span>
    			</td>
    			<td width="400" class="as">
    	<select id="leavetype" name="leavetype" style="width:380px,padding:0px;margin:0px;">
      		<option value="">请选择休假类型</option>
      		<option value="1">病假</option>
      		<option value="2">年休假</option>
      		<option value="3">事假</option>
      		<option value="4">婚假</option>
      		<option value="5">产假/陪护假</option>
      		<option value="6">探亲假（配偶）</option>
      		<option value="7">探亲假（父母）</option>
      		<option value="8">丧假</option>
      		<option value="9">工伤假</option>
      		<option value="10">公假</option>
      		<option value="11">加班调休</option>
      		<option value="12">产检</option>
      		<option value="13">陪考假</option>
      		<option value="14">哺乳假</option>
      	</select>
    				
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
				
					
			
		    <input type="hidden" id="leaveid" name="leaveid" value="${leaveid}"/> 
		    <input type="hidden" id="paraleavetype" name="paraleavetype" value="${wc.leavetype}"/> 
		</form>
	</body>

</html>


