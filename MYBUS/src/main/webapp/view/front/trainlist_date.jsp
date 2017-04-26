<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getContextPath()); 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
             <td title='<fmt:formatDate value="${schedule.departureTime }" pattern="HH:mm" />' class="text-center">
				<fmt:formatDate value="${schedule.departureTime }" pattern="HH:mm" />
			</td>
			<td title='<fmt:formatDate value="${schedule.arrivalTime }" pattern="HH:mm" />' class="text-center">
			<fmt:formatDate value="${schedule.arrivalTime }" pattern="HH:mm" />
			<c:choose>
				<c:when test="${schedule.numberDay==0}">(即日)</c:when>
				<c:when test="${schedule.numberDay==1}">(次日)</c:when>
				<c:when test="${schedule.numberDay==2}">(隔日)</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			</td>
<!-- 		   发车时间的这个有问题   不能显示出来      现在可以了    是get和set的问题   以后要注意  -->
             <td title='<c:out value="${schedule.time } "></c:out>' class="text-center">${schedule.time }</td>
             <td class="text-center">
          		<button class="btn btn-danger btn-sm"  onclick="product('${schedule.id }')"><i class="fa fa-check-circle"></i> Schedule</button>
             </td>
         </tr>
       </c:forEach>
   </c:if>
</c:if>