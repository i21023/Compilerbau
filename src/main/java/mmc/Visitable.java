package mmc;

import mmc.codegen.visitors.IClassCodeVisitor;
import mmc.codegen.visitors.IMethodCodeVisitor;
import mmc.codegen.visitors.IProgramCodeVisitor;
import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public interface Visitable {
    default void accept(IProgramCodeVisitor visitor) {
    }

    default void accept(IClassCodeVisitor visitor) {
    }

    default void accept(IMethodCodeVisitor visitor) {
    }

    TypeCheckResult accept(SemanticVisitor visitor);

    public int getStartLine();

}
