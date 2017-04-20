<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>

<html>	
<head>
<title>Register</title>
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
 <h1>Sign Up Form</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<!--<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>-->
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img src="${path}/images/avtar.png" />
	</div>
			<form id="registerform" name="registerform" method="post" action="${path }/luwei/account/logon/register" >
					<input type="text" id="name" name="name" class="text" value="Username" onfocus="this.value = '';" onblur="checkName()" ><br>
					<span id="namespan"></span>
					<input type="password" id="password" name="password" value="Password" onfocus="this.value = '';" onblur="checkPwd()" ><br>
					<span id="pwdspan"></span>
					<input type="password" id="password2" name="password2" value="Password" onfocus="this.value = '';" onblur="checkPwd2()"><br>
					<span id="pwd2span"></span>
					<br><br>
			</form>
	<div class="signin">
		<input type="submit" id="reg" value="Sign Up" >
	</div>
</div>
   <div class="copy-rights">
 
 		<p><a href="${path }/view/login/login.jsp">go Login</a></p>	
		<p>Copyright &copy; 2017.Company name All rights reserved.</p>
   </div>

<script>
	
		function judgePassword(pwd) {
			var regex = /^[a-zA-Z]\w{5,17}$/;	//以字母来头的字母数字下划线 长度为6-18
			if (pwd.length < 6 || !regex.test(pwd)) {
				return false;
			}
			return true;
		}
		
		function checkName(){
			var name=$("#name").val();
			//if(!name) return;
			if(!name){
				//alert("name==null");
				layer.tips('name不能为空!', '#name',{
					tips: [2,'#F14164'],
					time: 5000
				});
				return;
			}else if(name.length<4 || name.length>12){
				layer.tips('name长度不能小于 4!', '#name',{
					tips: [2,'#F14164'],
					time: 5000
				});
				return;
			}
			//$("#namespan").text("");
			$.ajax(
		    		{
		    			 type:"POST",
		    		     url:"${path }/luwei/account/logon/register/checkname",
		    		     data: {name:name},
		    	         success:function(res){
		    	        	 if(res && res.result){
		    	        		 layer.msg(res.message);
// 		    	        		 alert(res.message); 
		    	        	 }else{
		    	        		 layer.msg(res.message);
		    	        	 	//alert(res.message);
		    	        	 }
			    		},
			    		error:function(err,err1,err2){
			    		    //debugger;
			            }
		    		});
		}
	
		function checkPwd(){
			var pwd=$("#password").val();
			if(!judgePassword(pwd)){
				layer.tips('6到18个字符!', '#password',{
					tips: [2,'#F14164'],
					time: 5000
				});
				//$("#pwdspan").text("以字母开头的6-18位");
				return;
			}
			//$("#pwdspan").text("");
		}
		function checkPwd2(){
			var pwd=$("#password").val();
			var pwd2=$("#password2").val();
			if(judgePassword(pwd) && pwd!=pwd2){
				 layer.msg('两次密码不一致！');
				//$("#pwd2span").text("请确认密码！");
				return;
			}
			//$("#pwd2span").text("");
		}
		
		$("#reg").bind("click",function(){
			
			var regex = /^[a-zA-Z]\w{5,17}$/;
			var name = $("#name").val();
			
			checkName();
			checkPwd(); //验证密码
			checkPwd2();
		
			$.post("${path }/luwei/account/logon/register",$("#registerform").serialize(),function(data) {
// 				if(data!=null){
// 					alert(data);
// 				}
				if (data && data.result) {
					//alert("恭喜你，注册成功！");
					layer.msg(data.message,{icon: 6});
					//window.location.replace("${path}/arwen/userinfo/register/result");
				}else if (data){
					alert(data.message,{icon: 5});
				}
			});
		});
	</script>
	
</body>
</html>