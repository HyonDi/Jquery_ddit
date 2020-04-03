<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
 <%
 //배열이니까 <%% 이거전에 [ 대괄호, 끝에 댛괄호 해줘야대					//BuyerList.java 47번줄
 // controller에서 request에 저장된 namelist에 해당하는 value값을 가져온다.
 // namelist = String, value( = Object) 형변환 왜해준다구??? 
 	List<BuyerVO> list = (List<BuyerVO>)request.getAttribute("namelist");
 
 	for(int i=0; i<list.size(); i++){
 		BuyerVO vo = list.get(i);
 		// jason 만들어야해.
 		if(i>0) out.print(",");
 %>
 
 
 {
 	"id" : "<%= vo.getBuyer_id() %>",
 	"name" : "<%= vo.getBuyer_name() %>"
 }
 
 <%
 // 다했으면 html 만들어서 출력만하면 된다!!
 }
 
 %>
 
 ]