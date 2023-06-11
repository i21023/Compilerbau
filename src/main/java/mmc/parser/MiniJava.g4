grammar MiniJava;

//Declarations
program: ('package' ID ('.' ID )* SEMICOLON)* class_decl*;
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
statement: statement_block | local_var_decl SEMICOLON | if_else_statement | while_statement | for_statement | return_statement | statement_expr SEMICOLON;
local_var_decl: type ID (ASSIGN expr)? (COMMA ID (ASSIGN expr)?)*; // example a = 3; a = b; a = a + b; a = ( a - b )
//ToDo: Keine Deklarationen bei If, For oder While ohne Block
if_else_statement: IF LEFT_BRACKET logical_expr RIGHT_BRACKET statement else_statement?; // example if ( expr ) { statement }
else_statement: ELSE statement; // example else { statement }
while_statement: WHILE LEFT_BRACKET logical_expr RIGHT_BRACKET statement; // example while ( expr ) { statement }
for_statement: FOR LEFT_BRACKET for_init? SEMICOLON logical_expr? SEMICOLON for_statement_expr? RIGHT_BRACKET statement;
for_init: for_statement_expr | local_var_decl;
for_statement_expr: statement_expr (COMMA statement_expr)*;
return_statement: RETURN expr? SEMICOLON;

///Statement expression
statement_expr: method_call_statement| new_statement  | assign_statement | crement_statement ; // example MyClass obj = new MyClass(42);
method_call_statement: method_owner_prefix? method_chain* (ID LEFT_BRACKET argumentList? RIGHT_BRACKET);
//example a.hello().hello2(); methode1 ( expr , expr );
method_owner_prefix: (THIS | inst_var | new_statement | ID) DOT;
method_chain: ID LEFT_BRACKET argumentList? RIGHT_BRACKET DOT;
new_statement: NEW ID LEFT_BRACKET argumentList? RIGHT_BRACKET;
argumentList: expr (COMMA expr)*;
assign_statement: (inst_var | ID) assign_op expr; // example this.a = c + 3; x += 3;
crement_statement: (pre_cre_op (ID | inst_var )) | ((ID | inst_var ) suf_cre_op); //example a++; ++a

//Instanciate variable
inst_var: (THIS DOT ID) | ((THIS DOT)? (ID DOT)+ ID); // example this.a

//expression
//ToDo: ggf. Mehrdeutigkeit bei INT-Werten auflösen?
expr: basic_expr | binary_expr;
basic_expr: THIS | ID | inst_var | statement_expr | NOT expr | LEFT_BRACKET expr RIGHT_BRACKET | add_sub_op INT | literal;
binary_expr: logical_expr | calculate_expr; //| string_concat_expr; //example a + b; 3 + 3 - a; "Countdown: " + a
//ToDo: == etc. muss stärker binden als || etc.
logical_expr: basic_expr logical_op expr;// (a +b ) == c; c == (a+b)
calculate_expr: calculate_expr add_sub_op mul_div_expr | mul_div_expr;
mul_div_expr: mul_div_expr mul_div_op value_calculate_expr | value_calculate_expr;
value_calculate_expr: INT | ID | inst_var | method_call_statement | LEFT_BRACKET calculate_expr RIGHT_BRACKET | crement_statement;
//string_concat_expr: string_concat_expr '+' (ID | inst_var | string_concat_expr) | (ID | inst_var) '+' string_concat_expr  | (STRING|CHAR);
// example  b =  a == 5 * 3 + 7 + 6 / 2;

/* example
3 + 3;
idString
( expression )
null
hallo
*/

// Operator
logical_op: '|' | '&' | '||' | '&&' | '==' | '!=' | '<' | '>' | '<=' | '>=';
add_sub_op: '+' | '-';
mul_div_op: '*' | '/';
pre_cre_op: '++' | '--';
suf_cre_op: '++' | '--';
assign_op: '=' | '+=' | '-=' | '*=' | '/=' | '%=';

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