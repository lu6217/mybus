<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
// 	request.setAttribute("scheduleViewId", request.getParameter("id"));
// 	request.setAttribute("trainId", request.getParameter("trainId"));
// 	request.setAttribute("beginSiteId", request.getParameter("beginSiteId"));
// 	request.setAttribute("endSiteId", request.getParameter("endSiteId"));

%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>initOrder</title>
    <%@ include file="/view/background/common/css.jsp" %>
    <!-- TABLE STYLES-->
    <link href="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${path}/css/jquery-ui.min.css">
</head>
<body>
 <div id="wrapper">
       <jsp:include page="/view/background/common/header.jsp" />
        <!--/. NAV TOP  -->
         <nav class="navbar-default navbar-side" role="navigation">
<!-- 		<div id="sideNav" href=""><i class="fa fa-caret-right"></i></div> -->
             <jsp:include page="/view/background/common/sidebar.jsp?item=trainList"/>
        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            Train <small>train tables</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             
                        </div>
                        <div class="panel-body">
                       <form role="form" id="orderform" name="orderform" >
                        <div class="form-group">
						  <div class="input-group ">
						  
						  <div class="input-group ">
                               <label>Train Info</label>
                                <input type="hidden" name="scheduleId" id="scheduleId" value="${scheduleView.id }">
                                <input type="hidden" name="trainId" id="trainId" value="${scheduleView.train.id }">
                                <input type="hidden" name="numberDay" id="numberDay" value="${scheduleView.numberDay }">
                                <input type="hidden" name="beginSiteId" id="beginSiteId" value="${scheduleView.beginSite.id }">
                                <input type="hidden" name="departureTime" id="departureTime" value="${scheduleView.departureTime }">
                                <input type="hidden" name="endSiteId" id="endSiteId" value="${scheduleView.endSite.id }">
                                <input type="hidden" name="arrivalTime" id="arrivalTime" value="${scheduleView.arrivalTime }">
                                 <input type="hidden" name="price" id="price" value="${scheduleView.price }">
                              <p class=""><span id=""><fmt:formatDate value="${scheduleView.departureTime }" pattern="yyyy-MM-dd" /> </span>
                              		&nbsp;<span id="" name="">${scheduleView.train.number }次</span>
                              		&nbsp;<span id="" name="" value="">${scheduleView.beginSite.name } (</span> 
                              		&nbsp;<span id="" name="" ><fmt:formatDate value="${scheduleView.departureTime }" pattern="HH:mm" /> 开)</span>
                              		&nbsp;-- <span id="" name="" value="">${scheduleView.endSite.name } (</span> 
                              		
                              		<c:if test="${scheduleView.numberDay ==1}">
                              		<span>次日</span>
                              		</c:if>
                              		<c:if test="${scheduleView.numberDay ==2}">
                              		<span>隔日</span>
                              		</c:if>
                              		&nbsp;<span id="" name=""><fmt:formatDate value="${scheduleView.arrivalTime }" pattern="HH:mm" /> 到)</span>
                              </p>
                          </div>
                          <br>
                           <div class="input-group ">
                              <label>User Info</label>
                           </div>
                           
                           <div class="form-group">
                           <i class="fa fa-user fa-fw"></i>
	                         <c:forEach varStatus="vs" var="user" items="${users}">
	                           <label class="checkbox-inline">
	                                    <input type="checkbox" id="c${user.id }" name="userLists" onclick="getUserInfo('${user.id}')" value="${user.id }">${user.name }
	                                </label>
	                           </c:forEach>
                            </div>
                            <hr>
                            <table class="table">
                            	<thead>
	                            	<tr>
<!-- 	                            		<td>序号</td> -->
	                            		<td class="text-center">姓名</td>
	                            		<td class="text-center">证件号码</td>
	                            		<td class="text-center">手机号</td>
	                            		<td class="text-center">操作</td>
	                            	</tr>
	                            </thead>
	                            <tbody>
	                             	<c:forEach varStatus="vs" var="user" items="${users}">
		                            	<tr id="${user.id }" style="display:none">
<%-- 			                            	<td>${vs.count }</td> --%>
			                            	<td class="text-center">${user.name }</td>
			                            	<td class="text-center">${user.IDcard }</td>
			                            	<td class="text-center">${user.telphone }</td>
			                            	<td class="text-center"><button class="btn btn-danger btn-sm"  onclick="hideuser('${user.id }')"><i class="fa fa-trash-o"></i></button></td>
		                            	</tr>
	                            	</c:forEach>
	                            </tbody>
                            </table>
                            <div class="input-group">
                            	<a class="form-control btn btn-success" type="" id="back" value=""></i> 上一步</a>
								<span class="input-group-addon"></span>
                            	<a class="form-control btn btn-success" type="submit" id="reg" value=""><!-- <i class="fa fa-search"> --></i> 提交订单</a>
							</div>
							</div>
                        </div>
                    </form>
                     </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
             <!-- /. PAGE INNER  -->
  </div>
     <jsp:include page="/view/background/common/scripts.jsp" />
     <!-- DATA TABLE SCRIPTS -->
    <script src="${path}/view/moban/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${path}/view/moban/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script src="${path}/js/jquery-ui.min.js"></script>
	<script src="${path}/js/jquery-ui.custom.min.js"></script>
    <script>
            $(document).ready(function () {
            	
                $('#dataTables-example').dataTable();
                $(':radio').click(function(){
	            	var radioVal=$('input[name="optionsRadios"]:checked').val();
	            		if(radioVal=="single"){
	            			searchtrainform.backDate.disabled=true;
	            		}else{
	            			searchtrainform.backDate.disabled=false;
	            		}
            	});
            });
            
            function getUserInfo(id){
            	if(document.getElementById('c'+id).checked){
            		document.getElementById(id).style.display="";
            	}else{
            		document.getElementById(id).style.display="none";
            	}
            }
            
            function hideuser(id){
            	document.getElementById(id).style.display="none";
            }
            
            $("#reg").bind("click",function(){
            //提交之前要先判断有没有选择用户
    			$.post("${path }/luwei/order/createorder",$("#orderform").serialize(),function(data) {
//     				$("#trainlistId").html(data);
    				if(data && data.result){
//    	        			 layer.msg(data.message);
   	        			layer.open({
   	             		  type: 1, 
   	             		  title: ['Tip Info'],
   	             		  area:['260px','180px'],
   	             		  content: '<center><p>订单已提交</p> <p> 支付请点击<a href="${path}/luwei/order/topay" style="color:blue;">订单支付</a></p> <p>查看订单情况请点击<a href="${path }/luwei/order/orderlist" style="color:blue;">未完成订单</a></p></center>',
   	             		  shadeClose: true,//点击窗体外的任意处 关闭窗体
   	             		  btn:['Close']
//   	              		  end:function(){
//   	              			// alert('close');
//   	                 		 window.location.reload();
//   	              		 }
   	             		});
   	        	 	}else{
   	        			 layer.msg(data.message);
   	        		 }
    			}); 
    		});
            
             
    </script>
<!-- 	<script> -->
<!-- // 		layui.use('laydate', function(){ -->
<!-- // 		  var laydate = layui.laydate; -->
		  
<!-- // 		  var start = { -->
<!-- // 			format: 'YYYY-MM-DD', -->
<!-- // 		    min: laydate.now() -->
<!-- // 		    ,max: laydate.now(+30) -->
<!-- // 		    ,istoday: false -->
<!-- // // 		    ,istime: true -->
<!-- // 		    ,choose: function(datas){ -->
<!-- // 		      end.min = datas; //开始日选好后，重置结束日的最小日期 -->
<!-- // 		      end.start = datas //将结束日的初始值设定为开始日 -->
<!-- // 		    } -->
<!-- // 		  }; -->
		  
<!-- // 		  var end = { -->
<!-- // 			format: 'YYYY-MM-DD', -->
<!-- // 		    min: laydate.now() -->
<!-- // 		    ,max: laydate.now(+30) -->
<!-- // 		    ,istoday: false -->
<!-- // // 		    ,istime: true -->
<!-- // 		    ,choose: function(datas){ -->
<!-- // 		      start.max = datas; //结束日选好后，重置开始日的最大日期 -->
<!-- // 		    } -->
<!-- // 		  }; -->
		  
<!-- // 		  document.getElementById('departureDate').onclick = function(){ -->
<!-- // 		    start.elem = this; -->
<!-- // 		    laydate(start); -->
<!-- // 		  } -->
<!-- // 		  document.getElementById('backDate').onclick = function(){ -->
<!-- // 		    end.elem = this -->
<!-- // 		    laydate(end); -->
<!-- // 		  } -->
		  
<!-- // 		}); -->
<!-- 	</script> -->
         <!-- Custom Js -->
    <script src="${path}/view/moban/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
