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
                    <div class="jumbotron">
                        <h1>Jumbotron</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing.</p>
                        <p>
                            <a class="btn btn-primary btn-lg" role="button">Learn more</a>
                        </p>
                    </div>
                </div>
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
                                   				<a href="" style="padding:10px;line-height:15px;">${information.title } </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                   			</c:if>
                                   			</c:forEach>
    								</c:if>
                                    
                                    <a href="" style="padding:10px;line-height:15px;">关于调整互联网、电话订票起售时间的公告 </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">上海铁路局关于2017年5月30日增开部分旅客列车的公告  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">哈尔滨铁路局关于加格达奇-韩家园4059次旅客列车调整的公告  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">成都铁路局关于部分客车停运、停站调整的通知  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">成都铁路局关于加开部分旅客列车的公告 </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">青藏铁路公司关于加开动车组列车的通知  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
<!--                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
                                </div>
                                <div class="tab-pane fade" id="messages">
<!--                                     <h4  style="padding:10px;line-height:20px;">Messages Tab</h4> -->
									<br>
									<c:if test="${not empty informations}">
      										<c:forEach varStatus="vs" var="information" items="${informations}">
                                   			<c:if test="${information.type==30 }">
                                   				<a href="" style="padding:10px;line-height:15px;">${information.title } </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                   			</c:if>
                                   			</c:forEach>
    								</c:if>
    								
                                    <a href="" style="padding:10px;line-height:15px;">实行车票实名制时，可以使用哪些身份证件？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">什么是实名制车票？  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">为什么有“硬卧代硬座”和“软卧代软座或二等座”车票？  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">如何购买优待（惠）车票？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">什么是异地票、联程票和往返票？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">什么是直达票、通票？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
<!--                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
                                </div>
                                <div class="tab-pane fade" id="settings">
<!--                                     <h4  style="padding:10px;line-height:30px;">Settings Tab</h4> -->
                                    <br>
                                    <c:if test="${not empty informations}">
      										<c:forEach varStatus="vs" var="information" items="${informations}">
                                   			<c:if test="${information.type==20 }">
                                   				<a href="" style="padding:10px;line-height:15px;">${information.title } </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                   			</c:if>
                                   			</c:forEach>
    								</c:if>
                                    <a href="" style="padding:10px;line-height:15px;">铁路旅客信用信息记录期限为多长时间？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">纳入铁路旅客信用信息，旅客有异议时如何办理？  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">铁路进站乘车禁止和限制携带物品  </a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">旅客持银行卡购票后需退票时，如果银行卡处于挂失、冻结、销卡状态，无法退款怎么办？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">《铁路旅客信用记录管理办法（试行）》制定依据是什么？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
                                    <a href="" style="padding:10px;line-height:15px;">哪些失信行为，将纳入铁路旅客信用信息记录管理？</a><hr style=" height:1px;border:none;border-top:0px dotted;" />
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
	 <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>

</body>

</html>