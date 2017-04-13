<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> addTrainSite</title>
</head>
<body>

<form id="addtrainsiteform" name="addtrainsiteform" method="post" >
		<center>
			<table>
				<h1>addTrainSite</h1>
				<tr>
					车次：<input type="text" name="number" id="number" onblur="checkName()" /><span id="namespan" ></span>
				</tr><br>
				<tr>
					前一站名：<input type="text" name="prevsite" id="prevsite" onblur="" /><span id="pwdspan"></span>
				</tr><br>
				<tr>
					站点名：<input type="text" name="site" id="site" onblur="" /><span ></span>
				</tr><br>
				<tr>
					票价：<input type="text" name="price" id="price" onblur="" /><span ></span>
				</tr><br>
				<tr>
					到站时间：<input type="text" name="num" id="num" onblur="" /><span ></span>
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
					<input type="button" id="create" value="提交" />
				</tr>
				<br>
			</table>
		</center>
	</form>
</body>
</html>