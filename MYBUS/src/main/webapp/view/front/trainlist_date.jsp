<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getContextPath()); 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${not empty pageVO}">
	<c:if test="${not empty pageVO.details}">
	<c:forEach varStatus="vs" var="scheduleview" items="${pageVO.details}">
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
             <td title='<c:out value="${scheduleview.train.number } "></c:out>' class="text-center"><a href="javascript:void(0)" onclick="showSite('${scheduleview.train.id }')">${scheduleview.train.number }</a></td>
             <td title='<c:out value="${scheduleview.beginSite.name } "></c:out>' class="text-center">${scheduleview.beginSite.name }</td>
             
             <td title='<c:out value="${scheduleview.endSite.name } "></c:out>' class="text-center">${scheduleview.endSite.name }</td>
             <td title='<fmt:formatDate value="${scheduleview.departureTime }" pattern="yyyy-MM-dd HH:mm" />' class="text-center">
				<fmt:formatDate value="${scheduleview.departureTime }" pattern="HH:mm" />
			</td>
			<td title='<fmt:formatDate value="${scheduleview.arrivalTime }" pattern="yyyy-MM-dd HH:mm" />' class="text-center">
			<fmt:formatDate value="${scheduleview.arrivalTime }" pattern="HH:mm" />
			<c:choose>
				<c:when test="${scheduleview.numberDay==0}">(即日)</c:when>
				<c:when test="${scheduleview.numberDay==1}">(次日)</c:when>
				<c:when test="${scheduleview.numberDay==2}">(隔日)</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			</td>
<!-- 		   发车时间的这个有问题   不能显示出来      现在可以了    是get和set的问题   以后要注意  -->
             <td title='<c:out value="${scheduleview.time } "></c:out>' class="text-center">${scheduleview.time }</td>
             <td class="text-center">
<%--           		<button class="btn btn-danger btn-sm"  onclick="product('${scheduleview.id }','${scheduleview.train.id }','${scheduleview.beginSite.id }','${scheduleview.endSite.id }','${scheduleview.departureTime }','${scheduleview.arrivalTime }','${scheduleview.numberDay }','${scheduleview.price }')"><i class="fa fa-check-circle"></i> Schedule</button> --%>
<%--           		<a class="btn btn-danger btn-sm" href="${path}/view/front/initorder.jsp?id=${scheduleview.id } &trainId=${scheduleview.train.id }&beginSiteId=${scheduleview.beginSite.id }&endSiteId=${scheduleview.endSite.id }"  ><i class="fa fa-check-circle"></i> Schedule</a> --%>
          		<a class="btn btn-danger btn-sm" href="${path}/luwei/order/initorder/${scheduleview.id } /${scheduleview.train.id }/${scheduleview.beginSite.id }/${scheduleview.endSite.id }/${scheduleview.departureTime }/${scheduleview.arrivalTime }/${scheduleview.numberDay }/${scheduleview.price }"  ><i class="fa fa-check-circle"></i> 预定</a>
             </td>
         </tr>
       </c:forEach>
   </c:if>
</c:if>