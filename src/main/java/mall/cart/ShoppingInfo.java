package mall.cart;

public class ShoppingInfo {
	
	private int pnum;	//상품 번호
	private String pname;	//상품명
	private int price;		//가격
	private int qty;	//수량
	private int amount;	//금액
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ShoppingInfo [pnum=" + pnum + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", amount="
				+ amount + "]";
	}
	
}
