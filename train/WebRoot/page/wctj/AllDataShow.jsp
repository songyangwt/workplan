<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	
  <style type="text/css">
  .b {
	font-weight:bold;
	word-break:break-all;
	}
	.cb {
	text-align: center;
	font-weight:bold;
	word-break:break-all;
	}
	.c {
	text-align: center;
	word-break:break-all;
	}
	.o{
	word-break:break-all;
	}
	
	
b{
	color:red;
}
  </style>
  
  <script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
   var length1="${lengthwaichu}";
   var length2="${lengthjiediao}";

   if(Number(length1)!=0)
   {
    length1=Number(length1);
   	 document.getElementById("scroll1").style.height=Number(length1)*33+'px';
   	 //alert(Number(length1)*30+'px');
   }
   if(Number(length2)!=0)
   {
	   length2=Number(length2)>3?Number(length2):3;
   	 document.getElementById("scroll2").style.height=Number(length2)*33+'px';
   	 //alert(Number(length2)*30+'px');
   }
  
 
   if(Number(length1)>3)
     {
     	document.getElementById("scroll1").style.height='99px';
     	//alert("450px");
     }
  if(Number(length2)>6)
     {
     	document.getElementById("scroll2").style.height='198px';
     	 //alert("450px");
     }
 
 });
 
 function findbyname()
{
	 var name=document.getElementById("name").value;
	var date=document.getElementById("date").value;
	window.location = "<%=path%>/finddetailbyname.action?name="+name+"&date="+date;
}
 function findbydate()
{
	 var date=document.getElementById("date").value;
	
	window.location = "<%=path%>/showalldata.action?date="+date;
}
function findbyzu()
{
	var zu=document.getElementById("zu").value;
	var date=document.getElementById("date").value;
	window.location = "<%=path%>/finddetailbyzu.action?zu="+zu+"&date="+date;
}
function detail1()
{
	var date=document.getElementById("date").value;
	window.location = "<%=path%>/showdetail.action?type=1&date="+date;
}
function detail2()
{
	var date=document.getElementById("date").value;
	window.location = "<%=path%>/showdetail.action?type=2&date="+date;
}
function detail3()
{
	var date=document.getElementById("date").value;
	window.location = "<%=path%>/showleavedetail.action?date="+date;
}
 </script>
 
 
 
  </head>
  
  <body>
    <form  action="" method="post">
    <br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 28px;"><strong>研发支持二处员工分布情况</strong></p><br>
                	  
    	    <p align="center" style="padding:0px;margin:0px; font-size: 20px;">日期：<input style="width:150px" type="text" name="date" id="date" class="Wdate"  value="${date}"   onClick="WdatePicker();"><input type="button" value="查询" onclick="findbydate()"/>&nbsp;&nbsp;&nbsp;&nbsp;	 姓名 :<input  style="width: 150px;" type="text" name="name" id="name"/><input type="button" value="查询" onclick="findbyname()"/>&nbsp;&nbsp;&nbsp;&nbsp;小组:	<select id="zu" name="zu" style="width: 180px">
										<option value="wu">-请选择小组-</option>
										<option value="1">测试管理组</option>
										<option value="2">需求管理组</option>
										<option value="3">上线支持组</option>
										<option value="4">体验推广组</option>
										
										
						</select>
    				<input type="button" value="查询" onclick="findbyzu()"/></p>  

    	        <br>
    	  
          <div style="width:1000px; margin:0 auto;" >    
           <p align="left" style="padding:0px;margin:0px; font-size: 18px;"><strong>处室共有：${numtype1+numtype2+numtype3+numtype4+numtype5}人</strong></p><br>  
             <p align="left" style="padding:0px;margin:0px; font-size: 18px;"><strong>今日消防安全值班：${zhibannames}</strong></p><br>                         
           <div  style="width:300px; height:85px;float:left; border:1px solid black; margin:0px 30px 30px 0px;">
            <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>川投大厦:</strong></p><br>
             <p align="center" style="padding:0px;margin:0px; font-size: 18px;">今日：${numtype1}人&nbsp;&nbsp;<input type="button" value="查看详情" onclick="detail1()"/></p> 
           </div>   
           
            <div style="width:300px; height:85px;float:left; border:1px solid black; margin:0px 30px 30px 0px;" >
            <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>航天办公</strong></p><br>
             <p align="center" style="padding:0px;margin:0px; font-size: 18px;">今日：${numtype2}人&nbsp;&nbsp;<input type="button" value="查看详情" onclick="detail2()"/></p>
           </div>
             <div style="width:300px; height:85px;float:left; border:1px solid black; margin:0px 30px 30px 0px;">
            <p align="center" style="padding:0px;margin:0px; font-size: 24px;"><strong>休假</strong></p><br>
             <p align="center" style="padding:0px;margin:0px; font-size: 18px;">今日：${numtype3}人&nbsp;&nbsp;<input type="button" value="查看详情" onclick="detail3()"/></p>
           </div>
            
           </div>
           
           <div style="width:1000px; margin:0 auto;" >  
              <div style="width:965px; float:left; height:200px; border:1px solid black; ">
            <p  align="center"><span style="padding:0px;margin:0px; font-size: 24px;"><strong>出差（外出）:</strong> </span> <span  style="padding:0px;margin:0px; font-size: 20px;">今日 ${numtype4}人</span></p>
             <!-- <p align="center" style="padding:0px;margin:0px; font-size: 18px;">今日：${numtype4}人</p> -->
               <c:if test="${fn:length(listcity)!=0}">  
			           
				
			        	<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
			        	<tr height="20px" class="表格表头背景1" id="hang">
						
							<td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>城市</p>
								</div></td>
						   <td  width="150px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>人数</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>	
							
																	
						</tr>
			        	</table>
			         <div id="scroll1" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px;margin-left:17px;">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
					 
					<c:forEach items="${listcity}" var="wb" varStatus="status">
					<tr class="btbj" id="hang" style="height:25px">
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.city}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wb.sum}</div></td>		
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">
											<a href="<%=path%>/showcitydetail.action?city=${wb.city}&date=${date}">查看详情</a>
										</div>
								</td>
							
							        </tr>
									</c:forEach>
								</table>
			                     </div>  
			             
			            </c:if>
           
           </div>   
            <div style="width:965px; float:left; height:20px; ">
          </div>  
            <div  style="width:965px; float:left; height:350px; border:1px solid black; " >
           <p align="center"> <span  style="padding:0px;margin:0px; font-size: 24px;"><strong>借调:</strong></span>  <span style="padding:0px;margin:0px; font-size: 20px;">今日  ${numtype5}人</span></p>
             <!-- <p align="center" style="padding:0px;margin:0px; font-size: 18px;">今日：${numtype5}人</p> -->
               <c:if test="${fn:length(listjiediao)!=0}">  
			           
				
					
			        <table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
			         <tr height="20px" class="表格表头背景1" id="hang">
						
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
						   <td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>小组</p>
								</div></td>
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>借调开始时间</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>借调结束时间</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>借调事由</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>借调地点</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>借调单位</p>
								</div></td>
						
																	
						</tr>
			        </table>
			         <div id="scroll2" align="center" style="overflow-y: scroll; overflow-x: hidden;height:200px;margin-left:17px;">
					<table  align="center" style="border: 0px; " cellpadding="0" cellspacing="2" >
				   
							<c:forEach items="${listjiediao}" var="wc" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
							
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wc.name}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:zunametostring(wc.zu)}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wc.begindate}</div></td>
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wc.enddate}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wc.reason}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wc.location}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wc.department}</div></td>
							
						
							</tr>
							</c:forEach>
								</table>
			                     </div>  
			             
			            </c:if>
           </div>
             </div>     
            <input type="hidden" id="listcity" name="listcity" value="${listcity}"/> 
             <input type="hidden" id="listjiediao" name="listjiediao" value="${listjiediao}"/> 
    </form>
  </body>
</html>
