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
<script type="text/javascript" src="<%=path%>/js/userajax.js"></script>
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

//删除用户
 function del(id)
{
	var aa= window.confirm("请确认是否删除该用户");
	if (aa) {
		window.location = "<%=path%>/userdel.action?id="+id;
	}
}
function modify(id)
{
	//window.location = "<%=path%>/userlist.action";
	window.location = "<%=path%>/usermodify.action?id="+id;
}

function add()
{
	//window.location = "<%=path%>/userlist.action";
	window.location = "<%=path%>/showuseradd.action";
}



 </script>
 <link href="<%=path%>/css/table_back.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
  ${daohang}
   <form action="<%=path%>/userlistall.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" >
						<tr>
							<td
								style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="6" align="center" bordercolor="#FFFFFF"><b>员工信息管理</b>
							</td>
						</tr>
						<tr>
							<td colspan="6" height="10px">
								
								<div align="right">
				
				                                            
									<input type="button" value="增加员工" onclick="add()"/>
								
						       </div></td>	
						</tr>
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="40px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>新一代编号</p>
								</div></td>
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>姓名</p>
								</div></td>
							
						
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>班组</p>
								</div></td>
					      
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>角色</p>
								</div></td>
					
						
							<td  width="100px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>
															
						</tr>
							<c:forEach items="${list}" var="ui" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="40px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.newnumber}</div></td>		
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${ui.username}</div></td>
							
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:zunametostring(ui.zu)}</div></td>
								
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:roletostring(ui.authority)}</div></td>
								
							
								<td width="100px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										<input type="button" value="删除" onclick="del('${ui.id}')"/>
										<input type="button" value="修改" onclick="modify('${ui.id}')"/>
										<!-- <a href="<%=path%>/user.action?type=to_update&id=<s:property value="id"/>">修改</a> -->
											</div>
								</td>
							
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
						
							<td colspan="12">
						 		
							<div align="center">
								<a	href="<%=path%>/userlistall.action?currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/userlistall.action?currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
								</div></td>
							<td>
						
							</td>
						</tr>
		</table>
		</form>
  </body>
</html>
