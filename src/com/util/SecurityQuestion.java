package com.util;

import java.util.HashMap;

public class SecurityQuestion {
	static HashMap<Integer, String> questions = new HashMap<Integer, String>();
	static {
		questions.put(1,"What is your favourite food dish");
		questions.put(2, "Who is your favourite player");
		questions.put(3,"What is name of your pet");
		questions.put(4, "What is name of your childhood friend ");
		questions.put(5, "Type your own question");
		
	}
	public static HashMap<Integer, String> questionSet(){
		return questions;
	}
	
}
