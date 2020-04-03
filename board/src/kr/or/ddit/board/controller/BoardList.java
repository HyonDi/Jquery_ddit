package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. ajax요청시, 클라이언트 요청시 파라미터 값 받기 - 없다.
		String spage = request.getParameter("page");
		
		
		// 1. 서비스객체를 만든다.
		 IBoardService service = BoardServiceImpl.getService();
		// 2. 서비스 메소드 호출하기 - 결과값 받기.
		 List<BoardVO> list = service.selectAll();
		// 3. 결과값을 request. 에 저장
		 request.setAttribute("list", list);
		// 4. View페이지로 forward 하기
		 request.getRequestDispatcher("board/list.jsp").forward(request, response);
		
	}

}
