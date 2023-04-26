grammar MiniJava;

//Declarations
program: class_decl*;
class_decl: ACCES_MOD 'class' ID LEFT_BRACE field_decl* method_decl* RIGHT_BRACE ;
field_decl: ACCES_MOD type ID SEMICOLON;
method_decl: ACCES_MOD type ID LEFT_BRACKET parameter_list? RIGHT_BRACKET statement_block;

parameter_list: type ID (COMMA type ID)*;

//statements
statement_block: LEFT_BRACE statement* RIGHT_BRACE;
statement: assignment_statement | if_statement | while_statement | method_call_statement | return_statement;
assignment_statement: location EQUALS expr SEMICOLON;
if_statement: 'if' LEFT_BRACKET expr RIGHT_BRACKET statement ( 'else' statement )?;
while_statement: 'while' LEFT_BRACKET expr RIGHT_BRACKET statement;
method_call_statement: location LEFT_BRACKET ( expr (COMMA expr)* )? RIGHT_BRACKET SEMICOLON;
return_statement: 'return' expr? SEMICOLON;

location: ID;

expr: literal | location | binary_expr | LEFT_BRACKET expr RIGHT_BRACKET;

binary_expr: expr op expr;

op: '+' | '-' | '*' | '/' | '==' | '!=' | '<' | '>' | '<=' | '>=';

literal: INT | BOOLEAN | CHAR;

type: 'int' | 'boolean' | 'char';
ACCES_MOD: 'private' | 'public' | 'protected';

ID: [a-zA-Z][a-zA-Z0-9]*;

INT: [0-9]+;

BOOLEAN: 'true' | 'false';

CHAR: '\'' . '\'';

//signs
LEFT_BRACE: '{';
RIGHT_BRACE: '}';
LEFT_BRACKET: '(';
RIGHT_BRACKET: ')';
SEMICOLON: ';';
COMMA: ',';
EQUALS: '=';


