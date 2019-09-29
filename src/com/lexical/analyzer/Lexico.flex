////////////////////////////////////////////////
// IMPORTS
////////////////////////////////////////////////
package com.lexical.analyzer;
import java_cup.runtime.*;
import java.util.LinkedList;


////////////////////////////////////////////////
// CONFIGS
////////////////////////////////////////////////
%%
%public
%class Lexico
%cup
%char
%line
%column

////////////////////////////////////////////////
// REGEX
////////////////////////////////////////////////
L 																= [a-zA-Z]
GUION_BAJO 														= _
D 																= [0-9]
INT 															= {D}+
R 																= [0-9]+"."[0-9]+
WHITESPACE     													= \r|\n|\r\n|[ \t\f]
OPERADOR 														= (\+|-|\/|\*|>|<|\!=|<=|>=|=){1}
SIGNO 															= ,|:|;
STRING 															= \"({WHITESPACE}|{SIGNO}|{OPERADOR}|{L}|{D}|\.|\!|\¡|ñ|Ñ)*\"
COMENTARIO                                                     	= \-\/([^/]|[\r\n]|(\/+([^/-]|[\r\n])))*\/+\-
WHITE=[ \t\r\n]

////////////////////////////////////////////////
// VARS & FUNCTIONS
////////////////////////////////////////////////
%{
public String lexeme;
public String last_type = "";
public boolean hasError = false;
public String errorMessage = "";
public int errorLine = 0;
public int errorColumn = 0;
public static LinkedList<LexicalError> LexicalErrorList = new LinkedList<LexicalError>();
public static TablaSimbolo SymbolTable = new TablaSimbolo(); 

public void addReal( String value){	
    boolean isOk = SymbolTable.addReal( value);
    if(!isOk) makeError("Real out of range");
}

public void addString( String value) {
    boolean isOk = SymbolTable.addString(value);
    if(!isOk) makeError("String out of range");
}

public void addId( String value) {
    boolean isOk = SymbolTable.addId(value, last_type);
    if(!isOk) makeError("ID out of range");
}

public void addInt(String value) {
    boolean isOk = SymbolTable.addInt(value);
    if(!isOk) makeError("Integer out of range");
}

public void makeError(String error) {
    hasError = true;    
    LexicalError lexicalError = new LexicalError(yytext(), "Error léxico", error, yyline + 1,yycolumn + 1);
    LexicalErrorList.add(lexicalError);
}

public void save(){
    SymbolTable.save();
}

%}

////////////////////////////////////////////////
// LEXICAL RULES
////////////////////////////////////////////////
%%

{COMENTARIO}													{/*Ignore*/}
{WHITE}							                                {/*Ignore*/}
"REAL"                                                          {last_type = "REAL";return new Symbol(sym.TIPO_REAL, yycolumn, yyline);}
"STRING"                                                        {last_type = "STRING";return new Symbol(sym.TIPO_STRING, yycolumn, yyline);}
"INT"                                                           {last_type = "INT";return new Symbol(sym.TIPO_INT, yycolumn, yyline);}
"LONG"                                                          {last_type = "LONG";return new Symbol(sym.LONG, yycolumn, yyline);}
"DEFVAR"                                                        {return new Symbol(sym.DEFVAR, yycolumn, yyline);}
"ENDDEF"                                                        {return new Symbol(sym.ENDDEF, yycolumn, yyline);}
"ELSE"                                                          {return new Symbol(sym.ELSE, yycolumn, yyline);}
"CASE" 															{return new Symbol(sym.CASE, yycolumn, yyline);}
"DO" 															{return new Symbol(sym.DO, yycolumn, yyline);}
"BREAK" 														{return new Symbol(sym.BREAK, yycolumn, yyline);}
"OTHER" 														{return new Symbol(sym.OTHER, yycolumn, yyline);}
"ENDCASE" 														{return new Symbol(sym.ENDCASE, yycolumn, yyline);}
"FOR" 															{return new Symbol(sym.FOR, yycolumn, yyline);}
"ENDFOR"														{return new Symbol(sym.ENDFOR, yycolumn, yyline);}
"IF" 															{return new Symbol(sym.IF, yycolumn, yyline);}
"ENDIF"															{return new Symbol(sym.ENDIF, yycolumn, yyline);}
"WHILE"                                                         {return new Symbol(sym.WHILE, yycolumn, yyline);}
"ENDWHILE"														{return new Symbol(sym.ENDWHILE, yycolumn, yyline);}
"DISPLAY"                                                       {return new Symbol(sym.DISPLAY, yycolumn, yyline);}
"DECLARE.SECTION"                                               {return new Symbol(sym.DECLARESECTION, yycolumn, yyline);}
"ENDDECLARE.SECTION"                                            {return new Symbol(sym.ENDDECLARESECTION, yycolumn, yyline);}
"PROGRAM.SECTION"                                               {return new Symbol(sym.PROGRAMSECTION, yycolumn, yyline);}
"ENDPROGRAM.SECTION"                                            {return new Symbol(sym.ENDPROGRAMSECTION, yycolumn, yyline);}
"WRITE"                                                         {return new Symbol(sym.OUTPUT, yycolumn, yyline);}
","                                     						{return new Symbol(sym.COMA, yycolumn, yyline);}
";"                                     						{return new Symbol(sym.FIN_INSTRUCCION, yycolumn, yyline);}
":="                                     						{return new Symbol(sym.OP_ASIGNACION, yycolumn, yyline);}
"+"                                     						{return new Symbol(sym.OP_SUMA, yycolumn, yyline);}
"-"                                     						{return new Symbol(sym.OP_RESTA, yycolumn, yyline);}
"*"                                     						{return new Symbol(sym.OP_MULTIPLICACION, yycolumn, yyline);}
"/"                                     						{return new Symbol(sym.OP_DIVISION, yycolumn, yyline);}
"=="                                    						{return new Symbol(sym.OP_IGUAL, yycolumn, yyline);}
"!="                                    						{return new Symbol(sym.OP_DISTINTO, yycolumn, yyline);}
">"                                     						{return new Symbol(sym.OP_MAYOR, yycolumn, yyline);}
"<"                                     						{return new Symbol(sym.OP_MENOR, yycolumn, yyline);}
">="                                    						{return new Symbol(sym.OP_MAYOR_IGUAL, yycolumn, yyline);}
"<="                                    						{return new Symbol(sym.OP_MENOR_IGUAL, yycolumn, yyline);}
"&&"                                    						{return new Symbol(sym.AND, yycolumn, yyline);}
"||"                                    						{return new Symbol(sym.OR, yycolumn, yyline);}
"{"                                     						{return new Symbol(sym.BLOQUE_ABRE, yycolumn, yyline);}
"}"                                     						{return new Symbol(sym.BLOQUE_CIERRA, yycolumn, yyline);}
"["                                     						{return new Symbol(sym.CORCHETE_ABRE, yycolumn, yyline);}
"]"                                     						{return new Symbol(sym.CORCHETE_CIERRA, yycolumn, yyline);}
"("                                     						{return new Symbol(sym.PARENTESIS_ABRE, yycolumn, yyline);}
")"                                     						{return new Symbol(sym.PARENTESIS_CIERRA, yycolumn, yyline);}
":"                                                             {return new Symbol(sym.DOS_PUNTOS, yycolumn, yyline);}
{STRING}                                                        {addString(yytext()); return new Symbol(sym.CONST_STRING, yycolumn, yyline ,new String(yytext()));}
{INT}                                                           {addInt(yytext()); return new Symbol(sym.CONST_INT, yycolumn, yyline ,new String(yytext()));}
{R}                                     						{addReal(yytext()); return new Symbol(sym.CONST_REAL, yycolumn, yyline ,new String(yytext()));}
{GUION_BAJO}?{L}({L}|{D}|{GUION_BAJO})* 						{addId(yytext()); return new Symbol(sym.ID, yycolumn, yyline ,new String(yytext()));}
. 																{/*Ignore*/}
