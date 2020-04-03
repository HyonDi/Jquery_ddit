<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function gogo(a){
		history.go(a);
	}
</script>
</head>
<body>
<%
	// 클라이언트 요청시 입력값과 hidden 값을 가져온다.
	String namevalue = request.getParameter("abc");
%>

<h1><%= namevalue%> 님 환영합니다.</h1>
<br>
<a href="#" onclick="gogo(-1)">뒤로</a>
</body>
</html>