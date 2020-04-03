<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<ProdVO> list = (List<ProdVO>)request.getAttribute("list");

	if(list != null && list.size()>0){
		// 데이터가 있는 경우! sucess 에서 res.sw 가 ok인지 no 인지 구분한다.
		// res.data[i].id
		// res.data[i].name
%>		

{
	"sw" : "ok",
	"data" : [



<%
	for(int i=0; i<list.size(); i++){
		// 포문에서만 배열
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
}

<%
	}else{// 데이터가 없는 경우 : 여기서는 배열 아님.

%>

{
	"sw" : "no"
}

		
<%	
}
%>