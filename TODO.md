# Cosas por hacer

## JAVA CUP

- [x] sentencias debe permitir todo tipo de sentencias, no solo display. Ej: asignaciones, ifs, cases, etc.
- [x] Creo que es por lo anterior que NO compila cuando hago las asignaciones dentro de PROGRAM.SECTION
- [x] sentencias y salida_pantalla son iguales.
- [x] Pasar todos los terminales a mayusculas.


## JFlex

- Crear regex de Lexer de estos (algunos ya estan pero hay que validarlos):
  - [ ] CORREGIR COMENTARIOS ( --/ esto es un comentario /-- ). Actualmente son asi: -/ /-
  - [X] IF
  - [X] ENDIF
  - [X] WHILE
  - [X] ENDWHILE
  - [X] ASIGNACION
  - [X] STRING ("esto es un string") con un limite de 30 caracteres 
  - [X] ENDWHILE
  - [X] STRING (�esto es un string�)
  - [X] VARIABLES
  - [X] ENTEROS 16 BITS
  - [X] REALES 32 BITS (SEPARADOR ".")
  - [X] SALIDAS PANTALLA
  - [X] CONDICIONES
  - [X] DECLARACI�N DE SECCIONES (DECLARE.SECTION o ENDDECLARE.SECTION)
  - [X] PROGRAM_SECTION
  - [X] ENDPROGRAM_SECTION
  - [X] DO
  - [X] CASE
  - [X] ENDCASE
  - [X] OTHER

### Tareas importantes

  - [ ] ALMACENAR LOS DATOS EN UN ARCHIVO CON FORMATO ESPECIFICADO EN EL TP
  - [ ] MOSTRAR EN PANTALLA LOS RESULTADOS CON EL FORMATO ESPECIFICADO EN EL TP


### Detalles que observe comparando "prueba.txt" con "ts.txt"

- [ ] Al definir un tipo "String", el compilador lo toma como un ID.
- [X] "SALTO DE LINEA" aparece duplicado.
- [ ] Cuando se hace la operacion "i = 1;" toma el uno como real cuando deberia ser int.
- [X] El espacio lo toma como Simbolo no definido.
- [ ] Despues de salir del else, sigue marcando como si estuviera dentro del else.
- [ ] La instruccion "write" lo toma como un id. Deberia ser una palabra reservada?