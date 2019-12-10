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
  function tijiao() {
	  var radio=document.getElementsByName("radio");
	  var xuanze = document.getElementById("xuanze").value;
	  var message = "确认提交？";
	  if(radio[0].checked!=true&&radio[1].checked!=true)
		{
			alert("请选择审批意见");
		}
	  else if(xuanze=="wu"&&radio[0].checked==true)
		{
			alert("请选择下一级审批人");
		}
		else
		{
			if (window.confirm(message)) {
				with(document.forms[0]) {
					action='shenpi.action';
					method="post";
					submit();
				}
			}
		}
  }
  function sel(o)
  {
	  if(o==11)
	  {
		  document.getElementById("xuanze").style.display="inline-block";
			
		}else{
			alert("请确认您选择的意见是【不同意】");
			document.getElementById("xuanze").style.display="none"; 
		} 
	} 
	 </script>	
	 
	</head>
	<body>
		<form action="<%=path%>/shenpi.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>外出登记修改申请</b>
				</div>
               <table width="600"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				
    			<span style="font-size:12pt;color:black">	${fb:newnumbertoname(wm.applicant)}</span>
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">新一代编号</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    			<span style="font-size:12pt;color:black">	${wm.applicant}</span>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">办公地点</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				<span style="font-size:12pt;color:black">${fb:worktypetostring(wm.worktype)}</span>
    			</td>
    			
    		  </tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出地点</span>
    			</td>
    			<td width="400" class="as">
    		   <span style="font-size:12pt;color:black"> ${wm.location}</span>
    				
    			</td>
    			
    		</tr>
    		<tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">外出理由</span>
    			</td>
    			<td width="400" class="as">
    			<span style="font-size:12pt;color:black"> ${wm.reason}</span>
    				
    			</td>
    			
    		</tr>
    		
    		<tr>
    			<td class="as">
    			<span style="font-size:12pt;color:black">	审批意见</span>
    			</td>
    			<td colspan="5">
    				<span style="font-size:12pt;color:black"><c:forEach items="${listlp}" var="lp" varStatus="status">
    					<c:if test="${lp.authority=='B'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
      					<c:if test="${lp.authority=='C'}"> 
     	 					审核人：${lp.viewer}&nbsp;&nbsp;意见：${fb:opiniontostring(lp.opinion)}&nbsp;&nbsp;<c:if test="${not empty lp.remark}">备注：${lp.remark}&nbsp;&nbsp;</c:if>审核时间：${lp.time}<br/>
      					</c:if>
    				
    				</c:forEach>
    				
    					<input type="radio" name="radio" value="agree" onclick="sel(11)">
        						同意
        				<input type="radio" name="radio" value="disagree" onclick="sel(22)">
        						不同意
     					 备注：<input type="text" name="textfield" >
    				
    				</span>
    				
    			</td>
    		</tr>
    		
    		<c:if test="${youshenpi==1}"> 
    		<tr>
    			<td class="as">
    				选择审批人
    			</td>
    			<td class="as">
    				<select id="xuanze" name="xuanze">
        				<option>请选择下一级审批人</option>
        					<c:forEach items="${listui}" var="user" varStatus="status">
        						<option value="${user.newnumber}">${user.username}</option>
        					</c:forEach>
        			</select>
    			</td>
    		</tr>
    		</c:if>
    		<c:if test="${youshenpi!=1}"> 
    			<input type="hidden" id="xuanze" name="xuanze" value=""/>
    		</c:if>
    		 
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span>*</span>
    			</td>
    			<td width="400" class="as">
    				<input type="button" onclick="tijiao()"  value="提  交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<input type="button" onclick="javascript:history.go(-1);" value="返  回" />
    				
    			</td>
    			
    		</tr>
    		 <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
   
    	</table>
				    <input type="hidden" name="number" value="${number}"/>
    				<input type="hidden" name="thisunder" value="${undersign}"/>
    				<input type="hidden" name="thisnewnumber" value="${newnumber}"/>
    				<input type="hidden" name="thisundername" value="${username}"/>
					
			
		
		</form>
	</body>

</html>


