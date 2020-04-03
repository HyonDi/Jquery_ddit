package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
	
	public List<BoardVO> selectAll() throws SQLException;
	
	// 답글 저장
	public int insertReply(ReplyVO vo) throws SQLException;
	
	// 답글 리스트
	public List<ReplyVO> replyList(int bonum) throws SQLException;  
		
	// 게시글 페이지 리스트
	public List<BoardVO> listPage(Map<String, Integer> map) throws SQLException;
	
	// 전체 글 갯수
	public int totalList() throws SQLException;
}
