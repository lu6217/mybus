<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/js/jquery-2.1.1.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
</head>
<body>

	<form id="loginform" name="loginform" method="post" action="${path }/luwei/account/login">
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
					<input type="button" id="loginbtn" value="登录" /><br>
<!-- 					<input type="submit" value="登录" /><br> -->
				</tr>
				<hr/>
				<a href="${path }/view/register.jsp">暂未账号，去注册</a>
			</table>
		</center>
	</form>

<script type="text/javascript">

	$("#loginbtn").bind("click",function(){
	
		$.post("${path }/luwei/account/login",$("#loginform").serialize(),function(data) {
			if(data!=null){
				alert(data);
				if(data=="success!"){
					window.location.replace("${path}/luwei/account/login/result");
				}
			}
//				if (data && data.result) {
//					alert("恭喜你，注册成功！");
//					//window.location.replace("${path}/arwen/userinfo/register/result");
//				}else if (data){
//					alert(data.message);
//				}
		});
	});

</script>

</body>
</html>