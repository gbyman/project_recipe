package mall.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mall.cart.MyCartList;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class CartAddController {
	
	private static final String gotoPage = "redirect:/list.mall"; //CartListController
	private static final String command = "/add.mall";
	
	@Autowired
	public ProductDao productDao;
	
	//ProductDetailView.jsp에서 장바구니 클릭시
	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doActionPost(HttpSession session, Product product) throws IOException {
	
		System.out.println("CartAddController Post");
		System.out.println("product.getPnum() : " + product.getPnum() );
		System.out.println("product.getOrderqty() : " + product.getOrderqty());
		
		int pnum = product.getPnum();
		int qty = product.getOrderqty();
		
		//로그인 안되있으면 로그인 먼저
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/detail.mt?pnum="+pnum);
			return "redirect:/login.mem";
		
		} else {//로그인 되어 있으면 카트에 담는다
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			System.out.println("mycart : " + mycart);
			
			if(mycart == null) { //카트가 없으면 새로운 객체 생성
				
				mycart = new MyCartList();// 카트(장바구니) 클래스(상품번호, 주문수량의 Map 형태)
			
			}//End of if
			
			mycart.AddOrder(pnum, qty); //Map<Integer, Integer> orderlists에 put하는 기능을 갖고 있다.
			
			session.setAttribute("mycart", mycart);
			
			return gotoPage;	
			
		}//if ~ else
	}

}
