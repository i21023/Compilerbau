package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.statements.Statement;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.beans.Visibility;
import java.util.List;

public class Constructor implements Visitable {
    public List<Parameter> parameters;
    public Statement statement;

    public Constructor(Statement pStatement, List<Parameter> pParameters)
    {
        statement=pStatement;
        parameters=pParameters;
    }

    public void codeGen(ClassWriter cw){

    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
