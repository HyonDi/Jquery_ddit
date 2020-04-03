package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.sqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao {
	private SqlMapClient client ; 
	private static IMemberDao dao; // 자기거에는 static을 붙힌다.
	
	// 생성자 - client 열기 // 생성자에서는 자기가 필요한것을 가져온다.
	private MemberDaoImpl(){
		client = sqlMapClientFactory.getSMClient();
	}
	
	// dao객체 생성, 리턴 - getDao()
	
	 // get() : return dao객체. 
	 public static IMemberDao getDao() {
		 
		 if(dao==null) dao = new MemberDaoImpl();
		 
		 return dao;
		 
	 }
	
	
	
	@Override
	public List<MemberVO> listAll() throws SQLException {
		return client.queryForList("member.listAll");
	}

	@Override
	public String checkById(String id) throws SQLException {
		return (String) client.queryForObject("member.checkById", id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) throws SQLException {
		return client.queryForList("member.selectByDong",dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		return (String) client.insert("member.insertMember",vo);
	}

}
