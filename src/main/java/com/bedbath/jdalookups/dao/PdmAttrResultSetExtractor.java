package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.PdmAttribute;

public class PdmAttrResultSetExtractor implements ResultSetExtractor<List<PdmAttribute>> {

	public List<PdmAttribute> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<PdmAttribute> attrs = new LinkedList<PdmAttribute>();
		
        while(rs.next()){  
        	PdmAttribute attr = new PdmAttribute();  
        	attr.setAttrVal(rs.getString("ATTRIBUTE_VALUE"));  
        	//attr.setTotal(rs.getInt("ATTRIBUTE_VALUE"));  
        	attrs.add(attr);
        } 
		
		return attrs;		
	}				
	
}