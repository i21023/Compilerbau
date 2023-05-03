package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.statements.IStatement;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.util.List;

public class Method implements Visitable {
    public Type type;
    public String name;
    public List<Parameter> parameters;
    public IStatement statement;
    public AccessModifier accessModifier;

    public Method(Type pType, String pName, List<Parameter> pParameters, IStatement pStatement, AccessModifier pAccessModifier)
    {
        type=pType;
        name=pName;
        parameters=pParameters;
        statement=pStatement;
        accessModifier=pAccessModifier;
    }

    public Type getType() {
        return type;
    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isSameDeclaration(Method methodDecl) {

        if (!this.name.equals(methodDecl.name) || !this.getType().equals(methodDecl.getType())
                || this.parameters.size() != methodDecl.parameters.size()) {
            return false;
        }

        for (int i = 0; i < this.parameters.size(); i++) {
            if (!this.parameters.get(i).getType().equals(methodDecl.parameters.get(i).getType())) {
                return false;
            }
        }
        return true;
    }
}
