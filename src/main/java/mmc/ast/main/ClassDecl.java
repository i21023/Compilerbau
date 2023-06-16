package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.codegen.visitors.IClassCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.List;

public class ClassDecl implements Visitable {
    public String name;
    public List<Field> fields;
    public List<Method> methods;
    public List<Constructor> constructors;
    public AccessModifier accessModifier;
    public int startLine; public int stopLine;

    public ClassDecl(String pName, List<Field> pFiedls, List<Method> pMethods, List<Constructor> pConstructors, AccessModifier pAccessModifier) {
        name = pName;
        fields = pFiedls;
        methods = pMethods;
        constructors = pConstructors;
        accessModifier = pAccessModifier;
    }

    public ClassDecl(String pName, List<Field> pFiedls, List<Method> pMethods, List<Constructor> pConstructors) {
        name = pName;
        fields = pFiedls;
        methods = pMethods;
        constructors = pConstructors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassDecl Class = (ClassDecl) o;
        return name.equals(Class.name) && fields.equals(Class.fields) && methods.equals(Class.methods) && constructors.equals(Class.constructors);
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
