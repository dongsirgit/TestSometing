<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basepath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>

<title>Plupload - Custom example</title>

<script type="text/javascript" src="js/plupload.full.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
</head>
<body style="font: 13px Verdana; background: #eee; color: #333">
<pre id="console"></pre>
<script type="text/javascript">
var fdafda =0;
function showTimes(){
	$('#console').html("这是第"+fdafda+"次提示！")
	fdafda++;
	setTimeout("showTimes()",1000*1);//setTimeout:window的方法，定时执行方法。第一个参数为将要执行的方法，第二个参数为定时时间，单位毫秒
}
$(function(){
	showTimes();
})
</script>

<form action="">
	<input type="text">
	<input type="submit">
</form>

</body>
</html>
