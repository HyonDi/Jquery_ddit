package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.ibatis.config.sqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;
/**
 * SqlMapClient 얻기. : factory에서 얻는다.
 * LprodDao객체 생성, 리턴. : service에서 사용할것이다.
 * 
 * @author PC-16
 *
 */
public class LprodDaoImpl implements ILprodDao{
	private SqlMapClient client ; 
	private static ILprodDao dao; // 자기거에는 static을 붙힌다.
	
	// 생성자 - client 열기 // 생성자에서는 자기가 필요한것을 가져온다.
	private LprodDaoImpl(){
		client = sqlMapClientFactory.getSMClient();
	}
	
	// dao객체 생성, 리턴 - getDao()
	
	 // get() : return dao객체. 
	 public static ILprodDao getDao() {
		 
		 if(dao==null) dao = new LprodDaoImpl();
		 
		 return dao;
		 
	 }
	
	
	
	@Override
	public List<LprodVO> listLprod() throws SQLException {
		return client.queryForList("lprod.listLprod");
	}

}
