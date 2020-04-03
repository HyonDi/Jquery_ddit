<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
	
		function historyGo(a){
			history.go(a);
		}
	
	</script>
</head>
<body>
	<h1>JSP</h1>
	<h2>Java Server Page</h2>
	<br>
	되돌아가기(=history.go(뒤로 갈 횟수 num))
	<br>
	
	<!-- <a href="Location_test.html">go</a> 이렇게해도되고 아래처럼해도됨.-->
	<a href="#" onclick="historyGo(-1)">go</a>
	<!-- a href="#" 하면 아무데도 안간다. -->
</body>
</html>