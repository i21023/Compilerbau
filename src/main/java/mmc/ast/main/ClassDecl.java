package mmc.ast.main;

import java.util.List;

import mmc.Visitable;
import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

public class ClassDecl implements Visitable {
    public String name;
    public Type type;
    public List<Field> fields;
    public List<Method> methods;
    public List<Constructor> constructors;

    public ClassDecl(String pName, Type pType, List<Field> pFiedls, List<Method> pMethods, List<Constructor> pConstructors)
    {
        name=pName;
        type=pType;
        fields=pFiedls;
        methods=pMethods;
        constructors=pConstructors;
    }

    //SemantikCheck

    public void codeGen(){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, name, null,
                "java/lang/Object", null);

        fields.forEach(f -> f.codeGen(cw));
        constructors.forEach(c -> c.codeGen(cw));
        methods.forEach(m -> m.codeGen(cw));
    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
