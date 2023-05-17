package mmc;

import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Operator;
import mmc.ast.Type;
import mmc.ast.expressions.Binary;
import mmc.ast.expressions.BoolExpr;
import mmc.ast.expressions.IntExpr;
import mmc.ast.expressions.LocalOrFieldVar;
import mmc.ast.main.*;
import mmc.ast.statementexpression.Assign;
import mmc.ast.statements.*;
import mmc.codegen.visitors.ProgramCodeGenerator;
import org.antlr.v4.runtime.CharStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ressources.helpers.Classwriter;
import ressources.helpers.Resources;

import java.beans.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static mmc.semantikcheck.SemanticCheck.generateTypedast;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TastTests {

    @Test
    @DisplayName("Empty Class")
    public void EmptyClassTest() throws IOException {
        CharStream file = Resources.getFileInput("src/test/java/ressources/testcases/EmptyClass.java");

        //Program tast = Compiler.getAst(file);
        //List<Constructor> constructors = new List<Constructor>(1);
        ClassDecl classDecl = new ClassDecl("EmptyClass", new ArrayList<Field>(),
                new ArrayList<Method>(), new ArrayList<Constructor>(), AccessModifier.PUBLIC);
        ArrayList<ClassDecl> classDecls = new ArrayList<ClassDecl>();
        classDecls.add(classDecl);
        Program testTast = new Program(classDecls);

    }

    @Test
    @DisplayName("ClassIfLokalVar")
    public void ClassIfLokalVarTest() {
        Block ElseBlock = new Block(new ArrayList<IStatement>(Arrays.asList(new Return(new BoolExpr(false)))));
        Block IfBlock = new Block(new ArrayList<IStatement>(Arrays.asList(new Return(new BoolExpr(true)))));
        Binary IfExpression = new Binary(Operator.EQUAL, new LocalOrFieldVar("a"), new LocalOrFieldVar("b"));
        Block Rumpf = new Block(new ArrayList<IStatement>(Arrays.asList(new LocalVarDecl("a", BasicType.INT), new LocalVarDecl("b", BasicType.INT), new If(IfBlock, ElseBlock, IfExpression))));
        ArrayList<Method> method = new ArrayList<Method>(Arrays.asList(new Method(null, "add", new ArrayList<Parameter>(), Rumpf, AccessModifier.PUBLIC, false)));
        ArrayList<ClassDecl> Testclass = new ArrayList<ClassDecl>(Arrays.asList(new ClassDecl("ClassIfLokalVar", new ArrayList<Field>(), method, new ArrayList<Constructor>(), AccessModifier.PUBLIC)));
        Program prog = new Program(Testclass);

        Program tast = generateTypedast(prog);
        Type typ = tast.classes.get(0).methods.get(0).type;
        assertEquals(BasicType.BOOL, typ);
    }

    @Test
    @DisplayName("Class with FieldVars and Method")
    public void FieldVarClassMutableTest() {

        Method method = new Method(BasicType.VOID, "changeX", new ArrayList<Parameter>(),
                new Block(new ArrayList<IStatement>(
                        Arrays.asList(new Assign(new LocalOrFieldVar("x"),
                                new IntExpr(30), null)))), AccessModifier.PUBLIC, false);


        ClassDecl classDecl = new ClassDecl("FieldVarClassMutable", new ArrayList<Field>(Arrays.asList(new Field(BasicType.INT,
                "x", AccessModifier.PUBLIC, new IntExpr(10), false))), new ArrayList<Method>(Arrays.asList(method)),
                new ArrayList<Constructor>(), AccessModifier.PUBLIC);

        Program prog = new Program(Arrays.asList(classDecl));

        Program tast = generateTypedast(prog);

    }
}
