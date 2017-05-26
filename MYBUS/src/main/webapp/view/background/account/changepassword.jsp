<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Account</title>
<%@ include file="/view/background/common/css.jsp" %>
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="changepasswordForm" name="changepasswordForm" >
                        <input type="hidden" name="id" id="id" value="${accountinfo.id }">
                        <div class="form-group">
                            <label>Original Password</label>
                            <input class="form-control" type="password" placeholder="" id="originalpassword" name="originalpassword" value="">
                        </div>
                       <div class="form-group">
                            <label> New Password</label>
                            <input type="password" class="form-control" placeholder="" id="password" name="password" onblur="checkPwd()" value="">
                        </div>
                           <div class="form-group">
                            <label>Password</label>
                           <input type="password" class="form-control" placeholder="" id="password2" name="password2" onblur="checkPwd2()" value="">
                        </div>
                         
                        <a type="submit" class="btn btn-success" id="reg">Submit</a>
                        <a type="reset" class="btn btn-default">Reset</a>
                    </form>
                </div>
                <!-- /.panel-body -->
            </div>
<jsp:include page="/view/background/common/scripts.jsp" />
<script>
	
	function judgePassword(pwd) {
		var regex = /^[a-zA-Z]\w{5,17}$/;	//以字母来头的字母数字下划线 长度为6-18
		if (pwd.length < 6 || !regex.test(pwd)) {
			return false;
		}
		return true;
	}
	
	function checkPwd(){
		var pwd=$("#password").val().trim();
		if(!judgePassword(pwd)){
			layer.tips('不能为空格,6到18个字符!', '#password',{
				tips: [1,'#F14164'],
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
	
		//提交前还没有进行验证  还需要添加 	
		$("#reg").bind("click",function(){
			checkPwd(); //验证密码 
			checkPwd2();
			$.post("${path }/luwei/accountinfo/changepassword",$("#changepasswordForm").serialize(),function(data) {
				if(data && data.result) {
					parent.layer.msg(data.message,{icon: 6,time: 3000});
				}else{
					parent.layer.msg(data.message,{icon: 5,time: 3000});
				}
 				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	            parent.layer.close(index);
 				window.parent.location.reload();
			});
		});

</script>
	  
</body>
</html>
</body>
</html>