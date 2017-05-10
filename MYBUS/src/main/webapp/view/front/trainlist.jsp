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
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>TrainList</title>
    <%@ include file="/view/background/common/css.jsp" %>
    <!-- TABLE STYLES-->
    <link href="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.min.css">
</head>
<body>
 <div id="wrapper">
       <jsp:include page="/view/background/common/header.jsp" />
        <!--/. NAV TOP  -->
         <nav class="navbar-default navbar-side" role="navigation">
<!-- 		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div> -->
             <jsp:include page="/view/background/common/sidebar.jsp?item=trainList"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Train <small>train tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             Train table
                        </div>
                        <div class="panel-body">
                       <form role="form" id="searchtrainform" name="searchtrainform" >
                        <div class="form-group">
						  <div class="input-group ">
							  <div class="input-group-addon">
                                  <input class="" type="radio" name="optionsRadios" id="single" value="single" checked="">单程
                                  <input class="" type="radio" name="optionsRadios" id="round" value="round">往返
                             </div>
                        	 <span class="input-group-addon">出发地 <i class="fa fa-map-marker"></i></span>
							 <div class="input-group ">
							  	<input class="form-control" placeholder=""  name="beginSite" id="beginSite" value="" onblur="checkSite(this)">
<!-- 							 	<div class="input-group-addon"> -->
<!--                                    <i class="fa fa-map-marker"></i> -->
<!--                                 </div>	 -->
							 </div>
							 <span class="input-group-addon">目的地 <i class="fa fa-map-marker"></i></span>
							 <div class="input-group ">
								<input class="form-control" placeholder=""  name="endSite" id="endSite" value="" onblur="checkSite(this)">
<!-- 							 	<div class="input-group-addon"> -->
<!--                                    <i class="fa fa-map-marker"></i> -->
<!--                                 </div>	 -->
							 </div>
							 <span class="input-group-addon">出发日</span>
							 <div class="input-group">
							  	<input class="form-control" placeholder="" name="departureDate" id="departureDate" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})">
								<div class="input-group-addon">
                                   <i class="fa fa-calendar"></i>
                                </div>													
							</div>
							<span class="input-group-addon">返程日</span>
							<div class="input-group">
							 	<input class="form-control" placeholder="" name="backDate" id="backDate" onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD'})" disabled="true">
								<div class="input-group-addon">
                             	   <i class="fa fa-calendar"></i>
                           		 </div>	
							</div>
							<span class="input-group-addon"></span>
							<div class="input-group">
								<a class="form-control btn btn-success" type="submit" id="reg" value=""><i class="fa fa-search"></i> Search</a>
							</div>
							</div>
                        </div>
                    </form>
                        
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="text-center">车次</th>
                                            <th class="text-center">发车站</th>
                                            <th class="text-center">终点站</th>
                                            <th class="text-center">发车时间</th>
                                            <th class="text-center">到站时间</th>
                                            <th class="text-center">运行时间</th>
                                            <th class="text-center">Option</th>
                                        </tr>
                                    </thead>
                                    <tbody id="trainlistId">

                                    </tbody>
                                <div>
                                </div>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>

        </div>
    </div>
             <!-- /. PAGE INNER  -->
  </div>
     <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${path}/js/jquery-ui.min.js"></script>
	<script src="${path}/js/jquery-ui.custom.min.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
                $(':radio').click(function(){
	            	var radioVal=$('input[name="optionsRadios"]:checked').val();
	            		if(radioVal=="single"){
	            			searchtrainform.backDate.disabled=true;
	            		}else{
	            			searchtrainform.backDate.disabled=false;
	            		}
            	});
            });
            
            function product(id,trainId,beginSiteId,endSiteId,departureTime,arrivalTime,numberDay,price){
            	
            	var data= {id:id
   		    	 ,trainId:trainId
   		    	 ,beginSiteId:beginSiteId
   		    	 ,endSiteId:endSiteId
   		    	 ,departureTime:departureTime
   		    	 ,arrivalTime:arrivalTime
   		    	 ,numberDay:numberDay
   		    	 ,price:price}
            	
//             	layer.open({
//              		  type: 2, 
//              		  title: ['Station Info','font-size:25px;'],
//              		  area:['550px','400px'],
//              		  content: '${path}/luwei/order/initorder/'+data,
//              		  shadeClose: true,//点击窗体外的任意处 关闭窗体
//              		  btn:['Close']
// //              		  end:function(){
// //              			// alert('close');
// //                 		 window.location.reload();
// //              		 }
//              		});
            	
            	
            	
            	$.post("${path}/luwei/order/initorder",data,function(res){
//             		window.location.reload();
alert("kk");
// alert("id="+res.id+" trainId="+res.trainId+" beginid="+res.beginSiteId+"endId="+res.endSiteId);
					window.location.href="${path}/view/front/initorder.jsp?id="+id+"&trainId="+trainId+"&beginSiteId="+beginSiteId+"&endSiteId="+endSiteId;
					//还是有点问题  穿过去的id   再通过ID进行查询  查出所需的内容   
//             		window.location.replace("${path}/view/front/initorder.jsp?id="+id);
            	}); 
            	
            	
//            	 	$.ajax({
//    				 type:"POST",
// 		    		     url:"${path}/luwei/order/initorder",
// 		    		     data: {id:id
// 		    		    	 ,trainId:trainId
// 		    		    	 ,beginSiteId:beginSiteId
// 		    		    	 ,endSiteId:endSiteId
// 		    		    	 ,departureTime:departureTime
// 		    		    	 ,arrivalTime:arrivalTime
// 		    		    	 ,numberDay:numberDay
// 		    		    	 ,price:price},
// 		    	         	success:function(res){
// 		    	        	 alert("kk");
		    	        	 
// 		    	        	 $(this).html(res);
// // 		    	        	 if(res && res.result){
// // 		    	        		 layer.msg(res.message);
// // 		    	        	 }else{
// // 		    	        		 layer.msg(res.message);
// // 		    	        	 }
// //		  						window.location.reload();
// // 		    	        	 layer.close(index);
// 			    		},
// 			    		error:function(err,err1,err2){
// 			    		    //debugger;
// 			            }
// 		    		  });
            	
// //             	layer.open({

// //             	});
            	
            }
            
            
            function showSite(id){
            	layer.open({
           		  type: 2, 
           		  title: ['Station Info','font-size:25px;'],
           		  area:['550px','400px'],
           		  content: '${path}/luwei/front/train_site/get/'+id,
           		  shadeClose: true,//点击窗体外的任意处 关闭窗体
           		  btn:['Close']
//            		  end:function(){
//            			// alert('close');
//               		 window.location.reload();
//            		 }
           		});
            }
            
            $("#reg").bind("click",function(){
            	var beginsite=$('#beginSite').val().trim();
            	var endsite=$('#endSite').val().trim();
            	var depDate=$('#departureDate').val().trim();
            	if(beginsite==null || beginsite==''){
            		layer.msg('Site Not Null!');
            		return false;
            	}
            	if(endsite==null || endsite==''){
            		layer.msg('Site Not Null!');
            		return false;
            	}
            	if(depDate==null || depDate==''){
            		layer.msg('Please choose a date!');
            		return false;
            	}
    			$.post("${path }/luwei/front/train/searchlist",$("#searchtrainform").serialize(),function(data) {
    				$("#trainlistId").html(data);
    				
    			}); 
    		});
            
       $(document).ready(function () {	
			$("#beginSite").autocomplete({
			source : function(request, response) {
				$.ajax({
						url : "${path}/luwei/front/site/fuzzy",
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
						url : "${path}/luwei/front/site/fuzzy",
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
		    ,max: laydate.now(+30)
		    ,istoday: false
// 		    ,istime: true
		    ,choose: function(datas){
		      end.min = datas; //开始日选好后，重置结束日的最小日期
		      end.start = datas //将结束日的初始值设定为开始日
		    }
		  };
		  
		  var end = {
			format: 'YYYY-MM-DD',
		    min: laydate.now()
		    ,max: laydate.now(+30)
		    ,istoday: false
// 		    ,istime: true
		    ,choose: function(datas){
		      start.max = datas; //结束日选好后，重置开始日的最大日期
		    }
		  };
		  
		  document.getElementById('departureDate').onclick = function(){
		    start.elem = this;
		    laydate(start);
		  }
		  document.getElementById('backDate').onclick = function(){
		    end.elem = this
		    laydate(end);
		  }
		  
		});
	</script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
