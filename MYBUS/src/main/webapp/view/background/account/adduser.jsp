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
<%@ include file="/view/background/common/css.jsp" %>
</head>
<body>

<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                        <div class="form-group">
                                            <label>Text Input with Placeholder</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                         <div class="form-group">
                                            <label>Text Input with Placeholder</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                         <div class="form-group">
                                            <label>Text Input with Placeholder</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                         <div class="form-group">
                                            <label>Text Input with Placeholder</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                         <div class="form-group">
                                            <label>Text Input with Placeholder</label>
                                            <input class="form-control" placeholder="Enter text">
                                        </div>
                                        <div class="form-group">
                                            <label>File input</label>
                                            <input type="file">
                                        </div>
                                        <div class="form-group">
                                            <label>Text area</label>
                                            <textarea class="form-control" rows="3"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Inline Radio Buttons</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="option1" checked="">1
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="option2">2
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="option3">3
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <label>Selects</label>
                                            <select class="form-control">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

<!-- ------------------------------------------------------------------- -->
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
	  <jsp:include page="/view/background/common/scripts.jsp" />
</body>
</html>