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
													<button class="btn btn-primary btn-sm" onclick="addAccountType()"><i class="fa fa-plus "></i> Add AccountType</button>
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
          
          function delmenu(roleId,menuId){
//         	  alert(roleId+"  "+menuId);
        	  layer.msg('你确定要去除此订单？', {
        		  time: 0 //不自动关闭
        		  ,btn: ['必须啊', '取消']
        		  ,yes: function(index){
        		    $.ajax({
  		    			 type:"POST",
  		    		     url:"${path}/luwei/authority/delrolemenu",
  		    		     data: {roleId:roleId,menuId:menuId},
  		    	         success:function(res){
  		    	        	 if(res && res.result){
  		    	        		 layer.msg(res.message);
  		    	        	 }else{
  		    	        		 layer.msg(res.message);
  		    	        	 }
  		  						layer.close(index);
  		  						window.location.reload();
  			    		},
  			    		error:function(err,err1,err2){
  			            }
    		    	});
       			  }
        		});
         	 }
            
      		function addAccountType(){ 
               	layer.open({
               		  type: 2, 
               		  title: ['addAccountType','font-size:25px;'],
               		  area:['600px','500px'],
               		  content:'${path}/luwei/authority/toaddaccounttype',
               		  btn:['Close']
            		}); 
            };
            
            function addmenu(){ 
             	layer.open({
             		  type: 2, 
             		  title: ['AddMenu','font-size:25px;'],
             		  area:['480px','440px'],
             		  content:'${path}/luwei/authority/toaddmenu',
             		  btn:['Close']
             		}); 
             };
            
            function addrole(){ 
             	layer.open({
             		  type: 2, 
             		  title: ['AddRole','font-size:25px;'],
             		  area:['480px','370px'],
             		  content:'${path}/luwei/authority/toaddrole',
             		  btn:['Close']
             		}); 
             };
            
             
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
