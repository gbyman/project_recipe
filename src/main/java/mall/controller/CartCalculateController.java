package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import allmember.model.AllMember;
import mall.cart.MyCartList;
import order.model.OrderDao;
import orderdetail.model.OrderDetail;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {//CartList에서 결제하기 누르면 이동
	
	private static final String command = "/calculate.mall";
	
	@Autowired
	private ProductDao productDao;//재고 수량 감소
	
	@Autowired
	private OrderDao orderDao; //allorder 테이블에 데이터 추가
	
	@Autowired
	private OrderDetailDao orderDetailDao; //주문 상세 테이블에 추가
	
	@RequestMapping(value = command)
	public String doActionPost(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");//세션 설정 : CartAddController
		//세션에 있는 값을 MyCartList형식의 mycart라는 이름으로 데이터 담는다
		
		System.out.println("MyCartList mycart : " + mycart);
		
		if(mycart != null) {
			
			Map<Integer,Integer> maplists = mycart.GetAllOrderLists();
			System.out.println("CartCalculateController의 maplists.size() : " + maplists.size());
			Set<Integer> keylist = maplists.keySet();
			
			System.out.println("keylist : " + keylist); 
			
			//allorder 테이블에 데이터 추가
			
			AllMember member = ((AllMember)session.getAttribute("loginInfo"));
			orderDao.InsertData(member.getId());
			
			int onum = orderDao.GetMaxOrderNum();
			System.out.println("onum : " + onum);
			//가장 최근 송장번호가 지금 주문한 내용이므로 최근의 송장번호(주문번호)를 가져온다
			//가장 최근의 송장번호를 주문번호로 담는다
			
			for(Integer pnum : keylist) {
				Integer qty = maplists.get(pnum);
				
				System.out.println("order qty : " + qty);
				
				//상품 재고 수량 감소
				productDao.UpdateData2(pnum, qty);
				
				OrderDetail odBean = new OrderDetail();
				odBean.setOnum(onum);	//주문번호
				odBean.setPnum(pnum);	//상품번호
				odBean.setQty(qty);
				
				//주문 상세 테이블에 추가	
				orderDetailDao.InsertData(odBean);
				
			}//End of for
			
			//세션 해제
			session.removeAttribute("shoplists");//구매 후 세션 해제
			session.removeAttribute("mycart");
			
		}//End of if
		
		return "redirect:/list.mt";//상품 목록보기로 돌아감
	}
	

}
