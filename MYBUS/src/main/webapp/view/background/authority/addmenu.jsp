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
<title>Add Menu</title>
 <link href="${path}/bootstrap/css/bootstrap.min.css" media="all" rel="stylesheet" type="text/css" />
  <link href="${path}/bootstrap/css/icon-picker.min.css" media="all" rel="stylesheet" type="text/css" />
  
<%@ include file="/view/background/common/css.jsp" %>
<style type="text/css">
        #wraper{position:absolute;width:400px; left:50%;margin-left: -200px;top:100px;}
        input{padding-bottom: 30px;}
    </style>
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="createmenu" name="createmenu">
                        <div class="form-group">
<!--                             <label>Role Name</label> -->
                            <input class="form-control" placeholder="名称" id="name" name="name" value="" onblur="checkName()">
                        </div>
                        
                        <div class="form-group">
<!--                             <label>链接</label> -->
                            <input class="form-control" placeholder="链接" id="url" name="url" value="" onblur="checkName()">
                        </div>
                        <div class="form-group">
<!--                             <label>图标</label> -->
							<input type="text" name="icon" placeholder="图标" class="icon-picker" />
<!--                             <input class="icon-picker" placeholder="图标" id="iconCls" name="iconCls" value="" onblur="checkName()"> -->
<!--                              <span class="input-group-addon"><i class="fa fa-calendar"></i></span> -->
                        </div>
                        <div class="form-group">
                   				<select class="form-control" name="upperLevelMenuId">
                   					<option value="0">-- 根目录 --</option>
                   					<c:if test="${not empty menus}">
                   						<c:forEach varStatus="vs" var="menu" items="${menus}">
                   							<option value="${menu.id}">${menu.name }</option>
                   						</c:forEach>
		                   			</c:if>
                   				</select>		
	                     			
<!--                             <input class="form-control" placeholder="上级菜单" id="upperLevelMenu" name="upperLevelMenu" value="" onblur="checkName()"> -->
                        </div>
                         <div class="form-group">
<!--                             <label>层次</label> -->
                            <input class="form-control" placeholder="item" id="item" name="item" value="" onblur="checkName()">
                        </div>
                        <div class="form-group">
<!--                             <label>层次</label> -->
                            <input class="form-control" placeholder="层次" id="level" name="level" value="" onblur="checkName()">
                        </div>
                          <div class="form-group">
<!--                             <label>是否为叶子节点</label> -->
							<select name="leaf" id="leaf" class="form-control">
                                <option value="1">是叶子节点 </option>
								<option value="0">不是叶子节点</option>
                            </select>
<!--                             <input class="form-control" placeholder="是否为叶子节点"  name="leaf" id="leaf" value="" onblur="checkSite(this)"> -->
                        </div>
                         
						<!-- 下面这个按钮用button是提交就无法关闭弹出框   用a标签的时候就可以关闭  -->
                        <a type="submit" class="btn btn-success" id="reg">Submit</a>
                        <a type="reset" class="btn btn-default">Reset</a>
                    </form>
                </div>
                <!-- /.panel-body -->
            </div>
	<jsp:include page="/view/background/common/scripts.jsp" />
<script src="${path}/bootstrap/js/iconPicker.min.js"></script>
<script type="text/javascript">

$(function () {
    $(".icon-picker").iconPicker();
});
// 	function checkName(){
// 		var name=$("#name").val();
// 		if(!name){
// 			layer.tips('Name not null!','#name',{
// 				tips:[2,'#F14164'],
// 				time:5000
// 			});
// 			return;
// 		}
// 		$.ajax(
// 	    		{
// 	    			 type:"POST",
// 	    		     url:"${path }/luwei/authority/checkmenuname",
// 	    		     data: {name:name},
// 	    	         success:function(res){
// 	    	        	 if(res && res.result){
// 	    	        		layer.msg(res.message);
// 	    	        	 }else{
// 	    	        		 layer.msg(res.message);
// 	    	        	 }
// 		    		},
// 		    		error:function(err,err1,err2){
// 		            }
// 	    		});
// 	}
	
	$("#reg").bind("click",function(){
		
		$.post("${path }/luwei/authority/addmenu",$("#createmenu").serialize(),function(data) {
			
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