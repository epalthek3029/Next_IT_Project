package kr.or.next.nextit.member.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.next.nextit.member.service.MemberSearchVo;
import kr.or.next.nextit.member.service.MemberService;
import kr.or.next.nextit.member.service.MemberVo;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/memberInsertFront.do")
	public ModelAndView getMemberInsert(
			ModelAndView modelAndView
			) throws Exception {
		modelAndView.setViewName("member/MemberInsert");
		
		log.debug("회원 가입 페이지 보여주기!!{}", modelAndView);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/memberList.do")
	public String getMemberList(
			Model model,
			@ModelAttribute(name="searchVo") MemberSearchVo searchVo
			) throws Exception{
		
		int totalCount = memberService.selectMemberTotalCnt(searchVo);
		
		searchVo.setTotalCount(totalCount);
		searchVo.setScreenSize(10);
		searchVo.setPageBlockSize(10);
		searchVo.pageSetting();
		List<MemberVo> resultList = memberService.selectMemberList(searchVo);
		
		model.addAttribute("memberList", resultList);
		
		return "member/MemberList";
	}
	
	@RequestMapping(value="/memberInsertProc.do")
	public ModelAndView setMembrInsertProc(
			ModelAndView modelAndView,
			// Vo에 담아서 보내주기..
			@ModelAttribute(name="memverVo") MemberVo memberVo,
			HttpServletRequest requets
			) throws Exception{
		
		log.debug("회원 가입 정상 작동 하였습니다!!{}", memberVo);
		
		memberVo.setUsrip(requets.getRemoteAddr());
		
		try {
			memberService.insertMemberInfo(memberVo);
			
			RedirectView redirectView = new RedirectView();
			
			redirectView.setUrl("/member/memberList.do");
			modelAndView.setView(redirectView);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modelAndView.setViewName("member/memberInsert");
			throw new Exception("회원가입시 에러가 발생하였습니다..", e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/memberView.do")
	public String getMemberInfoView(
			Model model,
			@ModelAttribute(name="searchVo") MemberSearchVo searchVo
			) throws Exception{
		
		log.debug("회원정보 상세보기!!{}", searchVo);
		
		MemberVo memberVo = memberService.selectMemberInfo(searchVo.getSeqNo());
		model.addAttribute("memberInfo", memberVo);
		
		return "member/MemberView";
	}
	
	@RequestMapping(value="/memberDeleteProc.do")
	public String setDeleteMemberInfo(
			Model model,
			@RequestParam(name="seqno", required=true) String seqNo,
			@ModelAttribute MemberSearchVo searchVo
			) throws Exception{
		
		log.debug("삭제 실행(del_at가 Y인것만 표시): {}", searchVo);
		
		memberService.deleteMemberInfo(searchVo.getSeqNo(), searchVo);
		
		return "redirect:/member/memberList.do";
	}
	
	@RequestMapping(value="/memberUpdateFront.do")
	public String getMemberUpdateFront(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		
		log.debug("update params : {}", params);
		
		String seqNo = (String)params.get("seqNo");
		
		MemberVo memberInfo = memberService.selectMemberInfo(seqNo);
		
		model.addAttribute("memberInfo", memberInfo);
		
		return "member/MemberUpdate";
	}
	
	@RequestMapping(value="/memberUpdateProc.do")
	public String setMemberUpdateProc(
			ModelMap model,
			@RequestParam HashMap<String, Object> params,
			HttpServletRequest request
			) throws Exception{
		
		log.debug("넘어오는 params : {}", params);
		
		params.put("usrip", request.getRemoteAddr());
		params.put("upduser", "maseter");
		
		try {
			memberService.updateMemberInfo(params);
			
//			log.debug("params ㄴ이라ㅓ 왜 안나오는거야 진짜.. ㅠㅠ:{}",params);
			
			return String.format("redirect:/member/memberView.do?seqNo=%s", params.get("seqNo"));
		} catch(Exception e) {
			e.printStackTrace();
			return String.format("redirect:/member/memberupdateFront.do?seqNo=%s", params.get("seqNo"));
			
		}
	}
}
