package com.bedbath.jdalookups.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bedbath.common.util.GetDataSource;
import com.bedbath.jdalookups.model.Color;
import com.bedbath.jdalookups.model.Hierarchy;
import com.bedbath.jdalookups.model.MerchandiseGroup;
import com.bedbath.jdalookups.model.PriceGroup;
import com.bedbath.jdalookups.model.ProductGroupHeader;
import com.bedbath.jdalookups.model.Size;
import com.bedbath.jdalookups.model.SkuLookup;
import com.bedbath.jdalookups.model.StateProvince;
import com.bedbath.jdalookups.model.Store;
import com.bedbath.jdalookups.model.TblFld;
import com.bedbath.jdalookups.model.Vendor;
import com.bedbath.jdalookups.model.Zone;

@Repository
public class JdaLookupDAOImpl implements JdaLookupDAO {
	
	public List<SkuLookup> getLookupSkus(String sql, String server) throws Exception {	

		List<SkuLookup> skuLookup = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		skuLookup =  select.query(sql, new SkuLookupRowMapper());
		return skuLookup;
	}
	
	public List<ProductGroupHeader> getLookupProductGroups(String sql, String server) throws Exception {	

		List<ProductGroupHeader> groupHeader = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		groupHeader =  select.query(sql, new ProductGroupHeaderRowMapper());
		return groupHeader;
	}
		
	public List<Hierarchy> getHierarchy(String sql, String server) throws Exception {	

		List<Hierarchy> hierarchy = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		hierarchy =  select.query(sql, new HierarchyRowMapper());
		return hierarchy;
	}
		
	public List<Vendor> getVendors(String sql, String server) throws Exception {	

		List<Vendor> vendors = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		vendors =  select.query(sql, new VendorRowMapper());
		return vendors;
	}
		
	public List<Color> getColors(String sql, String server) throws Exception {	

		List<Color> colors = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		colors =  select.query(sql, new ColorRowMapper());
		return colors;
	}
	
	public List<Size> getSizes(String sql, String server) throws Exception {	

		List<Size> sizes = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		sizes =  select.query(sql, new SizeRowMapper());
		return sizes;
	}
	
	public List<MerchandiseGroup> getMerchandiseGroups(String sql, String server) throws Exception {	

		List<MerchandiseGroup> merchandiseGroups = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		merchandiseGroups =  select.query(sql, new MerchandiseGroupRowMapper());
		return merchandiseGroups;
	}

	
	public List<PriceGroup> getPriceGroups(String sql, String server) throws Exception {	

		List<PriceGroup> priceGroups = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		priceGroups =  select.query(sql, new PriceGroupRowMapper());
		return priceGroups;
	}
	
	public List<TblFld> getTblFldEntries(String sql, String server) throws Exception {	

		List<TblFld> tblFld = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		tblFld =  select.query(sql, new TblFldRowMapper());
		return tblFld;
	}
		
	public List<Store> getStores(String sql, String server) throws Exception {	

		List<Store> stores = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		stores =  select.query(sql, new StoreRowMapper());
		return stores;
	}
	
	public List<Zone> getZones(String sql, String server) throws Exception {	

		List<Zone> zones = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		zones =  select.query(sql, new ZoneRowMapper());
		return zones;
	}

	public List<StateProvince> getStates(String sql, String server) throws Exception {	

		List<StateProvince> states = new ArrayList();
		GetDataSource getDataSource = new GetDataSource();	
		JdbcTemplate select = new JdbcTemplate();	
		select = new JdbcTemplate(getDataSource.getDataSource(server));

		states =  select.query(sql, new StateProvinceRowMapper());
		return states;
	}
		
	public String getLookupName(String sql, String server) throws Exception {
		
		GetDataSource getDataSource = new GetDataSource();
		JdbcTemplate select = new JdbcTemplate();
		select = new JdbcTemplate(getDataSource.getDataSource(server));
		
		String name = "**NOT FOUND**";
		
		List<Map<String, Object>> byteMe = select.queryForList(sql);		
		if(byteMe.size()>0){
			name = (String)byteMe.get(0).get("NAME");	
		} 
				
		return name;			
		
	}
	
}
