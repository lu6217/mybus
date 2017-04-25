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
    <title>SiteList</title>
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
             <jsp:include page="/view/background/common/sidebar.jsp?item=siteList"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Site List <small>site tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             site table
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="text-center" width="30%">name</th>
                                            <th class="text-center" width="30%">description</th>
                                            <th class="text-center" width="40%">Options</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:if test="${not empty pageVO}">
      										<c:if test="${not empty pageVO.details}">
      										<c:forEach varStatus="vs" var="site" items="${pageVO.details}">
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
	                                            <td title='<c:out value="${site.name } "></c:out>' class="text-center">${site.name }</td>
	                                            <td title='<c:out value="${site.description } "></c:out>' class="text-center">${site.description }</td>
	                                            <td class="text-center">
													<button class="btn btn-success btn-sm" onclick="adds('${site.id }')"><i class="fa fa-plus"></i> Add</button>
	                                            	<button class="btn btn-default btn-sm"><i class=" fa fa-refresh "></i> Update</button>
													<button class="btn btn-primary btn-sm" onclick="edits('${site.id }')"><i class="fa fa-edit "></i> Edit</button>
													<button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i> Delete</button>
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
         <footer><p>Copyright &copy; 2017..</p></footer>
        </div>
    </div>
   </div>
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
  <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script type="text/javascript">
         $(document).ready(function () {
             $('#dataTables-example').dataTable();
         });
         function edits(id){
          	layer.open({
       		  type: 2, 
       		  title: ['UserInfo','font-size:25px;'],
       		  area:['600px','500px'],
       		  content: '${path}/luwei/account/get/'+id,
       		  btn:['Close']
       		 
       		}); 
          }
          
         function adds(id){ 
         	layer.open({
         		  type: 2, 
         		  title: ['AddSite','font-size:25px;'],
         		  area:['600px','500px'],
         		  content:'${path}/luwei/site/tocreatesite/'+id,
//          		  content: '${path}/view/background/account/adduser.jsp?accountId='+id,
         		  btn:['Close'],
         		  anim: 0,		//0-6 窗口的弹出动画效果
         		  tips:1	
         		}); 
         };
        
            
    </script>
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>