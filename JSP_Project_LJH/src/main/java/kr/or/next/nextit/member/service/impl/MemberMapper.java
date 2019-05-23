package kr.or.next.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.next.nextit.member.service.MemberSearchVo;
import kr.or.next.nextit.member.service.MemberVo;

@Mapper
public interface MemberMapper {
					
	/**
	 * 가입
	 * @param memberVo
	 * @throws Exception
	 */
	public void insertMemberInfo(
			MemberVo memberVo
			) throws Exception;
	
	
	/**
	 * 검색기능
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(
			MemberSearchVo searchVo
			) throws Exception;
	
	/**
	 * selectMemberList 기능과 동일한 조건으로 카운터
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public int selectMemberTotalCnt(
			MemberSearchVo searchVo
			) throws Exception;
	
	/**
	 * 찾아오기
	 * @param seqNo
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberInfo(
			String seqNo
			) throws Exception;
	
	/**
	 * seqNo 값을 받고 수정(=삭제) 
	 * N값만 보이도록..
	 * @param seqNo
	 * @throws Exception
	 */
	public void deleteFlagMemberInfo(
			String seqNo
			) throws Exception;
	
	/**
	 * seq 값 수정하기
	 * @param params
	 * @throws Exception
	 */
	public void updateMemberInfo(
			HashMap<String, Object> params
			) throws Exception;
}
