package kr.or.next.nextit.session.service;

import java.util.HashMap;

public interface SessionService {

	/**
	 * requestparam HashMap<String, Object> 사용자가 입력한 ID, PW
	 * 값을 받은 뒤 동일한 녀석을 DB에서 가져오고 없으면 null 반환.. 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public LoginInfoVo selectMemberInfo(
			HashMap<String, Object> params
			) throws Exception;
}
