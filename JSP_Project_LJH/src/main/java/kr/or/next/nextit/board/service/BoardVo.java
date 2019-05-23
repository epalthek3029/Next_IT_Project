package kr.or.next.nextit.board.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BoardVo {

	private String num;
	private String seqno;
	private String servicetype;
	private String title;
	private String contents;
	private String readcount;
	private String usrip;
	private String delat;
	private String reguser;
	private String regdt;
	private String upduser;
	private String upddt;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this.getClass());
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getUsrip() {
		return usrip;
	}
	public void setUsrip(String usrip) {
		this.usrip = usrip;
	}
	public String getDelat() {
		return delat;
	}
	public void setDelat(String delat) {
		this.delat = delat;
	}
	public String getReguser() {
		return reguser;
	}
	public void setReguser(String reguser) {
		this.reguser = reguser;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public String getUpduser() {
		return upduser;
	}
	public void setUpduser(String upduser) {
		this.upduser = upduser;
	}
	public String getUpddt() {
		return upddt;
	}
	public void setUpddt(String upddt) {
		this.upddt = upddt;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
