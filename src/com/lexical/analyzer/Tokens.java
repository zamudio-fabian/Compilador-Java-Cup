  
package com.lexical.analyzer;

public enum Tokens {

	DECLARESECTION, BREAK,  ENDDECLARESECTION, FOR, ENDFOR, LONG, DEFVAR,CASE,OTHER,ENDIF,OUTPUT,ENDCASE,ENDWHILE,
	PROGRAMSECTION,ENDPROGRAMSECTION,DO,STRING, COMA, DOS_PUNTOS, ENDDEF, ELSE, IF, WHILE, WRITE, TIPO_STRING, TIPO_REAL, TIPO_INT,
	FIN_INSTRUCCION, ID, CONST_INT, CONST_REAL, CONST_STRING, OP_ASIGNACION, OP_IGUAL, OP_SUMA, OP_RESTA, OP_MULTIPLICACION,
	OP_DIVISION, OP_DISTINTO, OP_MAYOR_IGUAL, OP_MENOR_IGUAL, OP_MAYOR, OP_MENOR, BLOQUE_ABRE, BLOQUE_CIERRA, CORCHETE_ABRE, 
	CORCHETE_CIERRA, PARENTESIS_ABRE, PARENTESIS_CIERRA, DOS_PUNTO, ERROR,
	COMENTARIO_EMPIEZA,COMENTARIO_TERMINA,CONTENIDO_DEL_COMENTARIO

}