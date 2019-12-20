<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//String username = (String)request.getSession().getAttribute("username");
	String IP=request.getRemoteAddr();
	session.setAttribute("IP",IP);
	
%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/cccx_old.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style_old.css" />
<link rel="stylesheet" type="text/css" href="css/style_menu_top.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>研发二处管理工具</title>
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js"></script>

<script language="javascript"> 


function startTime()
{
	
var today=new Date();
var h=today.getHours();
var m=today.getMinutes();
var s=today.getSeconds();
// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
t=setTimeout('startTime()',500);

}

function checkTime(i)
{
if (i<10) 
  {i="0" + i;}
  return i;
}
 
</script>
<script type="text/javascript">

function frame(o)
{
	
	var authoA = document.getElementById("authoA").value;
    var authoB = document.getElementById("authoB").value;
	var authoC = document.getElementById("authoC").value;
	var authoD = document.getElementById("authoD").value;
	var authoE = document.getElementById("authoE").value;
	var authoF = document.getElementById("authoF").value;
	var id = document.getElementById("id").value;									
	var obj = " ";
	obj=o;
	if(obj=="userinfo")
	{
		document.getElementById("frame").src="<%=path%>/userlistall.action";
		
     }
  
	else if(obj=="pwdmodify")
	{
		 document.getElementById("frame").src="<%=path%>/userinfopwd.action?id="+id;
		
	}
	else if(obj=="global_data")//本人发起申请
	{
		
			document.getElementById("frame").src="<%=path%>/showglobledata.action?newnumber=${newnumber}";
	
		//document.getElementById("daohang").innerHTML="请假申请->发起申请->本人发起";
	}
	else if(obj=="all_data")//本人发起申请
	{
		
			document.getElementById("frame").src="<%=path%>/showalldata.action?";
	
		//document.getElementById("daohang").innerHTML="请假申请->发起申请->本人发起";
	}
   else if(obj=="import_data")//本人发起申请
	{
		
			document.getElementById("frame").src="<%=path%>/page/wctj/UploadData.jsp";
	
		//document.getElementById("daohang").innerHTML="请假申请->发起申请->本人发起";
	}
	else if(obj=="chu_data")//本人发起申请
	{
		
			document.getElementById("frame").src="<%=path%>/showchuwctj.action?newnumber=${newnumber}";
	
		
	}
	else if(obj=="zu_data")//本人发起申请
	{
		
			document.getElementById("frame").src="<%=path%>/showchuwctj.action?newnumber=${newnumber}";
	
		
	}
	else if(obj=="person_data")//本人发起申请
	{
		
			document.getElementById("frame").src="<%=path%>/showpersondata.action?newnumber=${newnumber}";
	
		
	}
	
	else if(obj=="my_shenpi")
	{
		
			document.getElementById("frame").src="<%=path%>/showmyshenpi.action?newnumber=${newnumber}";
	
		
	}
	
	else if(obj=="all_shenpi")
	{
		
			document.getElementById("frame").src="<%=path%>/showallshenpi.action?newnumber=${newnumber}";
	
	}
	else if(obj=="wait_shenpi")
	{
		
			document.getElementById("frame").src="<%=path%>/showshenpidata.action?newnumber=${newnumber}";
	
	}
	
	else if(obj=="leave_modify")
	{
		
			document.getElementById("frame").src="<%=path%>/showleavedata.action";
	
	}
		else if(obj=="jiediao_modify")
	{
		
			document.getElementById("frame").src="<%=path%>/showjiediaodata.action";
	
	}
	


	
	else if(obj=="test_drrlb")//导入日历表
	{
		document.getElementById("frame").src="<%=path%>/page/userinfo/importrlb.jsp";
		
	}
	
}


	
</script>

<script type="text/javascript">
$(document).ready(function(){

		   
	/* 滑动/展开 */
	$("ul.expmenu li > div.header").click(
	function()
	{
		var arrow = $(this).find("span.arrow");
	
		$(this).parent().find("ul.menu1").slideToggle("fast").parents(".a").siblings(".a").children("ul.menu1").hide(300);
	}
);
	$(".cc").click(
			function()
			{
				$(".cc").css("width","155px");
				$(this).css("width","168px");	
			}
			);
});
</script>
<style>
.menu1 ol { padding-left:15px; border:#E7E7E7 1px solid; border-top:none;background: #f7f2e5;}
.menu1 li i{background-color: #ae9c7e;padding: 1px 4px;color: #fff;text-shadow: 0px 0px 0px rgba(255, 255, 255, 0.8);font-family: 宋体;font-style:normal;}
.menu1 a{color: #3f3f3f;text-decoration: none;}
.menu1 .no {display:none;}
.menu1 ol a{width: 228px;display: block;line-height: 2em;margin-left: 20px;}
</style>

<style media="print" type="text/css"> 
.noprint{display:none;} 
</style> 

</head>
<body onload="startTime()"> 
	<div id="zhuti" style="position:absolute">
		<div id="top" class="noprint">
			<img src="images/logo.gif" width="276" height="50"
				style="margin-top:0px" />
		</div>
		<div class=x_beijing>
			<div class="x_anniu noprint">
				<div>
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b
						class="b4 d1"></b>
					<div class="b d1 k">
						<div class=x_gr>
							<!-- 登陆用户信息 -->
							<p style="margin:0px；padding:0px">${username }</p>
							<p style="font-size:14px">欢迎访问研发支持二处管理工具</p>
							<p>
								<input align="right" name="logout" type="button" value="修改密码" onclick="frame('pwdmodify')" />&nbsp;
								<input align="right" name="logout" type="button" value="安全退出" onclick="location='<%=path%>/page/userinfo/logout.jsp'" />
								<input type="hidden" id="id" name="id" value="${id}"/>
							</p>
							<p><%=new SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date())%></p>
							<p id="txt"></p>
							<p>累计访问量：${views}</p>
						</div>
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b
						class="b1b"></b>
				</div>
					<div style="margin-top: 5px; background-color: #188AE7;">
						<ul class="expmenu">
			
							<li class="a">
								<div class="header">
									<span class="label">外出登记</span>
								</div>
								<ul class="menu1">
								 
									<c:if test="${authoD=='D'||authoE=='E'}">
									<li class="cc"  onclick="frame('import_data')">导入排班数据</li>
								
									</c:if>
								   <li class="cc"  onclick="frame('all_data')">处室人员分布一栏</li>	
									<c:if test="${authoA=='A'||authoB=='B'||authoC=='C'||authoE=='E'}">
                                   						
									<li class="cc"  onclick="frame('chu_data')">处室人员本周明细</li>
									</c:if>
									<c:if test="${authoF=='F'||authoD=='D'}">
									<li class="cc"  onclick="frame('zu_data')">小组人员本周明细</li>
									</c:if>
									<c:if test="${authoF=='F'||authoD=='D'||authoE=='E'}">
									<li class="cc"  onclick="frame('person_data')">员工本人明细</li>
									</c:if>
									<c:if test="${authoD=='D'}">
									<li class="cc"  onclick="frame('leave_modify')">休假信息维护</li>
									</c:if>
									<c:if test="${authoE=='E'}">
									<li class="cc"  onclick="frame('jiediao_modify')">借调信息维护</li>
									</c:if>
									<!--<c:if test="${authoF=='F'||authoB=='B'||authoD=='D'||authoE=='E'}">
									<li class="cc"  onclick="frame('my_shenpi')">我的申请</li>
									</c:if>
									<c:if test="${authoB=='B'}">
									<li class="cc"  onclick="frame('wait_shenpi')">待审批事项</li>
									</c:if>
									<c:if test="${authoA=='A'||authoB=='B'||authoC=='C'||authoE=='E'}">
								    <li class="cc"  onclick="frame('all_shenpi')">所有审批</li>
								    </c:if>-->
								</ul>
							</li>
				
							<c:if test="${authoE=='E'}">
							<li class="a">
								<div class="header">
									<span class="label">用户管理</span>
								</div>
								<ul class="menu1">
									
								
										<li class="cc"  onclick="frame('userinfo')">员工信息管理</li>
										<li class="cc"  onclick="frame('test_drrlb')">导入日历表</li>
										
										<!-- <li class="cc"   onclick="frame('test_drcshsj')">导入初始化数据</li> --> <!---->
								
									
								</ul>
							</li>
							</c:if>
						</ul>
					</div>
			</div>
			<div class="x_xianshi" style="overflow:hidden">
				<div style="overflow:hidden">
					<b class="b1"></b><b class="b2 d1"></b><b class="b3 d1"></b><b class="b4 d1"></b>
					<div class="b d1 k3">
 			       <c:if test="${authoA=='A'||authoB=='B'||authoC=='C'||authoD=='D'||authoE=='E'}">
						<iframe id="frame" class="mainpage"	src="<%=path%>/showalldata.action" marginwidth='0' marginheight='0' frameborder='0'></iframe>
					</c:if>	
					  <c:if test="${authoF=='F'}">
						<iframe id="frame" class="mainpage"	src="<%=path%>/showpersondata.action?newnumber=${newnumber}" marginwidth='0' marginheight='0' frameborder='0'></iframe>
					</c:if>	
						<input type="hidden" id="zhi" value="${zhi}"/>
						
						<!-- <input type="hidden" id="autho" value="${autho}"/> -->
						<input type="hidden" id="authoA" value="${authoA}"/>
						<input type="hidden" id="authoB" value="${authoB}"/>
						<input type="hidden" id="authoC" value="${authoC}"/>
						<input type="hidden" id="authoD" value="${authoD}"/>
						<input type="hidden" id="authoE" value="${authoE}"/>
						<input type="hidden" id="authoF" value="${authoF}"/>
						
					
						
					</div>
					<b class="b4b d1"></b><b class="b3b d1"></b><b class="b2b d1"></b><b class="b1b"></b>
				</div>
			</div>
		</div>
	</div>
</body>
</html>