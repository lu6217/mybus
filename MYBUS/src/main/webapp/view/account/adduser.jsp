<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>

	<form id="addUserForm" name="addUserForm" method="post" action="${path }/luwei/account/adduser">
		<center>
			<table>
				<input type="hidden" name="accountId" id="accountId" value="1">
				username:<input type="text" id="name" name="name" /><br>
				sex:男<input type="radio" name="sex" value="1" /> 
				女<input type="radio" name="sex" value="0" /><br>
				cardType:<select name="cardType" id="cardType" class="form-control">
					<option value="1"> 身份证 </option>
					<option value="10">军官证</option>
					<option value="20">学生证</option>
				</select><br>
				card:<input type="text" name="IDcard" id="IDcard" /><br>
				age:<input type="text" name="age" id="age" /><br>
				tel:<input type="text" name="telphone" id="telphone" /><br>
				address:<input type="text" name="address" id="address" /><br>
				<input type="submit" id="addUserS" value="提交" />
				
			</table>
		</center>
	</form>
</body>
</html>