package com.sinauacademy.hackme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sinauacademy.hackme.dao.InvoiceDao;
import com.sinauacademy.hackme.domain.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	
	@Autowired
	private InvoiceDao invoiceDao;
	
	public Invoice findById(String id) {
		// TODO Auto-generated method stub
		return invoiceDao.findById(id);
	}

	public List<Invoice> getAll() {
		// TODO Auto-generated method stub
		return invoiceDao.getAll();
	}

	public Invoice add(Invoice invoce) {
		// TODO Auto-generated method stub
		return invoiceDao.add(invoce);
	}

}
