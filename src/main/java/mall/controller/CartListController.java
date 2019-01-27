package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class CartListController {	//CartAddController에서 넘어옴

	private static final String command = "/list.mall";
	private static final String getPage = "CartList";
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value=command)
	public String doActionPost(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer, Integer> maplists = mycart.GetAllOrderLists();
		//maplists : 상품 번호와 주문 수량에 대한 정보를 담고 있는 맵 컬렉션
		//주문한 모든 상품 정보가 리턴된다
		
		Set<Integer> keylist = maplists.keySet();
		//keySet() :  HashMap의 모든 키를 가져온다.
		System.out.println("keylist.size() : " + keylist.size());
		
		List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
		
		
		int totalAmount = 0; //총금액
		
		//keylist에 키값이 없을 때까지 keylist에 있는 키 값을 하나 꺼내 차례대로 pnum에 담는다
		for(Integer pnum : keylist) {
			Integer qty = maplists.get(pnum);
			System.out.println("pnum : " +pnum + ", qty : " + qty);
			//pnum = 상품번호, qty = 구매수량
			
			Product bean = this.productDao.GetData(pnum);
			//pnum에 관한 데이터를 Product형식의 bean에 담는다
			
			ShoppingInfo shopInfo = new ShoppingInfo();
			//주문 내역서를 만들기 위한 준비
			
			int amount = qty * bean.getPrice();
			totalAmount += amount;
			
			shopInfo.setAmount(amount);
			shopInfo.setPname(bean.getPname());
			shopInfo.setPnum(pnum);
			shopInfo.setPrice(bean.getPrice());
			shopInfo.setQty(qty);
			
			System.out.println(shopInfo.toString());
			shoplists.add(shopInfo);
			
		}//for
		
		session.setAttribute("shoplists", shoplists);
		//shoplists : 주문한 상품 번호, 수량, 상품명, 가격
		
		session.setAttribute("totalAmouts", totalAmount);
		
		return getPage;//CartList.jsp
	}
}
