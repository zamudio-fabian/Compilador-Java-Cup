package com.lexical.analyzer;

public class LexicalError {
	
	String lexeme;
	String tipo;
	String description;
	int line;
	int column;
	
	public LexicalError(String lexeme, String tipo, String description, int line, int column) {
		this.lexeme = lexeme;
		this.tipo = tipo;
		this.description = description;
		this.line = line;
		this.column = column;
	}
	
	public String getLexeme() {
		return lexeme;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescription() {
		return description;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

}
