<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>InformationList</title>
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
             <jsp:include page="/view/background/common/sidebar.jsp?item=information"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Information List <small>Information tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             information table
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="text-center" width="20%">Title</th>
                                            <th class="text-center" width="30%">Details</th>
                                            <th class="text-center" width="10%">Type</th>
                                            <th class="text-center" width="15%">CreateDate</th>
                                            <th class="text-center" width="25%">Options</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:if test="${not empty pageVO}">
      										<c:if test="${not empty pageVO.details}">
      										<c:forEach varStatus="vs" var="information" items="${pageVO.details}">
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
	                                            <td title='<c:out value="${information.title } "></c:out>' class="text-center">
		                                            <c:choose>
								   						<c:when test="${fn:length(information.title)>12}">
								   							${fn:substring(information.title, 0, 12)}...
								   						</c:when>
								   						<c:otherwise>
								   							${information.title }
								   						</c:otherwise>
								   					</c:choose>
	                                            </td>
	                                            <td title='<c:out value="${information.details } "></c:out>' class="text-center">
	                                           	 	<c:choose>
								   						<c:when test="${fn:length(information.details)>18}">
								   							${fn:substring(information.details, 0, 18)}...
								   						</c:when>
								   						<c:otherwise>
								   							${information.details }
								   						</c:otherwise>
								   					</c:choose>
	                                            </td>
<%-- 	                                            <td title='<c:out value="${information.type } "></c:out>' class="text-center">${information.type }</td> --%>
	                                            <td title='<c:out value="${information.type } "></c:out>' class="text-center">
	                                             	<c:choose>
														<c:when test="${information.type==10}">新闻动态</c:when>
														<c:when test="${information.type==20}">常见问题</c:when>
														<c:when test="${information.type==30}">铁路常识</c:when>
														<c:otherwise></c:otherwise>
													</c:choose>
	                                             </td>
	                                            <td title='<fmt:formatDate value="${information.createDate }" pattern="yyyy-MM-dd HH:mm" />' class="text-center">
													<fmt:formatDate value="${information.createDate }" pattern="yyyy-MM-dd HH:mm" />
												</td>
<%-- 	                                            <td title='<fmt:formatDate value="${information.departureTime }" pattern="yyyy-MM-dd HH:mm" />' class="text-center"> --%>
<%-- 	                                            	<fmt:formatDate value="${information.departureTime }" pattern="yyyy-MM-dd HH:mm" /> --%>
<!-- 	                                            </td> -->
	                                            <td class="text-center">
<%-- 													<button class="btn btn-success btn-sm" onclick="adds('${site.id }')"><i class="fa fa-plus"></i> Add</button> --%>
<!-- 	                                            	<button class="btn btn-default btn-sm"><i class=" fa fa-refresh "></i> Update</button> -->
													<button class="btn btn-primary btn-sm" onclick="edits('${information.id }')"><i class="fa fa-edit "></i> Edit</button>
													<button class="btn btn-danger btn-sm" onclick="del('${information.id }')"><i class="fa fa-trash-o"></i> Delete</button>
	                                            </td>
	                                        </tr>
	                                        </c:forEach>
    									   </c:if>
   										  </c:if>
                                    </tbody>
                                    <div>
                                   	 <button class="btn btn-success btn-sm" onclick="adds('0')"><i class="fa fa-plus"></i> Add</button>
                                    </div>
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
       		  title: ['AddInformation','font-size:25px;'],
       		  area:['480px','360px'],
       		  content: '${path}/luwei/information/get/'+id,
       		  btn:['Close']
       		 
       		}); 
          }
          
         function adds(id){ 
         	layer.open({
         		  type: 2, 
         		  title: ['AddInformation','font-size:25px;'],
         		  area:['480px','360px'],
         		  content:'${path}/luwei/information/toaddinformation/'+id,
//          		  content: '${path}/view/background/account/adduser.jsp?accountId='+id,
         		  btn:['Close'],
         		  anim: 0,		//0-6 窗口的弹出动画效果
         		  tips:1	
         		}); 
         };
        
         function del(id){
        	 layer.msg('确定要删除此数据信息?', {
        		  time: 20000, //20s后自动关闭
        		  btn: ['残忍删除', '火速取消'],
        		  yes: function(){
        			  $.ajax({
        				 type:"POST",
  		    		     url:"${path}/luwei/information/delinformation",
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
