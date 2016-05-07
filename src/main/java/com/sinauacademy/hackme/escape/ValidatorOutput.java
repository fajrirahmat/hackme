package com.sinauacademy.hackme.escape;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatorOutput {
	private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\s]{0,20}$");
	
	public Object validateObject(Object obj){
		if(obj instanceof List){
			int objSize = ((List) obj).size();
			for(int i=0;i<objSize;i++){
				
			}
		}
		return obj;
	}
	
	public String validate(String name, String input){
		String cannonical = normalize(input);
		if(!pattern.matcher(cannonical).matches()){
			//skip for now
		}
		cannonical = HTMLEntityCode(cannonical);
		
		return cannonical;
		
	}
	
	private String normalize(String input){
		String canonical = Normalizer.normalize(input, Normalizer.Form.NFKC);
		return canonical;
	}
	
	private static String HTMLEntityCode(String input){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<input.length();i++){
			char ch = input.charAt(i);
			if(Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)){
				sb.append(ch);
			}else{
				sb.append("&#" + (int)ch +";");
			}
		}
		return sb.toString();
	}
	
}
