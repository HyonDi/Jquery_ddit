<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// html코드, 주석 잇으면 안돼
	
	// 클라이언트 요청시 전달되는 값을 받는다.
	// 처리(CRUD)한다.
	// 처리결과를 가지고 응답데이터(jsonObject)를 만든다.
	// 키값은 영어로와야해. 키값 에 공백있으면 안돼.
	// 더블쿼테이션써야해.
	// html에서 값을 꺼내려면 res.name / res.tel / res.addr / res.zip 일케씀
%>

{
  "name" : "홍길동", "tel" : "010-1234-1234", "addr" : "대전 중구 대흥동", "zip" : "03212"
}

