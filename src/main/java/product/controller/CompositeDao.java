package product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import allmember.model.AllMember;
import order.model.Order;

@Component
public class CompositeDao {
	
	private static final String namespace = "product.model.Composite";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public CompositeDao() {
		
	}
	
	public List<Order> OrderMall(AllMember loginInfo){
		
		List<Order> lists = new ArrayList<Order>();
		lists = sqlSessionTemplate.selectList(namespace+".OrderMall", loginInfo.getId());
		System.out.println("Order Mall lists.size() : " + lists.size());
		return lists;
	}
	
	public List<HashMap<String, Object>> ShowDetail(int pnum){
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("onum", pnum);
		List<HashMap<String,Object>> maplists = null;
		
		maplists = sqlSessionTemplate.selectList(namespace+".ShowDetail", map);
		
		return maplists; //DetatilViewController로 리턴
	}
}
