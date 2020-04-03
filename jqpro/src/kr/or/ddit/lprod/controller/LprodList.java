package kr.or.ddit.lprod.controller;

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

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 요청시 client에서 값을 전달 받는다. - 없다.
		
		// 1. service 객체를 얻어오기.
		ILprodService service = LprodServiceImpl.getService();
		
		// 2. service 메서드 호출하기. - 결과값 받기.
		List<LprodVO> list = service.listLprod();
		
		// 3. 결과값을 request에 저장하기.
		request.setAttribute("list", list);// value list = 위에서 만든 LprodVO타입의 List.
		// 이거를 jsp에 가져가야해.
		
		// 4. 이 결과값을 출력(json데이터 생성)하기위해 view페이지로 이동한다.
		RequestDispatcher disp = request.getRequestDispatcher("0224/lprod.jsp");
		// view페이지로 이동시 forword 방식으로 이동한다.
		disp.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
