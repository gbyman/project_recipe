package recipe.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Recipe {

	public Recipe() {
		
	}
	
	private int recnum;		//레시피 넘버
	private String writer;		//작성자
	
	@NotEmpty(message = "요리 분류 해주세요")
	private String theme;	//요리대분류
	
	@NotEmpty(message = "요리 이름 써주세요")
	private String psubject;	//요리이름
	
	@NotEmpty(message = "요리 설명 해주세요")
	private String intro;		//설명
	
	private String mainimage;	// 메인이미지
	 	
	private String movieurl;	//동영상 링크 주소
	
	private String image1;	//이미지1
	private String image2;	//이미지2
	private String image3;	//이미지3
	private String image4;	//이미지4
	
	private Timestamp inputdate;	//작성일
	
	private MultipartFile uploadmainimage;
	private MultipartFile uploadimage1;
	private MultipartFile uploadimage2;
	private MultipartFile uploadimage3;
	private MultipartFile uploadimage4;
	
	public void setUploadmainimage(MultipartFile uploadmainimage){
		
		this.uploadmainimage = uploadmainimage;
		
		if(this.uploadmainimage != null){
			this.mainimage = this.uploadmainimage.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadmainimage(){
		return uploadmainimage;
	}
	
	public void setUploadimage1(MultipartFile uploadimage1){
		
		this.uploadimage1 = uploadimage1;
		
		if(this.uploadimage1 != null ){
			this.image1 = this.uploadimage1.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadimage1(){
		return uploadimage1;
	}
	
	public void setUploadimage2(MultipartFile uploadimage2){
		
		this.uploadimage2 = uploadimage2;
		
		if(this.uploadimage2 != null){
			this.image2 = this.uploadimage2.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadimage2(){
		return uploadimage2;
	}
	
	public void setUploadimage3(MultipartFile uploadimage3){
		
		this.uploadimage3 = uploadimage3;
		
		if(this.uploadimage3 != null){
			this.image3 = this.uploadimage3.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadimage3(){
		return uploadimage3;
	}
	
	public void setUploadimage4(MultipartFile uploadimage4){
		
		this.uploadimage4 = uploadimage4;
		
		if(this.uploadimage4 != null){
			this.image4 = this.uploadimage4.getOriginalFilename();
		}
	}
	
	public MultipartFile getUploadimage4(){
		return uploadimage4;
	}
	

	public int getRecnum() {
		return recnum;
	}

	public void setRecnum(int recnum) {
		this.recnum = recnum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPsubject() {
		return psubject;
	}

	public void setPsubject(String psubject) {
		this.psubject = psubject;
	}
	
	public void setTheme(String theme){
		this.theme = theme;
	}
	
	public String getTheme(){
		return theme;
	}
	
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getMainimage() {
		return mainimage;
	}

	public void setMainimage(String mainimage) {
		this.mainimage = mainimage;
	}

	public String getMovieurl() {
		return movieurl;
	}

	public void setMovieurl(String movieurl) {
		this.movieurl = movieurl;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public Timestamp getInputdate() {
		return inputdate;
	}

	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
	}

}
/*create table recipe(
		   recnum      number primary key,   
		   writer      varchar2(30) references allmember(id) on delete set null,
		   theme	varchar2(30),		-- 테마
		   psubject   varchar2(60) default '제목없음',
		   shortintro varchar2(40),		-- 짧은 소개글
		   intro      varchar2(2000),      --소개
		   mainimage   varchar2(40),      --대문이미지
		   ingredient   varchar2(1000),            --재료
		   movieurl   varchar2(60),      --동영상 링크주소
		   scrap      number default 0,   --스크랩수
		   image1      varchar2(40),      -- 이미지1
		   image2      varchar2(40),      -- 이미지2
		   image3      varchar2(40),      -- 이미지3
		   image4      varchar2(40),      -- 이미지4
		   inputdate   date default sysdate -- 작성일
		);
*/