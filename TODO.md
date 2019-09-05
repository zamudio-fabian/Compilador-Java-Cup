# Cosas por hacer

Asignese cada uno las tareas que quiere hacer.

- Crear regex de Lexer de estos (algunos ya estan pero hay que validarlos):
  - [X] IF
  - [ ] ENDIF
  - [X] WHILE
  - [ ] ENDWHILE
  - [ ] STRING (�esto es un string�)
  - [X] VARIABLES
  - [ ] IGNORAR COMENTARIOS ( �/ esto es un comentario /� )
  - [ ] SALIDAS PANTALLA
  - [ ] CONDICIONES
  - [ ] DECLARACI�N DE SECCIONES (DECLARE.SECTION o ENDDECLARE.SECTION)
  - [ ] PROGRAM.SECTION
  - [ ] ENDPROGRAM.SECTION
  - [ ] DO
  - [ ] CASE
  - [ ] ENDCASE
  - [ ] OTHER
- Tareas importantes
  - [ ] ALMACENAR LOS DATOS EN UN ARCHIVO CON FORMATO ESPECIFICADO EN EL TP
  - [ ] MOSTRAR EN PANTALLA LOS RESULTADOS CON EL FORMATO ESPECIFICADO EN EL TP

## Fixes Requeridos

- [X] Leer la doc de JFlex y hacer el fix para que devuelva bien todos los TOKENS.

### Detalles que observe comparando "prueba.txt" con "ts.txt"

- [ ] Al definir un tipo "String", el compilador lo toma como un ID.
- [X] "SALTO DE LINEA" aparece duplicado.
- [ ] Cuando se hace la operacion "i = 1;" toma el uno como real cuando deberia ser int.
- [X] El espacio lo toma como Simbolo no definido.
- [ ] Despues de salir del else, sigue marcando como si estuviera dentro del else.
- [ ] La instruccion "write" lo toma como un id. Deberia ser una palabra reservada?