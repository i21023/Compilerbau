package mmc.ast;

public enum Operator {
    //assign operators:
    ASSIGN,
    PLUSASSIGN,
    MINUSASSIGN,
    MULTASSIGN,
    DIVASSIGN,
    MODASSIGN,

    //crement operators
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
    SINGLEAND,
    SINGLEOR,
    AND,
    OR
}
