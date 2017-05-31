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
    <title>Home</title>
    <%@ include file="/view/background/common/css.jsp" %>
</head>

<body>
    <div id="wrapper">
        <jsp:include page="/view/background/common/header.jsp" />
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>
             <jsp:include page="common/sidebar.jsp"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
        
            <div id="page-inner">
			<div class="row">
			
			 <div class="col-md-12">
			 <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                    <div class="item active">
	                    <img src="${path }/images/qrcodeImages/index1.jpg" alt="index1">
	                    <div class="carousel-caption">
	        				<h3>...</h3>
	   						 <p>...</p>
	                    </div>
                    </div>
                    <div class="item">
	                    <img src="${path }/images/qrcodeImages/index2.jpg" alt="index2">
	                    <div class="carousel-caption">
					        <h3>...</h3>
					   		<p>...</p>
	                    </div>
                    </div>
    				<div class="item">
	                    <img src="${path }/images/qrcodeImages/index3.jpg" alt="index3">
	                    <div class="carousel-caption">
					        <h3>...</h3>
					   		<p>...</p>
	                    </div>
                    </div>
                    </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                    </a>
					</div>
                </div>
<!--                 <div class="col-md-12"> -->
<!--                     <div class="jumbotron"> -->
<!--                         <h1>Train</h1> -->
<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing.</p> -->
<!--                         <p> -->
<!--                             <a class="btn btn-primary btn-lg" role="button">Learn more</a> -->
<!--                         </p> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic Tabs
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#home" data-toggle="tab">Home</a>
                                </li>
                                <li class=""><a href="#profile" data-toggle="tab">最新动态</a>
                                </li>
                                <li class=""><a href="#messages" data-toggle="tab">铁路常识</a>
                                </li>
                                <li class=""><a href="#settings" data-toggle="tab">常见问题</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane fade active in" id="home">
                                    <br>
                                    <h4>Home Tab</h4>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                </div>
                                <div class="tab-pane fade" id="profile">
<!--                                     <h4 style="padding:10px;line-height:20px;">Profile Tab</h4> -->
                                    <br>
                                    <c:if test="${not empty informations}">
      										<c:forEach varStatus="vs" var="information" items="${informations}">
                                   			<c:if test="${information.type==10 }">
                                   				<div>
                                   					<a href="${path }/luwei/front/information/getinformation/${information.id}" target="_blank" style="padding:10px;line-height:15px;">${information.title } </a>
                                   					<span style="float: right;">(<fmt:formatDate value="${information.createDate }" pattern="yyyy-MM-dd" />)</span>
                                   					<hr style=" height:1px;border:none;border-top:0px dotted;" />
                                   				</div>
                                   			</c:if>
                                   			</c:forEach>
    								</c:if>
                                    
<!--                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
                                </div>
                                <div class="tab-pane fade" id="messages">
<!--                                     <h4  style="padding:10px;line-height:20px;">Messages Tab</h4> -->
									<br>
									<c:if test="${not empty informations}">
      										<c:forEach varStatus="vs" var="information" items="${informations}">
                                   			<c:if test="${information.type==30 }">
                                   				<a href="${path }/luwei/front/information/getinformation/${information.id}" target="_blank" style="padding:10px;line-height:15px;">${information.title } </a>
                                   				<span style="float: right;">(<fmt:formatDate value="${information.createDate }" pattern="yyyy-MM-dd" />)</span>
                                   				<hr style=" height:1px;border:none;border-top:0px dotted;" />
                                   			</c:if>
                                   			</c:forEach>
    								</c:if>
    								
<!--                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
                                </div>
                                <div class="tab-pane fade" id="settings">
<!--                                     <h4  style="padding:10px;line-height:30px;">Settings Tab</h4> -->
                                    <br>
                                    <c:if test="${not empty informations}">
      										<c:forEach varStatus="vs" var="information" items="${informations}">
                                   			<c:if test="${information.type==20 }">
                                   				<a href="${path }/luwei/front/information/getinformation/${information.id}" target="_blank" style="padding:10px;line-height:15px;">${information.title } </a>
                                   				<span style="float: right;">(<fmt:formatDate value="${information.createDate }" pattern="yyyy-MM-dd" />)</span>
                                   				<hr style=" height:1px;border:none;border-top:0px dotted;" />
                                   			</c:if>
                                   			</c:forEach>
    								</c:if>
<!--                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
          
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
	<jsp:include page="/view/background/common/scripts.jsp" />
	<script>
	$('.carousel').carousel({
		  interval: 2000
		})
<!-- //             $(document).ready(function () { -->
<%-- //             	window.location.href="${path}/luwei/front/home/index"; --%>
<!-- //             }); -->
    </script>
	 <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
 	
</body>

</html>