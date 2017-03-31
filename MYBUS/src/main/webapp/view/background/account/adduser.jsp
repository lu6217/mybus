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
                    <form role="form" id="addUserForm" name="addUserForm" method="post" action="${path }/luwei/account/adduser">
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
                        <button type="submit" class="btn btn-success" id="reg">Submit</button>
                        <button type="reset" class="btn btn-default">Reset</button>
                    </form>
                </div>
                <!-- /.panel-body -->
            </div>
<jsp:include page="/view/background/common/scripts.jsp" />
<script>
		$("#reg").bind("click",function(){
			layer.msg("kk");
			$.post("${path }/luwei/account/adduser",$("#addUserForm").serialize(),function(data) {
				if (data && data.result) {
// 					layer弹窗有点问题  
					layer.msg(data.message);
// 					window.location.replace("${path}/luwei/account/userlist");
				}else if (data){
					layer.msg(data.message);
				}
			});
		});

</script>
	  
</body>
</html>