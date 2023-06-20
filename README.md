# MachMalCompiler

Herzlich willkommen bei unserem Mini-Java Compiler vom 4. Semester.

## Unterstützte Java-Syntax

```plain
//(Base-)Types:
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
if...else, while, for (auch inline-Schreibweise)

//Andere Keywörter:
class, new, this, null, static        
```
## Besonderheiten

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

## Verwendete Tools
* [ANTLR4](https://www.antlr.org/) --> Wird verwendet, um den Code in einen abstrakten Syntaxbaum zu schreiben
* [ASM](https://asm.ow2.io/) --> Wird verwendet, um Bytecode aus dem typisierten Syntaxbaum zu generieren

## Projektstruktur

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
## Klassendiagramm
![UML-Diagram](./uml/AST_UML.svg)

## Komponenten

### Parser

Implementiert von Nina Schmid und Hannes Kollert.

* ANTLR - Grammatik für Java-Subset
* Adapter für die Generierung des Abstrakten Syntax Baums

### Semantik Check + Typisierung

Implementiert von Emma Weiß.

* Semantik-Visitors um den gesamten Syntax Baum zu typisieren
* Semantische Fehlerbehandlung

### Bytecode

Implementiert von Julian Schmidt.

* Übersetzung vom Typisierten Abstrakten Syntax Baum zu Java-Bytecode mit ASM

### Testen</h3>

Implementiert von Micha Hölle.

- Tests zur Überprüfung, ob der abstrakte Syntaxbaum korrekt generiert wird.
- Tests zur Überprüfung, ob der Semantic-Check den AST korrekt eingibt und Fehler auslöst.
- Tests zur Überprüfung, ob der Byte-Code korrekt generiert wird (Getestet mit Java-Reflections).
- Integrationstests für den gesamten Compiler zur Überprüfung verschiedener Anwendungsfälle.

## Installationsanleitung

### Ausführung in IDE
Das Projekt wurde mit [maven](https://maven.apache.org/) als Paketverwaltungsprogramm entwickelt.
Zur Ausführung aus einer IDE muss diese demnach mit maven kompatibel sein und dieses installiert sein.
Nach dem Öffnen des Projekts kann die Main-Methode mmc/Main.java ausgeführt werden, um den Compiler zu starten.

### Ausführung mit .jar-Datei
Der Compiler kann außerdem mithilfe einer Jar-Datei gestartet werden.
Die aktuellste Jar-Datei [Jar-Datei](./MachMalCompiler.jar) kann mit dem Befehl ```java -jar MachMalCompiler.jar``` ausgeführt werden.

### Generelles
1. Nach dem Starten des Compilers muss zunächst die zu kompilierende ```.java```-Datei als Dateipfad übergeben werden.
2. Anschließend kann ggf. ein gewünschter Pfad zur Ablage der generierten ```.class```-Dateien angeben werden
3. Wird kein eigener Ablagepfad angegeben, wird im Ordner des Jar-Files ein ```gen```-Ordner erstellt, welcher die Output-Dateien erhält.
