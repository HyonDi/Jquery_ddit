package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	// select해서 list 가져오기.
	// list가져올때 페이지별로가져오기
	// 검색해서 결과만 가져오기
	// 등록/수정/삭제, 댓글 등등 인터페이스에 먼저 설계해야함.
	
	// 게시글 리스트
	public List<BoardVO> selectAll();
	
	// 게시글 페이지 리스트
	public List<BoardVO> listPage(Map<String, Integer> map);
	
	// 전체 글 갯수
	public int totalList();
	
	// 답글 저장
	public int insertReply(ReplyVO vo);
	
	// 답글 리스트
	public List<ReplyVO> replyList(int bonum);  
	
	
	
}
