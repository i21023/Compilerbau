grammar MiniJava;

program: class_decl*;
class_decl: 'class' ID '{' field_declaration* method_declaration* '}';
field_decl: type ID ';';

method_decl: type ID '(' parameter_list? ')' statement_block;

parameter_list: type ID (',' type ID)*;

statement_block: '{' statement* '}';

statement: assignment_statement | if_statement | while_statement | method_call_statement | return_statement;

assignment_statement: location '=' expr ';';

if_statement: 'if' '(' expr ')' statement ( 'else' statement )?;

while_statement: 'while' '(' expr ')' statement;

method_call_statement: location '(' ( expr (',' expr)* )? ')' ';';

return_statement: 'return' expr? ';';

location: ID;

expr: literal | location | binary_expr | '(' expr ')';

binary_expr: expr op expr;

op: '+' | '-' | '*' | '/' | '==' | '!=' | '<' | '>' | '<=' | '>=';

literal: INT | BOOLEAN | CHAR;

type: 'int' | 'boolean' | 'char';

ID: [a-zA-Z][a-zA-Z0-9]*;

INT: [0-9]+;

BOOLEAN: 'true' | 'false';

CHAR: '\'' . '\'';

