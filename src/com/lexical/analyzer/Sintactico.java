
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.lexical.analyzer;

import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Sintactico extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Sintactico() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Sintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Sintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\016\000\002\002\004\000\002\002\003\000\002\002" +
    "\004\000\002\004\005\000\002\005\004\000\002\005\003" +
    "\000\002\006\006\000\002\007\005\000\002\007\003\000" +
    "\002\003\003\000\002\003\003\000\002\003\003\000\002" +
    "\010\005\000\002\011\007" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\035\000\006\032\005\034\010\001\002\000\004\002" +
    "\037\001\002\000\010\006\026\007\024\010\025\001\002" +
    "\000\004\002\000\001\002\000\004\034\010\001\002\000" +
    "\004\030\012\001\002\000\004\035\017\001\002\000\004" +
    "\062\013\001\002\000\004\065\014\001\002\000\004\063" +
    "\015\001\002\000\004\040\016\001\002\000\004\035\ufff4" +
    "\001\002\000\004\002\ufff5\001\002\000\004\002\uffff\001" +
    "\002\000\012\006\ufffc\007\ufffc\010\ufffc\033\ufffc\001\002" +
    "\000\004\064\031\001\002\000\012\006\026\007\024\010" +
    "\025\033\030\001\002\000\004\064\ufff7\001\002\000\004" +
    "\064\ufff8\001\002\000\004\064\ufff6\001\002\000\012\006" +
    "\ufffd\007\ufffd\010\ufffd\033\ufffd\001\002\000\004\034\ufffe" +
    "\001\002\000\004\026\032\001\002\000\006\037\ufff9\040" +
    "\ufff9\001\002\000\006\037\034\040\035\001\002\000\004" +
    "\026\036\001\002\000\012\006\ufffb\007\ufffb\010\ufffb\033" +
    "\ufffb\001\002\000\006\037\ufffa\040\ufffa\001\002\000\004" +
    "\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\035\000\010\002\003\004\006\010\005\001\001\000" +
    "\002\001\001\000\010\003\021\005\022\006\020\001\001" +
    "\000\002\001\001\000\004\010\017\001\001\000\004\011" +
    "\010\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\003\021\006\026\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\007\032\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Sintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Sintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Sintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    /**Metodo al que se llama automaticamente ante algun error sintactico.*/
    public void syntax_error(Symbol s){
        System.out.println("Error en la linea " + (s.right+1) + " columna " + s.left + ". "
            + s + " no reconocido. valor " + s.value );
    }

    
 



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Sintactico$actions {


    public String resultado="";



  private final Sintactico parser;

  /** Constructor */
  CUP$Sintactico$actions(Sintactico parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action_part00000000(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Sintactico$result;

      /* select the action based on the action number */
      switch (CUP$Sintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= pgm EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		RESULT = start_val;
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Sintactico$parser.done_parsing();
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // pgm ::= bloque_sentencias 
            {
              Object RESULT =null;
		int bsleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bsright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object bs = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 System.out.println("REGLA[0]= NUEVO PROGRAMA SIN VARIABLES");
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("pgm",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // pgm ::= bloque_declaraciones_variables bloque_sentencias 
            {
              Object RESULT =null;
		int bdvleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int bdvright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object bdv = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int bsleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int bsright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object bs = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		 System.out.println("REGLA[1]= NUEVO PROGRAMA CON VARIABLES");
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("pgm",0, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // bloque_declaraciones_variables ::= DECLARESECTION lista_declaraciones_variables ENDDECLARESECTION 
            {
              Object RESULT =null;
		System.out.println("[REGLA[2]= BLOQUE DE DECLARACIÓN DE VARIABLES"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("bloque_declaraciones_variables",2, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // lista_declaraciones_variables ::= lista_declaraciones_variables declaracion_variables 
            {
              Object RESULT =null;
		int dvleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int dvright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object dv = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		int lleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object l = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		System.out.println("REGLA[3]= DECLARACIÓN DE CONJUNTO DE VARIABLES"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("lista_declaraciones_variables",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // lista_declaraciones_variables ::= declaracion_variables 
            {
              Object RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).left;
		int lright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()).right;
		Object l = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.peek()).value;
		System.out.println("REGLA[4]= DECLARACION DE VARIABLES"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("lista_declaraciones_variables",3, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // declaracion_variables ::= tipo DOS_PUNTOS lista_variables FIN_INSTRUCCION 
            {
              Object RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).right;
		Object t = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)).value;
		System.out.println("REGLA[5]= LISTA DE VARIABLES"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("declaracion_variables",4, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-3)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // lista_variables ::= lista_variables COMA ID 
            {
              Object RESULT =null;
		System.out.println("REGLA[6]= CONJUNTO DE VARIABLES MAS VARIABLE"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("lista_variables",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // lista_variables ::= ID 
            {
              Object RESULT =null;
		System.out.println("REGLA[7]= VARIABLE"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("lista_variables",5, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo ::= TIPO_INT 
            {
              Object RESULT =null;
		System.out.println("REGLA[8]= TIPO INT"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("tipo",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // tipo ::= TIPO_STRING 
            {
              Object RESULT =null;
		System.out.println("REGLA[9]= TIPO STRING"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("tipo",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // tipo ::= TIPO_REAL 
            {
              Object RESULT =null;
		System.out.println("REGLA[10]= TIPO REAL"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("tipo",1, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // bloque_sentencias ::= PROGRAMSECTION sentencias ENDPROGRAMSECTION 
            {
              Object RESULT =null;
		int ssleft = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).left;
		int ssright = ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).right;
		Object ss = (Object)((java_cup.runtime.Symbol) CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-1)).value;
		System.out.println("[REGLA[3]= BLOQUE DE DECLARACIÓN DE SENTENCIAS"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("bloque_sentencias",6, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-2)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // sentencias ::= DISPLAY PARENTESIS_ABRE CONST_STRING PARENTESIS_CIERRA FIN_INSTRUCCION 
            {
              Object RESULT =null;
		System.out.println("MEJORAR LAS SENTENCIAS DEL CUERPO"); 
              CUP$Sintactico$result = parser.getSymbolFactory().newSymbol("sentencias",7, ((java_cup.runtime.Symbol)CUP$Sintactico$stack.elementAt(CUP$Sintactico$top-4)), ((java_cup.runtime.Symbol)CUP$Sintactico$stack.peek()), RESULT);
            }
          return CUP$Sintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Sintactico$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Sintactico$do_action(
    int                        CUP$Sintactico$act_num,
    java_cup.runtime.lr_parser CUP$Sintactico$parser,
    java.util.Stack            CUP$Sintactico$stack,
    int                        CUP$Sintactico$top)
    throws java.lang.Exception
    {
              return CUP$Sintactico$do_action_part00000000(
                               CUP$Sintactico$act_num,
                               CUP$Sintactico$parser,
                               CUP$Sintactico$stack,
                               CUP$Sintactico$top);
    }
}

}
