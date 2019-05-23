package kr.or.next.nextit.board.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.next.nextit.board.service.BoardSearchVo;
import kr.or.next.nextit.board.service.BoardVo;

@Mapper
public interface BoardMapper {

	/**
	 * 처리된 값을 DB에서 insert 질의어 수행
	 * @param boardVo
	 * @throws Exception
	 */
	public void insertBoardInfo(
			BoardVo boardVo
			) throws Exception;
	
	/**
	 * 처리된값 DB 에서 실행
	 * @param searchVo
	 * @return
	 * @throws Exception
	 */
	public List<BoardVo> selectBoardList(
			BoardSearchVo searchVo
			) throws Exception;
	
}
