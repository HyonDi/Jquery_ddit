package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdList
 */
@WebServlet("/p.do")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 요청시 client에서 값을 전달 받는다. - lprod_gu값을 받는다.
		String lgu = request.getParameter("lprod_gu"); 
		// lprod_gu : ajax에서 넘어온다.
		// url, data 쓰는 곳에 { "lprod_gu" : "asdasd" } 여기 앞 키값이랑 파라미터랑 일치해야함.
		
		// 1. service 객체를 얻어오기.
		IProdService service = ProdServiceImpl.getService();
		
		// 2. service 메서드 호출하기. - 결과값 받기.
		List<ProdVO> list = service.prodNames(lgu);
		
		// 3. 결과값을 request에 저장하기.
		request.setAttribute("list", list);// value list = 위에서 만든 LprodVO타입의 List.
		// 이거를 jsp에 가져가야해.
		
		// 4. 이 결과값을 출력(json데이터 생성)하기위해 view페이지로 이동한다.
		RequestDispatcher disp = request.getRequestDispatcher("0224/prodNoName.jsp");
		// view페이지로 이동시 forword 방식으로 이동한다.
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 요청시 client에서 값을 전달 받는다. - 없다.
		String pid = request.getParameter("prod_id");
		
		// 1. service 객체를 얻어오기.
		IProdService service = ProdServiceImpl.getService();
		
		// 2. service 메서드 호출하기. - 결과값 받기.
		ProdVO vo = service.prodDetail(pid);
		
		// 3. 결과값을 request에 저장하기.
		request.setAttribute("prodVO", vo);// value list = 위에서 만든 LprodVO타입의 List.
		// 이거를 jsp에 가져가야해.
		
		// 4. 이 결과값을 출력(json데이터 생성)하기위해 view페이지로 이동한다.
		RequestDispatcher disp = request.getRequestDispatcher("0224/prodDetail.jsp");
		// view페이지로 이동시 forword 방식으로 이동한다.
		disp.forward(request, response);
	}

}
