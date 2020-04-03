package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.config.sqlMapClientFactory;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProdDaoImpl implements IProdDao {
	private SqlMapClient client ; 
	private static IProdDao dao; // 자기거에는 static을 붙힌다.
	
	// 생성자 - client 열기 // 생성자에서는 자기가 필요한것을 가져온다.
	private ProdDaoImpl(){
		client = sqlMapClientFactory.getSMClient();
	}
	
	// dao객체 생성, 리턴 - getDao()
	
	 // get() : return dao객체. 
	 public static IProdDao getDao() {
		 
		 if(dao==null) dao = new ProdDaoImpl();
		 
		 return dao;
}

	@Override
	public List<ProdVO> prodNames(String lprod_gu) throws SQLException {
		return client.queryForList("prod.prodNames", lprod_gu); // 파라미터 가져가야해!! : lprod_gu
	}

	@Override
	public ProdVO prodDetail(String prod_id) throws SQLException {
		return (ProdVO) client.queryForObject("prod.prodDetail", prod_id); //prod_id 잊지말고넣기.
	}
}