package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	private IProdDao dao;
	private static IProdService service; // static
	
	// 생성자 - dao객체 얻기 (나한테 필요한것. 남의것 얻어오는건 생성자로.)
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getDao();
	}
	
	public static IProdService getService(){
		if(service == null) service = new ProdServiceImpl();
		return service;
	}
	
	
	@Override
	public List<ProdVO> prodNames(String lprod_gu) {
		// 1. 변수 선언(메서드리턴타입의 변수). + 초기값 주기.
				List<ProdVO> list = null;
				
				// 2. dao메서드 실행.
				try {
					list = dao.prodNames(lprod_gu);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				// 3. return.
				return list;
		}
	

	@Override
	public ProdVO prodDetail(String prod_id) {
		
		ProdVO vo = null;
		
		try {
			vo = dao.prodDetail(prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

}
