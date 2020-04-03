<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- jsp파일. html파일아님!  -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test.jsp</title>
<style type="text/css">
	span {
	color : red;
	font-size : 1.5em;
	}
</style>
</head>
<body>

<h1>JSP : Java Server Page </h1>
<p>클라이언트에서 요청이 발생하면 발생시의 값을 전달받아서 처리하는 페이지.</p>
<p>html 뿐 아니라 자바문장도 사용할 수 있다.</p>
<p>자바문장을 이용해서 처리 할 때는 &lt;% 자바로 쓴 내용 %&gt; 가 필요하다.
&lt;%  %&gt; 이 사이에 기술.</p>
<p>자바 변수(String name, String pass 등)를 출력 할때는 
&lt;%=  %&gt; 사이에 기술한다.</p><br>

<!-- 폼에서 아래 기호로 넘어온다. -->
<!-- post방식 요청시 한글깨지면  
request.setCharacterEncoding("UTF-8"); 아래에 추가시킨다.-->
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("username");
	String pass = request.getParameter("userpass");
%>

<%= name %>님 <span>환영합니다.</span><br>
당신의 비밀번호는 <%= pass %> 입니다.<br>
<span>즐거운 하루 되세요.</span>
</body>
</html>