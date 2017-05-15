<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Role</title>
<%@ include file="/view/background/common/css.jsp" %>
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="createrole" name="createrole">
                        <div class="form-group">
                            <label>Role Name</label>
                            <input class="form-control" placeholder="" id="name" name="name" value="" onblur="checkName()">
                        </div>
                          <div class="form-group">
                            <label>Description</label>
                            <input class="form-control" placeholder=""  name="description" id="description" value="" onblur="checkSite(this)">
                        </div>
                         
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
		
		$.post("${path }/luwei/authority/addrole",$("#createrole").serialize(),function(data) {
			
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