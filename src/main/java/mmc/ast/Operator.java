package mmc.ast;

public enum Operator {
    //Assign operators:
    ASSIGN,
    INCPRE,
    INCSUF,
    DECPRE,
    DECSUF,

    //arithmetic operators:
    PLUS,
    MINUS,
    MULT,
    DIV,
    MOD,

    //comparative operators:
    GREATER,
    LESS,
    GREATEREQUAL,
    LESSEQUAL,
    EQUAL,
    NOTEQUAL,

    //logical operators:
    NOT,
    AND,
    OR
}
