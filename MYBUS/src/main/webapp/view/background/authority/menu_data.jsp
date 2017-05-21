<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getContextPath()); 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${not empty menus}">
	<c:forEach varStatus="vs" var="menu" items="${menus}">
       <c:choose>  
		 <c:when test="${vs.count%4==0}">  
             <tr class="success" ondblclick="delmenu('${roleId}','${menu.id }')">
           	 </c:when> 
           	 <c:when test="${vs.count%4==1}">  
           		<tr class="info" ondblclick="delmenu('${roleId}','${menu.id }')">
           	 </c:when> 
           	 <c:when test="${vs.count%4==2}">  
           		<tr class="warning" ondblclick="delmenu('${roleId}','${menu.id }')">
           	 </c:when> 
           	 <c:when test="${vs.count%4==3}">  
           		<tr class="danger" ondblclick="delmenu('${roleId}','${menu.id }')">
           	 </c:when> 
		</c:choose>  
             <td title='<c:out value="${menu.name } "></c:out>' class="text-center"><a href="javascript:void(0)" onclick="showSite('${menu.name }')">${menu.name }</a></td>
             <td title='<c:out value="${menu.url } "></c:out>' class="text-center">${menu.url }</td>
             
             <td title='<c:out value="${menu.icon } "></c:out>' class="text-center"><i class="${menu.icon }"></i></td>
             <td title='<c:out value="${menu.upperLevelMenuId } "></c:out>' class="text-center">${menu.upperLevelMenuId }</td>

			<td title='<c:out value="${menu.level } "></c:out>' class="text-center">${menu.level }</td>
             <td title='<c:out value="${menu.leaf } "></c:out>' class="text-center">${menu.leaf }</td>
         </tr>
       </c:forEach>
   </c:if>
