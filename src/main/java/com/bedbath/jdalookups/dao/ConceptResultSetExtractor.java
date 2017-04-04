package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.Concept;

public class ConceptResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		Concept concept = new Concept();
		
		concept.setConceptNumber(rs.getInt("COMPANY_NUMBER"));
		concept.setConceptName(rs.getString("COMPANY_NAME"));
		concept.setDnsName(rs.getString("DNS_NAME"));
				
		return concept;		
	}				
	
}