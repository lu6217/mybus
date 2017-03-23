<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create train</title>
<script src="${path}/js/jquery-2.1.1.min.js"></script>
<script src="${path}/js/laydate/laydate.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap-clockpicker.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.min.css">
</head>
<body>

<form id="createtrainform" name="reatetrainform" method="post" >
		<center>
			<table>
				<h1>Create Train</h1>
				<tr>
					车次：<input type="text" name="number" id="number" onblur="checkName()" /><span id="namespan" ></span>
				</tr><br>
				<tr>
					始发站：<input type="text" name="beginSite" id="beginSite" onblur="" /><span id="pwdspan"></span>
				</tr><br>
				<tr>
					目的地：<input type="text" name="endSite" id="endSite" onblur="" /><span ></span>
				</tr><br>
				<tr>
					全票价：<input type="text" name="price" id="price" onblur="" /><span ></span>
				</tr><br>
				<tr>
					座位数：<input type="text" name="num" id="num" onblur="" /><span ></span>
				</tr><br>
				<tr>
					发车时间：<div class="input-group clockpicker" style="width: 110px;margin-bottom: 10px;">
							    <input type="text" id="StartTime" name="StartTime" class="form-control" value="08:00">
							    <span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							    </span>
							</div>
				</tr><br>
				<tr>
					<input type="button" id="create" value="提交" />
				</tr>
				<br>
			</table>
		</center>
	</form>
	<script type="text/javascript" src="${path}/js/laydate/date/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/laydate/date/bootstrap-clockpicker.min.js"></script>
	<script src="${path}/js/jquery-ui.min.js"></script>
	<script src="${path}/js/jquery-ui.custom.min.js"></script>
	<script src="${path}/js/layer/layer.js"></script>
	<script type="text/javascript">
		
		$('.clockpicker').clockpicker();
		
		function checkName(){
			var name=$("#number").val();
			if(!name){
				//alert("name==null");
				layer.tips('Name not null!','#number',{
					tips:[2,'#F14164'],
					time:5000
				});
				return;
			}
			$.ajax(
		    		{
		    			 type:"POST",
		    		     url:"${path }/luwei/train/create/checkname",
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
		
		$("#create").bind("click",function(){
			$.post("${path }/luwei/train/create",$("#createtrainform").serialize(),function(data) {
				if(data && data.result) {
					layer.msg(data.message,{icon: 6});
					//window.location.replace("${path}/arwen/userinfo/register/result");
				}else{
					layer.msg(data.message,{icon: 5});
				}
			});
		});
	$(document).ready(function () {	
		$("#beginSite").autocomplete({
			source : function(request, response) {
				$.ajax({
						url : "${path}/luwei/site/fuzzy",
						dataType : "json",
						type : 'post',
						data : {
							q : request.term ,
							//request.term 表示获取文本框输入的值
							site: $('#endSite').val()
						},
						success : function(data) {
							response($.map(data, function(item) {
								return {
									label:item.name,
									value:item.id,
									name:item.name
								}
							}));
						}
				})
			},
			focus: function(event, ui) { 
 				return false;
 			},
 			select:function(event,ui){
 				//$("#parentCourse").val(ui.item['value']);
				//$("#beginSite").val(ui.item['name']);
				$(this).next("input").val(ui.item['lable']);
	 			$(this).val(ui.item['name']);
				return false;
 			},
 			change:function(event,ui){
 				if(null==ui.item){
 					$(this).next("input").val("");
 					//$("#parentCourse").val("");
 				}
 			},
 			minLength : 0
		});	
		$("#endSite").autocomplete({
			source : function(request, response) {
				$.ajax({
						url : "${path}/luwei/site/fuzzy",
						dataType : "json",
						type : 'post',
						data : {
							q : request.term,
							//request.term 表示获取文本框输入的值
							site: $('#beginSite').val()
						},
						success : function(data) {
							response($.map(data, function(item) {
								return {
									label:item.name,
									value:item.id,
									name:item.name
								}
							}));
						}
				})
			},
			focus: function(event, ui) { 
 				return false;
 			},
 			select:function(event,ui){
 				//$("#parentCourse").val(ui.item['value']);
				//$("#beginSite").val(ui.item['name']);
				$(this).next("input").val(ui.item['lable']);
	 			$(this).val(ui.item['name']);
				return false;
 			},
 			change:function(event,ui){
 				if(null==ui.item){
 					$(this).next("input").val("");
 					//$("#parentCourse").val("");
 				}
 			},
 			minLength : 0
		});	
	})
	</script>



</body>
</html>