package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class ListPage
 */
@WebServlet("/ListPage")
public class ListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 
		int spage = Integer.parseInt(request.getParameter("page"));
		
		// 1. 
		IBoardService service = BoardServiceImpl.getService();
		
		// 2.
		int totalcount = service.totalList();
		int perlist = 3; // 한 페이지당 몇개씩 출력
		int perpage = 3; //한 화면에 보여지는 페이지의 갯수
		
		
		// 총 페이지 수 
		int totalpage = (int)Math.ceil((double)totalcount / perlist);
		
		
		
		// 시작페이지, 끝페이지[1][2]	[3][4]	[5][6]
		int startpage = ((spage-1) / perpage * perpage) + 1;
		int endpage = startpage + perpage - 1;
		if(endpage > totalpage) endpage = totalpage;
		
		
		// 시작번호, 끝번호
		// [1]  ->  1, 5			[2] -> 6, 10		[3] -> 11, 15
		int start = (spage -1) * perlist + 1;
		int end = start + perlist - 1;
		
		if(end > totalcount) end = totalcount;
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("start", start);
		map.put("end", end);
		
		
		List<BoardVO> list = service.listPage(map);
		System.out.println(list.size() + " servlet++++++++++++");
		
		// 3. 
		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		//request.setAttribute("spage", spage);
		
		// 4.
		request.getRequestDispatcher("board/listPage.jsp").forward(request, response);
		
		
		
	}

}
