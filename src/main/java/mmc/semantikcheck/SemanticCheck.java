package mmc.semantikcheck;

import mmc.Visitable;
import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class SemanticCheck implements SemanticVisitor {

    private ClassDecl getClass;
    private String fileName;
    public ArrayList<Exception> errors = new ArrayList<>();
    private ArrayList<String> getFields = new ArrayList<>();

    public static void main(String[] args) {
        Vector<ClassDecl> classDeclList = new Vector<ClassDecl>();
        var program = new Program(classDeclList);
        SemanticCheck semanticVisitor = new SemanticCheck();
        TypeCheckResult typeCheck = program.accept(semanticVisitor); //TypeCheckResult als rückgabe
    }

    public static Program generateTypedast(Program program) { //Erstelle getypter Baum
        SemanticCheck semanticCheck = new SemanticCheck();
        var result = program.accept(semanticCheck);
        if (result.isValid()) {
            return program;
        } else {
            String ANSI_RESET = "\u001B[0m";
            String ANSI_RED = "\u001B[31m";
            var errorString = "\n" + ANSI_RED;
            for (int i = semanticCheck.errors.size() - 1; i >= 0; i--) {
                errorString += semanticCheck.errors.get(i).getMessage() + "\n";
            }
            throw new Exception(errorString + ANSI_RESET);
        }
    }

    @Override
    public TypeCheckResult typeCheck(Program toCheck) {
        //Nur auf Programm konzentrieren
        for (var classes : toCheck.classes) { //Geht durch alle Klassen und checkt sie
            classes.accept(this);
        }
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(ClassDecl toCheck) {
        this.getClass = toCheck; // For the Class-Context
        if (fileName == null) {
            this.fileName = toCheck.name + ".java";
        }
        ArrayList<String> identifiers = new ArrayList<>();
        var valid = true;
        getFields.clear();
        for (Field field : toCheck.fields) {
            var result = field.accept(this);
            valid = valid && result.isValid();
            if (valid) {
                identifiers.add(field.name);
            }
        }

        if (toCheck.constructors.isEmpty()) {
            new Constructor().accept(this);
        } else {
            for (Constructor constructorDecl : toCheck.constructors) {
                valid = constructorDecl.accept(this).isValid() && valid;
            }
        }
        for (Method methodDecl : toCheck.methods) {
            valid = methodDecl.accept(this).isValid() && valid;
        }

        return new TypeCheckResult(valid, null);
    }


    @Override
    public TypeCheckResult typeCheck(Field toCheck) {
        var valid = true;
        if (getFields.contains(toCheck.name)) { //Schaut ob der Feldname schon existiert
            errors.add(new Exception("Field " + toCheck.name + " is already defined in class "));
            valid = false;
        } else {
            getFields.add(toCheck.name); //Wenn nein fügt er in zur Liste
        }
        var result = toCheck.accept(this);
        valid = valid && result.isValid();
        return new TypeCheckResult(valid, null);
    }


    @Override
    public TypeCheckResult typeCheck(Constructor toCheck) { //TypeCheck(Parameter) { Expression }
        boolean valid = true;
        for (var parameters : toCheck.parameters) {

        }
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Method toCheck) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Assign toCheck) {
        var leftExpr = toCheck.leftExpr.accept(this);
        var rightExpr = toCheck.rightExpr.accept(this);
        boolean valid = leftExpr.isValid() && rightExpr.isValid();
        valid = valid && Objects.equals(leftExpr, rightExpr);
        return new TypeCheckResult(valid, null);
    }

    @Override
    public TypeCheckResult typeCheck(Parameter toCheck) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(While whileStmt) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Return returnStmt) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(LocalVarDecl localVarDecl) {
        //int x;
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(If ifStmt) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Block block) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(New newDecl) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(MethodCall methodCall) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Unary unary) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(This aThis) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(JNull aNull) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(LocalOrFieldVar localOrFieldVar) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(IntExpr integerExpr) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(InstVar instVar) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(CharExpr charExpr) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(BoolExpr boolExpr) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Binary binary) {
        return null;
    }
}
