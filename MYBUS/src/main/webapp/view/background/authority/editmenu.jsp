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
                        <input type="hidden" id="id" name="id" value="${menu.id }" >
                        <div class="form-group">
                            <input class="form-control" placeholder="名称" id="name" name="name" value="${menu.name }" onblur="checkName()">
                        </div>
                        
                        <div class="form-group">
                            <input class="form-control" placeholder="链接" id="url" name="url" value="${menu.url }" onblur="checkName()">
                        </div>
                        <div class="form-group">
							<input type="text" name="icon" placeholder="图标" value="${menu.icon }" class="icon-picker" />
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
	
	$("#reg").bind("click",function(){
		
		$.post("${path }/luwei/authority/editmenu",$("#createmenu").serialize(),function(data) {
			
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