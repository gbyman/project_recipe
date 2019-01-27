package procedure.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyProcedureDao")
public class ProcedureDao {
	private static String namespace="procedure.model.Procedure";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insertProcedure(Procedure procedure) {
		int cnt=0;
		cnt=sqlSessionTemplate.insert(namespace+".insertProcedure", procedure);
		return cnt;
	}

	public List<Procedure> selectByRecnum(int recnum) {
		List<Procedure> list=null;
		list=sqlSessionTemplate.selectList(namespace+".selectByRecnum", recnum);
		
		return list;
	}

	public void deleteProcedure(int recnum) {
		sqlSessionTemplate.delete(namespace+".deleteProcedure", recnum);
	}
	
}
