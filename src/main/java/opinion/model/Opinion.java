package opinion.model;

import java.sql.Timestamp;

public class Opinion {
	private int opnum;
	private String opid;
	private String opsubject;
	private String opcontent;
	private int ref;
	private int restep;
	private int relevel;
	private Timestamp currdate;
	public Opinion() {
		super();
	}
	public Opinion(int opnum, String opid, String opsubject, String opcontent, int ref, int restep, int relevel,
			Timestamp currdate) {
		super();
		this.opnum = opnum;
		this.opid = opid;
		this.opsubject = opsubject;
		this.opcontent = opcontent;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.currdate = currdate;
	}
	public int getOpnum() {
		return opnum;
	}
	public void setOpnum(int opnum) {
		this.opnum = opnum;
	}
	public String getOpid() {
		return opid;
	}
	public void setOpid(String opid) {
		this.opid = opid;
	}
	public String getOpsubject() {
		return opsubject;
	}
	public void setOpsubject(String opsubject) {
		this.opsubject = opsubject;
	}
	public String getOpcontent() {
		return opcontent;
	}
	public void setOpcontent(String opcontent) {
		this.opcontent = opcontent;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public Timestamp getCurrdate() {
		return currdate;
	}
	public void setCurrdate(Timestamp currdate) {
		this.currdate = currdate;
	}
	@Override
	public String toString() {
		return "Opinion [opnum=" + opnum + ", opid=" + opid + ", opsubject=" + opsubject + ", opcontent=" + opcontent
				+ ", ref=" + ref + ", restep=" + restep + ", relevel=" + relevel + ", currdate=" + currdate + "]";
	}
	
	
	
}
