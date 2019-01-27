package talk.model;

import java.sql.Timestamp;

public class TalkContainer {
	private int tnum;
	private String tid;
	private String tcontent;
	private String img;
	private String timage;
	private String tmovie;
	private Timestamp inputdate;
	private String nickname;
	private String timeString;
	
	public static final int SEC = 60;
	public static final int MIN = 60;
	public static final int HOUR = 24;
	public static final int DAY = 30;
	public static final int MONTH = 12;
	
	public TalkContainer() {
		super();
	}
	public TalkContainer(int tnum, String tid, String tcontent, String img, String timage, String tmovie, Timestamp inputdate,
			String nickname) {
		super();
		this.tnum = tnum;
		this.tid = tid;
		this.tcontent = tcontent;
		this.img = img;
		this.timage = timage;
		this.tmovie= tmovie;
		this.inputdate = inputdate;
		this.nickname = nickname;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTimage() {
		return timage;
	}
	public void setTimage(String timage) {
		this.timage = timage;
	}
	public Timestamp getInputdate() {
		return inputdate;
	}
	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
		if(inputdate!=null) {
			this.timeString=formatTimeString(inputdate);
		}
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	
	public String getTmovie() {
		return tmovie;
	}
	public void setTmovie(String tmovie) {
		this.tmovie = tmovie;
	}
	
	
	@Override
	public String toString() {
		return "TalkContainer [tnum=" + tnum + ", tid=" + tid + ", tcontent=" + tcontent + ", img=" + img + ", timage="
				+ timage + ", tmovie=" + tmovie + ", inputdate=" + inputdate + ", nickname=" + nickname
				+ ", timeString=" + timeString + "]";
	}
	public String formatTimeString(Timestamp tempDate) {

		long curTime = System.currentTimeMillis();
		long regTime = tempDate.getTime();
		long diffTime = (curTime - regTime) / 1000;

		String msg = null;
		if (diffTime < this.SEC) {
			msg = "방금 전";
		} else if ((diffTime /= this.SEC) < this.MIN) {
			msg = diffTime + "분 전";
		} else if ((diffTime /= this.MIN) < this.HOUR) {
			msg = (diffTime) + "시간 전";
		} else if ((diffTime /= this.HOUR) < this.DAY) {
			msg = (diffTime) + "일 전";
		} else if ((diffTime /= this.DAY) < this.MONTH) {
			msg = (diffTime) + "달 전";
		} else {
			msg = (diffTime) + "년 전";
		}

		return msg;
	}
}

	





