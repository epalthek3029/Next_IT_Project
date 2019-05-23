package kr.or.next.nextit.member.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MemberVo {

	private int num;
	private String seqno;
	private String usrid;
	private String usrname;
	private String usremail;
	private String usrhp;
	private String usrfax;
	private String usrgender;
	private String usrage;
	private String usrip;
	private String delat;
	private String reguser;
	private String regdt;
	private String upduser;
	private String upddt;
	private String usrpwd;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getUsrpwd() {
		return usrpwd;
	}

	public void setUsrpwd(String usrpwd) {
		this.usrpwd = usrpwd;
	}
}
