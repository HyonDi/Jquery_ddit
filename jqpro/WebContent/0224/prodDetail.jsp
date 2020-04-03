<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	ProdVO vo = (ProdVO)request.getAttribute("prodVO");

%>

{
<%//res.id res.qin %>
"id" : " <%= vo.getProd_id() %>",
"name" : "<%= vo.getProd_name() %>",
"lgu" : "<%= vo.getProd_lgu() %>",
"price" : "<%= vo.getProd_price() %>",
"cost" : "<%= vo.getProd_cost() %>",
"color" : "<%= vo.getProd_color() %>",
"out" : "<%= vo.getProd_outline() %>",
"qin" : "<%= vo.getProd_qtyin() %>",
"pstock" : "<%= vo.getProd_properstock() %>",
"qsale" : "<%= vo.getProd_qtysale() %>",
"buyer" : "<%= vo.getProd_buyer() %>",
"size" : "<%= vo.getProd_size() %>",
"tstock" : "<%= vo.getProd_totalstock() %>"

}