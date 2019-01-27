package chef.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import recipe.model.Recipe;
import utility.Paging;
import utility.chefPaging;

@Component("chefDao")
public class ChefDao {
	
	private final String namespace = "chef.model.Chef";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public ChefDao() {
		
	}
	
	//변수(chefnum)로 총 갯수 파악해서 보내기
	public int GetTotalCount() {
		
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",cnt);
		return cnt;
	}
	
	//ChefList 만들어서 ChefListController로 
/*	public List<Chef> GetDataList(Paging pageInfo, Map<String, String> map) {
		
		List<Chef> lists = new ArrayList<Chef>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList", map, rowBounds);
		return lists;
	}
	*/
	//chefnum을 통해서 데이터 담아 보내기
	public Chef GetData(int chefnum) {
		
		Chef chef = null;
		chef = sqlSessionTemplate.selectOne(namespace+".GetData", chefnum);
		return chef;
	}
	
	//chefnum을 통해서 데이터 지우기
	public int DeleteData(int chefnum) {
		
		int cnt =-1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteData", chefnum);
		return cnt;
	}
	
	//데이터 DB에 입력
	public Integer InsertData(Chef chef) {
		
		Integer cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertData", chef);
		return cnt;
	}
	
	//데이터 수정
	public Integer UpdateData(Chef chef) {
		
		Integer cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateData", chef);
		return cnt;
	}
	
	public List<Chef> searchChef(Map<String,String> map){
		
		List<Chef> list = new ArrayList<Chef>();
		list = sqlSessionTemplate.selectList(namespace+".searchChef", map);
		return list;
	}
	
	public List<Chef> recentChef(int count){
		
		List<Chef> list = new ArrayList<Chef>();
		RowBounds rowBounds = new RowBounds(count, 3);
		list = sqlSessionTemplate.selectList(namespace, null, rowBounds);
		return list;
	}

	public List<Chef> GetDataList(chefPaging pageInfo) {
		List<Chef> lists = null;
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList", null, rowBounds);

		return lists;
	}
}
