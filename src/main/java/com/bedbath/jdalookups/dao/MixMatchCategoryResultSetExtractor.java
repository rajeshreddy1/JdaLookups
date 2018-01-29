package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.MixMatchCategory;

public class MixMatchCategoryResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		MixMatchCategory mixMatchCategory = new MixMatchCategory();
		
		mixMatchCategory.setMixMatchCategoryCode(rs.getInt("PcCatg"));
		mixMatchCategory.setMixMatchCategoryName(rs.getString("PcDesc"));		
		mixMatchCategory.setTotalRows(rs.getDouble("TOTAL_ROWS"));		
		
		return mixMatchCategory;		
	}				
	
}