<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
// 클라이언트 요청시 전달되는 값을 받는다. -> 없다.

// 처리(CRUD)한다.
// 1. SqlMapClient객체 얻어오기.
//SqlMapClient client = sqlMapClientFactory.getSMClient();

// 2. mapper파일의 namespace이름(member)과 id(listAll)이름을 이용하여 sql문 실행.
//  -> 결과를 받는다.
//List<LprodVO> list = client.queryForList("lprod.listLprod");
List<ProdVO> list = (List<ProdVO>)request.getAttribute("list");
// 요기list는 바꿔도돼										// 이건바꾸면안돼

// 3.  list에서 한줄씩 꺼내어 json object배열을 만든다.
// (배열은 대괄호.) for문돌릴거야.


for(int i = 0; i < list.size(); i++){
	ProdVO vo = list.get(i);
	if(i>0) out.print(",");

%>

{
	"id" : "<%= vo.getProd_id() %>",
	"name" : "<%= vo.getProd_name() %>"
}

<%
}
%>
		
]
