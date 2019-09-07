package com.lexical.analyzer;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lexical.analyzer.*;
	


public class TablaSimbolo {
	
	HashMap<String, Simbolo> simbolos;
	private int STRING_LIMIT = 30;
	
	public TablaSimbolo() {
		this.simbolos = new HashMap();
	}
	
	private void agregarSimbolo(Tokens t, String valor) {
		Simbolo simb = new Simbolo(t, valor);
		this.simbolos.put(simb.getHash(), simb);
	}
	
	public boolean addReal(String r) {
		/* validacion */
		if (!this.validateReal(r)) {
			
			return false;
		}
	
		this.agregarSimbolo(Tokens.CONST_REAL, r);
		return true;
	}
	
	public boolean addInt(String i) {
		if (!this.validateInt(i)) {
			
			return false;
		}
		
		this.agregarSimbolo(Tokens.CONST_INT, i);
		return true;
	}
	
	public boolean addString(String s) {
		if (!this.validateString(s)) {
			
			return false;
		}
		
		this.agregarSimbolo(Tokens.CONST_STRING, s);
		return true;
	}

	
	private boolean validateReal(String s) {
		// 32 bits o 4 bytes.
		try {
			float f = Float.parseFloat(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private boolean validateInt(String s) {
		// 16 bits o 2 bytes.
		try {
			short i = Short.parseShort(s);
		} catch (Exception e) {
			return false;
		}
		
		/*
		if ( (i < (-32768)) || (i > 32768) ) {
			return false;
		}
		*/
		return true;
	}
	
	private boolean validateString(String s) {
		// Se suma 2 por las comillas de los extremos
		if (s.length() > STRING_LIMIT + 2) {
			return false;
		}
		return true;
	}
	
	/**
	 * Guarda la tabla a un archivo
	 */
	public void save() {
		/*
		try {
        	File archivo = new File(_resultPath);
            PrintWriter escribir;
            escribir = new PrintWriter(archivo);
            escribir.print(resultado);
            escribir.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        }
        */
	}
}
