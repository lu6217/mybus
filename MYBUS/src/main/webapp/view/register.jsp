<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form id="registerform" name="registerform" method="post" action="${path }/luwei/account/register" >
		<center>
			<table name="registertable">
				<h1>Register</h1>
				<tr>
					账户名：<input type="text" name="name" id="name" />
				</tr><br>
				<tr>
					密码：<input type="password" name="password" id="password" />
				</tr><br>
				<tr>
					确认密码：<input type="password" name="password2" id="password2" />
				</tr><br>
				<tr>
					<input type="reset" value="重置" />
					<input type="submit" value="提交" />
				</tr>
				<br><hr/>
				<tr>
					<a href="${path }/view/login.jsp">去登陆</a>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>