package kr.or.next.nextit.board.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

import kr.or.next.nextit.com.cmm.PagingVo;

public class BoardSearchVo extends PagingVo{

	private String searchText;
	private String searchType;
	private String seqNo;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this.getClass());
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
}
