package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.statements.IStatement;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Constructor implements Visitable {
    public List<Parameter> parameters;
    public IStatement statement;
    public AccessModifier accessModifier;

    public Constructor(IStatement pStatement, List<Parameter> pParameters, AccessModifier pAccessModifier)
    {
        statement=pStatement;
        parameters=pParameters;
        accessModifier=pAccessModifier;
    }

    public void codeGen(ClassWriter cw){

    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
