package mall.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import allmember.model.AllMember;
import order.model.Order;
import product.controller.CompositeDao;

@Controller
public class OrderMallController {//주문 내역 보기
	//ProductDetailView.jsp에서 바로구매 클릭 시
	private static final String command = "/order.mall"; 
	private static final String getPage = "ShopList";
	
	@Autowired
	private CompositeDao compositeDao;
	
	@RequestMapping(value=command)
	public String doActionPost(HttpSession session, Model model) {
		
		AllMember loginInfo = (AllMember)session.getAttribute("loginInfo");
		
		if(loginInfo == null) {
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/login.mem";
		
		} else {
			
			//lists : 주문 내역 담고 있는 변수
			List<Order> lists = this.compositeDao.OrderMall(loginInfo);
			
			for(Order order : lists) {
				int onum = order.getOnum();
				String mid = order.getMid();
				int pnum = order.getPnum();
				int qty = order.getQty();
				int amount = order.getAmount();
				Timestamp orderdate = order.getOrderdate();
				System.out.println("onum : "+onum + " mid : " + mid + " pnum : " + pnum + " qty : " +qty + " amount : "+ amount +" orderdate : "+orderdate);
				
			}//End of for
			
			model.addAttribute("orderlists", lists);
			
			return getPage;//ShopList.jsp
			
		}//if ~ else
		
	}
}
