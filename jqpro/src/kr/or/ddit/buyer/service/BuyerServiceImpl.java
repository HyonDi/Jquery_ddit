package kr.or.ddit.buyer.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;
/**
 * service 객체생성,  get() - reuturn
 * @author PC-16
 *
 */
public class BuyerServiceImpl implements IbuyerService {
	private static IbuyerService service;
	private IBuyerDao dao;
	
	private BuyerServiceImpl(){
		dao = BuyerDaoImpl.getDaoInstance();
	}
	
	public static IbuyerService getService(){
		if(service == null) service = new BuyerServiceImpl();
		
		return service;
	}
	
	
	@Override
	public List<BuyerVO> nameList() {
		List<BuyerVO> list = null;
		
		try {
			list = dao.nameList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BuyerVO buyerDetail(String id) {
		BuyerVO vo = null;
		
		try {
			vo = dao.buyerDetail(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}

}
