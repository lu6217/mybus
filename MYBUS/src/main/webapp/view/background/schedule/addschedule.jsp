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
<title>Create Schedule</title>
<%@ include file="/view/background/common/css.jsp" %>
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap-clockpicker.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.min.css">
</head>
<body>

            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" id="createscheduleform" name="createscheduleform" >
                       
                          <div class="form-group">
                            <label>TrainNumber</label>
                            <input class="form-control" placeholder="" id="trainName" name="trainName" value="" onblur="checkTrain(this)">
                        </div>
                         

                        <div class="form-group">
                        	<label>StartTime ~ EndTime</label>
							<div class="input-group clockpicker" style="width: 350px;margin-bottom: 10px;">

<!-- 						日期的格式在传到后台的时候  如果格式不一致可能会出现问题 要注意 -->
							<div class="layui-inline">
							  <input class="layui-input" placeholder="startDate" name="startDate" id="startDate" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})">
							</div>
							<span class="input-group-addon">~</span>
							<div class="layui-inline">
							  <input class="layui-input" placeholder="endDate" name="endDate" id="endDate" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})">
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
			$.post("${path }/luwei/schedule/addschedule2",$("#createscheduleform").serialize(),function(data) {
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
			$("#trainName").autocomplete({
			source : function(request, response) {
			$.ajax({
						url : "${path}/luwei/train/fuzzy",
						dataType : "json",
						type : 'post',
						data : {
							q : request.term,
							//request.term 表示获取文本框输入的值
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
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  var start = {
	format: 'YYYY-MM-DD',
    min: laydate.now()
    ,max: '2099-06-16 23:59:59'
    ,istoday: false
    ,istime: true
    ,choose: function(datas){
      end.min = datas; //开始日选好后，重置结束日的最小日期
      end.start = datas //将结束日的初始值设定为开始日
    }
  };
  
  var end = {
	format: 'YYYY-MM-DD',
    min: laydate.now()
    ,max: '2099-06-16 23:59:59'
    ,istoday: false
    ,istime: true
    ,choose: function(datas){
      start.max = datas; //结束日选好后，重置开始日的最大日期
    }
  };
  
  document.getElementById('startDate').onclick = function(){
    start.elem = this;
    laydate(start);
  }
  document.getElementById('endDate').onclick = function(){
    end.elem = this
    laydate(end);
  }
  
});
</script>
	  
</body>
</html>