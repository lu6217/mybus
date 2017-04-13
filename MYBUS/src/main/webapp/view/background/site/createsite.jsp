<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script src="${path}/js/jquery-2.1.1.min.js"></script>
<script src="${path}/js/layer/layer.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Site</title>
</head>
<body>
	
	<form id="createsite" name="createsite" method="post" >
		<center>
			<table>
				站点名:<input type="text" id="name" name="name" onblur="checkName()" /><br>
				<span id="namespan"></span><br>
				站点描述:<input type="text" name="description" id="description" /><br>
				<input type="button" id="reg" value="提交" />
				
			</table>
		</center>
	</form>

	<script type="text/javascript">
	function checkName(){
		var name=$("#name").val();
		if(!name){
			//alert("name==null");
			layer.tips('Name not null!','#name',{
				tips:[2,'#F14164'],
				time:5000
			});
			//layer.msg('Name not null!');
			//$("#namespan").text("name not null！");
			return;
		}
		//$("#namespan").text("");
		$.ajax(
	    		{
	    			 type:"POST",
	    		     url:"${path }/luwei/site/create/checkname",
	    		     data: {name:name},
	    	         success:function(res){
	    	        	 if(res && res.result){
	    	        		layer.msg(res.message);
	    	        		//alert(res.message); 
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
	
	$("#reg").bind("click",function(){
		
		$.post("${path }/luwei/site/create",$("#createsite").serialize(),function(data) {
			
			if(data && data.result) {
				//alert("恭喜你，创建成功！");
				layer.msg(data.message,{icon: 1});
				//window.location.replace("${path}/arwen/userinfo/register/result");
			}else{
				layer.msg(data.message,{icon: 5});
			}
		});
	});
	</script>
</body>
</html>