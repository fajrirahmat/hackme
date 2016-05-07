package com.sinauacademy.hackme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinauacademy.hackme.domain.Invoice;
import com.sinauacademy.hackme.escape.ValidatorOutput;
import com.sinauacademy.hackme.service.InvoiceService;

@Controller
@RequestMapping(value =  "/" + InvoiceUnsecureController.FUNCTION)
public class InvoiceUnsecureController {
	public final static String FUNCTION = "insecureinvoice";
	
	@Autowired
	InvoiceService service;
	
	@RequestMapping(value = "/getAll")
	public ModelAndView getAll(ModelAndView mv){
		List<Invoice> result = new ArrayList<Invoice>();
		result = service.getAll();
		mv.addObject("invoices", result);
//		mv.addObject("invoices", escapeList(result));
		mv.setViewName("invoice");
		return mv;
	}
	
	private Invoice escape(Invoice obj){
		ValidatorOutput val = new ValidatorOutput();
		obj.setKeterangan(val.validate("keterangan", obj.getKeterangan()));
		return obj;
	}
	
	private List<Invoice> escapeList(List<Invoice> list){
		List<Invoice> newList = new ArrayList<Invoice>();
		if(list.size() > 0){
			for(int i=0;i<list.size();i++){
				Invoice after = escape(list.get(i));
				newList.add(after);
			}
		}
		return newList;
	}
	
}
