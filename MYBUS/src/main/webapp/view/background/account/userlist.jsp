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
    <title>UserList</title>
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
                            User List <small>user tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             User table
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="text-center">IDcard</th>
                                            <th class="text-center">Name</th>
                                            <th class="text-center">Age</th>
                                            <th class="text-center">Sex</th>
                                            <th class="text-center">Telphone</th>
                                            <th class="text-center">Address</th>
                                            <th class="text-center">AccountId</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:if test="${not empty pageVO}">
      										<c:if test="${not empty pageVO.details}">
      										<c:forEach varStatus="vs" var="user" items="${pageVO.details}">
	                                       <!-- varStatus 是从1开始的  -->
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
	                                            <td title='<c:out value="${user.IDcard } "></c:out>' class="text-center">${user.IDcard }</td>
	                                            <td title='<c:out value="${user.name } "></c:out>' class="text-center">${user.name }</td>
	                                            <td title='<c:out value="${user.age } "></c:out>' class="text-center">${user.age }</td>
	                                            <c:choose>
								       				<c:when test="${user.sex == 1}">
								       					<td title="男(male)" class="text-center">男</td>
								       				</c:when>
								       				<c:otherwise>
								       					<td title="女(female)" class="text-center">女</td>
								       				</c:otherwise>
							       				</c:choose>
<%-- 	                                            <td title='<c:out value="${user.sex } "></c:out>' class="center">${user.sex }</td> --%>
	                                            <td title='<c:out value="${user.telphone } "></c:out>' class="text-center">${user.telphone }</td>
	                                            <td title='<c:out value="${user.address } "></c:out>' class="text-center">${user.address }</td>
	                                            <td title='<c:out value="${user.accountId } "></c:out>' class="text-center">${user.accountId }</td>
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
     <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
