package com.sinauacademy.hackme.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.sinauacademy.hackme.domain.Invoice;
import com.sinauacademy.hackme.escape.ValidatorOutput;

public class ReflectionTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		ValidatorOutput validate = new ValidatorOutput();
		
		List<Invoice> result = new ArrayList<Invoice>();
		
		Invoice inv = new Invoice();
		inv.setDariKepada("adasdsada");
		result.add(inv);
		inv = new Invoice();
		inv.setKeterangan("<script></script>");
		result.add(inv);
		
		if(result instanceof List){
			System.out.println("List");
			if(result.size() > 0){
				System.out.println("ADA");
				for(Object obj: result){
					for(Method method: obj.getClass().getMethods()){
						if(method.getName().startsWith("get") && !("getClass".equals(method.getName()))){
							//System.out.println(method.getName());
							System.out.println(method.invoke(obj));
						}
					}
				}
			}
		}
		
		
	}
}
