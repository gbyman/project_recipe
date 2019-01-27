package allmember.model;

import java.sql.Timestamp;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class AllMember {
	private String id;
	
	@NotEmpty(message="패스워드를 입력해주세요.")
	private String password;
	
	@NotEmpty(message="닉네임을 입력해주세요.")
	private String nickname;
	
	@NotEmpty(message="이름을 입력해주세요.")
	private String name;
	
	private String email1;
	private String email2;
	private String email3;
	
	@NotEmpty(message="휴대폰 앞자리를 입력해주세요.")
	private String hp1;
	
	@Pattern(regexp="^[0-9]{3,4}$",message="3~4자 숫자로 입력해주세요.")
	private String hp2;
	
	@Pattern(regexp="^[0-9]{4}$",message="3~4자 숫자로 입력해주세요.")
	private String hp3;
	
	private String postnumber;
	private String address1;
	private String address2;
	private String year;
	private String month;
	private String day;
	private String gender;
	private String img;
	private String img2;
	private MultipartFile imgUpload;
	private Timestamp joindate;
	public AllMember() {
		super();
	}
	public AllMember(String id, String password, String nickname, String name, String email1, String email2,
			String email3, String hp1, String hp2, String hp3, String postnumber, String address1, String address2,
			String year, String month, String day, String gender, String img, String img2, MultipartFile imgUpload,
			Timestamp joindate) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.name = name;
		this.email1 = email1;
		this.email2 = email2;
		this.email3 = email3;
		this.hp1 = hp1;
		this.hp2 = hp2;
		this.hp3 = hp3;
		this.postnumber = postnumber;
		this.address1 = address1;
		this.address2 = address2;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.img = img;
		this.img2 = img2;
		this.imgUpload = imgUpload;
		this.joindate = joindate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmail3() {
		return email3;
	}
	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getPostnumber() {
		return postnumber;
	}
	public void setPostnumber(String postnumber) {
		this.postnumber = postnumber;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public MultipartFile getImgUpload() {
		return imgUpload;
	}
	public void setImgUpload(MultipartFile imgUpload) {
		this.imgUpload = imgUpload;
		if(imgUpload!=null) {
			this.img=this.imgUpload.getOriginalFilename();
		}
	}
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "AllMember [id=" + id + ", password=" + password + ", nickname=" + nickname + ", name=" + name
				+ ", email1=" + email1 + ", email2=" + email2 + ", email3=" + email3 + ", hp1=" + hp1 + ", hp2=" + hp2
				+ ", hp3=" + hp3 + ", postnumber=" + postnumber + ", address1=" + address1 + ", address2=" + address2
				+ ", year=" + year + ", month=" + month + ", day=" + day + ", gender=" + gender + ", img=" + img
				+ ", img2=" + img2 + ", imgUpload=" + imgUpload + ", joindate=" + joindate + "]";
	}
	
	
	
}
