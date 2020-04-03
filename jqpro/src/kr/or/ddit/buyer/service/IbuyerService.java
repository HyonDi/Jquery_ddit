package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IbuyerService {
	
	public List<BuyerVO> nameList();
	public BuyerVO buyerDetail(String id);
	// buyerxml에 select id에 넣은것과 같은 이름으로 메서드 만들으렴. 헷갈리니까.
}
