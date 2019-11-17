package com.lexical.analyzer;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.*;


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
            System.out.println("\n\n\n\n");
            System.out.println("############################################################");
            System.out.println("#                                                          #");
            System.out.println("#                       COMPILING...                       #");
            System.out.println("#                                                          #");
            System.out.println("############################################################\n");
            
            @SuppressWarnings("deprecation")
			Sintactico sintactico= new Sintactico (lexer);
            sintactico.parse();
            if(!lexer.hasError) {
                lexer.save();
                System.out.println("############################################################");
                System.out.println("#                                                          #");
                System.out.println("#                  COMPILE SUCCESSFUL!!!                   #");
                System.out.println("#                                                          #");
                System.out.println("############################################################\n");
            }else {

                System.out.println("############################################################");
                System.out.println("#                                                          #");
                System.out.println("#                    COMPILATION ERROR                     #");
                System.out.println("#                                                          #");
                System.out.println(generateErrorLine(lexer));
                System.out.println("############################################################\n");
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
		}
		
	}
	
	private Lexical() { }
	
	private String generateErrorLine(Lexico lexer) {
		String message = lexer.errorMessage + " at line " + lexer.errorLine + ":" + lexer.errorColumn ;
		int paddingLeft = (60 - message.length()) / 2;
		int paddingRight = (60 - paddingLeft) - message.length();
		String space = " ";
		
		// create a string made up of n copies of string s
		String spacesLeft = String.join("", Collections.nCopies(paddingLeft - 1, space));
		
		// create a string made up of n copies of string s
		String spaceRight = String.join("", Collections.nCopies(paddingRight - 1, space));
		
		message = "#" + spacesLeft + message + spaceRight + "#";
		return message;
	}
	
	private void analyzeToken(Lexico lexer, Tokens tokens) {
		switch (tokens) {
			case ERROR:
	            break;
	        default:
	        	System.out.println(String.format("%-50s %-30s", lexer.yytext(), tokens));
	            break;
	    }
	}
	
	private Lexico createLexer(String codePath) throws FileNotFoundException {
		
    	FileReader fileReader = new FileReader(codePath);
        Reader lector = new BufferedReader(fileReader);
        return new Lexico(lector);
	}

}
