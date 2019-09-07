package com.lexical.analyzer;
import com.lexical.analyzer.Tokens.*;
%%
%class Lexico
%type Tokens
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE}							                                {/*Ignore*/}
"long"                                                          {return Tokens.LONG;}
"defvar"                                                        {return Tokens.DEFVAR;}
"enddef"                                                        {return Tokens.ENDDEF;}
"else"                                                          {return Tokens.ELSE;}
"if" 															{return Tokens.IF;}
"while"                                                         {return Tokens.WHILE;}
"write"                                                         {return Tokens.WRITE;}
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
":"                                     						{return Tokens.DOS_PUNTOS;}
{L}({L}|{D})* 													{lexeme=yytext(); return Tokens.ID;}
. {return Tokens.ERROR;}