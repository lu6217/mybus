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
    <title>UserInfo</title>
</head>
<body style="padding: 10px; line-height: 10px; background-color: #393D49; color: #fff; font-weight: 300;">
      <form role="form">
            <p>Name: <span>${user.name }</span></p>
          
            <p>IDcard: <span>${user.IDcard }</span></p>
           
            <p>Age: <span>${user.age }</span></p>
          
            <p>Sex: 
	            <c:choose>
	  				<c:when test="${user.sex == 1}">
	  					<span>男</span>
	  				</c:when>
	  				<c:when test="${user.sex == 0}">
	  					<span>女</span>
	  				</c:when>
	 			</c:choose>
            </p>
          
            <p>Telphone: <span>${user.telphone }</span></p>
           
            <p>Address: <span>${user.address }</span></p>
          
           <p>Account: <span>${user.account.name }</span></p>
   	</form>
</body>
</html>
