grammar MiniJava;

//Declarations
program: class_decl*;
//Class
class_decl: ACCES_MOD? 'class' ID LEFT_BRACE (const_decl | method_decl | field_decl)*  RIGHT_BRACE;
///Class objects
const_decl: ACCES_MOD? ID LEFT_BRACKET parameter_list? RIGHT_BRACKET statement_block;
method_decl: ACCES_MOD? STATIC? method_type ID LEFT_BRACKET (parameter_list? | main?) RIGHT_BRACKET statement_block;
field_decl: ACCES_MOD? STATIC? type ID (ASSIGN expr)? (COMMA ID (ASSIGN expr)?)* SEMICOLON;
//example int a = 5, b = 6, c;

//methode
parameter_list: type ID (COMMA type ID)*;
method_type: VOID | type;

//statements
statement_block: LEFT_BRACE statement* RIGHT_BRACE; //Block
statement: statement_block | local_var_decl | if_else_statement | while_statement | for_statement | return_statement | statement_expr SEMICOLON;
local_var_decl: type ID (ASSIGN expr)? SEMICOLON; // example a = 3; a = b; a = a + b; a = ( a - b )
if_else_statement: IF LEFT_BRACKET expr RIGHT_BRACKET statement_block else_statement?; // example if ( expr ) { statement }
else_statement: ELSE statement_block; // example else { statement }
while_statement: WHILE LEFT_BRACKET logical_expr RIGHT_BRACKET statement_block; // example while ( expr ) { statement }
for_statement: FOR LEFT_BRACKET (statement_expr | local_var_decl) SEMICOLON logical_expr SEMICOLON statement_expr RIGHT_BRACKET statement_block;
return_statement: RETURN expr? SEMICOLON;

///Statement expression
statement_expr: method_call_statement | new_statement | assign_statement | cre_expr; // example MyClass obj = new MyClass(42);
method_call_statement: (inst_var | ID) LEFT_BRACKET ( expr (COMMA expr)* )? RIGHT_BRACKET; // methode1 ( expr , expr );
new_statement: NEW ID LEFT_BRACKET expr RIGHT_BRACKET;
assign_statement: (inst_var | ID) ASSIGN expr; // example this.a = c + 3;
cre_expr: cre_op (ID | INT | inst_var ) | (ID | INT | inst_var ) cre_op; //example a++; ++a

//Instanciate variable
inst_var: THIS DOT ID? | (THIS DOT)? (ID DOT)+ ID; // example this.a

//expression
expr: binary_expr | basic_expr;
binary_expr: logical_expr | calculate_expr; //example a + b; 3 + 3 - a
basic_expr: THIS | ID | inst_var | statement_expr | NOT expr | LEFT_BRACKET expr RIGHT_BRACKET | add_sub_op INT | literal;
logical_expr: basic_expr (logical_op expr)*;// (a +b ) == c; c == (a+b)
calculate_expr: calculate_expr add_sub_op mul_div_expr | mul_div_expr;
value_calculate_expr: INT | ID | inst_var | method_call_statement | LEFT_BRACKET calculate_expr RIGHT_BRACKET | cre_expr;
mul_div_expr: mul_div_expr mul_div_op value_calculate_expr | value_calculate_expr;
// example  b =  a == 5 * 3 + 7 + 6 / 2;

/* example
3 + 3;
idString
( expression )
null
hallo
*/

// Operator
calculate_op: mul_div_op | add_sub_op;
logical_op: '==' | '!=' | '<' | '>' | '<=' | '>=';
add_sub_op: '+' | '-';
mul_div_op: '*' | '/';
cre_op: '++' | '--';

//Datatypes
type: 'int' | 'boolean' | 'char' | ID ;

//Declaration parameter
ACCES_MOD: 'private' | 'public' | 'protected';
STATIC: 'static';
VOID: 'void';
NEW: 'new';
THIS: 'this';
main: 'String[] args';

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
FOR: 'for';
RETURN: 'return';

// values
literal: INT | BOOLEAN | CHAR | STRING | NULL;
INT: [0-9]+;
BOOLEAN: 'true' | 'false';
CHAR: '\'' . '\''; //example 'a'
STRING: '"' ~[\r\n]* '"' ;
NULL: 'null';

//Identifier
ID: [a-zA-Z][a-zA-Z0-9]*;

WS : [ \t\r\n] -> skip;
InlineComment:'//' ~[\r\n]* -> skip;
MultilineComment: '/' .? '*/' -> skip;