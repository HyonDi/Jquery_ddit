<%@page import="kr.or.ddit.ibatis.config.sqlMapClientFactory"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	//클라이언트 요청시 전달되는 값 받기 - 없음
	
	//CRUD
	// 1. SqlMapClient객체 얻어오기
	SqlMapClient client = sqlMapClientFactory.getSMClient();

	// 2. mapper 파일의 namespace이름과 id이름을 이용하여 sql문을 실행하여 결과값을 받기
	List<MemberVO> list = client.queryForList("member.listAll");
	
	// 3. 받은 결과값을 한줄씩 json object배열로 만들어 응답 데이터를 만들기
	// []는 자바 쓰는 공간 밖에...
	for(int i = 0; i < list.size(); i++){
		MemberVO vo = list.get(i);
		if(i > 0) out.print(","); //마지막 json object를 제외하고 ','를 붙이는 방법
	//json을 쓰기 위해 자바쓰는 공간을 닫아준다
%>

	{
		"name" : "<%= vo.getMem_name() %>",
		"tel" : "<%= vo.getMem_hp() %>",
		"addr" : "<%= vo.getMem_add1() %> <%= vo.getMem_add2() %>",
		"id" : "<%= vo.getMem_id() %>",
		"mail" : "<%= vo.getMem_mail() %>"
	}
	
<%		
	}
%>
]
