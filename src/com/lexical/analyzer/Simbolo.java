package com.lexical.analyzer;
import com.lexical.analyzer.Tokens.*;
import java.security.MessageDigest;


public class Simbolo {
	
	private Tokens token;
	private String type = null;
	private String value;
	private String nombre;
	
	public Simbolo (Tokens token, String value, String type_var) {
		this.token = token;
		this.value = value;
		this.type  = type_var;
		
		if (token == Tokens.CONST_STRING) {
			this.value = this.value.substring(1, this.value.length() - 1);
		}
		
		/* Si es const, _"nombre const" */
		if (token == Tokens.CONST_INT || token == Tokens.CONST_REAL || token == Tokens.CONST_STRING) {
			this.nombre = "_" + this.value;
			this.type = "-";
		}
		/* Si es id, id */
		else if (token == Tokens.ID) {
			this.nombre = this.value;
			this.type = type_var;
			this.value = "-";
		}
	}
	
	public String getHash() {
		return this.nombre;
	}
	
	private String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	
	private String getLength() {
		if (this.token == Tokens.CONST_STRING){
			return String.valueOf(this.value.length());
		}else {
			return "-";		
		}
	}
	
	public String toString() {
		return String.format("%-40s %-20s %-10s %-40s %-10s", this.nombre, this.token, this.type , this.value, this.getLength());
	}
}