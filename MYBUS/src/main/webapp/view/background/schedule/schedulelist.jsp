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
    <title>ScheduleList</title>
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
             <jsp:include page="/view/background/common/sidebar.jsp?item=schedule"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Schedule <small>Schedule tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             schedule table
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="text-center">车次</th>
                                            <th class="text-center">发车站</th>
                                            <th class="text-center">终点站</th>
                                            <th class="text-center">发车时间</th>
                                            <th class="text-center">到站时间</th>
<!--                                             <th class="text-center">运行时间</th> -->
                                            <th class="text-center">Status</th>
                                            <th class="text-center">Option</th>
                                        </tr>
                                    </thead>
                                    <tbody>
	                                    <c:if test="${not empty pageVO}">
	     									<c:if test="${not empty pageVO.details}">
	     									<c:forEach varStatus="vs" var="schedule" items="${pageVO.details}">
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
	                                            <td title='<c:out value="${schedule.train.number } "></c:out>' class="text-center"><a href="javascript:void(0)" onclick="showSite('${schedule.train.id }')">${schedule.train.number }</a></td>
	                                            <td title='<c:out value="${schedule.beginSite.name } "></c:out>' class="text-center">${schedule.beginSite.name }</td>
	                                            
	                                             <td title='<c:out value="${schedule.endSite.name } "></c:out>' class="text-center">${schedule.endSite.name }</td>
<%-- 	                                            <td title='<c:out value="${train.departureTime } "></c:out>' class="text-center">${train.departureTime }</td> --%>
<%-- 	                                            <td title='<c:out value="${train.arrivalTime } "></c:out>' class="text-center">${train.arrivalTime }</td> --%>
	                                            <td title='<fmt:formatDate value="${schedule.departureTime }" pattern="yyyy-MM-dd HH:mm" />' class="text-center">
													<fmt:formatDate value="${schedule.departureTime }" pattern="yyyy-MM-dd HH:mm" />
												</td>
												 <td title='<fmt:formatDate value="${schedule.arrivalTime }" pattern="yyyy-MM-dd HH:mm" />' class="text-center">
													<fmt:formatDate value="${schedule.arrivalTime }" pattern="yyyy-MM-dd HH:mm" />
<%-- 													<c:choose> --%>
<%-- 														<c:when test="${schedule.numberDay==0}">(即日)</c:when> --%>
<%-- 														<c:when test="${schedule.numberDay==1}">(次日)</c:when> --%>
<%-- 														<c:when test="${schedule.numberDay==2}">(隔日)</c:when> --%>
<%-- 														<c:otherwise></c:otherwise> --%>
<%-- 													</c:choose> --%>
												</td>
	<!-- 		             									发车时间的这个有问题   不能显示出来      现在可以了    是get和set的问题   以后要注意  -->
<%-- 	                                             <td title='<c:out value="${schedule.time } "></c:out>' class="text-center">${schedule.time }</td> --%>
	                                             <td title='<c:out value="${schedule.status } "></c:out>' class="text-center">
	                                             	<c:choose>
														<c:when test="${schedule.status==0}">已禁用</c:when>
														<c:when test="${schedule.status==10}">正常运营</c:when>
														<c:otherwise></c:otherwise>
													</c:choose>
	                                             </td>
	                                            <td class="text-center">
													<button class="btn btn-success btn-sm" onclick="edits('${schedule.id }')" disabled=""><i class="fa fa-edit" ></i> Edit</button>
													<button class="btn btn-danger btn-sm"  onclick="del('${schedule.id }')"><i class="fa fa-trash-o"></i> Delete</button>
	                                            
	                                            </td>
	                                        </tr>
	                                        </c:forEach>
	   									   </c:if>
	  									 </c:if>
                                    </tbody>
                                <div>
                                	<button class="btn btn-primary btn-sm" onclick="adds('0')"><i class="fa fa-plus "></i> Add Schedule</button>
<%-- 									<button class="btn btn-primary btn-sm" onclick="addTrainSite('${schedule.id }')"><i class="fa fa-plus "></i> Add Schedule</button> --%>
                                	<hr>
                                </div>
                                </table>
                            </div> 
                            
                        </div>
                    </div>
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
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
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
   		
            		
            function adds(id){ 
             	layer.open({
             		  type: 2, 
             		  title: ['AddSchedule','font-size:25px;'],
             		  area:['400px','340px'],
             		  content:'${path}/luwei/schedule/toaddschedule',
             		  btn:['Close']
             		  
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
             
             function del(id){
            	 layer.msg('确定要删除此次调度？', {
            		  time: 20000, //20s后自动关闭
            		  btn: ['残忍删除', '火速取消'],
            		  yes: function(){
            			  $.ajax({
            				 type:"POST",
      		    		     url:"${path}/luwei/schedule/delschedule",
      		    		     data: {id:id},
      		    	         success:function(res){
      		    	        	 if(res && res.result){
      		    	        		 layer.msg(res.message);
      		    	        	 }else{
      		    	        		 layer.msg(res.message);
      		    	        	 }
      		  						window.location.reload();
      			    		},
      			    		error:function(err,err1,err2){
      			    		    //debugger;
      			            }
      		    		  });
            		  }
            		});
            	 
             }
             
             
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
