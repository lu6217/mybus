<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>

<html>	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="${path}/css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<script src="${path}/js/jquery-2.1.1.min.js"></script>
<script src="${path}/js/layer/layer.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
 <!--SIGN UP-->
 <h1>Login Form</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="${path}/images/avtar.png" />
	</div>
			<form id="loginform" name="loginform" method="post" action="${path }/luwei/account/logon/login">
					<input type="text" id="name" name="name" class="text" value=" " onfocus="this.value = '';" onblur="checkName()" >
						<div class="key">
					<input type="password" id="password" name="password" value=" " onfocus="this.value = '';" onblur="checkPwd()">
						</div><br><br>
			</form>
	<div class="signin">
		<input type="submit" id="loginbtn" value="Login" >
	</div>
</div>
   <div class="copy-rights">
 		<p><a href="${path }/luwei/account/logon/toregister" >new user Register</a></p>
		<p>Copyright &copy; 2017.Company name All rights reserved.</p>
   </div>
<script type="text/javascript">

	function checkName(){
		var name=$("#name").val();
		if(!name){
			layer.tips('Name Not Null!', '#name',{
				tips: [2,'#F14164'],
				time: 5000
			});
			return;
		}
	}
	
	function checkPwd(){
		var pwd=$("#password").val();
		if(!pwd){
			layer.tips('Password Not Null', '#password',{
				tips: [2,'#F14164'],
				time: 5000
			});
			//$("#pwdspan").text("以字母开头的6-18位");
			return;
		}
		//$("#pwdspan").text("");
	}
	

	$("#loginbtn").bind("click",function(){
	
		checkName();
		checkPwd();
		$.post("${path }/luwei/account/logon/login",$("#loginform").serialize(),function(data) {
			
			if (data && data.result) {
				layer.msg(data.message,{icon: 6});
				window.location.replace("${path}/luwei/front/home/index");
			}else if (data){
				layer.msg(data.message,{icon: 5});
			}
			
		});
	});

</script>


</body>
</html>