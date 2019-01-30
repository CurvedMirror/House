<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		<h1>发布房屋信息</h1>
   		<form action="houseServlet?opr=insert" method="post">
   			标题:<input type="text" name="title"><br/>
   			房屋类型<select name="type_id">
  						<option value="-1">请选择</option>	
  						<c:forEach items="${types}" var="type">
  							<option value="${type.id }" <c:if test="${type_id==type.id}">selected</c:if>>${type.type_name}</option>
  						</c:forEach>
  					</select><br/>
   			房屋价格:<input type="text" name="price"><br/>
   			发布时间:<input type="text" name="fdate">yyyy-MM-dd<br/>
   			联系人:<input type="text" name="contact"><br/>
   			房屋描述:<input type="text" name="description"><br/>
   			<input type="submit" value="提交">
   			<input type="reset" value="重置">
   		</form>
   		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
   		<script type="text/javascript">
   			$(function(){
   				$("[name=fdate]").blur(function(){
   					var fdate = $(this).val();
   					var reg = /^\d{4}-\d{2}-\d{4}$/;
   					if(reg.test(fdate)==false){
   						alert("Error");
   					}
   				});
   			});
   		</script>
  </body>
</html>
