package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import utility.productPaging;

@Component("productDao")
public class ProductDao {
	
	private final static String namespace = "product.model.Product";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public ProductDao() {
		
	}
	
	//변수(pnum)로 총 갯수 파악해서 ProductListController로 보내기
	public int GetTotalCount(Map<String, String> map) {
		
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount", map);
		return cnt;
	}

	//제품 리스트 모아서 보내기
	public List<Product> GetDataList(productPaging pageInfo, Map<String, String> map) {
		
		List<Product> lists = new ArrayList<Product>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList", map, rowBounds);
		return lists;
	}
	
	//DB에 데이터 입력
	public Integer InsertData(Product product) {
		
		Integer cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertData", product);
		return cnt;
		
	}

	public Product GetData(int pnum) {
		
		Product product = null;
		product = sqlSessionTemplate.selectOne(namespace+".GetData", pnum);
		return product;
	}

	public Integer UpdateData(Product product) {

		Integer cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateData", product);
		return cnt;
	}

	public int DeleteData(int pnum) {
		
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteData", pnum);
		return cnt;
	}
	
	//CartCalculateController에서 넘어옴(결제하기 에서 넘어옴)
	public Integer UpdateData2(Integer pnum, Integer qty) {
		
		System.out.println("UpdateData pnum : " + pnum);
		System.out.println("UpdateData qty : " + qty);
		
		Product bean = new Product();
		bean.setPnum(pnum);
		bean.setStock(qty);
		
		Integer cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateData2", bean);
		return cnt;
	}

	

	public List<Product> selectPageRow(productPaging pageInfo, String pkind) {
		List<Product> list=new ArrayList<Product>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
	
		list=sqlSessionTemplate.selectList(namespace+".selectPageRow", pkind,rowBounds);
		return list;
	}

	public int totalpkindCount(String pkind) {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".totalpkindCount",pkind);
		return cnt;
	}

	public List<Product> GetDataList() {
		List<Product>list=null;
		RowBounds rowBounds=new RowBounds(0, 8);
		list=sqlSessionTemplate.selectList(namespace+".GetDataList1", null, rowBounds);
		return list;
	}  

	
}
