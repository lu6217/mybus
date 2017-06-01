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
    <title>OrderList</title>
	<%@ include file="/view/background/common/css.jsp" %>
     <!-- TABLE STYLES-->
    <link href="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
 <div id="wrapper">
        <jsp:include page="/view/background/common/header.jsp" />
        <!--/. NAV TOP  -->
         <nav class="navbar-default navbar-side" role="navigation">
<!-- 		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div> -->
             <jsp:include page="/view/background/common/sidebar.jsp?item=order"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Order List <small>order tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             Order table
                        </div>
                        <div class="form-group">
<!--                             <label>CardType</label> -->
                            <select name="status" id="status" class="form-control" onchange="statusChange()">
                                <option value="0">所有订单 </option>
								<option value="待支付">未支付订单</option>
								<option value="已支付">已支付订单</option>
                            </select>
                        </div>
                        <div class="panel-body" id="orderList">
                        
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
        </div>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
     <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
            
            statusChange();
            
            function statusChange(){
            	 var status=$("#status").val();
//             	 alert(opt);
            	 $.post("${path }/luwei/order/selectorder",{status:status},function(data) {
     				$("#orderList").html(data);
     				
     			}); 
            }
            
            
            function showQrcode(id){
            	layer.open({
            		type: 2
                    ,title: '订单二维码'
                    ,area: ['400px','400px']
                    ,shade: 0.8
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,btn: ['关闭']
                    ,moveType: 1 //拖拽模式，0或者1
                    ,content: '${path}/luwei/order/showqrcode/'+id
                    
           		}); 
            }
            
            
            function createQrcode(id){
            	
            	layer.open({
            		type: 2
                    ,title: '订单二维码'
                    ,area: ['400px','400px']
                    ,shade: 0.8
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,btn: ['关闭']
                    ,moveType: 1 //拖拽模式，0或者1
                    ,content: '${path}/luwei/order/createqrcode/'+id
                    ,end: function () {
                        location.reload();
                    }
           		}); 
            	
            }
            
            function topay(id){
            	layer.open({
            		type: 2
                    ,title: '是否支付此订单？'
                    ,closeBtn: false
                    ,area: ['290px','360px']
                    ,shade: 0.8
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,btn: ['确定支付','取消']
                    ,moveType: 1 //拖拽模式，0或者1
//                     ,content:'${path}/view/background/account/userinfo.jsp'
                    ,content: '${path}/luwei/order/getorderinfo/'+id
                    ,yes: function(){
                    	$.ajax(
            		    		{
            		    			 type:"POST",
            		    		     url:"${path}/luwei/order/topay",
            		    		     data: {id:id},
            		    	         success:function(res){
            		    	        	 if(res && res.result){
            		    	        		 layer.msg(res.message);
//             		    	        		 alert(res.message); 
            		    	        	 }else{
            		    	        		 layer.msg(res.message);
            		    	        	 	//alert(res.message);
            		    	        	 }
//             		    	        	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//             		 	               		 parent.layer.close(index);
            		  						//window.parent.location.reload();
            		  						window.location.reload();
            			    		},
            			    		error:function(err,err1,err2){
            			    		    //debugger;
            			            }
            		    		});
                    }
//                     ,success: function(layero){
//                       var btn = layero.find('.layui-layer-btn');
//                       btn.css('text-align', 'center');
//                       btn.find('.layui-layer-btn0').attr({
//                         href: '${path}/luwei/account/toadduser/'+id
                       
//                       });
//                     }	
           		}); 
            	
            }
            
            
            
            function edits(id){
              	layer.open({
           		  type: 2, 
           		  title: ['UserInfo','font-size:25px;'],
           		  area:['600px','500px'],
           		  content: '${path}/luwei/account/get/'+id,
           		  btn:['Close']
//            		  end:function(){
//            			// alert('close');
//               		 window.location.reload();
//            		 }
           		});
              }
              
             function adds(id){ 
             	layer.open({
             		  type: 2, 
             		  title: ['AddUser','font-size:25px;'],
             		  area:['600px','500px'],
             		  content:'${path}/luwei/account/toadduser/'+id,
             		  btn:['Close']
//              		  ,end:function(){
//              			 alert('close');
//                			// window.location.reload();
//             		 }
             		}); 
             };
             
             function del(id){
            	 layer.msg('你确定要取消订单？', {
            		  time: 0 //不自动关闭
            		  ,btn: ['必须啊', '退出']
            		  ,yes: function(index){
            		    
            		    $.ajax(
            		    		{
            		    			 type:"POST",
            		    		     url:"${path}/luwei/order/delorder/",
            		    		     data: {id:id},
            		    	         success:function(res){
            		    	        	 if(res && res.result){
            		    	        		 layer.msg(res.message);
//             		    	        		 alert(res.message); 
            		    	        	 }else{
            		    	        		 layer.msg(res.message);
            		    	        	 	//alert(res.message);
            		    	        	 }
//             		    	        	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//             		 	               		 parent.layer.close(index);
            		  						//window.parent.location.reload();
            		  						layer.close(index);
            		  						window.location.reload();
            			    		},
            			    		error:function(err,err1,err2){
            			    		    //debugger;
            			            }
            		    		});
            		    
            		  }
            		});
            	 
             }
//             function del(id){
//             	layer.open({
//             		type: 2
//                     ,title: '是否取消此订单？'
//                     ,closeBtn: false
//                     ,area: ['250px','360px']
//                     ,shade: 0.8
//                     ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
//                     ,btn: ['火速取消','退出']
//                     ,moveType: 1 //拖拽模式，0或者1
// //                     ,content:'${path}/view/background/account/userinfo.jsp'
//                     ,content: '${path}/luwei/order/getorderinfo/'+id
//                     ,yes: function(){
//                     	$.ajax(
//             		    		{
//             		    			 type:"POST",
//             		    		     url:"${path}/luwei/order/delorder/",
//             		    		     data: {id:id},
//             		    	         success:function(res){
//             		    	        	 if(res && res.result){
//             		    	        		 layer.msg(res.message);
// //             		    	        		 alert(res.message); 
//             		    	        	 }else{
//             		    	        		 layer.msg(res.message);
//             		    	        	 	//alert(res.message);
//             		    	        	 }
// //             		    	        	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
// //             		 	               		 parent.layer.close(index);
//             		  						//window.parent.location.reload();
//             		  						window.location.reload();
//             			    		},
//             			    		error:function(err,err1,err2){
//             			    		    //debugger;
//             			            }
//             		    		});
//                     }
// //                     ,success: function(layero){
// //                       var btn = layero.find('.layui-layer-btn');
// //                       btn.css('text-align', 'center');
// //                       btn.find('.layui-layer-btn0').attr({
// //                         href: '${path}/luwei/account/toadduser/'+id
                       
// //                       });
// //                     }	
//            		}); 
//             }
            
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
