package com.lexical.analyzer;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Lexical implements ILexical {

	private static ILexical _instance;
	private static String _resultPath = System.getProperty("user.dir") + "/assets/ts.txt";
	
	
	public static ILexical getInstance() {
		if(_instance == null) {
			_instance = new Lexical();
		}

		return _instance;
	}

	@Override
	public void generateLexer(String rulesPath) {
		File rulesFile = new File(rulesPath);
		jflex.Main.generate(rulesFile);
		
	}

	@Override
	public void analyzeCode(String codePath) {
        
        try {
        	
            Lexico lexer = createLexer(codePath);
            boolean isEOF = false;
            
            while (!isEOF) {
                Tokens tokens = lexer.yylex();
                isEOF = tokens == null;
                
                if (!isEOF && !lexer.hasError) {
                    analyzeToken(lexer, tokens);
                }
                
            }
            if(!lexer.hasError) {
                lexer.save();
                System.out.println("Compile successful!!!" );
            }else {
            	System.out.println("Compilation error: " + lexer.errorMessage );
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        }
		
	}
	
	private Lexical() { }
	
	private void analyzeToken(Lexico lexer, Tokens tokens) {
		switch (tokens) {
			case ERROR:
	            break;
	        default:
	            System.out.println(lexer.yytext() + "\t\t\t\t es un " + tokens );
	            break;
	    }
	}
	
	private Lexico createLexer(String codePath) throws FileNotFoundException {
		
    	FileReader fileReader = new FileReader(codePath);
        Reader lector = new BufferedReader(fileReader);
        return new Lexico(lector);
	}

}
