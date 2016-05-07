package com.sinauacademy.hackme.bean;

import com.sinauacademy.hackme.domain.Invoice;

public class InvoiceReply extends CommonReply {
	Invoice invoice;

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
