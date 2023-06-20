<h1>MachMalCompiler</h1>

<p>Herzlich willkommen bei unserem Mini-Java Compiler vom 4. Semester.</p>

<h2>Unterstützte Java-Syntax</h2>
```plain
//Base-Types:
int, booelan, char, String

//Access-Modifier:
public, private (Klassen Deklarationen ohne Access-Modifier)

//Assign-Operatoren:
ASSIGN("="), PLUSASSIGN("+="), MINUSASSIGN("-="), MULTASSIGN("*="), DIVASSIGN("/="),  MODASSIGN("%="), 

//Crement-Operatoren
INCPRE("++"), INCSUF("++"),  DECPRE("--"),  DECSUF("--"), 

//Arithmetische-Operatoren:
PLUS("+"), MINUS("-"), MULT("*"), DIV("/"), MOD("%"),

//Comparative-Operatoren:
GREATER(">"), LESS("<"), GREATEREQUAL(">="), LESSEQUAL("<="), EQUAL("=="), NOTEQUAL("!="),

//Logische-Operatoren:
NOT("!"), SINGLEAND("&"), SINGLEOR("|"), AND("&&"), OR("||");

//Statements:
if...else, while, for

//Andere Keywörter:
class, new, this, null, static

//Besonderheiten:
          - statically-imported Methods: 
              - System.out.print 
              - System.out.println 
              - java.lang.String
          - Assign-Operatoren
          - Increment und Decrement
          - Inline und Inline initialisierung
          - main Methode
          - Bindungsstärke der Operatoren
          - Verkettung von Methodenaufrufen und Instanzvariablen
          - Semantik Fehlerbehandlung
          - Statische Methoden und Felder          
```
<h2>Besonderheiten</h2>

| Funktionen                                                    | Beispiele                                                                          |
|---------------------------------------------------------------|------------------------------------------------------------------------------------|
| Assign-Operatoren                                             | += ; -= ; *= ; %=                                                                  |
| Increment und Decrement                                       | a++ ; --b                                                                          |
| Inline                                                        | if(x) a = 5;<br/> if(z) k = a-5; else a+=5;<br/>for(;;) b=7<br/> while(y) a--;     |
| For-Schleifen                                                 | for(;;) {}<br/>for(int a; a<b; a--){}                                              |
| main Methode                                                  | public static void main(String[] args){}                                           |
| Inline Initialisierung                                        | int a = 5;<br/>String alter = "elf";<br/>static String wert = new String("Hallo"); |
| Inline Initialisierung und Deklaration von mehreren Variablen | int y=3, b, c, d = 99, e = 106;                                                    |
| Bindungsstärke der Operatoren                                 | n == 0 && n == 1                                                                   |
| Verkettung von Methodenaufrufen und Instanzvariablen          | test.getInstance().a = test2.get(i).str.concat("Hallo");                           |

<h2>Verwendete Tools</h2>
* [ANTLR4](https://www.antlr.org/)
    * Wird verwendet, um den Code in einen abstrakten Syntaxbaum zu schreiben
* [ASM](https://asm.ow2.io/)
    * Wird verwendet, um Bytecode aus dem typisierten Syntaxbaum zu generieren

<h2>Projektstruktur</h2>

```plain
Compilerbau [MachMalCompiler]/
│
│
└── src
    ├── main
    │   └── java
    │       └── mmc
    │           ├── ast <-- General Java-Class Structrue to model the AST
    │           │   ├─── expressions
    │           │   ├─── main
    │           │   ├─── statementexpression
    │           │   └─── statements
    │           │
    │           ├── codegen <-- ProgramGenerator to generate the Bytecode
    │           │   └─── visitors <-- Visitor-Interfaces for the visitor-pattern
    │           │
    │           ├── compiler
    │           │
    │           ├── parser
    │           │   ├─── adapter <-- Adapter to create the Syntax-Tree (AST)
    │           │   ├─── antlr <-- generated ANTLR Code
    │           │   └─── grammar <-- MiniJava.g4-File
    │           │
    │           └── semantikcheck
    │               └─── environment
    └── test
```
<h2>Klassendiagramm</h2>
![UML-Diagram](https://github.com/i21023/Compilerbau/blob/master/uml/AST_UML.svg)

<h2>Komponenten</h2>

<h3>Parser</h3>

Implementiert von Nina Schmid und Hannes Kollert.

- ANTL - Grammatik für Java-Subset
- Adapter für die Generierung des Abstrakten Syntax Baum

<h3>Semantik Check + Typisierung</h3>

Implementiert von Emma Weiß.

- Semantik-Visitors um den gesamten Syntax Baum zu typisieren
- Semantische Fehlerbehandlung

<h3>Bytecode</h3>

Implementiert von Julian Schmidt.

- Übersetzung von Abstrakten Syntax Baum zu Java-Bytecode mit ASM

<h3>Testen</h3>

Implementiert von Micha Hölle.

- Tests zur Überprüfung, ob der abstrakte Syntaxbaum korrekt generiert wird.
- Tests zur Überprüfung, ob der Semantic-Check den AST korrekt eingibt und Fehler auslöst.
- Tests zur Überprüfung, ob der Byte-Code korrekt generiert wird (Getestet mit Java-Reflections).
- Integrationstests für den gesamten Compiler zur Überprüfung verschiedener Anwendungsfälle.

<h2 style="color: #55b2ca;">Installationsanleitung</h2>