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
var worktype=document.getElementById("paraworktype").value;
$('#worktype').attr('value',worktype);

 });
 
 	function hide()
	{
	   type = document.getElementById("worktype").value;
	   if(type==1)
	   {
	    $("#city").hide();
	    $("#location").hide();
	    $("#reason").hide();
	   }
	   else if(type==2)
	   {
	   	 $("#city").hide();
	     $("#location").hide();
	     $("#reason").show();
	   }
	   else if (type==3)
	   {
	   	  $("#city").show();
	    $("#location").show();
	    $("#reason").show();
	   }
	   else if(type==4)
	   {
	   	 $("#city").hide();
	     $("#location").hide();
	     $("#reason").hide();
	   }
	   else if(type==5)
	   {
	   	 $("#city").hide();
	     $("#location").hide();
	     $("#reason").hide();
	   }
        // return;
     }
	


 </script>
	</head>
	<body>
		<form action="<%=path%>/submodifyrecord.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>外出登记修改</b>
				</div>
               <table width="600"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				${ui.username}
    				<input type="hidden" id="username" name="username" value="${ui.username}"/> 
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">新一代编号</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				${ui.newnumber}
    				<input type="hidden" id="applicant" name="applicant" value="${ui.newnumber}"/> 
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">办公地点</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    					<select id="worktype" name="worktype" onchange="hide()">
										<option value="1">川投大厦</option>
										<option value="2">航天大厦</option>
										<option value="3">外出</option>
										<option value="4">借调</option>
										<option value="5">休假</option>
						</select>
    			</td>
    			
    		  </tr>
    		  
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出城市</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="city" name="city"  value="${wd.city}" /> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出地点</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="location" name="location"  value="${wd.location}" /> 
    				
    			</td>
    			
    		</tr>
    		<tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出理由</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="reason" name="reason" value="${wd.reason}"  /> 
    				
    			</td>
    			
    		</tr>
    		
    	    <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">备注</span>
    			</td>
    			<td width="400" class="as">
    			<input style="width:380px"  type="text" id="remark" name="remark" value="${wd.remark}"  /> 
    				
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
				
					
			 <input type="hidden" name="newnumber" value="${newnumber}"/>
		    <input type="hidden" id="workdataid" name="workdataid" value="${workdataid}"/> 
		    <input type="hidden" id="paraworktype" name="paraworktype" value="${wd.worktype}"/> 
		</form>
	</body>

</html>


