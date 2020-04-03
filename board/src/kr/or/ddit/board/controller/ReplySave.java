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
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplySave
 */
@WebServlet("/ReplySave")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. ajax에서 요청시 값가져오기-reply.bonum, reply.name, reply.cont
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name = request.getParameter("name");
		String cont = request.getParameter("cont");
		// 위를vo에 넣는다.
		ReplyVO vo = new ReplyVO();
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		
		// 1. service객체얻어오기
		IBoardService service = BoardServiceImpl.getService();
		
		// 2. service메서드 호출
		int renum = service.insertReply(vo); //리턴하는건 현재시퀀스값.(cuurrent seq)
		
		// 3. 결과값 저장
		request.setAttribute("renum", renum);
	
		// 4. view페이지로 이동.
		request.getRequestDispatcher("board/replySave.jsp").forward(request, response);
	}

}
