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
<title>Register</title>
</head>
<body>
	<form id="registerform" name="registerform" method="post" action="${path }/luwei/account/register" >
		<center>
			<table name="registertable">
				<h1>Register</h1>
				<tr>
					账户名：<input type="text" name="name" id="name" onblur="checkName()" /><span id="namespan" ></span>
				</tr><br>
				<tr>
					密码：<input type="password" name="password" id="password" onblur="checkPwd()" /><span id="pwdspan"></span>
				</tr><br>
				<tr>
					确认密码：<input type="password" name="password2" id="password2" onblur="checkPwd2()" /><span id="pwd2span"></span>
				</tr><br>
				<tr>
					<input type="reset" value="重置" />
					<input type="button" id="reg" value="提交" />
				</tr>
				<br><hr/>
				<tr>
					<a href="${path }/view/login.jsp">去登陆</a>
				</tr>
			</table>
		</center>
	</form>
	
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
				$("#namespan").text("用户名不能为空！");
				return;
			}else if(name.length<4 || name.length>12){
				$("#namespan").text("长度不能小于4！");
				return;
			}
			$("#namespan").text("");
			
			
			$.ajax(
		    		{
		    			 type:"POST",
		    		     url:"${path }/luwei/account/register/checkname",
		    		     data: {name:name},
		    	         success:function(res){
		    	        	 if(res!=null && res=="true"){
		    	        		alert("账户名被占用"); 
		    	        	 }else{
		    	        	 	alert("ok");
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
				$("#pwdspan").text("以字母开头的6-18位");
				return;
			}
			$("#pwdspan").text("");
		}
		function checkPwd2(){
			var pwd=$("#password").val();
			var pwd2=$("#password2").val();
			if(judgePassword(pwd) && pwd!=pwd2){
				$("#pwd2span").text("请确认密码！");
				return;
			}
			$("#pwd2span").text("");
		}
		
		$("#reg").bind("click",function(){
			
			var regex = /^[a-zA-Z]\w{5,17}$/;
			var name = $("#name").val();
			
			
			checkPwd(); //验证密码
			checkPwd2();
			$.post("${path }/luwei/account/register",$("#registerform").serialize(),function(data) {
				if(data!=null){
					alert(data);
				}
// 				if (data && data.result) {
// 					alert("恭喜你，注册成功！");
// 					//window.location.replace("${path}/arwen/userinfo/register/result");
// 				}else if (data){
// 					alert(data.message);
// 				}
			});
		});
	</script>
	
</body>
</html>