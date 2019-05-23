package kr.or.next.nextit.session.web;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.next.nextit.com.utils.CookieBox;
import kr.or.next.nextit.session.service.LoginInfoVo;
import kr.or.next.nextit.session.service.SessionService;

@Controller
@RequestMapping(value="/session")
public class SessionController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value="/sessionLoginInfo.do")
	public String actionLoginFront(
			Model modelMap,
			HttpServletRequest request
			) throws Exception{
		
		CookieBox cookieBox = new CookieBox(request);
		
		log.debug("idsave : {}", cookieBox.exists("idsave"));
		
		if(cookieBox.exists("idsave")) {
			String idsave = cookieBox.getValue("idsave");
			modelMap.addAttribute("idsave", idsave);
		}
		
		modelMap.addAttribute("checkUserId", cookieBox.getValue("checkUserId"));
		
		return "session/LoginFront";
	}
	
	@RequestMapping(value="/sessionLoginProc.do")
	public String actionLoginProc(
			Model model,
			@RequestParam HashMap<String, Object> params,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		
		log.debug("로그인 시동 : {}", params);
		
//		CookieBox cookieBox = new CookieBox(request.getCookies());
		
		log.debug("기억하기 : {}", params.containsKey("remember"));
		
		if(params.containsKey("remember")) {
			Cookie idsave = CookieBox.createCookie("idsave", "checked=\"checked\"", "/", 50000000);
			
			response.addCookie(idsave);
			
			Cookie checkUserId = CookieBox.createCookie("checkUserId", params.get("usrid") == null ? "" : (String)params.get("usrid"), "/", 50000000);
			
			response.addCookie(checkUserId);
			
			log.debug("쿠키 생성 완료.. : {}", idsave);
		} else {
			Cookie idsave = CookieBox.createCookie("idsave", "", "/", 0);
			
			response.addCookie(idsave);
			
			Cookie checkUserId = CookieBox.createCookie("checkUserId", "", "/", 0);
			
			response.addCookie(checkUserId);
		}
		
		LoginInfoVo loginInfoResult = sessionService.selectMemberInfo(params);
		
		log.debug("loginInfo : {} ", loginInfoResult);
		
		if(loginInfoResult != null) {

			session.setAttribute("loginInfo", loginInfoResult);

			return "redirect:/";
		} else {

			session.invalidate();
			
			model.addAttribute("message", "아이디 또는 비밀 번호가 틀렸습니다..");
			
			return "redirect:/session/sessionLoginInfo.do?message=" + URLEncoder.encode("아이디 또는 비밀 번호가 틀렸습니다..", "UTF-8");
		}
	}

	@RequestMapping(value= {"/sessionLogOutProc.do"})
	public ModelAndView actionLogoutProc(
			ModelAndView modelAndView,
			HttpSession session
			) throws Exception{
		
		session.invalidate();
		
		RedirectView redierctView = new RedirectView();
		
		redierctView.setUrl("/");
		
		modelAndView.setView(redierctView);
		
		return modelAndView;
	}
}
