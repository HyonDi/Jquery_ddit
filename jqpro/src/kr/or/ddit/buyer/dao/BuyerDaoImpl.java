package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.sqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao{
	// dao 객체 생성
	 private SqlMapClient client;
	 private static IBuyerDao dao;
	 
	 // dao객체 한개를 서비스에서 공유하기위에 static 붙인다.
	 
	 private BuyerDaoImpl(){
		 client = sqlMapClientFactory.getSMClient();
	 }
	 
	 // get() : return dao객체
	 public static IBuyerDao getDaoInstance(){
		 if(dao==null) dao = new BuyerDaoImpl();
		 
		 return dao;
	 }
	 
	

	// SqlMapClient객체 얻기(sqlMapClientFactory 에서.(우리가만듦))
	// mapper의 sql문 실행.
	
	
	
	
	
	@Override
	public List<BuyerVO> nameList() throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("buyer.nameList");
	}

	@Override
	public BuyerVO buyerDetail(String id) throws SQLException {
		// TODO Auto-generated method stub
		return (BuyerVO)client.queryForObject("buyer.buyerDetail",id);
		// vo로 캐스팅한다.
	}
	
}
