package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.expressions.IExpression;
import mmc.codegen.visitors.IClassCodeVisitor;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.beans.Visibility;

public class Field implements Visitable {
    public Type type;
    public String name;
    public AccessModifier accessModifier;
    public boolean isStatic;
    public IExpression expression;

    public Field(Type pType, boolean pisStatic, String pName,AccessModifier pAccessModifier, IExpression pExpression)
    {
        type=pType;
        name=pName;
        accessModifier = pAccessModifier;
        isStatic = pisStatic;
        expression = pExpression;
    }
    public Field(String pName, AccessModifier pAccessModifier) {
        name = pName;
        accessModifier = pAccessModifier;
    }
    public Field(AccessModifier pAccessModifier, boolean pisStatic, Type pType, String pName) {
        name = pName;
        accessModifier = pAccessModifier;
        isStatic = pisStatic;
        type = pType;
    }

    public Type getType() {
        return type;
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept(IClassCodeVisitor visitor) {
        visitor.visit(this);
    }
}
