package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class ZipCode
 */
@WebServlet("/ZipCode")
public class ZipCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 여서 request 인코딩해야함
		request.setCharacterEncoding("UTF-8");
		
		// 0. 요청시 client에서 값을 전달 받는다. - 입력한 id를 가져와야함.(텍스트필드 아이디부분에 작성한 id)
		String dong = request.getParameter("dong");
				
		// 1. service 객체를 얻어오기.
		IMemberService service = MemberServiceImpl.getService();
		
		// 2. service 메서드 호출하기. - 결과값 받기.
		List<ZipVO> list = service.selectByDong(dong);
		
		// 3. 결과값을 request에 저장하기.
		request.setAttribute("list", list);
		// 이거를 jsp에 가져가야해.
		
		
		// 4. 이 결과값을 출력(json데이터 생성)하기위해 view페이지로 이동한다.
		RequestDispatcher disp = request.getRequestDispatcher("0226/zipsearch.jsp");
		
		// view페이지로 이동시 forword 방식으로 이동한다.
		disp.forward(request, response);
	}

}
