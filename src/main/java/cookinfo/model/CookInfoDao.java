package cookinfo.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.infoPaging;

@Component("MyCookInfoDao")
public class CookInfoDao {
	private static String namespace="cookinfo.model.CookInfo";	
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insertCookInfo(CookInfo cookinfo) {
		int cnt=0;
		cnt=sqlSessionTemplate.insert(namespace+".insertCookinfo", cookinfo);
		return cnt;
	}
	
/*
	public int totalCount() {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".totalCount",cnt);
		return cnt;
	}  
*/

	public CookInfo GetCook(int infonum) {
		CookInfo cookinfo = null;
		cookinfo = sqlSessionTemplate.selectOne(namespace+".GetCook",infonum);
		return cookinfo;
	}
 

	public CookInfo selectByNum(int infonum) {
		CookInfo cookinfo = null;
		cookinfo=sqlSessionTemplate.selectOne(namespace+".selectByNum", infonum);
	
		return cookinfo;
	}


	public  Integer UpdateData(CookInfo cookinfo) {
		Integer cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".UpdateData", cookinfo);
		return cnt;
	}


	public int DeleteData(int infonum) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteData", infonum);
		return cnt;
	}


	public int totalimageCount() {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".totalimageCount",cnt);
		return cnt;
	}

	/*
	public int totalmovieCount() {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".totalmovieCount",cnt);
		return cnt;
	}

*/
/*	public List<CookInfo> selectPageRow(Paging pageInfo, String infokind) {
		List<CookInfo> list=new ArrayList<CookInfo>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		list=sqlSessionTemplate.selectList(namespace+".selectPageRow", infokind,rowBounds);
		return list;
	}

	public List<CookInfo> selectPageRow2(Paging pageInfo2, String infokind) {
		List<CookInfo> list2=new ArrayList<CookInfo>();
		RowBounds rowBounds=new RowBounds(pageInfo2.getOffset(), pageInfo2.getLimit());
		
		list2=sqlSessionTemplate.selectList(namespace+".selectPageRow2", infokind,rowBounds);
		return list2;
	}

	*/
/*	public List<CookInfo> selectPageRow(Paging pageInfo) {
		List<CookInfo> list=new ArrayList<CookInfo>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		list=sqlSessionTemplate.selectList(namespace+".selectPageRow",null, rowBounds);
		return list;
	}

	
	public List<CookInfo> selectPageRow2(Paging pageInfo) {
		List<CookInfo> list=new ArrayList<CookInfo>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		list=sqlSessionTemplate.selectList(namespace+".selectPageRow2", null,rowBounds);
		return list;
	}

*/
	public int totalinfokindCount(String infokind) {
		int cnt=0;
		cnt=sqlSessionTemplate.selectOne(namespace+".totalinfokindCount",infokind);
		return cnt;
	}


	public List<CookInfo> selectPageRow(infoPaging pageInfo, String infokind) {
		List<CookInfo> list=new ArrayList<CookInfo>();
		RowBounds rowBounds=new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		list=sqlSessionTemplate.selectList(namespace+".selectPageRow", infokind,rowBounds);
		return list;
	}

	
	


}