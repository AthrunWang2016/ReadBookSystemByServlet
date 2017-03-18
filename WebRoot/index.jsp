<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
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
		<form action="user/login" method="post">
			<TABLE width=255 border="0" align="center">
				<tr>
					<td width="72" align="right">
						账号：
					</td>
					<td align="center">
						<input type="text" name="userID" size=15.0>
					</td>
				</tr>
				<tr>
					<td width="72" align="right">
						密码：
					</td>
					<td align="center">
						<input type="password" name="password" size=15.0>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="submit" value="登录">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<a href="#" class="a2" target="_top">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" class="a2">找回密码</a>
					</td>
				</tr>
			</TABLE>
		</form>
	</body>
</html>
