package com.sinauacademy.hackme.service;

import java.util.List;

import com.sinauacademy.hackme.domain.Invoice;

public interface InvoiceService {
	Invoice findById(String id);
	List<Invoice> getAll();
	Invoice add(Invoice invoce);
}
