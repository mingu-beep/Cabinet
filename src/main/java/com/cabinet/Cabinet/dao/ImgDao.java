package com.cabinet.Cabinet.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class ImgDao {
	  @Autowired
	    private SqlSession query;
	    
	    public void saveImage(Map<String, Object> hmap) throws SQLException {
			query.insert("query.saveImage", hmap);
		}
	    
	    public Map<String, Object> getImg() {
	    	return query.selectOne("query.getImg");
	    }
}
