package kr.or.next.nextit.board.web;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.next.nextit.board.service.BoardSearchVo;
import kr.or.next.nextit.board.service.BoardService;
import kr.or.next.nextit.board.service.BoardVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name="propertyService")
	private Properties propertiesService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardInsertForm.do")
	public String getBoardInsertFront(
			Model model,
			@ModelAttribute BoardSearchVo searchVo
			) throws Exception{
		log.debug("게시물 작성이다!!! model : {}", model);
		
		return "/board/BoardForm";
	}
	
	@RequestMapping(value="/boardInsertProc.do")
	public String setBoardInsertProc(
			Model model,
			@ModelAttribute(name="boardVo") BoardVo boardVo,
			HttpServletRequest request
			) throws Exception{
		
		try {
//			boardVo.setUsrip(request.getRemoteAddr());
//			boardVo.setReguser(loginInfo);
			
			boardVo.setUsrip(request.getRemoteAddr());
			boardVo.setReguser(request.getRemoteUser());
			
			log.debug("boardVo : {}", boardVo);
			
			boardService.insertBoardInfo(boardVo);
			
			log.debug("request : {}", request);
			
			return "redirect:/board/boardListFront.do";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			
			return "board/BoardForm";
		}
	}
	
	@RequestMapping(value="/boardListFront.do")
	public String getBoardList(
			Model model,
			@ModelAttribute BoardSearchVo searchVo
			) throws Exception{
		
		List<BoardVo> resultBoardList = boardService.selectBoardList(searchVo);
		
		model.addAttribute("boardList", resultBoardList);
		
		return "board/BoardList";
	}
}