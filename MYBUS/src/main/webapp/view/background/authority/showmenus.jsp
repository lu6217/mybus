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
    <title>TrainSiteList</title>
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
<!--                           	<th class="text-center" width="10%">编号</th> -->
                             <th class="text-center" width="30%">名称</th>
                             <th class="text-center" width="40%">URL</th>
                             <th class="text-center" width="30%">图标</th>
<!--                              <th class="text-center" width="20%">发车时间</th> -->
<!--                              <th class="text-center" width="20%">停留时间</th> -->
                         </tr>
                     </thead>
                     <tbody>
                     <c:if test="${not empty menus}">
                     	<c:forEach varStatus="vs" var="menu" items="${menus}">
	                        <c:choose>  
							 	 <c:when test="${vs.count%4==0}">  
					             <tr class="success" ondblclick="editmenu('${menu.id }')">
					           	 </c:when> 
					           	 <c:when test="${vs.count%4==1}">  
					           		<tr class="info" ondblclick="editmenu('${menu.id }')">
					           	 </c:when> 
					           	 <c:when test="${vs.count%4==2}">  
					           		<tr class="warning" ondblclick="editmenu('${menu.id }')">
					           	 </c:when> 
					           	 <c:when test="${vs.count%4==3}">  
					           		<tr class="danger" ondblclick="editmenu('${menu.id }')">
					           	 </c:when> 
							</c:choose>  
<%-- 	                             <td class="text-center">${vs.count }</td> --%>
	                             <td title='<c:out value="${menu.name } "></c:out>' class="text-center">${menu.name }</td>
           						  <td title='<c:out value="${menu.url } "></c:out>' class="text-center">${menu.url }</td>
             
            					 <td title='<c:out value="${menu.icon } "></c:out>' class="text-center"><i class="${menu.icon }"></i></td>
	                         </tr>
                         </c:forEach>
                       </c:if>
                     </tbody>
                 </table>
             </div>
            </div>
    </div>
  </div>
   <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
  <script>
 	 function editmenu(menuId){
  		layer.open({
 		  type: 2, 
 		  title: ['EditMenu','font-size:25px;'],
 		  area:['380px','300px'],
 		  content:'${path}/luwei/authority/toeditmenu/'+menuId,
 		  btn:['Close']
 		}); 
  	
  }
  
  </script>
  <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
</body>
</html>
