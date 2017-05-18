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
</head>
<body>
 <div id="wrapper">
       <jsp:include page="/view/background/common/header.jsp" />
        <!--/. NAV TOP  -->
         <nav class="navbar-default navbar-side" role="navigation">
<!-- 		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div> -->
             <jsp:include page="/view/background/common/sidebar.jsp?item=authority"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Authority <small></small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Authority Assignment
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-5">
                                    <div class="panel panel-default">
				                        <div class="panel-heading">
				                            Role
				                        </div>
				                        <div class="panel-body">
				                            <div class="table-responsive">
				                                <table class="table table-striped table-bordered table-hover">
				                                    <thead>
				                                        <tr class="">
				                                            <th class="text-center">#</th>
				                                            <th class="text-center">Name</th>
				                                            <th class="text-center">Description</th>
				                                            <th class="text-center">Options</th>
				                                        </tr>
				                                    </thead>
				                                    <tbody id="rolebody">
				                                    	<c:if test="${not empty pageVO}">
				                                    		<c:if test="${not empty pageVO.details}">
					     										<c:forEach varStatus="vs" var="role" items="${pageVO.details}">
						                                    	  <c:choose>  
				   													 <c:when test="${vs.count%4==0}">  
					                                        			<tr class="success" ondblclick="detail('${role.id}')">
					                                    	    	 </c:when> 
					                                        		 <c:when test="${vs.count%4==1}">  
					                                        			<tr class="info" ondblclick="detail('${role.id}')">
					                                        	 	</c:when> 
					                                        	 	<c:when test="${vs.count%4==2}">  
					                                        			<tr class="warning" ondblclick="detail('${role.id}')">
					                                        	 	</c:when> 
					                                        	 	<c:when test="${vs.count%4==3}">  
					                                        			<tr class="danger" ondblclick="detail('${role.id}')">
					                                        	 	</c:when> 
																	</c:choose>  
					                                    
						                                           <td class="text-center" name="role_number">${vs.count }</td>
						                                           <td class="text-center" name="role_name">${role.name }</td>
						                                           <td class="text-center" name="role_description">${role.description }</td>
					                                      		   <td class="text-center"><button class="btn btn-success btn-sm" onclick="assignment('${role.id }')"><i class="fa fa-edit"></i> Assignment</button></td>
					                                      		  </tr>
					                                        	</c:forEach>
					                                        </c:if>
				                                        </c:if>
				                                    </tbody>
				                                    <div>
				                                	<button class="btn btn-primary btn-sm" onclick="addrole()"><i class="fa fa-plus "></i> Add</button>
													<button class="btn btn-primary btn-sm" onclick="addTrainSite('${role.id }')"><i class="fa fa-plus "></i> Add Site</button>
													<button class="btn btn-success btn-sm" onclick="edits('${role.id }')"><i class="fa fa-edit"></i> Edit</button>
				<!-- 	                                            	<button class="btn btn-default btn-sm"><i class=" fa fa-refresh "></i> Update</button> -->
													<button class="btn btn-danger btn-sm"  onclick="del('${role.id }')"><i class="fa fa-trash-o"></i> Delete</button>
				                                	<hr>
				                                </div>
				                                </table>
				                            </div>
				                        </div>
				                    </div>
                                </div>
                                <div class="col-lg-7">
                                    <div class="panel panel-default">
                       
				                        <div class="panel-heading">
				                            Menu
				                        </div>
				                        
				                        <div class="panel-body">
				                            <div class="table-responsive">
				                                <table class="table table-striped table-bordered table-hover">
				                                    <thead>
				                                        <tr>
				                                            <th class="text-center">Name</th>
				                                            <th class="text-center">URL</th>
				                                            <th class="text-center">Icon</th>
				                                            <th class="text-center">Parent Menu</th>
				                                            <th class="text-center">Level</th>
				                                            <th class="text-center">Leaf</th>
				                                        </tr>
				                                    </thead>
				                                    <tbody id="menuTableId">
				                                       
				                                    </tbody>
				                                      <div>
					                                	<button class="btn btn-primary btn-sm" onclick="addmenu()"><i class="fa fa-plus "></i> Add</button>
														<button class="btn btn-primary btn-sm" onclick="addTrainSite('${train.id }')"><i class="glyphicon glyphicon-apple "></i> Add Site</button>
					                                	<hr>
					                                </div>
				                                </table>
				                            </div>
				                        </div>
				                    </div>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

        </div>
    </div>
             <!-- /. PAGE INNER  -->
  </div>
     <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
            
            function assignment(id){
            	layer.open({
           		  type: 2, 
           		  title: ['Assignment','font-size:25px;'],
           		  area:['480px','400px'],
           		  content:'${path}/luwei/authority/toassignment/'+id,
           		  btn:['Close']
           		}); 
            }
            
            
          function detail(id){
        	  
        	  $.post("${path}/luwei/authority/getmenu",{roleId:id},function(data) {
  				
        		  $("#menuTableId").html(data);
  				
  			}); 
        	  
          }
            
             function product(trainId){
            	 var index =layer.load(2,
            			 {shade: [0.4, '#393D49']
            	 });
            	 
            	 $.ajax({
    				 type:"POST",
		    		     url:"${path}/luwei/schedule/addschedule",
		    		     data: {trainId:trainId},
		    	         success:function(res){
		    	        	 if(res && res.result){
		    	        		 layer.msg(res.message);
		    	        	 }else{
		    	        		 layer.msg(res.message);
		    	        	 }
// 		  						window.location.reload();
		    	        	 layer.close(index);
			    		},
			    		error:function(err,err1,err2){
			    		    //debugger;
			            }
		    		  });
            	 
            	 
             }
            function showSite(id){
            	layer.open({
             		  type: 2, 
             		  title: ['Station Info','font-size:25px;'],
             		  area:['550px','400px'],
             		  content: '${path}/luwei/train_site/get/'+id,
             		  shadeClose: true,//点击窗体外的任意处 关闭窗体
             		  btn:['Close']
//              		  end:function(){
//              			// alert('close');
//                 		 window.location.reload();
//              		 }
             		});
            }
           
            		
      		function addTrainSite(id){ 
               	layer.open({
               		  type: 2, 
               		  title: ['AddTrainSite','font-size:25px;'],
               		  area:['600px','500px'],
               		  content:'${path}/luwei/train/toaddtrainsite/'+id,
               		  btn:['Close']
//                      		  ,end:function(){
//                      			 alert('close');
//                        			// window.location.reload();
//                     		 }
            		}); 
            };
            
            
            function addmenu(){ 
             	layer.open({
             		  type: 2, 
             		  title: ['AddMenu','font-size:25px;'],
             		  area:['480px','440px'],
             		  content:'${path}/luwei/authority/toaddmenu',
             		  btn:['Close']
//              		  ,end:function(){
//              			 alert('close');
//                			// window.location.reload();
//             		 }
             		}); 
             };
            
            function addrole(){ 
             	layer.open({
             		  type: 2, 
             		  title: ['AddRole','font-size:25px;'],
             		  area:['480px','300px'],
             		  content:'${path}/luwei/authority/toaddrole',
             		  btn:['Close']
//              		  ,end:function(){
//              			 alert('close');
//                			// window.location.reload();
//             		 }
             		}); 
             };
            
             function edits(id){
               	layer.open({
            		  type: 2, 
            		  title: ['UserInfo','font-size:25px;'],
            		  area:['600px','500px'],
            		  content: '${path}/luwei/train/get/'+id,
            		  btn:['Close']
//             		  end:function(){
//             			// alert('close');
//                		 window.location.reload();
//             		 }
            		});
               }
             
             function del(id,number){
            	 layer.msg('确定要删除  '+number+' 列车', {
            		  time: 20000, //20s后自动关闭
            		  btn: ['残忍删除', '火速取消'],
            		  yes: function(){
            			  $.ajax({
            				 type:"POST",
      		    		     url:"${path}/luwei/train/deltrain",
      		    		     data: {id:id},
      		    	         success:function(res){
      		    	        	 if(res && res.result){
      		    	        		 layer.msg(res.message);
//       		    	        		 alert(res.message); 
      		    	        	 }else{
      		    	        		 layer.msg(res.message);
      		    	        	 	//alert(res.message);
      		    	        	 }
//       		    	        	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//       		 	               		 parent.layer.close(index);
      		  						//window.parent.location.reload();
      		  						window.location.reload();
      			    		},
      			    		error:function(err,err1,err2){
      			    		    //debugger;
      			            }
      		    		  });
            		  }
            		});
            	 
             }
             
               // 需要修改 还不能实现功能   
/* 			function del(id){
            	 layer.open({
             		type: 2
                     ,title: '是否删除此用户？'
                     ,closeBtn: false
                     ,area: ['250px','360px']
                     ,shade: 0.8
                     ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                     ,btn: ['残忍删除','火速取消']
                     ,moveType: 1 //拖拽模式，0或者1
//                      ,content:'${path}/view/background/account/userinfo.jsp'
                     ,content: '${path}/luwei/account/getuserinfo/'+id
                     ,yes: function(){
                     	$.ajax(
             		    		{
             		    			 type:"POST",
             		    		     url:"${path}/luwei/account/deluser/",
             		    		     data: {id:id},
             		    	         success:function(res){
             		    	        	 if(res && res.result){
             		    	        		 layer.msg(res.message);
//              		    	        		 alert(res.message); 
             		    	        	 }else{
             		    	        		 layer.msg(res.message);
             		    	        	 	//alert(res.message);
             		    	        	 }
//              		    	        	 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//              		 	               		 parent.layer.close(index);
             		  						//window.parent.location.reload();
             		  						window.location.reload();
             			    		},
             			    		error:function(err,err1,err2){
             			    		    //debugger;
             			            }
             		    		});
                     }
//                      ,success: function(layero){
//                        var btn = layero.find('.layui-layer-btn');
//                        btn.css('text-align', 'center');
//                        btn.find('.layui-layer-btn0').attr({
//                          href: '${path}/luwei/account/toadduser/'+id
                        
//                        });
//                      }	
            		});  
             }  */
             
             
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
