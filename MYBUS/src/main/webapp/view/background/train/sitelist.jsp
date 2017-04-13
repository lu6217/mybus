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
    <title>TrainList</title>
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
                     <thead>
                         <tr>
                             <th>#</th>
                             <th>First Name</th>
                             <th>Last Name</th>
                             <th>Username</th>
                         </tr>
                     </thead>
                     <tbody>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                         <tr class="success">
                             <td>1</td>
                             <td>Mark</td>
                             <td>Otto</td>
                             <td>@mdo</td>
                         </tr>
                         <tr class="info">
                             <td>2</td>
                             <td>Jacob</td>
                             <td>Thornton</td>
                             <td>@fat</td>
                         </tr>
                         <tr class="warning">
                             <td>3</td>
                             <td>Larry</td>
                             <td>the Bird</td>
                             <td>@twitter</td>
                         </tr>
                         <tr class="danger">
                             <td>4</td>
                             <td>John</td>
                             <td>Smith</td>
                             <td>@jsmith</td>
                         </tr>
                     </tbody>
                 </table>
             </div>
            </div>
    </div>
  </div>
</body>
</html>
