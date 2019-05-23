package kr.or.next.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.next.nextit.member.service.MemberSearchVo;
import kr.or.next.nextit.member.service.MemberService;
import kr.or.next.nextit.member.service.MemberVo;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void insertMemberInfo(MemberVo memberVo) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.insertMemberInfo(memberVo);
	}
	
	@Override
	public List<MemberVo> selectMemberList(MemberSearchVo searchVo) throws Exception {
		// TODO Auto-generated method stub
		List<MemberVo> resultList = memberMapper.selectMemberList(searchVo);
		return resultList;
	}
	
	@Override
	public int selectMemberTotalCnt(MemberSearchVo searchVo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return memberMapper.selectMemberTotalCnt(searchVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public MemberVo selectMemberInfo(String seqNo) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberInfo(seqNo);
	}

	@Override
	public void deleteMemberInfo(String seqNo, MemberSearchVo searchVo) throws Exception {
		// TODO Auto-generated method stub
		if(seqNo == null) {
			throw new NullPointerException("seqNo 값이 넘어오지 않았습니다..ㅜ");
		}
		
		memberMapper.deleteFlagMemberInfo(seqNo);
	}

	@Override
	public void updateMemberInfo(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.updateMemberInfo(params);
	}

}
