package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.ast.statements.Block;
import mmc.ast.statements.IStatement;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Constructor implements Visitable {
    public List<Parameter> parameters;
    public IStatement statement;
    public Type type;
    public AccessModifier accessModifier;

    public Constructor(IStatement pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier, Block pBlock)
    {
        statement=pStatement;
        parameters=pParameters;
        accessModifier=pAccessModifier;
        type = BasicType.VOID;
    }

    public Constructor()
    {
        accessModifier=AccessModifier.PUBLIC;
        type = BasicType.VOID;
    }

    public void codeGen(ClassWriter cw){

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
