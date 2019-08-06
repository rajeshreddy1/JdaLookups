package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.BbsAppValuRes;

public class BbsAppValuResultSetExtractor implements ResultSetExtractor<List<BbsAppValuRes>> {
	
	public List<BbsAppValuRes> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<BbsAppValuRes> appValuResSet = new ArrayList<BbsAppValuRes>();
		
		while(rs.next()) {
			
			BbsAppValuRes appValuRes= new BbsAppValuRes();;
			appValuRes.setAppKey(rs.getString("AVKEY"));
			appValuRes.setCharVal1(rs.getString("AVVALU1C"));
			appValuRes.setCharVal2(rs.getString("AVVALU2C"));
			appValuRes.setCharVal3(rs.getString("AVVALU3C"));
			appValuRes.setNumVal1(rs.getLong("AVVALU1N"));
			appValuRes.setNumVal2(rs.getLong("AVVALU2N"));
			appValuRes.setNumVal3(rs.getLong("AVVALU3N"));
			appValuRes.setDocumentPath(rs.getString("AVVALU1P"));
			appValuRes.setNote1(rs.getString("AVVALU1T"));
			appValuRes.setNote2(rs.getString("AVVALU2T"));
			appValuRes.setTotalRows(rs.getInt("TOTAL_ROWS"));
						
			appValuResSet.add(appValuRes);						
		}
		
		return appValuResSet;		
	}
}
