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
<title>Add Information</title>
<%@ include file="/view/background/common/css.jsp" %>
</head>
<body>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="addinformation" name="addinformation">
                    <input type="hidden" name="id" id="id" value="${information.id }">
                        <div class="form-group">
                            <label>Title</label>
                            <input class="form-control" placeholder="" id="title" name="title" value="${information.title }">
                        </div>
                          <div class="form-group">
                            <label>Details</label>
                            <input class="form-control" placeholder=""  name="details" id="details" value="${information.details }">
                        </div>
                         <div class="form-group">
                            <label>Information Type</label>
                            <select name="type" id="type" class="form-control">
                            <c:choose>
								<c:when test="${information.type==10 }">
                              	  	<option value="10" selected = "selected">新闻动态 </option>
									<option value="20">常见问题</option>
									<option value="30">铁路常识</option>
								</c:when>
								<c:when test="${information.type==20 }">
									<option value="10">新闻动态 </option>
									<option value="20" selected = "selected">常见问题</option>
									<option value="30">铁路常识</option>
								</c:when>
                                <c:when test="${information.type==30 }">
                                   	<option value="10">新闻动态 </option>
									<option value="20">常见问题</option>
									<option value="30" selected = "selected">铁路常识</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="10">新闻动态 </option>
									<option value="20">常见问题</option>
									<option value="30">铁路常识</option>
                               	</c:otherwise>
							</c:choose>	
                            </select>
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
// 	function checkName(){
// 		var name=$("#title").val();
// 		if(!name){
// 			//alert("name==null");
// 			layer.tips('Name not null!','#title',{
// 				tips:[2,'#F14164'],
// 				time:5000
// 			});
// 			//layer.msg('Name not null!');
// 			//$("#namespan").text("name not null！");
// 			return;
// 		}
// 		//$("#namespan").text("");
// 		$.ajax(
// 	    		{
// 	    			 type:"POST",
// 	    		     url:"${path }/luwei/information/create/checkname",
// 	    		     data: {name:name},
// 	    	         success:function(res){
// 	    	        	 if(res && res.result){
// 	    	        		layer.msg(res.message);
// 	    	        		//alert(res.message); 
// 	    	        	 }else{
// 	    	        		 layer.msg(res.message);
// 	    	        	 	//alert(res.message);
// 	    	        	 }
// 		    		},
// 		    		error:function(err,err1,err2){
// 		    		    //debugger;
// 		            }
// 	    		});
// 	}
	
	$("#reg").bind("click",function(){
		
		$.post("${path }/luwei/information/addinformation",$("#addinformation").serialize(),function(data) {
			
			if(data && data.result) {
				//alert("恭喜你，创建成功！");
				layer.msg(data.message,{icon: 1});
				//window.location.replace("${path}/arwen/userinfo/register/result");
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