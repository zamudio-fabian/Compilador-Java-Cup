package com.lexical.analyzer;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lexical.analyzer.*;
	


public class TablaSimbolo {

	private static String _resultPath = System.getProperty("user.dir") + "/assets/ts.txt";
	
	HashMap<String, Simbolo> simbolos;
	private int STRING_LIMIT = 30;
	private int ID_LIMIT = 30;
	
	public TablaSimbolo() {
		this.simbolos = new HashMap();
	}
	
	private void agregarSimbolo(Tokens t, String valor, String type) {
		Simbolo simb = new Simbolo(t, valor, type);
		
		/* Veficio si ya esta antes de agregarlo. Si es asi, no lo agrego */
		if ( !this.simbolos.containsValue(simb) ) {
			this.simbolos.put(simb.getHash(), simb);
		}
		
	}
	
	public boolean addReal(String r) {
		/* validacion */
		if (!this.validateReal(r)) {
			
			return false;
		}
	
		this.agregarSimbolo(Tokens.CONST_REAL, r, null);
		return true;
	}
	
	
	public boolean addInt(String i) {
		if (!this.validateInt(i)) {
			
			return false;
		}
		
		this.agregarSimbolo(Tokens.CONST_INT, i, null);
		return true;
	}
	
	public boolean addString(String s) {
		if (!this.validateString(s)) {
			return false;
		}
		
		this.agregarSimbolo(Tokens.CONST_STRING, s, null);
		return true;
	}
	
	public boolean addId(String s, String type) {
		if (!this.validateId(s)) {
			
			return false;
		}
		
		this.agregarSimbolo(Tokens.ID, s, type);
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
		int asd = 2;
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
		return true ;
	}
	
	private boolean validateString(String s) {
		// Se suma 2 por las comillas de los extremos
		if (s.length() > STRING_LIMIT + 2) {
			return false;
		}
		return true;
	}
	
	private boolean validateId(String s) {
		// Se suma 2 por las comillas de los extremos
		if (s.length() > ID_LIMIT + 2) {
			return false;
		}
		return true;
	}
	
	/**
	 * Guarda la tabla a un archivo
	 */
	public void save() {
		
		try {
        	File archivo = new File(_resultPath);
            PrintWriter outputStream;
            outputStream = new PrintWriter(archivo);
            outputStream.println(String.format("%-40s %-20s %-10s %-40s %-10s", "NOMBRE", "TOKEN", "TIPO", "VALOR", "LONG"));
            for (HashMap.Entry<String, Simbolo> entry : this.simbolos.entrySet()) {
            	outputStream.println(entry.getValue().toString());
            }
            outputStream.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("LOGGER").log(Level.SEVERE, null, ex);
        }
        
	}
}
