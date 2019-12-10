<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
 
$("tr").css({"background-color":"#F0F8FF","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
	 brbrbr();
});
 </script>
 
 
 <script type="text/javascript">
 	function brbrbr()
 	{
 		//var reg1=new RegExp("；","g"); 
 		 var reg2=new RegExp("。","g");  
 		 $('td').each(function()//遍历文章；
 	             {
 	                var html = $(this).html();
 	                var newHtml1 = html.replace(reg2, '。<br/>');//回车符
 	                $(this).html(newHtml1);//更新文章；
 	     });
 	 }  
 
</script>  
 
  </head>
  
  <body>
    <form action="seasonquery_person.action" method="post">
    <br><br>
    	  <p align="center" style="padding:0px;margin:0px; font-size: 28px;"><strong>研发支持二处员工分布一览表</strong></p><br>
        
        <table id="pdp" style="font-size:18px;width:800px" border="1" align="center" cellpadding="1" cellspacing="0">
           <tr height="20px">
    			<td class="b" colspan="2" style="font-size:24px;"> 
    				时间：${date} 
    			</td>
    		</tr>	
    	
    		<tr height="20px">
    			<td class="b" colspan="2" style="font-size:24px;"> 
    				一、成都分中心员工
    			</td>
    		</tr>	
    
    		<tr>
    			<td class="b" style="font-size:24px;"> 
    				人数：${numtype1}
    			</td>
    			 
    			<td class="cb" style="font-size:24px;"> 
    				<a href="<%=path%>/showglobaldetail.action?worktype=1">查看详情</a> 
    			</td>
    		     
    		</tr>
    	
    		<tr height="20px">
    			<td class="b" colspan="2" style="font-size:24px;">
    				二、成都事业群员工
    			</td>
    		</tr>	
    
    		<tr>
    			<td class="b" style="font-size:24px;"> 
    				人数：${numtype2}
    			</td>
    			<td class="cb" style="font-size:24px;"> 
    				<a href="<%=path%>/showglobaldetail.action?worktype=2">查看详情</a> 
    			</td>
    		
    		</tr>
   
    		<tr height="20px">
    			<td class="b" colspan="2" style="font-size:24px;">
    				三、北京出差员工
    			</td>
    		</tr>	
    		
    		<tr>
    			<td class="b" style="font-size:24px;"> 
    				人数：${numtype3}
    			</td>
    			<td class="cb" style="font-size:24px;"> 
    				<a href="<%=path%>/showglobaldetail.action?worktype=3">查看详情</a> 
    			</td>
    			
    		</tr>
    		
    		<tr height="20px">
    			<td class="b"  colspan="2"  style="font-size:24px;">
    				四、武汉出差员工
    			</td>
    		</tr>	
    	
    		<tr>
    			<td class="b" style="font-size:24px;"> 
    				人数：${numtype4}
    			</td>
    			<td class="cb" style="font-size:24px;"> 
    				<a href="<%=path%>/showglobaldetail.action?worktype=4">查看详情</a> 
    			</td>
    		
    		</tr>
    		
    		<tr height="20px">
    			<td class="b" colspan="2" style="font-size:24px;">
    				五、请休假员工
    			</td>
    		</tr>	
    		<tr>
    			<td class="b" style="font-size:24px;"> 
    				人数：${numtype5}
    			</td>
    			<td class="cb" style="font-size:24px;"> 
    				<a href="<%=path%>/showglobaldetail.action?worktype=5">查看详情</a> 
    			</td>
    		
    		</tr>
    		<tr height="20px">
    			<td class="b" colspan="2" style="font-size:24px;">
    				六、其他地点出差员工
    			</td>
    		</tr>	
    		<tr>
    			<td class="b" style="font-size:24px;"> 
    				人数：${numtype6}
    			</td>
    			<td class="cb" style="font-size:24px;"> 
    				<a href="<%=path%>/showglobaldetail.action?worktype=6">查看详情</a> 
    			</td>
    		</tr>
    		
    		
    	
    	</table>
    </form>
  </body>
</html>
