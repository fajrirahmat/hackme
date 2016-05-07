package com.sinauacademy.hackme.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinauacademy.hackme.bean.InvoiceRequest;
import com.sinauacademy.hackme.domain.Invoice;
import com.sinauacademy.hackme.service.InvoiceService;

@RestController
@RequestMapping(value = "/" + InvoiceController.FUNCTION)
public class InvoiceController {
	public static final String FUNCTION = "invoice";
	
	@Autowired
	InvoiceService service;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET )
	public ResponseEntity<List<Invoice>> getAll(){
		List<Invoice> result = new ArrayList<Invoice>();
		result = service.getAll();
		return new ResponseEntity<List<Invoice>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> add(@RequestBody InvoiceRequest request, UriComponentsBuilder builder){
		System.out.println("Invoice from/to: " + request.getInvoice().getDariKepada());
		com.sinauacademy.hackme.bean.Invoice invRequest = request.getInvoice();
		Invoice invoice = new Invoice();
		invoice.setDariKepada(invRequest.getDariKepada());
		invoice.setKeterangan(invRequest.getKeterangan());
		invoice.setLastUpdate(new Date(invRequest.getLastUpdate()));
		invoice.setLastUser(invRequest.getLastUser());
		invoice.setNoFaktur(invRequest.getNoFaktur());
		invoice.setTglFaktur(new Date(invRequest.getTglFaktur()));
		invoice = this.service.add(invoice);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/hackme/insecureinvoice/getAll").build().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
