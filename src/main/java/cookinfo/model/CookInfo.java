package cookinfo.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class CookInfo {
	private int infonum;
	private String infosubject;
	private String infointro;
	private String infoimage;
	private String infomovie;
	private Timestamp indate;
	private String infokind;
	
	
	private MultipartFile upload;
	private String upload2; 
	
	
	public CookInfo() {
		super();
	}
	
	
	
	public CookInfo(int infonum, String infosubject, String infointro, String infoimage, String infomovie,
			Timestamp indate, String infokind, MultipartFile upload, String upload2) {
		super();
		this.infonum = infonum;
		this.infosubject = infosubject;
		this.infointro = infointro;
		this.infoimage = infoimage;
		this.infomovie = infomovie;
		this.indate = indate;
		this.infokind = infokind;
		this.upload = upload;
		this.upload2 = upload2;
	}

	public int getInfonum() {
		return infonum;
	}
	public void setInfonum(int infonum) {
		this.infonum = infonum;
	}
	public String getInfosubject() {
		return infosubject;
	}
	public void setInfosubject(String infosubject) {
		this.infosubject = infosubject;
	}
	public String getInfointro() {
		return infointro;
	}
	public void setInfointro(String infointro) {
		this.infointro = infointro;
	}
	public String getInfoimage() {
		return infoimage;
	}
	public void setInfoimage(String infoimage) {
		this.infoimage = infoimage;
	}
	public String getInfomovie() {
		return infomovie;
	}
	public void setInfomovie(String infomovie) {
		this.infomovie = infomovie;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
	
	
	public String getInfokind() {
		return infokind;
	}



	public void setInfokind(String infokind) {
		this.infokind = infokind;
	}



	public MultipartFile getUpload() {
		return upload;
	}
	
	public void setUpload(MultipartFile upload) { // upload=Penguin.jpg
		this.upload = upload;
		if( this.upload != null){ //업로드 잘 되었다면
			this.infoimage = this.upload.getOriginalFilename();
		}
	}
	
	
	public String getUpload2() {
		return upload2;
	}
	public void setUpload2(String upload2) {
		System.out.println("setUpload2");
		this.upload2 = upload2;
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "CookInfo [infonum=" + infonum + ", infosubject=" + infosubject + ", infointro=" + infointro
				+ ", infoimage=" + infoimage + ", infomovie=" + infomovie + ", indate=" + indate + "]";
	}
	
}
