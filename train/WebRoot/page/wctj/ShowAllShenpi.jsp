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
  <form action="<%=path%>/viewall.action" method="post" name="fm1">
					<table height="80" align="center" cellpadding="0"
						cellspacing="2" border: 0px;">
						<tr>
							<td
								style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
								colspan="13" align="center" bordercolor="#FFFFFF"><b> 全部审批 </b>
							</td>
						</tr>
				
						<tr height="50px" class="表格表头背景1" id="hang">
							<td  width="50px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>序号</p>
								</div></td>
							<td  width="140px" align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>编号</p>
								</div></td>
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起日期</p>
								</div></td>	
							<td  width="70px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>发起人</p>
								</div></td>
							
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>员工</p>
								</div></td>	

							<td  width="120px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>状态</p>
								</div></td>	
							<td  width="150px"  align="center" valign="middle" nowrap
								bordercolor=none><div align="center">
									<p>操作</p>
								</div></td>														
						</tr>
							<c:forEach items="${list}" var="wm" varStatus="status">
							<tr class="btbj" id="hang" style="height:20px">
								
								<td  width="50px" height="25" align="center" valign="middle" nowrap><div
										align="center">${status.index+1+(currentPage-1)*pageSize}</div></td>
								<td width="140px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wm.number}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${wm.date}</div></td>
								<td width="70px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wm.initiator)}</div></td>
								
								<td width="150px" height="25" align="center" valign="middle" nowrap><div
										align="center">${fb:newnumbertoname(wm.applicant)}</div></td>		
							
								<td width="120px" height="25" align="center" valign="middle" nowrap><div
										align="center">
										${fb:datatostring(wm.status)}
										</div></td>		
								<td width="152px" height="25" align="center" valign="middle" nowrap><div
										align="center">
									<a href="<%=path%>/showmodifydetail.action?number=${wm.number}&newnumber=${newnumber}">查看详情</a> 
								    <c:if test="${wm.status!=4&&wm.status!=6&&authoE=='E'}">
								    <a href="<%=path%>/deletemodifypage.action?number=${wm.number}&newnumber=${newnumber}">撤销</a> 
									</c:if>
									</div>
									</td>	
							</tr>
							</c:forEach>
							<tr class="表格表头背景">
							<td colspan="13">
								<div align="center">
								<a	href="<%=path%>/showallshenpi.action?currentPage=${previousPage}"
							style="padding-right: 30px;color: #104E8B">上一页</a> 
									${currentPage} of ${totalPages}
								<a	href="<%=path%>/showallshenpi.action?currentPage=${nextPage}"
							style="padding-right: 30px;color: #104E8B">下一页</a> 	
									共有 ${totalRows} 条记录
									&nbsp;&nbsp;&nbsp;
								第<input style="width:30px" type="text" name="currentPage"/>页
								<input type="hidden" name="newnumber" value="${newnumber}"/>
								<input type="submit" value="跳转"/>	
								</div>
								<br/>
								</td>
						</tr>
		</table>
		</form>
  </body>
</html>
