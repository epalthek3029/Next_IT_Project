package kr.or.next.nextit.session.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LoginInfoVo {

	private String seqno;
	private String usrid;
	private String usrname;
	private String usremail;
	private String usrhp;
	private String usrfax;
	private String usrgender;
	private String usrage;
	
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

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getUsremail() {
		return usremail;
	}

	public void setUsremail(String usremail) {
		this.usremail = usremail;
	}

	public String getUsrhp() {
		return usrhp;
	}

	public void setUsrhp(String usrhp) {
		this.usrhp = usrhp;
	}

	public String getUsrfax() {
		return usrfax;
	}

	public void setUsrfax(String usrfax) {
		this.usrfax = usrfax;
	}

	public String getUsrgender() {
		return usrgender;
	}

	public void setUsrgender(String usrgender) {
		this.usrgender = usrgender;
	}

	public String getUsrage() {
		return usrage;
	}

	public void setUsrage(String usrage) {
		this.usrage = usrage;
	}
}
