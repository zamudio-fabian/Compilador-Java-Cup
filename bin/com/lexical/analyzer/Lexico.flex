package com.lexical.analyzer;
import com.lexical.analyzer.Tokens;
%%
%class Lexico
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
{TIPO_STRING} {return Tokens.TIPO_STRING;}							                           
{TIPO_REAL} {return Tokens.TIPO_REAL;}							                           
{CONST_REAL} {return Tokens.CONST_REAL;}                                                     
{CONST_STRING} {return Tokens.CONST_STRING;}                                                   
{COMA} {return Tokens.COMA;}                                                           
{DOS_PUNTOS} {return Tokens.DOS_PUNTOS;}							                           
{FIN_INSTRUCCION} {return Tokens.FIN_INSTRUCCION;}                                                
{OP_IGUAL} {return Tokens.OP_IGUAL;}                                                       
{OP_DISTINTO} {return Tokens.OP_DISTINTO;}                                                    
{OP_MAYOR} {return Tokens.OP_MAYOR;}                                                       
{OP_MENOR} {return Tokens.OP_MENOR;}                                                       
{PARENTESIS_CIERRA} {return Tokens.PARENTESIS_CIERRA;}
{PARENTESIS_ABRE} {return Tokens.PARENTESIS_ABRE;}
{CORCHETE_CIERRA} {return Tokens.CORCHETE_CIERRA;}
{CORCHETE_ABRE} {return Tokens.CORCHETE_ABRE;}
{BLOQUE_CIERRA} {return Tokens.BLOQUE_CIERRA;}
{BLOQUE_ABRE} {return Tokens.BLOQUE_ABRE;}
{OP_MENOR_IGUAL} {return Tokens.OP_MENOR_IGUAL;}
{OP_MAYOR_IGUAL} {return Tokens.OP_MAYOR_IGUAL;}
{TAB} {return Tokens.TAB;}
{SALTO_LINEA} {return Tokens.SALTO_LINEA;}
{COMENTARIO} {return Tokens.COMENTARIO;}
{OP_ASIGNACION} {return Tokens.OP_ASIGNACION;}
{OP_SUMA} {return Tokens.OP_SUMA;}
{OP_RESTA} {return Tokens.OP_RESTA;}
{OP_MULTIPLICACION} {return Tokens.OP_MULTIPLICACION;}
{OP_DIVISION} {return Tokens.OP_DIVISION;}
{ID} {return Tokens.ID;}
("(-"{DIGITO}+")")|{DIGITO}+ {lexeme=yytext(); return Tokens.Numero;}
 . {return Tokens.ERROR;}
