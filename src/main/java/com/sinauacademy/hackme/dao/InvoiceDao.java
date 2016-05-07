package com.sinauacademy.hackme.dao;

import java.util.List;

import com.sinauacademy.hackme.domain.Invoice;


public interface InvoiceDao {
	Invoice findById(String id);
	List<Invoice> getAll();
	Invoice add(Invoice add);
}
