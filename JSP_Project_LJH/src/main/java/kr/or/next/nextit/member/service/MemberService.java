package kr.or.next.nextit.member.service;

import java.util.HashMap;
import java.util.List;

public interface MemberService {

	/**
	 * 회원가입 MemberVo 를 이용해서 
	 * DB에 저장
	 * @param memberVo
	 * @throws Exception
	 */
	public void insertMemberInfo(
			MemberVo memberVo
			) throws Exception;

	/**
	 * 회원 정보 검색 기능..
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(
			MemberSearchVo searchVo
			) throws Exception;
	
	/**
	 * selectMemberList 검색 조건과 동일한 조건을 가지고오기..
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public int selectMemberTotalCnt(
			MemberSearchVo searchVo
			) throws Exception;
	/**
	 * 리스트에서 찾기 seqNo로
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectMemberInfo(
			String seqNo
			) throws Exception;
	
	/**
	 * 삭제 기능 (완전삭제 x)
	 * 안보이게 설정
	 * @param seqNo
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public void deleteMemberInfo(
			String seqNo,
			MemberSearchVo searchVo
			) throws Exception;
	
	/**
	 * 화면에 입력된거 Map으로 받아서 seqNo에 해당하는 값 변경
	 * @param params
	 * @throws Exception
	 */
	public void updateMemberInfo(
			HashMap<String, Object> params
			) throws Exception;
}
