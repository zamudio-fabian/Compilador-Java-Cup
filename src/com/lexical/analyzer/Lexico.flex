package com.lexical.analyzer;
import com.lexical.analyzer.Tokens.*;
%%
%class Lexico
%type Tokens
%line
%column
L = [a-zA-Z_]
D = [0-9]
INT = {D}+
R = [0-9]+"."[0-9]+
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
OPERADOR = (\+|-|\/|\*|>|<|\!=|<=|>=|=){1}
SIGNO = ,|:|;
STRING = \"({WhiteSpace}|{SIGNO}|{OPERADOR}|{L}|{D}|\.|\!|\¡|ñ|Ñ)*\"
COMENTARIO                                                     = \-\/([^/]|[\r\n]|(\/+([^/-]|[\r\n])))*\/+\-

WHITE=[ \t\r\n]
%{
public String lexeme;
public boolean hasError = false;
public String errorMessage = "";
public int errorLine = 0;
public int errorColumn = 0;

private TablaSimbolo miTabla = new TablaSimbolo(); 

public void addReal( String value){	
    boolean response = miTabla.addReal( value);
    if(!response) makeError("Real format not allowed");
}

public void addString( String value) {
    boolean response = miTabla.addString(value);
    if(!response) makeError("String format not allowed");
}

public void addId( String value) {
    boolean response = miTabla.addId(value);
    if(!response) makeError("ID format not allowed");
}

public void addInt(String value) {
    boolean response = miTabla.addInt(value);
    if(!response) makeError("Integer format not allowed");
}

public void makeError(String error) {
    hasError = true;
    errorMessage = error;
    errorLine = yyline + 1;
    errorColumn = yycolumn + 1;
}

public void save(){
    miTabla.save();
}

%}
%%
{COMENTARIO}													{/*Ignore*/}
{WHITE}							                                {/*Ignore*/}
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
"write"                                                         {return Tokens.WRITE;}
"case"                                                          {return Tokens.CASE;}
"do"                                                            {return Tokens.DO;}
"endcase"                                                       {return Tokens.ENDCASE;}
"other"                                                         {return Tokens.OTHER;}
"DECLARE.SECTION"                                               {return Tokens.DECLARESECTION;}
"ENDDECLARE.SECTION"                                            {return Tokens.ENDDECLARESECTION;}
"PROGRAM.SECTION"                                               {return Tokens.PROGRAM_SECTION;}
"ENDPROGRAM.SECTION"                                            {return Tokens.ENDPROGRAM_SECTION;}
"write"                                                         {return Tokens.OUTPUT;}
","                                     						{return Tokens.COMA;}
";"                                     						{return Tokens.FIN_INSTRUCCION;}
"="                                     						{return Tokens.OP_ASIGNACION;}
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
{L}({L}|{D})* 													{addId(yytext());return Tokens.ID;}
. 																{makeError("Simbol not defined");return Tokens.ERROR;}