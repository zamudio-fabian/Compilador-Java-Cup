package com.lexical.analyzer;
import com.lexical.analyzer.Tokens;
%%
%class Lexer
%type Tokens
LETRA                                                           =[a-zA-Z_]
DIGITO                                                          =[0-9]
TIPO_STRING							                            ="string"
TIPO_REAL							                            ="real"
ID                                                              ={LETRA}(_?({LETRA}|{DIGITO}))*
CONST_REAL                                                      =({DIGITO}+\.{DIGITO}*)|({DIGITO}*\.{DIGITO}+)|{DIGITO}+
CONST_STRING                                                    =\"([^\"]|\.)*\"
COMA                                                            =","
DOS_PUNTOS							                            =":"
FIN_INSTRUCCION                                                 =";"
OP_ASIGNACION                                                   ="="
OP_SUMA                                                         ="+"
OP_RESTA                                                        ="\-"
OP_MULTIPLICACION                                               ="*"
OP_DIVISION                                                     ="/"
OP_IGUAL                                                        ="=="
OP_DISTINTO                                                     ="!="
OP_MAYOR                                                        =">"
OP_MENOR                                                        ="<"
OP_MAYOR_IGUAL                                                  =">="
OP_MENOR_IGUAL                                                  ="<="
BLOQUE_ABRE                                                     ="{"
BLOQUE_CIERRA                                                   ="}"
CORCHETE_ABRE                                                   ="["
CORCHETE_CIERRA                                                 ="]"
PARENTESIS_ABRE                                                 ="("
PARENTESIS_CIERRA                                               =")"
COMENTARIO                                                      =\-\/([^/]|[\r\n]|(\/+([^/-]|[\r\n])))*\/+\-
SALTO_LINEA                                                     =[\n,\r\n]
TAB                                                             =[\t]+
%{
    public String lexeme;
%}
%%
int | if | else | while {lexeme=yytext(); return Tokens.Reservadas;}
{TIPO_STRING} {lexeme=yytext(); return Tokens.TIPO_STRING;}							                           
{TIPO_REAL} {lexeme=yytext(); return Tokens.TIPO_REAL;}							                           
{CONST_REAL} {lexeme=yytext(); return Tokens.CONST_REAL;}                                                     
{CONST_STRING} {lexeme=yytext(); return Tokens.CONST_STRING;}                                                   
{COMA} {lexeme=yytext(); return Tokens.COMA;}                                                           
{DOS_PUNTOS} {lexeme=yytext(); return Tokens.DOS_PUNTOS;}							                           
{FIN_INSTRUCCION} {lexeme=yytext(); return Tokens.FIN_INSTRUCCION;}                                                
{OP_IGUAL} {lexeme=yytext(); return Tokens.OP_IGUAL;}                                                       
{OP_DISTINTO} {lexeme=yytext(); return Tokens.OP_DISTINTO;}                                                    
{OP_MAYOR} {lexeme=yytext(); return Tokens.OP_MAYOR;}                                                       
{OP_MENOR} {lexeme=yytext(); return Tokens.OP_MENOR;}                                                       
{PARENTESIS_CIERRA} {lexeme=yytext(); return Tokens.PARENTESIS_CIERRA;}
{PARENTESIS_ABRE} {lexeme=yytext(); return Tokens.PARENTESIS_ABRE;}
{CORCHETE_CIERRA} {lexeme=yytext(); return Tokens.CORCHETE_CIERRA;}
{CORCHETE_ABRE} {lexeme=yytext(); return Tokens.CORCHETE_ABRE;}
{BLOQUE_CIERRA} {lexeme=yytext(); return Tokens.BLOQUE_CIERRA;}
{BLOQUE_ABRE} {lexeme=yytext(); return Tokens.BLOQUE_ABRE;}
{OP_MENOR_IGUAL} {lexeme=yytext(); return Tokens.OP_MENOR_IGUAL;}
{OP_MAYOR_IGUAL} {lexeme=yytext(); return Tokens.OP_MAYOR_IGUAL;}
{TAB} {lexeme=yytext(); return Tokens.TAB;}
{SALTO_LINEA} {lexeme=yytext(); return Tokens.SALTO_LINEA;}
{COMENTARIO} {lexeme=yytext(); return Tokens.COMENTARIO;}
{OP_ASIGNACION} {lexeme=yytext(); return Tokens.OP_ASIGNACION;}
{OP_SUMA} {lexeme=yytext(); return Tokens.OP_SUMA;}
{OP_RESTA} {lexeme=yytext(); return Tokens.OP_RESTA;}
{OP_MULTIPLICACION} {lexeme=yytext(); return Tokens.OP_MULTIPLICACION;}
{OP_DIVISION} {lexeme=yytext(); return Tokens.OP_DIVISION;}
{ID} {lexeme=yytext(); return Tokens.ID;}
("(-"{DIGITO}+")")|{DIGITO}+ {lexeme=yytext(); return Tokens.Numero;}
 . {return Tokens.ERROR;}
