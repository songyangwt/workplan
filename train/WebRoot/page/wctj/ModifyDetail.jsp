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

 

 </script>
  
	</head>
	<body>
		<form  method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>外出登记修改</b>
				</div>
               <table width="600"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				<span style="font-size:12pt;color:black">${ui.username}</span>
    				<input type="hidden" id="username" name="username" value="${ui.username}"/> 
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">新一代编号</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				<span style="font-size:12pt;color:black">${ui.newnumber}</span>
    				<input type="hidden" id="newnumber" name="newnumber" value="${ui.newnumber}"/> 
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">办公地点</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    			<span style="font-size:12pt;color:black">
    					<select id="worktype" name="worktype">
										<option value="1">川投大厦</option>
										<option value="2">航天大厦</option>
										<option value="3">外出出差</option>
										<!--  <option value="4">借调</option>-->
										<!-- <option value="5">休假</option>-->
										
						</select>
						</span>
    			</td>
    			
    		  </tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出地点</span>
    			</td>
    			<td width="400" class="as">
    			
    				<span style="font-size:12pt;color:black">${wm.location}</span>
    			</td>
    			
    		</tr>
    		<tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出理由</span>
    			</td>
    			<td width="400" class="as">
    			  <span style="font-size:12pt;color:black">  ${wm.reason}</span>
    				
    			</td>
    			
    		</tr>
    		
    		
    			<tr>
    			<td class="as">
    				审批意见<span>*</span>
    			</td>
    			<td  class="as">
    			 <span style="font-size:12pt;color:black">
    				<c:forEach items="${listlp}" var="lp" varStatus="status">
    					
     	 					审批人：${lp.viewer}&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;</c:if>审批时间：${lp.time}<br/>
      					
      					
    				</c:forEach>
    				</span>
    			</td>
    		</tr>
    		 
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				<input style="width: 80px" type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 
    				
    			</td>
    			
    		</tr>
    		 <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
   
    	</table>
				
					
			
		     <input type="hidden" id="paraworktype" name="worktype" value="${wm.worktype}"/> 
		</form>
	</body>

</html>


