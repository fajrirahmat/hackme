package com.sinauacademy.hackme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinauacademy.hackme.domain.Invoice;

public class InvoiceMapper implements RowMapper<Invoice> {

	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Invoice invoice = new Invoice();
		invoice.setNoFaktur(rs.getString("no_faktur"));
		invoice.setLastUpdate(rs.getDate("last_update"));
		invoice.setLastUser(rs.getString("last_user"));
		invoice.setDariKepada(rs.getString("dari_kepada"));
		invoice.setKeterangan(rs.getString("keterangan"));
		invoice.setTglFaktur(rs.getDate("tgl_faktur"));
		return invoice;
	}

}
