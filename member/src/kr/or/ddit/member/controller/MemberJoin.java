package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.beanutils.BeanUtils;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/MemberJoin")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.클라이언트에서 요청시(전송) 전달값 받기
//		String mid=		request.getParameter("mem_id");
//		String mpass=	request.getParameter("mem_pass");
//		String mname=	request.getParameter("mem_name");
//		String madd1=	request.getParameter("mem_add1");
//		String madd2=	request.getParameter("mem_add2");
//		String mmail=	request.getParameter("mem_mail");
//		String mhp=		request.getParameter("mem_hp");
//		String mzip=	request.getParameter("mem_zip");
//		String mbir=	request.getParameter("mem_bir");
		
		MemberVO vo = new MemberVO();
		
//		vo.setMem_id(mid);
//		vo.setMem_pass(mpass);
//		vo.setMem_name(mname);
//		vo.setMem_add1(madd1);
//		vo.setMem_add2(madd2);
//		vo.setMem_mail(mmail);
//		vo.setMem_hp(mhp);
//		vo.setMem_zip(mzip);
//		vo.setMem_bir(mbir);
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1. service객체 얻기
		IMemberService serv = MemberServiceImpl.getService();
		//2. service메소드 호출- 결과값 받기(저장한 id) , 저장실패시 null값 
		String memid= serv.insertMember(vo);
		//3. 결과값을 request에 저장
		request.setAttribute("resultid", memid);
		request.setAttribute("mid", vo.getMem_id());
		//4. view페이지로 이동
		RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
		rd.forward(request, response);
		
	
	}

}
