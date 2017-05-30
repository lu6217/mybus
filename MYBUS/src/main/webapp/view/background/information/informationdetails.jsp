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
    <title>Information Details</title>
	<%@ include file="/view/background/common/css.jsp" %>
     <!-- TABLE STYLES-->
    <link href="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
	<style type="text/css">
/* 		p {color:blue;} */
	</style>
</head>
<body>
	<div id="page-inner">
		<div class="row">
            <div class="col-md-12 col-sm-12">
                <div class="panel panel-success" style="width:80%;height:500px;margin:0px auto;" >
                    <div class="panel-heading">
                        Success Panel
                    </div>
                    <div class="panel-body">
                    	<p style="font-size:25px;">
							<c:choose>
								<c:when test="${information.type==10}">新闻动态</c:when>
								<c:when test="${information.type==20}">常见问题</c:when>
								<c:when test="${information.type==30}">铁路常识</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</p><hr>
                    	<p class="text-center" style="font-size:30px;">${information.title }</p>
                    	<p class="text-center" >[<fmt:formatDate value="${information.createDate }" pattern="yyyy-MM-dd" />]</p><br>
                        <p>${information.details }</p>
                    </div>
<!--                     <div class="panel-footer"> -->
<!--                         Panel Footer -->
<!--                     </div> -->
                 </div>
              </div>
         </div>
   	</div>     
</body>
</html>