package procedure.model;

import org.springframework.web.multipart.MultipartFile;

public class Procedure {
	private int pronum;
	private int recnum;
	private String procontent;
	private String proimage;
	private MultipartFile proUpload;
	
	public Procedure() {
		super();
	}

	public Procedure(int pronum, int recnum, String procontent, String proimage, MultipartFile proUpload) {
		super();
		this.pronum = pronum;
		this.recnum = recnum;
		this.procontent = procontent;
		this.proimage = proimage;
		this.proUpload = proUpload;
	}

	public int getPronum() {
		return pronum;
	}

	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	public int getRecnum() {
		return recnum;
	}

	public void setRecnum(int recnum) {
		this.recnum = recnum;
	}

	public String getProcontent() {
		return procontent;
	}

	public void setProcontent(String procontent) {
		this.procontent = procontent;
	}

	public String getProimage() {
		return proimage;
	}

	public void setProimage(String proimage) {
		this.proimage = proimage;
	}

	public MultipartFile getProUpload() {
		return proUpload;
	}

	public void setProUpload(MultipartFile proUpload) {
		this.proUpload = proUpload;
		if(this.proUpload!=null) {
			this.proimage=this.proUpload.getOriginalFilename();
		}
	}

	@Override
	public String toString() {
		return "Procedure [pronum=" + pronum + ", recnum=" + recnum + ", procontent=" + procontent + ", proimage="
				+ proimage + ", proUpload=" + proUpload + "]";
	}
	
	
	
}
