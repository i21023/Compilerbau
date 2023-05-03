package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Method implements Visitable {
    public Type type;
    public String name;
    public List<Parameter> parameters;
    public Statement statement;

    public Method(Type pType, String pName, List<Parameter> pParameters, Statement pStatement)
    {
        type=pType;
        name=pName;
        parameters=pParameters;
        statement=pStatement;
    }

    public void codeGen(ClassWriter cw) {

    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
