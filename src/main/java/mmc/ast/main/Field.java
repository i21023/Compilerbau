package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
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
    public int startLine; public int stopLine;

    public Field(Type pType, String pName, AccessModifier pAccessModifier, IExpression pExpression, boolean pisStatic) {
        type = pType;
        name = pName;
        accessModifier = pAccessModifier;
        isStatic = pisStatic;
        expression = pExpression;
    }

    public Field(String pName, AccessModifier pAccessModifier) {
        name = pName;
        accessModifier = pAccessModifier;
    }

    public Field(String pName, Type pType) {
        name = pName;
        type = pType;
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
    public boolean equals(Object o) {
        boolean typeIsEqual = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        if (type == null && field.type == null) {
            typeIsEqual = true;
        } else if (type.equals(field.type)) {
            typeIsEqual = true;
        }
        return typeIsEqual && name.equals(field.name) && accessModifier.equals(field.accessModifier) && isStatic == field.isStatic && expression.equals(field.expression);
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
