package product.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int pnum;	//상품번호
	
	private String pkind;
	
	@NotEmpty(message = "제품 이름 입력해야함")
	private String pname;	//상품이름
	
	@NotNull(message = "가격 입력해야 함")
	private int price;		//가격
	
	@NotNull(message = "물건 재고 입력해야 함")
	private int stock;		//재고
	private String company;		//제조회사
	
	@NotEmpty(message = "원산지 입력해야 함")
	private String origin;		//원산지
	private String pimage;		//상품이미지
	
	@NotNull(message ="수량 선택하세요")
	private int orderqty;		//주문수량
	private MultipartFile uploadpimage;
	private Timestamp inputdate;
	
	public Product() {
		super();
	}
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public int getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(int orderqty) {
		this.orderqty = orderqty;
	}

	
	
	
	public String getPkind() {
		return pkind;
	}

	public void setPkind(String pkind) {
		this.pkind = pkind;
	}

	public Timestamp getInputdate() {
		return inputdate;
	}
	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
	}
	
	public void setUploadpimage(MultipartFile uploadpimage) {
		
		this.uploadpimage = uploadpimage;
		
		if(this.uploadpimage != null) {
			this.pimage = this.uploadpimage.getOriginalFilename();
		}
	}
	
	
	
	public MultipartFile getUploadpimage() {
		
		return uploadpimage;
	}
	
	@Override
	public String toString() {
		return "Product [pnum=" + pnum + ", pname=" + pname + ", price=" + price + ", stock="
				+ stock + ", company=" + company + ", origin=" + origin + ", pimage=" + pimage + ", inputdate="
				+ inputdate + "]";
	}
	
}
