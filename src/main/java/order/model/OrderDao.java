package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyOrderDao")
public class OrderDao {
	
	private static String namespace="order.model.Order";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public Integer InsertData(String id) {
		
		Order order = new Order();
		order.setMid(id);
		//주문자 id를 가져와서 Order에 있는 mid로 설정
		Integer cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertData", order);
		//넘기는 데이터가 하나라면 그 변수만 넘겨도 되지만 두 개 이상이라면 하나로 묶어서 보내자
		return cnt;
	}
	
	//가장 최근의 주문번호를 가져온다 
	public int GetMaxOrderNum() {
		 
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetMaxOrderNum");
		return cnt;
	}

	
	
}
