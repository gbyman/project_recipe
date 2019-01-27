package orderdetail.model;

public class OrderDetail {
	
	private int odid; //주문 상세보기 시퀀스
	private int onum; //주문 번호
	private int pnum; //상품 번호
	private int qty;  //주문 수량
	
	public int getOdid() {
		return odid;
	}
	public void setOdid(int odid) {
		this.odid = odid;
	}
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
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
}
