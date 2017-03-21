<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create train</title>
<script src="${path}/js/laydate/laydate.js"></script>

<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/js/laydate/date/bootstrap-clockpicker.min.css">
</head>
<body>

<form id="createtrainform" name="reatetrainform" method="post" action="${path }/luwei/train/create" >
		<center>
			<table name="createtable">
				<h1>Create Train</h1>
				<tr>
					车次：<input type="text" name="number" id="number" onblur="" /><span id="namespan" ></span>
				</tr><br>
				<tr>
					始发站：<input type="text" name="beginSite" id="beginSite" onblur="" /><span id="pwdspan"></span>
				</tr><br>
				<tr>
					目的地：<input type="text" name="endSite" id="endSite" onblur="" /><span ></span>
				</tr><br>
				<tr>
					全票价：<input type="text" name="price" id="price" onblur="" /><span ></span>
				</tr><br>
				<tr>
					座位数：<input type="text" name="num" id="num" onblur="" /><span ></span>
				</tr><br>
				<tr>
					发车时间：<div class="input-group clockpicker" style="width: 110px;margin-bottom: 10px;">
							    <input type="text" id="StartTime" name="StartTime" class="form-control" value="08:00">
							    <span class="input-group-addon">
							        <span class="glyphicon glyphicon-time"></span>
							    </span>
							</div>
				</tr><br>
				<tr>
					<input type="reset" value="重置" />
					<input type="submit" id="create" value="提交" />
				</tr>
				<br><hr/>
<!-- 				<tr> -->
<%-- 					<a href="${path }/view/login.jsp">去登陆</a> --%>
<!-- 				</tr> -->
			</table>
		</center>
	</form>
	<script type="text/javascript" src="${path}/js/laydate/date/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/laydate/date/bootstrap-clockpicker.min.js"></script>
	<script type="text/javascript">
		$('.clockpicker').clockpicker();
	</script>



</body>
</html>