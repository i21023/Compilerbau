package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.Type;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;
import org.objectweb.asm.ClassWriter;

import java.beans.Visibility;

public class Field implements Visitable {
    public Type type;
    public String name;

    public Field(Type pType, String pName)
    {
        type=pType;
        name=pName;
    }

    public void codeGen(ClassWriter cw) {

    }

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
