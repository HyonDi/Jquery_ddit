<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = (String)request.getAttribute("resId");
	// a001 -> a001       korea  ->  null
	
	String inId = (String)request.getAttribute("inId");
	// a001 -> a001       korea  ->  korea
	
	if(id==null){
		//  아이디 사용 가능 - korea를 입력한 경우.
%>		
	{
		"sw" : "'<%=inId%>'는 사용가능한 ID 입니다."
	}
		
		
<%	
	}else {
		// 아이디 사용 불가능 - a001을 입력한 경우.
%>

	{
		"sw" : "'<%=id%>'는 사용불가능한 ID 입니다."
	}

		
<%	
	}
%>