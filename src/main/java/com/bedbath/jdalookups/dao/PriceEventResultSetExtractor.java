package com.bedbath.jdalookups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bedbath.jdalookups.model.PriceEvent;

public class PriceEventResultSetExtractor implements ResultSetExtractor{

	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {

		PriceEvent priceEvent = new PriceEvent();
		
		priceEvent.setEventDescription(rs.getString("EVHDSC"));
		priceEvent.setEndDate(rs.getInt("EVHEDT"));
		//priceEvent.setEventNumber(rs.getInt("EVENT"));
		priceEvent.setEventNumber(rs.getString("EVENT"));
		priceEvent.setEventLevel(rs.getString("EVHSEL"));
		priceEvent.setEventStatus(rs.getString("EVHSTS"));
		priceEvent.setEventType(rs.getString("EVHTYP"));
		priceEvent.setStartDate(rs.getInt("EVHSDT"));			
		priceEvent.setClearanceSignage(rs.getString("ECCLSN"));
        priceEvent.setComment1(rs.getString("ECCOM1"));		
        priceEvent.setComment2(rs.getString("ECCOM2"));
        priceEvent.setComment3(rs.getString("ECCOM3"));
        priceEvent.setComment4(rs.getString("ECCOM4"));
        priceEvent.setComment5(rs.getString("ECCOM5"));
        priceEvent.setDollarOff(rs.getDouble("EVDOLO"));
		priceEvent.setForcedHardMark(rs.getString("XTHDMK"));
		priceEvent.setPercentOff(rs.getInt("EVPERO"));
		priceEvent.setPricingMethod(rs.getInt("EVMETH"));
		priceEvent.setReasonDescription(rs.getString("TBLDSC"));
		priceEvent.setTotalRows(rs.getDouble("TOTAL_ROWS"));
		
		return priceEvent;		
	}				
	
}
