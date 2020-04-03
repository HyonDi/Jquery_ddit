<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link_rel="stylesheet" href="../CSS/mystyle.css">
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String text = request.getParameter("area");
	
	text = text.replaceAll("\\r\\n","<br>");
%>

<pre>
textarea에 입력한 내용 중에는 Enter기호('\r\n')가 삽입되어 있다.<br>
Enter 기호를 줄바꿈태그 &lt;br&gt; 로 변환(변경,replaceAll)해서 출력해야 한다.<br>
text = text.replaceAll("\\r\\n","&lt;br&gt;");
</pre>
<h1>처리결과</h1>

<br>
<br>
<div>
<strong>이름</strong> : <%= name %>
<br><br>
<strong>내용</strong> : <br>
<div>
<%= text %>
</div>
</div>
</body>
</html>