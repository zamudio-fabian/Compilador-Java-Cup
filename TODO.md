# Cosas por hacer

Asignese cada uno las tareas que quiere hacer.

- Crear regex de Lexer de estos (algunos ya estan pero hay que validarlos):
  - [ ] IF
  - [ ] ENDIF
  - [ ] WHILE
  - [ ] ENDWHILE
  - [ ] STRING (“esto es un string”)
  - [ ] VARIABLES
  - [ ] IGNORAR COMENTARIOS ( —/ esto es un comentario /— )
  - [ ] SALIDAS PANTALLA
  - [ ] CONDICIONES
  - [ ] DECLARACIÒN DE SECCIONES (DECLARE.SECTION o ENDDECLARE.SECTION)
  - [ ] PROGRAM.SECTION
  - [ ] ENDPROGRAM.SECTION
  - [ ] DO
  - [ ] CASE
  - [ ] ENDCASE
  - [ ] OTHER

## Fixes Requeridos

- [ ] Leer la doc de JFlex y hacer el fix para que devuelva bien todos los TOKENS.

### Detalles que observe comparando "prueba.txt" con "ts.txt"

- [ ] Al definir un tipo "String", el compilador lo toma como un ID.
- [ ] "SALTO DE LINEA" aparece duplicado.
- [ ] Cuando se hace la operacion "i = 1;" toma el uno como real cuando deberia ser int.
- [ ] El espacio lo toma como Simbolo no definido.
- [ ] Despues de salir del else, sigue marcando como si estuviera dentro del else.
- [ ] La instruccion "write" lo toma como un id. Deberia ser una palabra reservada?