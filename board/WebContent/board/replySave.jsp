<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int renum = (Integer)request.getAttribute("renum");
	if(renum > 0){
%>

{
	"sw" : "<%= renum%> 으로 저장 성공! "
}

<%}else{ %>

{
	"sw" : " 저장 실패! "
}

<%
}
%>

