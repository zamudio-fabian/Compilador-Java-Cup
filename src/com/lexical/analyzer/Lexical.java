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
        	
            String resultado = "";
            Lexico lexer = createLexer(codePath);
            boolean isEOF = false;
            
            while (!isEOF) {
                Tokens tokens = lexer.yylex();
                isEOF = tokens == null;
                if (!isEOF) {
                    resultado += analyzeToken(lexer, tokens);
                }
            }
            lexer.save();
            generateSymbolTable(resultado);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        }
		
	}
	
	private Lexical() { }
	
	private String analyzeToken(Lexico lexer, Tokens tokens) {
		switch (tokens) {
	    	case ERROR:
	            return lexer.yytext() + "Simbolo no definido\n";
	    	case LONG:
	    	case DEFVAR:
	    	case ENDDEF:
	    	case ELSE:
	    	case IF:
	    	case WHILE:
	    	case WRITE:
	    	case TIPO_STRING:
	    	case TIPO_REAL:
	    	case FIN_INSTRUCCION:
	    	case ID:
	    	case CONST_REAL:
	    	case CONST_STRING:
	    	case OP_ASIGNACION:
	    	case OP_IGUAL:
	    	case OP_SUMA:
	    	case OP_RESTA:
	    	case OP_MULTIPLICACION:
	    	case OP_DIVISION:
	    	case OP_DISTINTO:
	    	case OP_MAYOR_IGUAL:
	    	case OP_MENOR_IGUAL:
	    	case OP_MAYOR:
	    	case OP_MENOR:
	    	case BLOQUE_ABRE:
	    	case BLOQUE_CIERRA:
	    	case CORCHETE_ABRE:
	    	case CORCHETE_CIERRA:
	    	case PARENTESIS_ABRE:
	    	case PARENTESIS_CIERRA:
	    	case DOS_PUNTO:
	            return lexer.yytext() + ": Es un " + tokens + " con largo " + lexer.yylength() +  "\n";
	        default:
	            return "Token: " + tokens + "\n";
	    }
	}
	
	private Lexico createLexer(String codePath) throws FileNotFoundException {
		
    	FileReader fileReader = new FileReader(codePath);
        Reader lector = new BufferedReader(fileReader);
        return new Lexico(lector);
	}
	
	private void generateSymbolTable(String resultado) {

        try {
        	File archivo = new File(_resultPath);
            PrintWriter escribir;
            escribir = new PrintWriter(archivo);
            escribir.print(resultado);
            escribir.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        }
	}
	
	

}
