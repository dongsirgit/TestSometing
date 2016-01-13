<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basepath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#test1').click(function(){
			$.ajax({
				url:'<%=basepath%>/testAjax',
				type:'post',
				dataType:'text',
				data:{id:1},
				success:function(data){
					alert(eval(data));
				}
			});
		});
	})
</script>
</head>
<body>
	<input id="test1" type="button" value="测试ajax" >
</body>
</html>