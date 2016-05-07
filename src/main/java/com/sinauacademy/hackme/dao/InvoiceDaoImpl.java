package com.sinauacademy.hackme.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sinauacademy.hackme.domain.Invoice;
import com.sinauacademy.hackme.mapper.InvoiceMapper;

@Repository
public class InvoiceDaoImpl implements InvoiceDao{

	
	private String TABLE_NAME = "invoice";
	private String TABLE_PRIMARY_KEY = "no_faktur";
	
	private String SELECT_BY_ID_QUERY = "SELECT * FROM " + this.TABLE_NAME + " WHERE " + TABLE_PRIMARY_KEY + " = ?";
	private String SELECT_ALL = "SELECT * FROM " + this.TABLE_NAME;
	private String INSERT_INVOICE = "INSERT INTO " + this.TABLE_NAME + 
			"(no_faktur, tgl_faktur, last_user, dari_kepada,keterangan) VALUES(?,?,?,?,?)";
	private String INSERT_QUERY = "INSERT INTO " + TABLE_NAME + "(no_faktur, tgl_faktur, last_user,dari_kepada, last_update, keterangan) values(?,?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Invoice findById(String id) {
		Invoice invoice = null;
		try{
			invoice = jdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new Object[] {id} , new InvoiceMapper());
		}catch(EmptyResultDataAccessException e){
			
		}catch(Exception e){
			
		}
		return invoice;
	}

	public List<Invoice> getAll() {
		try{
			return jdbcTemplate.query(SELECT_ALL, new InvoiceMapper());
		}catch(EmptyResultDataAccessException e){
			
		}catch(Exception e){
			
		}
		return null;
	}

	public void insert(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Invoice add(Invoice add) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(INSERT_QUERY, new Object[] {add.getNoFaktur(), add.getTglFaktur(), add.getLastUser(),
				add.getDariKepada(), add.getLastUpdate(),add.getKeterangan()});
		return add;
	}

}
