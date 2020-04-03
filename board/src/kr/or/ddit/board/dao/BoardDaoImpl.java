package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.sqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {

	// sql클라이언트, 자기 객체 만든다.
	private SqlMapClient client;
	private static IBoardDao dao;
	
	// 생성자 - client 열기
	private BoardDaoImpl(){
		client = sqlMapClientFactory.getSMClient();
	}
	
	// dao객체 생성
	public static IBoardDao getDao(){
		
		if(dao==null) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		
		return client.queryForList("board.selectAll");
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		
		return (int)client.insert("board.insertReply",vo);
	}

	@Override
	public List<ReplyVO> replyList(int bonum) throws SQLException {
		return client.queryForList("board.replyList",bonum);
	}

	@Override
	public List<BoardVO> listPage(Map<String, Integer> map) throws SQLException {
		return client.queryForList("board.listPage", map);
	}

	@Override
	public int totalList() throws SQLException {
		return (int)client.queryForObject("board.totalList");
	}

}
