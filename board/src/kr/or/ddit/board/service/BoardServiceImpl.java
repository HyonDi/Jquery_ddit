package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao dao;
	private static IBoardService service;
	
	//dao객체 얻기
	private BoardServiceImpl(){
		dao = BoardDaoImpl.getDao();
	}
	
	public static IBoardService getService(){
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public List<BoardVO> selectAll() {
		
		List<BoardVO> list = null;
		
		// 2. dao메서드 실행
		try {
			list = dao.selectAll();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		
		int num = 0;
		
		try {
			num = dao.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<ReplyVO> replyList(int bonum) {
		
		List<ReplyVO> list = null;
		
		try {
			list = dao.replyList(bonum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
	}

	@Override
	public List<BoardVO> listPage(Map<String, Integer> map) {
		List<BoardVO> list= null;
		
		try {
			list = dao.listPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int totalList() {
		int count = 0;
		
		try {
			count = dao.totalList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
