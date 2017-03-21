<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script src="${path}/js/jquery-2.1.1.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Site</title>
</head>
<body>
	
	<form id="createsite" name="createsite" method="post" action="${path }/luwei/site/create">
		<center>
			<table>
				站点名:<input type="text" id="name" name="name" onblur="checkName()" /><br>
				<span id="namespan"></span><br>
				站点描述:<input type="text" name="description" id="description" /><br>
				<input type="submit" id="create" value="提交" />
				
			</table>
		</center>
	</form>

	<script type="text/javascript">
	function checkName(){
		var name=$("#name").val();
		if(!name){
			//alert("name==null");
			$("#namespan").text("用户名不能为空！");
			return;
		}
		$("#namespan").text("");
		$.ajax(
	    		{
	    			 type:"POST",
	    		     url:"${path }/luwei/site/create/checkname",
	    		     data: {name:name},
	    	         success:function(res){
	    	        	 if(res!=null && res=="true"){
	    	        		alert("站点已存在"); 
	    	        	 }else{
	    	        	 	alert("ok");
	    	        	 }
		    		},
		    		error:function(err,err1,err2){
		    		    //debugger;
		            }
	    		});
	}
	</script>
</body>
</html>