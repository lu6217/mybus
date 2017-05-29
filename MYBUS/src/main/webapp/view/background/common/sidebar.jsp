<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%
	request.setAttribute("path", request.getContextPath());

%>
 <!--/. NAV TOP  -->
       
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				
				    <li>
                        <a <c:if test="${param.item=='booking'}" >class="active-menu"</c:if> href="${path }/luwei/front/train/booking"><i class="glyphicon glyphicon-fire"></i> Book tickets </a>
                    </li>
					<c:if test="${not empty menus }">
						<c:forEach varStatus="vs" var="menu" items="${menus}">
							<li>
		                        <a <c:if test="${param.item=='${menu.item }'}" >class="active-menu"</c:if> href="${path }${menu.url}"><i class="${menu.icon }"></i> ${menu.name }</a>
		                    </li>
						</c:forEach>
					</c:if>
				
<!--                     <li> -->
<%--                         <a <c:if test="${param.item=='accountList'}" >class="active-menu"</c:if> href="${path }/luwei/account/accountlist"><i class="fa fa-dashboard"></i> Account Management</a> --%>
<!--                     </li> -->
<!--                     <li> -->
<%--                         <a <c:if test="${param.item=='userList'}" >class="active-menu"</c:if> href="${path }/luwei/account/userlist"><i class="fa fa-desktop"></i>User Management</a> --%>
<!--                     </li> -->
<!-- 					<li> -->
<%--                         <a <c:if test="${param.item=='trainList'}" >class="active-menu"</c:if> href="${path }/luwei/train/trainlist"><i class="fa fa-bar-chart-o"></i> Train Management</a> --%>
<!--                     </li> -->
<!--                     <li> -->
<%--                         <a <c:if test="${param.item=='siteList'}" >class="active-menu"</c:if> href="${path }/luwei/site/sitelist"><i class="fa fa-qrcode"></i>Site Management</a> --%>
<!--                     </li> -->
                    
<!--                     <li> -->
<%--                         <a <c:if test="${param.item=='orderList'}" >class="active-menu"</c:if> href="${path }/luwei/order/orderlist"><i class="fa fa-table"></i> Order Management</a> --%>
<!--                     </li> -->
<!--                     <li> -->
<%--                         <a <c:if test="${param.item=='authority'}" >class="active-menu"</c:if> href="${path }/luwei/authority/authoritylist"><i class="fa fa-edit"></i> Authority Management </a> --%>
<!--                     </li> -->
<!-- 					<li> -->
<%--                         <a <c:if test="${param.item=='schedule'}" >class="active-menu"</c:if> href="${path }/luwei/schedule/schedulelist"><i class="fa fa-edit"></i> Schedule Management </a> --%>
<!--                     </li> -->

<!--                     <li> -->
<!--                         <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a> -->
<!--                         <ul class="nav nav-second-level"> -->
<!--                             <li> -->
<!--                                 <a href="#">Second Level Link</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="#">Second Level Link</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="#">Second Level Link<span class="fa arrow"></span></a> -->
<!--                                 <ul class="nav nav-third-level"> -->
<!--                                     <li> -->
<!--                                         <a href="#">Third Level Link</a> -->
<!--                                     </li> -->
<!--                                     <li> -->
<!--                                         <a href="#">Third Level Link</a> -->
<!--                                     </li> -->
<!--                                     <li> -->
<!--                                         <a href="#">Third Level Link</a> -->
<!--                                     </li> -->

<!--                                 </ul> -->

<!--                             </li> -->
<!--                         </ul> -->
<!--                     </li> -->
<!--                     <li> -->
<%--                         <a <c:if test="${param.item=='booking'}" >class="active-menu"</c:if> href="${path }/luwei/front/train/booking"><i class="fa fa-edit"></i> Book tickets </a> --%>
<!--                     </li> -->
<!--                      <li> -->
<%--                         <a <c:if test="${param.item=='accountorderList'}" >class="active-menu"</c:if> href="${path }/luwei/order/accountorderlist"><i class="fa fa-table"></i> Order Management</a> --%>
<!--                     </li> -->
                </ul>

            </div>
