package PojoPac;

import java.sql.Date;

public class Drive {
private int did;
	private String cnm;
	private int no_of_rsrcs;
	private int exp_req;
	private int ctc;
	private int join_crt;
	private String bond;
	private int position;
	private Date followup;
	private int edu_crt;
	
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getCnm() {
		return cnm;
	}
	public void setCnm(String cnm) {
		this.cnm = cnm;
	}
	public int getNo_of_rsrcs() {
		return no_of_rsrcs;
	}
	public void setNo_of_rsrcs(int no_of_rsrcs) {
		this.no_of_rsrcs = no_of_rsrcs;
	}
	public int getExp_req() {
		return exp_req;
	}
	public void setExp_req(int exp_req) {
		this.exp_req = exp_req;
	}
	public int getCtc() {
		return ctc;
	}
	public void setCtc(int ctc) {
		this.ctc = ctc;
	}
	public int getJoin_crt() {
		return join_crt;
	}
	public void setJoin_crt(int join_crt) {
		this.join_crt = join_crt;
	}
	public String getBond() {
		return bond;
	}
	public void setBond(String bond) {
		this.bond = bond;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Date getFollowup() {
		return followup;
	}
	public void setFollowup(Date followup) {
		this.followup = followup;
	}
	public int getEdu_crt() {
		return edu_crt;
	}
	public void setEdu_crt(int edu_crt) {
		this.edu_crt = edu_crt;
	}
	@Override
	public String toString() {
		return "Drive [did=" + did + ", cnm=" + cnm + ", no_of_rsrcs=" + no_of_rsrcs + ", exp_req=" + exp_req + ", ctc="
				+ ctc + ", join_crt=" + join_crt + ", bond=" + bond + ", position=" + position + ", followup="
				+ followup + ", edu_crt=" + edu_crt + "]";
	}
	
	

	

}


