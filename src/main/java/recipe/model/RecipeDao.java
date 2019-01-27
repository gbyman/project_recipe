package recipe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;
import utility.recipePaging;

@Component("recipeDao")
public class RecipeDao {

	private final String namespace = "recipe.model.Recipe";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public RecipeDao() {

	}

	//변수(recnum)로 총 갯수 파악해서 보내기
	public int GetTotalCount(Map<String, String> map) {

		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount", map);
		return cnt;

	}

	//레시피 리스트 작성해서 보내기
	public List<Recipe> GetDataList(recipePaging pageInfo, Map<String, String> map) {

		List<Recipe> lists = new ArrayList<Recipe>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList", map, rowBounds);

		return lists;
	}

	//recnum을 통해서 데이터 담아 보내기
	public Recipe GetData(int recnum) {

		Recipe recipe = null;
		recipe = sqlSessionTemplate.selectOne(namespace+".GetData", recnum);
		return recipe;
	}

	//recnum을 통해서 데이터 지우기
	public int DeleteData(int recnum) {

		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteData", recnum);
		return cnt;
	}

	//recipe내에 변수들 DB에 입력하기
	public Integer InsertData(Recipe recipe) {

		Integer cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertData", recipe);
		return cnt;
	}

	//recipe내에 변수들 DB수정
	public Integer UpdateData(Recipe recipe) {

		Integer cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateData", recipe);
		return cnt;
	}

	public List<Recipe> searchRecipe(Map<String, String> map) {
		List<Recipe> list=new ArrayList<Recipe>();
		list=sqlSessionTemplate.selectList(namespace+".searchRecipe", map);
		return list;
	}

	public List<Recipe> recentRecipe(int count) {
		List<Recipe> list=new ArrayList<Recipe>();
		RowBounds rowBounds=new RowBounds(count, 3);
		list=sqlSessionTemplate.selectList(namespace+".recentRecipe", null, rowBounds);
		return list;
	}

	public List<Recipe> selectById(String id) {
		List<Recipe> list=new ArrayList<>();
		list=sqlSessionTemplate.selectList(namespace+".selectById", id);
		return list;
	}

	public void deleteById(String id) {
		int cnt=0;
		cnt=sqlSessionTemplate.delete(namespace+".deleteById", id);
		System.out.println("secDelcnt:"+cnt);
	}
	


}
