package com.lexical.analyzer;

public class Lexical implements ILexical {

	private static ILexical _instance;
	
	private Lexical() 
    { 
    }
	
	public static ILexical getInstance() {
		if(_instance == null) {
			_instance = new Lexical();
		}

		return _instance;
	}

	@Override
	public void generateTokens() {
		// TODO Auto-generated method stub
		
	}

}
