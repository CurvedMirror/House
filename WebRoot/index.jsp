<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  		<div id= "aa" align="center"  >
  		<form action="houseServlet" method="get">
  			<input type="hidden" value="select" name="opr">
  			标题<input type="text" name="title" value="${title }">
  			房屋类型<select name="type_id">
  						<option value="-1">请选择</option>
  						<c:forEach items="${types}" var="type">
  							<option value="${type.id }" <c:if test="${type_id==type.id}">selected</c:if>>${type.type_name}</option>
  						</c:forEach>
  					</select>
  			价格高于<input type="text" name="priceMax" value="${ priceMax}">
  			价格低于<input type="text" name="priceMin" value="${priceMin }">
  			<input type="submit" value="查询"> 
  		</form>
    	<c:if test="${houseList==null }">
    		<c:redirect url="houseServlet?opr=select"/>
    	</c:if>
    	
    	<table border="1px">
    		<tr>
    			<th>编号</th>
    			<th>标题</th>
    			<th>房屋类型</th>
    			<th>租金</th>
    			<th>联系人</th>
    			<th>发布时间</th>
    		</tr>
    		<c:forEach items="${houseList }" var="house">
    			<tr>
    				<td>${house.id }</td>
    				<td>${house.title }</td>
    				<td>${house.type.type_name}</td>
    				<td>${house.price }</td>
    				<td>${house.contact }</td>
    				<td>${house.fdate }</td>
    			</tr>
    		</c:forEach>
    	</table>
    	<a href="add.jsp">新增</a>
    	<select  style="text-align: right; margin-left: 980px" id = "pager"  >
    		<c:forEach begin="1" end="${pager.pageCount }" var="i">
    			<option>${i}</option>
    		</c:forEach>
    	</select> 
    	</div>
    	
    	
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#pager").change(function(){
    			var currentPage = this.value;
    			var title = $("[name=title]").val();
    			var type_id = $("[name=type_id]").val();
    			var priceMax = $("[name=priceMax]").val();
    			var priceMin = $("[name=priceMin]").val();
    			
    			location.href='houseServlet?opr=select&currentPage='+currentPage
    			+'&title'+title+'&type_id'+type_id+'&priceMax='+priceMax+'&priceMin'+priceMin;
    		});
    	});
    	
    </script>
    
  </body>
</html>
