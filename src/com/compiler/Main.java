package com.compiler;

import com.lexical.analyzer.ILexical;
import com.lexical.analyzer.Lexical;

public class Main {

	public static void main(String[] args) {
		
		String basePath = System.getProperty("user.dir");
		String lexerPath = basePath + "/src/com/lexical/analyzer/Lexico.flex";
		String codePath = basePath + "/assets/prueba.txt";
		
        ILexical lexical = Lexical.getInstance();
		lexical.generateLexer(lexerPath);
		
		lexical.analyzeCode(codePath);
	}

}
