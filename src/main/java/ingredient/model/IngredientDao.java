package ingredient.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyIngredientDao")
public class IngredientDao {
	
	private static String namespace="ingredient.model.Ingredient";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
}
