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
		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>
             <jsp:include page="/view/background/common/sidebar.jsp"/>
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
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="text-center">车次</th>
                                            <th class="text-center">发车站</th>
                                            <th class="text-center">终点站</th>
                                            <th class="text-center">发车时间</th>
                                            <th class="text-center">运行时间</th>
                                            <th class="text-center">Option</th>
                                        </tr>
                                    </thead>
                                    <tbody>
	                                    <c:if test="${not empty pageVO}">
	     									<c:if test="${not empty pageVO.details}">
	     									<c:forEach varStatus="vs" var="train" items="${pageVO.details}">
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
	                                            <td title='<c:out value="${train.number } "></c:out>' class="text-center"><a href="javascript:void(0)" onclick="showSite('${train.id }')">${train.number }</a></td>
	                                            <td title='<c:out value="${train.beginSite } "></c:out>' class="text-center">${train.beginSite }</td>
	                                             <td title='<c:out value="${train.endSite } "></c:out>' class="text-center">${train.endSite }</td>
	                                            <td title='<c:out value="${train.departureTime } "></c:out>' class="text-center">${train.departureTime }</td>
	<!-- 		             									发车时间的这个有问题   不能显示出来      现在可以了    是get和set的问题   以后要注意  -->
	                                             <td title='<c:out value="${train.time } "></c:out>' class="text-center">${train.time }</td>
	                                            <td class="text-center">
													<button class="btn btn-success btn-sm" onclick="adds('${train.id }')"><i class="fa fa-plus"></i> Reserve</button>
<!-- 	                                            	<button class="btn btn-default btn-sm"><i class=" fa fa-refresh "></i> Update</button> -->
<%-- 													<button class="btn btn-primary btn-sm" onclick="edits('${train.id }')"><i class="fa fa-edit "></i> Edit</button> --%>
<!-- 													<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i> Delete</button> -->
	                                            </td>
	                                        </tr>
	                                        </c:forEach>
	   									   </c:if>
	  									 </c:if>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <div class="row" >
                <div class="col-md-12">
                     <!--    Context Classes  -->
                    <div class="panel panel-default">
                       
                        <div class="panel-heading">
                            Context Classes
                        </div>
                        
                        <div class="panel-body">
                            <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
<!--                                 <table class="table"> -->
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="success">
                                            <td>1</td>
                                            <td>Mark</td>
                                            <td>Otto</td>
                                            <td>@mdo</td>
                                        </tr>
                                        <tr class="info">
                                            <td>2</td>
                                            <td>Jacob</td>
                                            <td>Thornton</td>
                                            <td>@fat</td>
                                        </tr>
                                        <tr class="warning">
                                            <td>3</td>
                                            <td>Larry</td>
                                            <td>the Bird</td>
                                            <td>@twitter</td>
                                        </tr>
                                        <tr class="danger">
                                            <td>4</td>
                                            <td>John</td>
                                            <td>Smith</td>
                                            <td>@jsmith</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--  end  Context Classes  -->
                </div>
            </div>
                <!-- /. ROW  -->
        </div>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
     <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
            
            function showSite(id){
            	alert("id="+id);
            	id=2;
            	layer.open({
             		  type: 2, 
             		  title: ['Station Info','font-size:25px;'],
             		  area:['600px','500px'],
             		  content: '${path}/luwei/site/get/'+id,
             		  shadeClose: true,//点击窗体外的任意处 关闭窗体
             		  btn:['Close']
//              		  end:function(){
//              			// alert('close');
//                 		 window.location.reload();
//              		 }
             		});
            	
            }
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
