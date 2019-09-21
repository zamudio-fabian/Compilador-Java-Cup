////////////////////////////////////////////////
// IMPORTS
////////////////////////////////////////////////
package com.lexical.analyzer;
import com.lexical.analyzer.Tokens.*;
import java_cup.runtime.*;

////////////////////////////////////////////////
// CONFIGS
////////////////////////////////////////////////
%%
%class Lexico
%type Tokens
%line
%column
%cupsym Simbolo
%cup

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
public boolean hasError = false;
public String errorMessage = "";
public int errorLine = 0;
public int errorColumn = 0;

private TablaSimbolo symbolTable = new TablaSimbolo(); 

public void addReal( String value){	
    boolean isOk = symbolTable.addReal( value);
    if(!isOk) makeError("Real out of range");
}

public void addString( String value) {
    boolean isOk = symbolTable.addString(value);
    if(!isOk) makeError("String out of range");
}

public void addId( String value) {
    boolean isOk = symbolTable.addId(value);
    if(!isOk) makeError("ID out of range");
}

public void addInt(String value) {
    boolean isOk = symbolTable.addInt(value);
    if(!isOk) makeError("Integer out of range");
}

public void makeError(String error) {
    hasError = true;
    errorMessage = error;
    errorLine = yyline + 1;
    errorColumn = yycolumn + 1;
}

public void save(){
    symbolTable.save();
}

%}

////////////////////////////////////////////////
// LEXICAL RULES
////////////////////////////////////////////////
%%
{COMENTARIO}													{/*Ignore*/}
{WHITE}							                                {/*Ignore*/}
"real"                                                          {return Tokens.TIPO_REAL;}
"string"                                                        {return Tokens.TIPO_STRING;}
"int"                                                           {return Tokens.TIPO_INT;}
"long"                                                          {return Tokens.LONG;}
"defvar"                                                        {return Tokens.DEFVAR;}
"enddef"                                                        {return Tokens.ENDDEF;}
"else"                                                          {return Tokens.ELSE;}
"CASE" 															{return Tokens.CASE;}
"DO" 															{return Tokens.DO;}
"break" 														{return Tokens.BREAK;}
"OTHER" 														{return Tokens.OTHER;}
"ENDCASE" 														{return Tokens.ENDCASE;}
"for" 															{return Tokens.FOR;}
"endfor"														{return Tokens.ENDFOR;}
"if" 															{return Tokens.IF;}
"endif"															{return Tokens.ENDIF;}
"while"                                                         {return Tokens.WHILE;}
"endwhile"														{return Tokens.ENDWHILE;}
"DISPLAY"                                                       {return Tokens.WRITE;}
"case"                                                          {return Tokens.CASE;}
"do"                                                            {return Tokens.DO;}
"endcase"                                                       {return Tokens.ENDCASE;}
"other"                                                         {return Tokens.OTHER;}
"DECLARE.SECTION"                                               {return Tokens.DECLARESECTION;}
"ENDDECLARE.SECTION"                                            {return Tokens.ENDDECLARESECTION;}
"PROGRAM.SECTION"                                               {return Tokens.PROGRAMSECTION;}
"ENDPROGRAM.SECTION"                                            {return Tokens.ENDPROGRAMSECTION;}
"write"                                                         {return Tokens.OUTPUT;}
","                                     						{return Tokens.COMA;}
";"                                     						{return Tokens.FIN_INSTRUCCION;}
":="                                     						{return Tokens.OP_ASIGNACION;}
"+"                                     						{return Tokens.OP_SUMA;}
"-"                                     						{return Tokens.OP_RESTA;}
"*"                                     						{return Tokens.OP_MULTIPLICACION;}
"/"                                     						{return Tokens.OP_DIVISION;}
"=="                                    						{return Tokens.OP_IGUAL;}
"!="                                    						{return Tokens.OP_DISTINTO;}
">"                                     						{return Tokens.OP_MAYOR;}
"<"                                     						{return Tokens.OP_MENOR;}
">="                                    						{return Tokens.OP_MAYOR_IGUAL;}
"<="                                    						{return Tokens.OP_MENOR_IGUAL;}
"{"                                     						{return Tokens.BLOQUE_ABRE;}
"}"                                     						{return Tokens.BLOQUE_CIERRA;}
"["                                     						{return Tokens.CORCHETE_ABRE;}
"]"                                     						{return Tokens.CORCHETE_CIERRA;}
"("                                     						{return Tokens.PARENTESIS_ABRE;}
")"                                     						{return Tokens.PARENTESIS_CIERRA;}
":"                                                             {return Tokens.DOS_PUNTOS;}
{STRING}                                                        {addString(yytext()); return Tokens.CONST_STRING;}
{INT}                                                           {addInt(yytext()); return Tokens.CONST_INT;}
{R}                                     						{addReal(yytext()); return Tokens.CONST_REAL;}
{GUION_BAJO}?{L}({L}|{D}|{GUION_BAJO})* 						{addId(yytext());return Tokens.ID;}
. 																{makeError("Symbol not defined");return Tokens.ERROR;}