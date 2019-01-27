package mall.cart;

import java.util.HashMap;
import java.util.Map;

//내 장바구니
public class MyCartList {
	
	private Map<Integer, Integer> orderlists = null;
	//key는 상품 번호, value는 주문 수량
	
	public MyCartList() {
		
		orderlists = new HashMap<Integer, Integer>();
		
	}
	
	//pnum에 해당하는 상품에 주문 수량을 추가
	public void AddOrder(int pnum, int oqty) {//상품번호, 주문수량
		
		if(orderlists.containsKey(pnum) == false) {
			
			orderlists.put(pnum, oqty);
			
		} else {
			
			orderlists.put(pnum, orderlists.get(pnum) + oqty);
			//pnum 번호 상품의 판매수량을 가져와서 주문수량을 더한 후에 다시 map에 넣는다
			
		}//if ~ else
	}
	
	public Map<Integer, Integer> GetAllOrderLists(){
		
		return orderlists;
	}
	

}
