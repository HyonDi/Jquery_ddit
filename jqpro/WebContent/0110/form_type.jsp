<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form_type.jsp</title>
</head>
<body>

<h1> JSP : Java Server Page </h1>
<h2> 클라이언트에서 전송(제출/요청)시 입력되어진 값들을 전송받는다. </h2>
<h3> 전송받은 값들을 이용해서 어떤 처리를 한다.(대체로 DB처리 (99.9%))</h3>
<h4> 처리된 결과를 이용하여 응답(response)페이지를 작성한다.</h4>
<h4> 요청시 값 받기 : request.getParameter("name")</h4>
<%
	request.setCharacterEncoding("UTF-8");

	String uid = request.getParameter("id");
	String upass = request.getParameter("pass");
	String uname = request.getParameter("name"); /* hidden으로돼있음. */
	String ugender = request.getParameter("gender");
	
	//복수일경우 아래와같이 배열형태로 받는다.
	String ulike[] = request.getParameterValues("like");
	String str = "";
	//아래는 ulike의 본래값을 부르기위해 작성한 for문.
	for(int i = 0; i < ulike.length; i++){
		//form_type1 파일 실행 전 :ulike.length 가 0이어서 에러발생.
		str += " [ " + ulike[i] + " ]  ";
	}
	String ufile = request.getParameter("file");
%>

<h1>결과</h1>
<div>
<!-- 결과 다같이 효과주려면 div로 효과를 주고 따로주려면 span으로 묶는다. -->
	<span> 아이디 : <%= uid %></span><br>
	이름 : <%= uname %><br>
	<%-- 관심분야 : <%= ulike %> --%>
	<!--이렇게하면 참조주소가 나온다. 본래값을 부르려면 for문사용-->
	관심분야 : <%= str %><br>
	성별 : <%= ugender %><br>
	첨부파일 : <%= ufile %><br>
	
</div>



</body>
</html>