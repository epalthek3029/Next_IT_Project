package kr.or.next.nextit.board.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.next.nextit.board.service.BoardSearchVo;
import kr.or.next.nextit.board.service.BoardService;
import kr.or.next.nextit.board.service.BoardVo;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public BoardVo insertBoardInfo(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		log.debug("전전전전전 넣는건가?? boardVo :{}", boardVo);
		
		boardMapper.insertBoardInfo(boardVo);
		
		log.debug("후후후후후 넣는건가?? boardVo :{}", boardVo);
		
		return boardVo;
	}

	@Override
	public List<BoardVo> selectBoardList(BoardSearchVo searchVo) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<BoardVo> resultList = boardMapper.selectBoardList(searchVo);
			return resultList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("질의어 오류..", e);
		}
	}

}
