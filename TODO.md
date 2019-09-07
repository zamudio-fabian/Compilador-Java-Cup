# Cosas por hacer

Asignese cada uno las tareas que quiere hacer.

- Crear regex de Lexer de estos (algunos ya estan pero hay que validarlos):
  - [X] IF
  - [X] ENDIF
  - [X] WHILE
<<<<<<< HEAD
  - [ ] ENDWHILE
  - [X] ASIGNACION
  - [ ] STRING ("esto es un string") con un limite de 30 caracteres 
=======
  - [X] ENDWHILE
<<<<<<< Updated upstream
  - [ ] STRING (�esto es un string�)
>>>>>>> 68d46b1f9ecc3b0f44cf21b2c0a569ce5963ae48
=======
  - [X] STRING (�esto es un string�)
>>>>>>> Stashed changes
  - [X] VARIABLES
  - [ ] ENTEROS 16 BITS
  - [ ] REALES 32 BITS (SEPARADOR ".")
  - [ ] IGNORAR COMENTARIOS ( --/ esto es un comentario /-- )
  - [ ] SALIDAS PANTALLA
  - [ ] CONDICIONES
  - [ ] DECLARACI�N DE SECCIONES (DECLARE.SECTION o ENDDECLARE.SECTION)
  - [X] PROGRAM_SECTION
  - [X] ENDPROGRAM_SECTION
  - [X] DO
  - [X] CASE
  - [X] ENDCASE
  - [X] OTHER
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