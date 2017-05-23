<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
	request.setAttribute("path2", request.getSession().getServletContext().getRealPath("/images/qrcodeImages"));

%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%-- <img src='${path2 }/${order.id}.jpg'  alt="二维码"  /> --%>
<%-- 	<img src='E:/myBusGit/mybus/MYBUS/src/main/webapp/images/qrcodeImages/${order.id}.jpg'  alt="二维码"  /> --%>
	<img src='${path }/images/qrcodeI	mages/${order.id}.jpg'  alt="二维码"  />
<%-- 	<img src='${order.qrcodeImg }'  alt="二维码" /> --%>
</center>
</body>
</html>