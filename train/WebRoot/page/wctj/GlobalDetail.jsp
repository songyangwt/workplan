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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
 <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ffffff;
}
-->
</style>
<script type="text/javascript">
 $(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 

 });
 

 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
  <form method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="13" align="center" bordercolor="#FFFFFF"><b> 明细展示</b>
							</td>
						</tr>
				
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="70px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="130px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期一</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期二</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期三</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期四</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期五</p>
								</div></td>
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期六</p>
								</div></td>	
							<td  width="100px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>星期日</p>
								</div></td>
																	
						</tr>
							<c:forEach items="${listdetail}" var="wc" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="130px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wc.newnumber)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek1)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek2)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek3)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek4)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek5)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek6)}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:worktypetostring(wc.worktypeweek7)}</div></td>
							
								                                                                                                               
						
							</tr>
							</c:forEach>
							
		</table>
		</form>
  </body>
</html>
