package chef.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Chef {
	
	private int chefnum;		//레시피 넘버
	private String writer;		//작성자
	
	@NotEmpty(message = "요리 이름 써주세요")
	private String csubject;	//요리이름
	
	@NotEmpty(message = "짧은 소개글 남겨 주세요")
	private String cshortintro; //짧은 소개글
	
	@NotEmpty(message = "요리 설명 해주세요")
	private String cintro;		//설명
	
	private String cmainimage;	// 메인이미지
	
	private String cingredient;	//식재료
	
	private String cimage1;	//이미지1
	private String cimage2;	//이미지2
	private String cimage3;	//이미지3
	private String cimage4;	//이미지4
	
	private Timestamp cinputdate;	//작성일
	
	private MultipartFile uploadcmainimage;
	private MultipartFile uploadcimage1;
	private MultipartFile uploadcimage2;
	private MultipartFile uploadcimage3;
	private MultipartFile uploadcimage4;
	
	public void setUploadcmainimage(MultipartFile uploadcmainimage){
		
		this.uploadcmainimage = uploadcmainimage;
		
		if(this.uploadcmainimage != null){
			this.cmainimage = this.uploadcmainimage.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadcmainimage(){
		return uploadcmainimage;
	}
	
	public void setUploadcimage1(MultipartFile uploadcimage1){
		
		this.uploadcimage1 = uploadcimage1;
		
		if(this.uploadcimage1 != null ){
			this.cimage1 = this.uploadcimage1.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadcimage1(){
		return uploadcimage1;
	}
	
	public void setUploadcimage2(MultipartFile uploadcimage2){
		
		this.uploadcimage2 = uploadcimage2;
		
		if(this.uploadcimage2 != null){
			this.cimage2 = this.uploadcimage2.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadcimage2(){
		return uploadcimage2;
	}
	
	public void setUploadcimage3(MultipartFile uploadcimage3){
		
		this.uploadcimage3 = uploadcimage3;
		
		if(this.uploadcimage3 != null){
			this.cimage3 = this.uploadcimage3.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadcimage3(){
		return uploadcimage3;
	}
	
	public void setUploadcimage4(MultipartFile uploadcimage4){
		
		this.uploadcimage4 = uploadcimage4;
		
		if(this.uploadcimage4 != null){
			this.cimage4 = this.uploadcimage4.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadcimage4(){
		return uploadcimage4;
	}

	public int getChefnum() {
		return chefnum;
	}

	public void setChefnum(int chefnum) {
		this.chefnum = chefnum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCsubject() {
		return csubject;
	}

	public void setCsubject(String csubject) {
		this.csubject = csubject;
	}

	public String getCshortintro() {
		return cshortintro;
	}

	public void setCshortintro(String cshortintro) {
		this.cshortintro = cshortintro;
	}

	public String getCintro() {
		return cintro;
	}

	public void setCintro(String cintro) {
		this.cintro = cintro;
	}

	public String getCingredient() {
		return cingredient;
	}

	public void setCingredient(String cingredient) {
		this.cingredient = cingredient;
	}

	public Timestamp getCinputdate() {
		return cinputdate;
	}

	public void setCinputdate(Timestamp cinputdate) {
		this.cinputdate = cinputdate;
	}

	public String getCmainimage() {
		return cmainimage;
	}

	public void setCmainimage(String cmainimage) {
		this.cmainimage = cmainimage;
	}

	public String getCimage1() {
		return cimage1;
	}

	public void setCimage1(String cimage1) {
		this.cimage1 = cimage1;
	}

	public String getCimage2() {
		return cimage2;
	}

	public void setCimage2(String cimage2) {
		this.cimage2 = cimage2;
	}

	public String getCimage3() {
		return cimage3;
	}

	public void setCimage3(String cimage3) {
		this.cimage3 = cimage3;
	}

	public String getCimage4() {
		return cimage4;
	}

	public void setCimage4(String cimage4) {
		this.cimage4 = cimage4;
	}
	
}

/*create sequence chefseq start with 1 increment by 1 nocache ;
 * 
 * create table chef(
	chefnum      number primary key,   
	writer      varchar2(30) references allmember(id) on delete set null,
	csubject   varchar2(60) default '제목없음',
	cshortintro varchar2(40),		-- 짧은 소개글
	cintro      varchar2(2000),      --소개
	cmainimage   varchar2(40),      --대문이미지
	cingredient   varchar2(1000),            --재료
	cimage1      varchar2(40),      -- 이미지1
	cimage2      varchar2(40),      -- 이미지2
	cimage3      varchar2(40),      -- 이미지3
	cimage4      varchar2(40),      -- 이미지4
	cinputdate   date default sysdate -- 작성일
);
*/
