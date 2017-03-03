<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateType</title>
</head>
<body>


	<form id="updateForm" name="updateForm" method="post" action="${path }/luwei/account/updatetype">
		<center>
			<table>
				<input type="hidden" id="accountId" name="accountId" value="2" />
				<select name="type" id="type" class="form-control">
					<option value="1"> - Admin - </option>
					<option value="10">General</option>
					<option value="20">Manager</option>
				</select>
				<input type="submit" id="updateTypeS" value="确定" />
				
			</table>
		
		</center>
	
	</form>

</body>
</html>