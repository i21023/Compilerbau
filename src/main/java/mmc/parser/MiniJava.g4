grammar MiniJava;

//Declarations
program: ('package' ID ('.' ID )* SEMICOLON)? public_class_decl;
//Class
public_class_decl: 'public' 'class' ID LEFT_BRACE (const_decl | method_decl | field_decl)*  RIGHT_BRACE class_decl* | class_decl+;
class_decl: 'class' ID LEFT_BRACE (const_decl | method_decl | field_decl)*  RIGHT_BRACE;
///Class objects
const_decl: ACCES_MOD? ID LEFT_BRACKET parameter_list? RIGHT_BRACKET block;
method_decl: main_method_decl | ACCES_MOD? STATIC? method_type ID LEFT_BRACKET parameter_list? RIGHT_BRACKET block;
main_method_decl: 'public' STATIC VOID 'main' LEFT_BRACKET (string_args | parameter_list?)  RIGHT_BRACKET  block;
string_args: 'String' '[' ']'  'args';
field_decl: ACCES_MOD? STATIC? type ID (ASSIGN expr)? (COMMA field_decl_concat)* SEMICOLON;
field_decl_concat: ID (ASSIGN expr)?;
//example int a = 5, b = 6, c;

//methode
parameter_list: type ID (COMMA type ID)*;
method_type: VOID | type;

//statements
block: LEFT_BRACE statement_block* RIGHT_BRACE; //Block
statement_block: local_var_decl SEMICOLON| statement;
statement: block | if_else_statement | while_statement | for_statement | return_statement | statement_expr SEMICOLON;
local_var_decl: type ID (ASSIGN expr)? (COMMA local_var_decl_concat)*; // example a = 3; a = b; a = a + b; a = ( a - b )
local_var_decl_concat: ID (ASSIGN expr)?;
if_else_statement: IF LEFT_BRACKET expr RIGHT_BRACKET statement else_statement?; // example if ( expr ) { statement }
else_statement: ELSE statement; // example else { statement }
while_statement: WHILE LEFT_BRACKET expr RIGHT_BRACKET statement; // example while ( expr ) { statement }
for_statement: FOR LEFT_BRACKET for_init? SEMICOLON expr? SEMICOLON for_statement_expr? RIGHT_BRACKET statement;
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
crement_statement: (pre_cre_op (ID | inst_var)) | ((ID | inst_var) suf_cre_op); //example a++; ++a

//Instanciate variable
inst_var: ((THIS | new_statement) DOT ID) | (((THIS DOT) | (new_statement DOT))? (ID DOT)+ ID); // example this.a

//expression
expr: logical_or_expr;
logical_or_expr: logical_or_expr logical_or_op logical_and_expr | logical_and_expr;
logical_and_expr: logical_and_expr logical_and_op bitwise_or_expr | bitwise_or_expr;
bitwise_or_expr: bitwise_or_expr bitwise_or_op bitwise_and_expr | bitwise_and_expr;
bitwise_and_expr: bitwise_and_expr bitwise_and_op equality_expr | equality_expr;
equality_expr: equality_expr equality_op relational_expr | relational_expr;
relational_expr: relational_expr relational_op additive_expr | additive_expr;
additive_expr: additive_expr add_sub_op multiplicative_expr | multiplicative_expr;
multiplicative_expr: multiplicative_expr mul_div_op unary_expr | unary_expr;
unary_expr: crement_statement | primary_expr;
primary_expr: THIS | ID | inst_var | statement_expr | NOT expr | LEFT_BRACKET expr RIGHT_BRACKET | literal;
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
logical_or_op: '||' ; // bindet schwächer als relational_op
logical_and_op: '&&'; // bindet stärker als logical_or_op, aber schwächer als relational_op
bitwise_or_op: '|' ; // bindet stärker als logical_and_op, aber schwächer als relational_op
bitwise_and_op: '&'; // bindet stärker als bitwise_or_op, aber schwächer als relational_op
equality_op: '==' | '!=';
relational_op: '<' | '>' | '<=' | '>=';
add_sub_op: '+' | '-';
mul_div_op: '*' | '/';
pre_cre_op: '++' | '--';
suf_cre_op: '++' | '--';
assign_op: '=' | '+=' | '-=' | '*=' | '/=' | '%=';

//Datatypes
type: 'int' | 'boolean' | 'char' | 'String' | ID ;

//Declaration parameter
ACCES_MOD: 'private' | 'public' | 'protected';
STATIC: 'static';
VOID: 'void';
NEW: 'new';
THIS: 'this';

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
literal: int | BOOLEAN | CHAR | STRING | NULL;
int: add_sub_op? INT;
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