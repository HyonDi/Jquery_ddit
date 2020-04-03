package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IbuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerList
 */
@WebServlet("/BuyerList")
public class BuyerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 클라이언트 요청시 전달되는 값을 받는다. -> 없다.
			// 없어서코딩안함.
		// request.getparameter(getname)???
		
		// 1. service 객체를 얻는다.
			IbuyerService service = BuyerServiceImpl.getService();
		
		// 2. service 메서드를 호출한다. -> 결과값을 받는다.(List)
			List<BuyerVO> list = service.nameList();
			System.out.println(list.size()+"!!!!!!!!!!!!!!!!!!!");
			
		// 3. 결과값(list) 를 request에 저장한다.
			request.setAttribute("namelist", list); 
			//키는 String인데 변수이름은 아무거나쓴다.,  value는 위에서만든 list임.
			
		// 4. 출력을 위해 view페이지(jsp)로 이동한다. -> redirect, forword. 두가지있음.
			// redirect : 한 번 서버 밖으로 응답한 후 새로운 request로 재요청하기때문에 컨트롤러와 view가  request와 response를 공유하지못한다.
				// 서버밖으로 나간다.(요청,응답이끝난것. 결과는없음. 그리고 재요청해서 jsp로 보냄.)
				// controller에있던 request 와 response는 사라진거임. 서버밖으로 들어갔다나오면
				// jsp에서 쓸 수 없다.(공유할수없다.)
				// client에서 새로운 request객체로 재요청. 서버밖으로 나갔다가 다시 안으로 들어와 jsp에 출력.
			
			// forword : controller, view 가 request와 response를 공유한다. 
				// 서버내부에서 페이지를 이동한다. 
				// 컨트롤러에있는 request, reponse 를(저장된request의 변수)를 내부jsp(뷰)와 공유할 수 있다.
		// 이동시, request에 저장된 결과값(list)를 jsp페이지로 넘겨준다. 
			RequestDispatcher disp = request.getRequestDispatcher("0221/nameList.jsp");
			
			disp.forward(request, response);
			
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0. 클라이언트 요청시 전달되는 값을 받는다. -> 여긴 있음!!
					String vid = request.getParameter("id");
					System.out.println(vid+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				// request.getparameter(getname)???
				
				// 1. service 객체를 얻는다.
					IbuyerService service = BuyerServiceImpl.getService();
				
				// 2. service 메서드를 호출한다. -> 결과값을 받는다.(List)
					BuyerVO vo = service.buyerDetail(vid);
					
				// 3. 결과값(list) 를 request에 저장한다.
					request.setAttribute("buyerVO", vo);
					
				// 4. 출력을 위해 view페이지(jsp)로 이동한다. -> redirect, forword. 두가지있음.
					RequestDispatcher disp = request.getRequestDispatcher("0224/detail.jsp");

					disp.forward(request, response);// 꼭써야해. 결과안나옴
	}

}
