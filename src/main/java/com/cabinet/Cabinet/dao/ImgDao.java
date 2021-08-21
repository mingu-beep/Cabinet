package com.cabinet.Cabinet.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class ImgDao {

	    private SqlSession query;

	    public void saveImage(Map<String, Object> hmap) throws SQLException {
				query.insert("query.saveImage", hmap);
		}

	    public Map<String, Object> getImg() {
	    	return query.selectOne("query.getImg");
	    }
}
