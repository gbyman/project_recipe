package orderdetail.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDetailDao")
public class OrderDetailDao {
	
	private static final String namespace = "orderdetail.model.OrderDetail";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public OrderDetailDao() {
		
	}
	
	public Integer InsertData(OrderDetail odBean) {
		
		Integer cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertData", odBean);
		return cnt;
		
	}
	
}
