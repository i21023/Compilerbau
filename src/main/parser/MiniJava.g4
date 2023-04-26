grammar MiniJava;

//Declarations
program: class_decl*;
class_decl: ACCES_MOD? 'class' ID LEFT_BRACE field_decl* method_decl* RIGHT_BRACE ;
field_decl: ACCES_MOD? STATIC? type ID (COMMA ID)* (ASSIGN expr)? SEMICOLON;
method_decl: ACCES_MOD? STATIC? method_type ID LEFT_BRACKET (parameter_list? | main?) RIGHT_BRACKET statement_block;
constructor_decl: ACCES_MOD? ID LEFT_BRACKET parameter_list? RIGHT_BRACKET statement_block;
main: 'String[] args';

parameter_list: type ID (COMMA type ID)*;

//statements
statement_block: LEFT_BRACE statement* RIGHT_BRACE; //Block
statement: local_var_decl | if_else_statement | while_statement | return_statement | statement_expr | SEMICOLON;
local_var_decl: ID ASSIGN expr SEMICOLON; // example a = 3; a = b; a = a + b; a = ( a - b )
if_else_statement: IF LEFT_BRACKET expr RIGHT_BRACKET statement_block else_statement?; // example if ( expr ) { statement }
else_statement: ELSE statement_block; // example else { statement }
while_statement: WHILE LEFT_BRACKET expr RIGHT_BRACKET statement_block; // example while ( expr ) { statement }
method_call_statement: inst_var ID LEFT_BRACKET ( expr (COMMA expr)* )? RIGHT_BRACKET SEMICOLON; // methode1 ( expr , expr );
return_statement: RETURN expr? SEMICOLON;
statement_expr: method_call_statement | new_statement | assign_statement; // example MyClass obj = new MyClass(42);
new_statement: NEW ID LEFT_BRACKET expr RIGHT_BRACKET;
assign_statement: (inst_var | ID) ASSIGN expr; // example this.a = c + 3;
inst_var: THIS DOT ID? | (THIS DOT)? (ID DOT)+ ID;

/*expr: literal | ID | binary_expr | LEFT_BRACKET expr RIGHT_BRACKET;
// example

binary_expr: expr op expr;*/

//expression


/////////////////////////////////////////////////////////////////////////////////////////////////////
// Bis hier. Nächstes mal nochmal über die expression drüber schauen und string




expr: binary_expr;
binary_expr: primary_expr (op primary_expr)*;
primary_expr: literal | ID | LEFT_BRACKET expr RIGHT_BRACKET | NULL;


method_type: VOID | type;

op: '+' | '-' | '*' | '/' | '==' | '!=' | '<' | '>' | '<=' | '>=';

//
literal: INT | BOOLEAN | CHAR;

WS : [ \t\r\n] -> skip;

type: 'int' | 'boolean' | 'char';

//Declaration parameter
ACCES_MOD: 'private' | 'public' | 'protected';
STATIC: 'static';
VOID: 'void';
NEW: 'new';
THIS: 'this';

//
ID: [a-zA-Z][a-zA-Z0-9]*;

//Datatypes
INT: [0-9]+;
BOOLEAN: 'true' | 'false';
CHAR: '\'' . '\''; //example 'a'
String: '"' (~["\\])* '"' ; //
NULL: 'null';

//signs
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_BRACKET: '(';
RIGHT_BRACKET: ')';
SEMICOLON: ';';
COMMA: ',';
EQUALS: '==';
ASSIGN: '=';
DOT: '.';

//Statement keywords
IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';


