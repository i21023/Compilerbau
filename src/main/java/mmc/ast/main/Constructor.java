package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.ast.statements.Block;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.util.ArrayList;
import java.util.List;

public class Constructor implements Visitable {
    public List<Parameter> parameters;
    public Block statement;
    public Type type;
    public AccessModifier accessModifier;

    public Constructor(Block pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier) {
        statement = pStatement;
        parameters = pParameters;
        accessModifier = pAccessModifier;
        type = BasicType.VOID;
    }

    public Constructor() {
        accessModifier = AccessModifier.PUBLIC;
        parameters = new ArrayList<Parameter>();
        statement = new Block();
        type = BasicType.VOID;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constructor constructor = (Constructor) o;
        return parameters.equals(constructor.parameters) && statement.equals(constructor.statement) && type.equals(constructor.type) && accessModifier.equals(constructor.accessModifier);
    }

    @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}
