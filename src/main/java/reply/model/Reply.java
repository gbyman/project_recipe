package reply.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Reply {
	private int renum;
	private String cate;
	private int canum;
	private String rewriter;
	private String content;
	private String renickname;
	private String reimg;
	private int ref;
	private int restep;
	private int relevel;
	private int parentnum;
	private Timestamp inputdate;
	private String dateString;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public Reply() {
		super();
	}
	public Reply(int renum, String cate, int canum, String rewriter, String content, String renickname, String reimg,
			int ref, int restep, int relevel,int parentnum, Timestamp inputdate) {
		super();
		this.renum = renum;
		this.cate = cate;
		this.canum = canum;
		this.rewriter = rewriter;
		this.content = content;
		this.renickname = renickname;
		this.reimg = reimg;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.parentnum=parentnum;
		this.inputdate = inputdate;
	}
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getCanum() {
		return canum;
	}
	public void setCanum(int canum) {
		this.canum = canum;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRenickname() {
		return renickname;
	}
	public void setRenickname(String renickname) {
		this.renickname = renickname;
	}
	public String getReimg() {
		return reimg;
	}
	public void setReimg(String reimg) {
		this.reimg = reimg;
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
	public Timestamp getInputdate() {
		return inputdate;
	}
	
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
		if(inputdate!=null) {
			this.dateString=sdf.format(inputdate);
		}
	}
	
	public int getParentnum() {
		return parentnum;
	}
	public void setParentnum(int parentnum) {
		this.parentnum = parentnum;
	}
	@Override
	public String toString() {
		return "Reply [renum=" + renum + ", cate=" + cate + ", canum=" + canum + ", rewriter=" + rewriter + ", content="
				+ content + ", renickname=" + renickname + ", reimg=" + reimg + ", ref=" + ref + ", restep=" + restep
				+ ", relevel=" + relevel + ", parentnum=" + parentnum + ", inputdate=" + inputdate + ", dateString="
				+ dateString + "]";
	}
	
	
	
}
