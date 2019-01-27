package order.model;

import java.sql.Timestamp;

public class Order {
	private int onum;		//주문번호
	private String mid;		//주문자 아이디
	private int pnum;		//제품 번호
	private int qty;		//수량
	private int price;		//가격	
	private int amount;	//금액
	private Timestamp orderdate;	//시간
	public Order() {
		super();
	}
	public Order(int onum, String mid, int pnum, int qty, int price, int amount, Timestamp orderdate) {
		super();
		this.onum = onum;
		this.mid = mid;
		this.pnum = pnum;
		this.qty = qty;
		this.price = price;
		this.amount = amount;
		this.orderdate = orderdate;
	}
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	@Override
	public String toString() {
		return "Order [onum=" + onum + ", mid=" + mid + ", pnum=" + pnum + ", qty=" + qty + ", price=" + price
				+ ", amount=" + amount + ", orderdate=" + orderdate + "]";
	}
	
	
}
