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
<title>Assignment Menu</title>
<%@ include file="/view/background/common/css.jsp" %>
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="role_menutable" name="role_menutable">
                    <input type="hidden" id="roleId" name="roleId" value="${role.id }">
                        <div class="form-group">
                            <label>Role Name</label>
<!--                             若input设置disabled="" 则在submit是不会被提交 -->
                            <input class="form-control" placeholder="" id="roleName" name="roleName" value="${role.name }" onblur="checkName()" disabled="">
                        </div>
                        <div class="form-group">
                            <label>Menu</label>
<!--                             <input class="form-control" placeholder=""  name="description" id="description" value="" onblur="checkSite(this)"> -->
                        </div>
                        <div class="form-group">
                           <i class="fa fa-user fa-fw"></i>
	                         <c:forEach varStatus="vs" var="menu" items="${menus }">
	                           <label class="checkbox-inline">
                                    <input type="checkbox" name="menulists" value="${menu.id }">${menu.name }
                                </label>
	                           </c:forEach>
                         </div>
                            
<!--                           <div class="form-group"> -->
<!--                             <label>Description</label> -->
<!--                             <input class="form-control" placeholder=""  name="description" id="description" value="" onblur="checkSite(this)"> -->
<!--                         </div> -->
                         
						<!-- 下面这个按钮用button是提交就无法关闭弹出框   用a标签的时候就可以关闭  -->
                        <a type="submit" class="btn btn-success" id="reg">Submit</a>
                        <a type="reset" class="btn btn-default">Reset</a>
                    </form>
                </div>
                <!-- /.panel-body -->
            </div>
	<jsp:include page="/view/background/common/scripts.jsp" />

<script type="text/javascript">
	function checkName(){
		var name=$("#name").val();
		if(!name){
			layer.tips('Name not null!','#name',{
				tips:[2,'#F14164'],
				time:5000
			});
			return;
		}
		$.ajax(
	    		{
	    			 type:"POST",
	    		     url:"${path }/luwei/authority/checkrolename",
	    		     data: {name:name},
	    	         success:function(res){
	    	        	 if(res && res.result){
	    	        		layer.msg(res.message);
	    	        	 }else{
	    	        		 layer.msg(res.message);
	    	        	 }
		    		},
		    		error:function(err,err1,err2){
		            }
	    		});
	}
	
	$("#reg").bind("click",function(){
		
		$.post("${path }/luwei/authority/addrolemenu",$("#role_menutable").serialize(),function(data) {
			
			if(data && data.result) {
				layer.msg(data.message,{icon: 1});
			}else{
				layer.msg(data.message,{icon: 5});
			}
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
			window.parent.location.reload();
		});
	});
	</script>
</body>
</html>