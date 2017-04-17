<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Train</title>
<%@ include file="/view/background/common/css.jsp" %>
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap-clockpicker.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.min.css">
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="createtrainform" name="createtrainform" >
                        <input type="hidden" name="accountId" id="accountId" value="${accountId }">
                        <input type="hidden" name="id" id="id" value="${train.id }">
                        <div class="form-group">
                            <label>TrainNumber</label>
                            <input class="form-control" placeholder="${train.number }" id="number" name="number" value="${train.number }" onblur="checkName()">
                        </div>
                          <div class="form-group">
                            <label>BeginSite</label>
                            <input class="form-control" placeholder="${train.beginSite }"  name="beginSite" id="beginSite" value="${train.beginSite }" onblur="checkSite(this)">
                        </div>
                         
                          <div class="form-group">
                            <label>EndSite</label>
                            <input class="form-control" placeholder="${train.endSite }"  name="endSite" id="endSite" value="${train.endSite }" onblur="checkSite(this)">
                        </div>
                        <div class="form-group">
	                        <label>Price</label>
	                        <div class="input-group">
	                            <span class="input-group-addon">￥</span>
	                            <input class="form-control" placeholder="${train.price }"  name="price" id="price" value="${train.price }">
	                            <span class="input-group-addon">.00</span>
	                        </div>
                        </div>
                        <div class="form-group">
                            <label>Seat Num</label>
                            <input type="number" class="form-control" placeholder="${train.num }"  name="num" id="num" value="${train.num }">
                        </div>
						<!--        时间还是有一点问题  还不能显示出对应的时间 还需要修改                  -->
                        <div class="form-group">
                        	<label>DepartureTime ~ ArrivalTime</label>
							<div class="input-group clockpicker" style="width: 350px;margin-bottom: 10px;">
							   	 <div class="input-group clockpicker1">
							   	 <input type="text" id="departureTime" name="departureTime" class="form-control" value="08:00">
							    	<span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							  	  </span>
							  	  </div>
							  	  <span class="input-group-addon">~</span>
							  	  <div class="input-group clockpicker2">
							  	  <input type="text" id="arrivalTime" name="arrivalTime" class="form-control" value="08:00">
							    	<span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							  	  </span>
							  	  </div>
							</div>
						</div>
						
						<!-- 下面这个按钮用button是提交就无法关闭弹出框   用a标签的时候就可以关闭  -->
                        <a type="submit" class="btn btn-success" id="reg">Submit</a>
                        <a type="reset" class="btn btn-default">Reset</a>
                    </form>
                </div>
                <!-- /.panel-body -->
            </div>
	<jsp:include page="/view/background/common/scripts.jsp" />
	<script src="${path}/js/laydate/laydate.js"></script>
	<script type="text/javascript" src="${path}/js/laydate/date/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/laydate/date/bootstrap-clockpicker.min.js"></script>
	<script src="${path}/js/jquery-ui.min.js"></script>
	<script src="${path}/js/jquery-ui.custom.min.js"></script>

<script>
		
		$('.clockpicker1').clockpicker();
		$('.clockpicker2').clockpicker();
		function checkSite(it){
			if(!it.value){
				id=$(it).attr("id");
				layer.tips('Site not null!',it,{
					tips:[3,'#f173ac'],
					time:5000
				});
				return;
			}
		}
		
		function checkName(){
			var name=$("#number").val();
			if(!name){
				//alert("name==null");
				layer.tips('Name not null!','#number',{
					tips:[1,'#f173ac'],
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
		//提交前进行验证 还没有做   还有添加  
 		$("#reg").bind("click",function(){
			$.post("${path }/luwei/train/saveOrUpdateTrain",$("#createtrainform").serialize(),function(data) {
				if(data && data.result) {
					parent.layer.msg(data.message,{icon: 6,time: 3000});
					//window.location.replace("${path}/arwen/userinfo/register/result");
				}else{
					parent.layer.msg(data.message,{icon: 5,time: 3000});
				}
// 				parent.layer.closeAll();
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	            parent.layer.close(index);
				window.parent.location.reload();
				
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