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
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplyList
 */
@WebServlet("/ReplyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 0. int
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		System.out.println("bonum = " + bonum);
		
		// 1. 서비스객체를 만든다.
		 IBoardService service = BoardServiceImpl.getService();
		 
		// 2. 서비스 메소드 호출하기 - 결과값 받기. // public List<ReplyVO> replyList(int bonum);  
		 List<ReplyVO> list = service.replyList(bonum);
		 System.out.println("list = " + list);
		 
		// 3. 결과값을 request. 에 저장
		 request.setAttribute("list", list);
		 
		// 4. View페이지로 forward 하기
		 request.getRequestDispatcher("board/replylist.jsp").forward(request, response);
		 
		
	}

}
