grammar MiniJava;

//Declarations
program: class_decl*;
class_decl: ACCES_MOD? 'class' ID LEFT_BRACE field_decl* method_decl* RIGHT_BRACE ;
field_decl: ACCES_MOD? STATIC? type ID (COMMA ID)* (ASSIGN expr)? SEMICOLON;
method_decl: ACCES_MOD? STATIC? method_type ID LEFT_BRACKET (parameter_list? | main?) RIGHT_BRACKET statement_block;
constructor_decl: ACCES_MOD? ID LEFT_BRACKET parameter_list? RIGHT_BRACKET statement_block;


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
statement_expr: method_call_statement | new_statement | assign_statement | cre_expression; // example MyClass obj = new MyClass(42);
new_statement: NEW ID LEFT_BRACKET expr RIGHT_BRACKET;
assign_statement: (inst_var | ID) ASSIGN expr; // example this.a = c + 3;
inst_var: THIS DOT ID? | (THIS DOT)? (ID DOT)+ ID;

/*expr: literal | ID | binary_expr | LEFT_BRACKET expr RIGHT_BRACKET;
// example

binary_expr: expr op expr;*/

//expression
/*
expr: binary_expr;
binary_expr: primary_expr (op primary_expr)*;
primary_expr: literal | ID | LEFT_BRACKET expr RIGHT_BRACKET | NULL;*/
//basic_expr (op basic_expr)*
/////////////////////////////////////////////////////////////////////////////////////////////////////
// Bis hier. Nächstes mal nochmal über die expression drüber schauen und string

expr: binary_expr | basic_expr;
binary_expr: logical_expr | calculate_expr; //example a + b; 3 + 3 - a
basic_expr: THIS | ID | inst_var | statement_expr | NOT expr | LEFT_BRACKET expr RIGHT_BRACKET | add_sub_op INT | literal;
cre_expression: cre_op (ID | INT | inst_var ) | (ID | INT | inst_var ) cre_op; //example a++; ++a
logical_expr: basic_expr (logical_op expr)*;
// (a +b ) == c; c == (a+b)
calculate_expr: basic_expr add_sub_op mul_div_expr; //todo
mul_div_expr:;

//

/* example
3 + 3; true + true; c + c;
idString
( expression )
null
hallo
*/

method_type: VOID | type;

// Operator
calculate_op: mul_div_op | add_sub_op;
logical_op: '==' | '!=' | '<' | '>' | '<=' | '>=';
add_sub_op: '+' | '-';
mul_div_op: '*' | '/';
cre_op: '++' | '--';



//
literal: INT | BOOLEAN | CHAR | STRING | NULL;

WS : [ \t\r\n] -> skip;

type: 'int' | 'boolean' | 'char';

//Declaration parameter
ACCES_MOD: 'private' | 'public' | 'protected';
STATIC: 'static';
VOID: 'void';
NEW: 'new';
THIS: 'this';
main: 'String[] args';

//
ID: [a-zA-Z][a-zA-Z0-9]*;

//Datatypes
INT: [0-9]+;
BOOLEAN: 'true' | 'false';
CHAR: '\'' . '\''; //example 'a'
STRING: '"' (~["\\])* '"' ; //
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
NOT: '!';

//Statement keywords
IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';


