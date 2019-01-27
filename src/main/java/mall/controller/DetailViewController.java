package mall.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.ShoppingInfo;
import product.controller.CompositeDao;

@Controller
public class DetailViewController {
	
	private static final String command = "/detailview.mall";
	private static final String getPage = "ShopResult";
	
	@Autowired
	private CompositeDao compositeDao;
	
	@RequestMapping(value = command)
	public String doActionPost(HttpSession session, 
			@RequestParam(value="pnum", required = true) int pnum, Model model ) {
		
		if(session.getAttribute("loginInfo") == null) {
			
			session.setAttribute("destination", "redirect:/list.mt");
			return "redirect:/login.mem";
		
		} else {
			
			List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
			List<HashMap<String, Object>> lists = this.compositeDao.ShowDetail(pnum);
			System.out.println("lists.size() : " + lists.size());
			
			for(int i=0 ; i<lists.size(); i++) {
				HashMap<String,Object> hash = lists.get(i);
				Set<String> set = hash.keySet();
				System.out.println("set : " + set);
				//set : [PANME, PNUM , PRICE, AMOUNT, QTY]
				
				for(String s : set) {
					Object obj = hash.get(s);
					System.out.println("obj : " + obj);
				}//for
				System.out.println("===========================");
			}//for
			
			for(HashMap<String,Object> map : lists) {
				BigDecimal pnum2 = (BigDecimal)map.get("PNUM");
				//pnum이 중복이라 pnum2로
				String pname = (String)map.get("PNAME");
				BigDecimal qty = (BigDecimal)map.get("QTY");
				BigDecimal price = (BigDecimal)map.get("PRICE");
				BigDecimal amount = (BigDecimal)map.get("AMOUNT");
				System.out.println(pname + " / " + qty +" / " + price + " / " + amount);
				
				ShoppingInfo shopinfo = new ShoppingInfo();
				shopinfo.setPnum(pnum2.intValue());
				shopinfo.setPname(pname);
				shopinfo.setQty(qty.intValue());
				shopinfo.setAmount(amount.intValue());
				
				shoplists.add(shopinfo);
				
			}//for
			
			model.addAttribute("pnum", pnum);//
			model.addAttribute("shoplists", shoplists);
			
			return getPage;//ShopResult.jsp
		}
	}

}
