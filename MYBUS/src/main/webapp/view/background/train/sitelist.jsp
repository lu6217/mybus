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
      <div class="panel panel-default">
         <div class="panel-body">
             <div class="table-responsive">
             <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                     <thead >
                         <tr>
                             <th class="text-center" width="20%">站序</th>
                             <th class="text-center" width="20%">站名</th>
                             <th class="text-center" width="20%">到站时间</th>
                             <th class="text-center" width="20%">发车时间</th>
                             <th class="text-center" width="20%">停留时间</th>
                         </tr>
                     </thead>
                     <tbody>
                     <c:if test="${not empty train_sites}">
                     	<c:forEach varStatus="vs" var="train_site" items="${train_sites}">
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
	                             <td>${vs.count }</td>
	                             <td>${train_site.id }</td>
<!-- 	                             vs.count的第一个是1 不是0 -->
	                             <c:choose>
   									<c:when test="${train_site.number==1}">  
   										<td>---</td>
	                             	</c:when>
	                            	<c:otherwise>
	                             		<td>${train_site.arrivalTime }</td>
								  	</c:otherwise>
								 </c:choose>
								 <c:choose>
   									<c:when test="${train_site.number==0}">  
   										<td>---</td>
	                             	</c:when>
	                            	<c:otherwise>
	                             		<td>${train_site.departureTime }</td>
								  	</c:otherwise>
								 </c:choose>
	                             <td>time</td>
	                         </tr>
                         </c:forEach>
                       </c:if>
                     </tbody>
                 </table>
             </div>
            </div>
    </div>
  </div>
</body>
</html>
