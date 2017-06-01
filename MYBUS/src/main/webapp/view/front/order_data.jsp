<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", request.getContextPath()); 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${not empty pageVO}">
							<c:if test="${not empty pageVO.details}">
								<c:forEach varStatus="vs" var="order" items="${pageVO.details}">
		                            <div class="table-responsive">
		                            	<p>
		                            		<span>订单日期：<fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd" /></span>
		                            		&nbsp;&nbsp;<span>${order.user.name }</span>
		                            		&nbsp;&nbsp;<span>${order.train.number }</span>
		                            		&nbsp;&nbsp;<span>${order.beginSite.name }</span>
		                            		--->   
		                            		&nbsp;&nbsp;<span>${order.endSite.name }</span>
		                            		&nbsp;&nbsp;<span>乘车日期：<fmt:formatDate value="${order.departureTime }" pattern="yyyy-MM-dd HH:mm" /></span>
		                            	</p>
		                                <table class="table table-striped table-bordered table-hover" id="">
		                                    <thead>
		                                    	
		                                        <tr>
		                                            <th class="text-center" width="6%">ID</th>
		                                            <th class="text-center" width="18%">Train Info</th>
		                                            <th class="text-center" width="12%">Seat Info</th>
		                                            <th class="text-center" width="12%">User Info</th>
		                                            <th class="text-center" width="10%">Price</th>
		                                            <th class="text-center" width="10%">Status</th>
		                                            <th class="text-center"width="32%">Options</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
			                                       
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
													 <td title='<c:out value=""></c:out>' class="text-center">${vs.count }</td>
													  <td title='<c:out value=""></c:out>' class="text-center">
													  	<fmt:formatDate value="${order.departureTime }" pattern="yyyy-MM-dd HH:mm" />开
													  	${order.train.number } &nbsp; ${order.beginSite.name } - ${order.endSite.name }
													  </td>
													   <td title='<c:out value=""></c:out>' class="text-center">
															${order.seat.compartmentNumber }车厢   ${order.seat.seatNumber }号
														</td>
													    <td title='<c:out value=""></c:out>' class="text-center">
															${order.user.name } 二代身份证
														</td>
													     <td title='<c:out value=""></c:out>' class="text-center">
															${order.price } 元
														</td>
													      <td title='<c:out value=""></c:out>' class="text-center">
															${order.status }
														</td>
			                                            <td title='<c:out value=""></c:out>' class="text-center">
			                                            	<c:if test="${order.status =='待支付'}">
																<button class="btn btn-success btn-sm" onclick="topay('${order.id}')"><i class="fa fa-yen"></i> 去支付</button>
															</c:if>
															
															<c:if test="${order.status =='已取消'}">
																<button class="btn btn-danger btn-sm"  onclick="del('${order.id}')" disabled=""><i class="fa fa-trash-o"></i> 取消订单</button>
															</c:if>
															<c:if test="${order.status !='已取消'}">
																<button class="btn btn-danger btn-sm"  onclick="del('${order.id}')"><i class="fa fa-trash-o"></i> 取消订单</button>
															</c:if>
															<c:choose>
																<c:when test="${order.qrcodeStatus ==1}">
																	<button class="btn btn-primary btn-sm" onclick="showQrcode('${order.id}')"><i class="fa fa-qrcode "></i> 查看二维码</button>
																</c:when>
																<c:when test="${order.status =='已支付'}">
																	<button class="btn btn-primary btn-sm" onclick="createQrcode('${order.id}')"><i class="fa fa-qrcode "></i> 生成二维码</button>
																</c:when>
																<c:otherwise>
																	<button class="btn btn-primary btn-sm" onclick="" disabled=""><i class="fa fa-qrcode "></i> 生成二维码</button>
																</c:otherwise>
															</c:choose>
															
														</td>
	                                        </tr>
	                                       
                                  	 	 </tbody>
                              	  	</table>
                           		 </div>
                               </c:forEach>
   							   </c:if>
							</c:if>