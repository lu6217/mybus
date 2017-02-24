<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form id="login" name="login" method="post" action="">
		<center>
			<table name="logintb">
				<h1>Login</h1>
				<tr>
					账号：<input type="text" id="name" name="name" /><br>
				</tr>
				<tr>
					密码：<input type="password" id="password" name="password" /><br>
				</tr>
				<tr>
					<input type="reset" value="取消" />
					<input type="submit" value="登录" /><br>
				</tr>
				<hr/>
				<a href="${path }/view/register.jsp">暂未账号，去注册</a>
			</table>
		</center>
	</form>

</body>
</html>