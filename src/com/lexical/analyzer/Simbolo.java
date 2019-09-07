package com.lexical.analyzer;
import com.lexical.analyzer.Tokens.*;
import java.security.MessageDigest;


public class Simbolo {
	
	private Tokens Token;
	private String Type = null;
	private String Value;
	private String Hash;
	
	public Simbolo (Tokens token, String value) {
		this.Token = token;
		this.Value = value;
		
		String combination = token + value + token.name();
		
		this.Hash = MD5(combination);
	}
	
	public String getHash() {
		return this.Hash;
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
		if (this.Token == Tokens.CONST_STRING){
			return String.valueOf(this.Value.length());
		}else {
			return "-";		
		}
	}
	
	public String toString() {
		return String.format("%-40s %-20s %-10s %-40s %-10s", this.Hash, this.Token, "-", this.Value, this.getLength());
	}
}