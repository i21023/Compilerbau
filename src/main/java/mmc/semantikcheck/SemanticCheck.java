package mmc.semantikcheck;

import mmc.ast.expressions.*;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statementexpression.MethodCall;
import mmc.ast.statementexpression.New;
import mmc.ast.statements.*;

import java.util.Objects;
import java.util.Vector;

public class SemanticCheck implements SemanticVisitor {

    public static void main(String[] args) {
        Vector<ClassDecl> classDeclList = new Vector<ClassDecl>();
        var program = new Program(classDeclList);
        SemanticCheck semanticVisitor = new SemanticCheck();
        program.accept(semanticVisitor); //TypeCheckResult als rückgabe
    }

    @Override
    public TypeCheckResult typeCheck(Program toCheck) {
        //Nur auf Programm konzentrieren
        for(var classes : toCheck.classes){
            classes.accept(this);
        } return null;
    }

    @Override
    public TypeCheckResult typeCheck(ClassDecl toCheck) {
        for(var fields : toCheck.fields){
            fields.accept(this);
        }
        for(var method : toCheck.methods){
            method.accept(this);
        } return null;
    }

    @Override
    public TypeCheckResult typeCheck(Field toCheck) {
        return null;
    }


    @Override
    public TypeCheckResult typeCheck(Constructor toCheck) {
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
        valid = valid && Objects.equals(leftExpr, rightExpr) ;
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

    @Override
    public TypeCheckResult typeCheck(StmtExpExp toCheck) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(Super superExpr) {
        return null;
    }

    @Override
    public TypeCheckResult typeCheck(StmtExprStmt toCheck) {
        return null;
    }
}
