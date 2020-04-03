package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IbuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;
/**
 * 다오 객체 얻기.
 * service객체 생성, 리턴 - controller에서 사용.
 * @author PC-16
 *
 */
public class LprodServiceImpl implements ILprodService {

	private ILprodDao dao;
	private static ILprodService service; // static
	
	// 생성자 - dao객체 얻기 (나한테 필요한것. 남의것 얻어오는건 생성자로.)
	private LprodServiceImpl(){
		dao = LprodDaoImpl.getDao();
	}
	
	public static ILprodService getService(){
		if(service == null) service = new LprodServiceImpl();
		return service;
	}
	
	@Override
	public List<LprodVO> listLprod() {
		// 1. 변수 선언(메서드리턴타입의 변수). + 초기값 주기.
		List<LprodVO> list = null;
		
		// 2. dao메서드 실행.
		try {
			list = dao.listLprod();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. return.
		return list;
	}

}
