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
                    <form role="form" id="editAccountForm" name="editAccountForm" >
                        <input type="hidden" name="id" id="id" value="${accountinfo.id }">
                        <div class="form-group">
                            <label>Account Name</label>
                            <input class="form-control" placeholder="${accountinfo.name }" id="name" name="name" value="${accountinfo.name }">
                        </div>
                       <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" placeholder="${accountinfo.password }" id="password" name="password" value="${accountinfo.password }">
                        </div>
                           <div class="form-group">
                            <label>Type</label>
                            <select name="type" id="type" class="form-control">
                            	
                                <option value="1" <c:if test="${accountinfo.type==1 }">selected</c:if>>超级管理员</option>
								<option value="10" <c:if test="${accountinfo.type==10 }">selected</c:if>>普通用户</option>
								<option value="20" <c:if test="${accountinfo.type==20 }">selected</c:if>>后台管理员</option>
                            </select>
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
			$.post("${path }/luwei/account/updateAccount",$("#editAccountForm").serialize(),function(data) {
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