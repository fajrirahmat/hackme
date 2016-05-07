package com.sinauacademy.hackme.escape;

public class ValidateOutputTest {
	public static void main(String[] args){
		ValidatorOutput a = new ValidatorOutput();
		String te = a.validate("asd", "<!--");
		System.out.println(te);
	}
}
