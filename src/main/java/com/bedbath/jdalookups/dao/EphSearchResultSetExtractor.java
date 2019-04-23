package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.PdmAttribute;

public class EphSearchResultSetExtractor implements ResultSetExtractor<List<PdmAttribute>> {

	public List<PdmAttribute> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<PdmAttribute> attrs = new LinkedList<PdmAttribute>();
		
        while(rs.next()) {
        	
        	PdmAttribute attr = new PdmAttribute();
        	attr.setAttrCode(rs.getString("EPH_NODE_ID"));
        	attr.setAttrVal(rs.getString("EPH_NODE_NAME") == null? "": rs.getString("EPH_NODE_NAME").trim());  
        	attr.setTotal(rs.getInt("TOTAL_ROWS"));  
        	attrs.add(attr);
        } 
		
		return attrs;		
	}				
	
}