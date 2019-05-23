package kr.or.next.nextit.session.service.impl;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.or.next.nextit.session.service.LoginInfoVo;

@Mapper
public interface SessionMapper {

	/**
	 * ID, PW 값을 DB 쿼리문 검색
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public LoginInfoVo selectMemberInfo(
			HashMap<String, Object> params
			) throws Exception;
}
