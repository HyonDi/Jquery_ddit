package kr.or.ddit.ibatis.config;

import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class sqlMapClientFactory {
	private static SqlMapClient smc;
	// sql문을 실행시키기 위한 객체 : SqlMapClient smc
	/*
	 * Mapper 파일(member.xml)의 sql문을 수행하기 위해서
	 * sqlMapClient 객체를 생성한다.
	 * 
	 * sqlMapClient 객체 생성시, 환경설정 파일(SqlMapConfig.xml) 을 재료로 한다.
	 * 
	 */
	
 
	static{
		try {
			//	1-1. xml문서 읽어오기
			// 설정파일의 인코딩 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/SqlMapConfig.xml");
			
			//	1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 계속할 객체 생성
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			// 빌더가 빌드할때 재료로 rd사용. 결과물 : smc
			
			// client 오류(null)가 나면 db연결, sql오타, 매핑잘 되었는가 확인하기.
			// sqlmapconfig.xml 가서 확인하면돼.
			// member.xml -> 매핑확인
			
			
		
		} catch(Exception ex){
				
		}
	}
	
	public static SqlMapClient getSMClient(){
		return smc;
	}
	
	
	
}