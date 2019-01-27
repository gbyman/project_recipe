package talk.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Talk {
	private int tnum;
	private String tid;
	
	@NotEmpty(message="내용을 입력해주세요")
	private String tcontent;
	
	private String timage;
	private String tmovie;
	private MultipartFile tUploader;
	private String tUploader2;
	private Timestamp inputdate;
	public Talk() {
		super();
	}
	
	public Talk(int tnum, String tid, String tcontent, String timage, String tmovie, MultipartFile tUploader,
			String tUploader2, Timestamp inputdate) {
		super();
		this.tnum = tnum;
		this.tid = tid;
		this.tcontent = tcontent;
		this.timage = timage;
		this.tmovie = tmovie;
		this.tUploader = tUploader;
		this.tUploader2 = tUploader2;
		this.inputdate = inputdate;
	}

	public int getTnum() {
		return tnum;
	}

	public void setTnum(int tnum) {
		this.tnum = tnum;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	public String getTimage() {
		return timage;
	}

	public void setTimage(String timage) {
		this.timage = timage;
	}

	public String getTmovie() {
		return tmovie;
	}

	public void setTmovie(String tmovie) {
		this.tmovie = tmovie;
	}

	public String gettUploader2() {
		return tUploader2;
	}

	public void settUploader2(String tUploader2) {
		this.tUploader2 = tUploader2;
	}

	public Timestamp getInputdate() {
		return inputdate;
	}

	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
	}

	public MultipartFile gettUploader() {
		return tUploader;
	}

	public void settUploader(MultipartFile tUploader) {
		this.tUploader = tUploader;
		if(this.tUploader!=null) {
			this.timage=this.tUploader.getOriginalFilename();
		}
	}

	@Override
	public String toString() {
		return "Talk [tnum=" + tnum + ", tid=" + tid + ", tcontent=" + tcontent + ", timage=" + timage + ", tmovie="
				+ tmovie + ", tUploader=" + tUploader + ", tUploader2=" + tUploader2 + ", inputdate=" + inputdate + "]";
	}
	
	
	
	
}
