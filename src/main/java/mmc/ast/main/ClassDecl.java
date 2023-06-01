package mmc.ast.main;

import java.util.ArrayList;
import java.util.List;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.codegen.visitors.IClassCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ClassDecl implements Visitable {
    public String name;
    public List<Field> fields;
    public List<Method> methods;
    public List<Constructor> constructors;

    public ClassDecl(String pName, List<Field> pFiedls, List<Method> pMethods, List<Constructor> pConstructors)
    {
        name=pName;
        fields=pFiedls;
        methods=pMethods;
        constructors=pConstructors;
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
