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
             <jsp:include page="/view/background/common/sidebar.jsp?item=accountorderList"/>
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
                        <div class="panel-body">
                        <c:if test="${not empty pageVO}">
							<c:if test="${not empty pageVO.details}">
								<c:forEach varStatus="vs" var="order" items="${pageVO.details}">
		                            <div class="table-responsive">
		                            	<p>
		                            		<span>订单日期：<fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd" /></span>
		                            		&nbsp;&nbsp;<span>${order.user.name }</span>
		                            		&nbsp;&nbsp;<span>${order.train.number }</span>
		                            		&nbsp;&nbsp;<span>${order.beginSite.name }</span>
		                            		--->   
		                            		&nbsp;&nbsp;<span>${order.endSite.name }</span>
		                            		&nbsp;&nbsp;<span>乘车日期：<fmt:formatDate value="${order.departureTime }" pattern="yyyy-MM-dd HH:mm" /></span>
		                            	</p>
		                                <table class="table table-striped table-bordered table-hover" id="">
		                                    <thead>
		                                    	
		                                        <tr>
		                                            <th class="text-center" width="6%">ID</th>
		                                            <th class="text-center" width="18%">Train Info</th>
		                                            <th class="text-center" width="12%">Seat Info</th>
		                                            <th class="text-center" width="12%">User Info</th>
		                                            <th class="text-center" width="10%">Price</th>
		                                            <th class="text-center" width="10%">Status</th>
		                                            <th class="text-center"width="32%">Options</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
			                                       
			                                       <c:choose>  
		   												 <c:when test="${vs.count%4==0}">  
			                                        		<tr class="success">
			                                        	 </c:when> 
			                                        	 <c:when test="${vs.count%4==1}">  
			                                        		<tr class="info">
			                                        	 </c:when> 
			                                        	 <c:when test="${vs.count%4==2}">  
			                                        		<tr class="warning">
			                                        	 </c:when> 
			                                        	 <c:when test="${vs.count%4==3}">  
			                                        		<tr class="danger">
			                                        	 </c:when> 
													</c:choose>  
													 <td title='<c:out value=""></c:out>' class="text-center">${vs.count }</td>
													  <td title='<c:out value=""></c:out>' class="text-center">
													  	<fmt:formatDate value="${order.departureTime }" pattern="yyyy-MM-dd HH:mm" />开
													  	${order.train.number } &nbsp; ${order.beginSite.name } - ${order.endSite.name }
													  </td>
													   <td title='<c:out value=""></c:out>' class="text-center">
															${order.seat.compartmentNumber }车厢   ${order.seat.seatNumber }号
														</td>
													    <td title='<c:out value=""></c:out>' class="text-center">
															${order.user.name } 二代身份证
														</td>
													     <td title='<c:out value=""></c:out>' class="text-center">
															${order.price } 元
														</td>
													      <td title='<c:out value=""></c:out>' class="text-center">
															${order.status }
														</td>
			                                            <td title='<c:out value=""></c:out>' class="text-center">
			                                            	<c:if test="${order.status =='待支付'}">
																<button class="btn btn-success btn-sm" onclick="topay('${order.id}')"><i class="fa fa-yen"></i> 去支付</button>
															</c:if>
															
															<c:if test="${order.status =='已取消'}">
																<button class="btn btn-danger btn-sm"  onclick="del('${order.id}')" disabled=""><i class="fa fa-trash-o"></i> 取消订单</button>
															</c:if>
															<c:if test="${order.status !='已取消'}">
																<button class="btn btn-danger btn-sm"  onclick="del('${order.id}')"><i class="fa fa-trash-o"></i> 取消订单</button>
															</c:if>
															<c:choose>
																<c:when test="${order.qrcodeStatus ==1}">
																	<button class="btn btn-primary btn-sm" onclick="showQrcode('${order.id}')"><i class="fa fa-qrcode "></i> 查看二维码</button>
																</c:when>
																<c:when test="${order.status =='已支付'}">
																	<button class="btn btn-primary btn-sm" onclick="createQrcode('${order.id}')"><i class="fa fa-qrcode "></i> 生成二维码</button>
																</c:when>
																<c:otherwise>
																	<button class="btn btn-primary btn-sm" onclick="" disabled=""><i class="fa fa-qrcode "></i> 生成二维码</button>
																</c:otherwise>
															</c:choose>
															
														</td>
	                                        </tr>
	                                       
                                  	 	 </tbody>
                              	  	</table>
                           		 </div>
                               </c:forEach>
   							   </c:if>
							</c:if>
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
