<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
<%@ include file="/view/background/common/css.jsp" %>
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="addUserForm" name="addUserForm" >
                        <input type="hidden" name="accountId" id="accountId" value="${accountId }">
                        <input type="hidden" name="id" id="id" value="${user.id }">
                        <div class="form-group">
                            <label>userName</label>
                            <input class="form-control" placeholder="${user.name }" id="name" name="name" value="${user.name }">
                        </div>
                         <div class="form-group">
                            <label>Sex</label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex" value="1" checked="">男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="sex" value="0">女
                            </label>
                        </div>
                           <div class="form-group">
                            <label>CardType</label>
                            <select name="cardType" id="cardType" class="form-control">
                                <option value="1">身份证 </option>
								<option value="10">军官证</option>
								<option value="20">学生证</option>
                            </select>
                        </div>
                         <div class="form-group">
                            <label>IDcard</label>
                            <input class="form-control" placeholder="${user.IDcard }"  name="IDcard" id="IDcard" value="${user.IDcard }">
                        </div>
                         <div class="form-group">
                            <label>Age</label>
                            <input class="form-control" placeholder="${user.age }" name="age" id="age" value="${user.age }" >
                        </div>
                         <div class="form-group">
                            <label>Telphone</label>
                            <input class="form-control" placeholder="${user.telphone }" name="telphone" id="telphone" value="${user.telphone }">
                        </div>
                         <div class="form-group">
                            <label>Address</label>
                            <input class="form-control" placeholder="${user.address }" name="address" id="address" value="${user.address }" >
                        </div>
                       
                        <a type="submit" class="btn btn-success" id="reg">Submit</a>
                        <a type="reset" class="btn btn-default">Reset</a>
                    </form>
                </div>
                <!-- /.panel-body -->
            </div>
<jsp:include page="/view/background/common/scripts.jsp" />
<script>

		//提交前还没有进行验证  还需要添加 	
		$("#reg").bind("click",function(){
			$.post("${path }/luwei/accountuser/saveOrUpdateUser",$("#addUserForm").serialize(),function(data) {
				if(data && data.result) {
					parent.layer.msg(data.message,{icon: 6,time: 3000});
					//window.location.replace("${path}/luwei/account/userlist");
				}else{
					parent.layer.msg(data.message,{icon: 5,time: 3000});
				}
// 				parent.layer.closeAll();
 				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	            parent.layer.close(index);
 				window.parent.location.reload();
			});
		});

</script>
	  
</body>
</html>