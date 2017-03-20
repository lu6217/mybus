<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create train</title>
</head>
<body>

<form id="createtrainform" name="reatetrainform" method="post" action="${path }/luwei/train/create" >
		<center>
			<table name="createtable">
				<h1>Create Train</h1>
				<tr>
					车次：<input type="text" name="number" id="number" onblur="checkName()" /><span id="namespan" ></span>
				</tr><br>
				<tr>
					始发站：<input type="text" name="beginSite" id="beginSite" onblur="checkPwd()" /><span id="pwdspan"></span>
				</tr><br>
				<tr>
					目的地：<input type="text" name="endSite" id="endSite" onblur="checkPwd2()" /><span id="pwd2span"></span>
				</tr><br>
				<tr>
					全票价：<input type="text" name="price" id="price" onblur="checkPwd2()" /><span id="pwd2span"></span>
				</tr><br>
				<tr>
					座位数：<input type="text" name="num" id="num" onblur="checkPwd2()" /><span id="pwd2span"></span>
				</tr><br>
				<tr>
					发车时间：<input type="text" name="StartTime" id="StartTime" onblur="checkPwd2()" /><span id="pwd2span"></span>
				</tr><br>
				<tr>
					<input type="reset" value="重置" />
					<input type="button" id="reg" value="提交" />
				</tr>
				<br><hr/>
<!-- 				<tr> -->
<%-- 					<a href="${path }/view/login.jsp">去登陆</a> --%>
<!-- 				</tr> -->
			</table>
		</center>
	</form>
	<script type="text/javascript">
	
	</script>



</body>
</html>