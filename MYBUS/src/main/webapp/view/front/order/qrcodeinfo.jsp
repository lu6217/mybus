<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
			<p>Train: ${order.train.number } &nbsp; ${order.beginSite.name } - ${order.endSite.name }</span></p>
          
            <p>Seat: <span>${order.seat.compartmentNumber }车厢   ${order.seat.seatNumber }号</span></p>

            <p>User: <span>${order.user.name }</span></p>

          	<p>DepartureTime：<span><fmt:formatDate value="${order.departureTime }" pattern="yyyy-MM-dd HH:mm" /></p>
          	
          	<p>ArrivalTime：<span><fmt:formatDate value="${order.arrivalTime }" pattern="yyyy-MM-dd HH:mm" /></p>
          	
            <p>Price: ${order.price } 元 </p>
	
	</div>


</body>
</html>