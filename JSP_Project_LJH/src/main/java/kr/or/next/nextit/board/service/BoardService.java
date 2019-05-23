package kr.or.next.nextit.board.service;

import java.util.List;

public interface BoardService {

	/**
	 * 사용자가 입력하면 정보를 처리 보내버려
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public BoardVo insertBoardInfo(
			BoardVo boardVo
			) throws Exception;
	
	/**
	 * DB 에 searchVo 에 맞는 데이터를 가져옴
	 * @param boardVo
	 * @return
	 * @throws Exception
	 */
	public List<BoardVo> selectBoardList(
			BoardSearchVo searchVo
			) throws Exception;
}
