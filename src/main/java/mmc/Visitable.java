package mmc;

import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

public interface Visitable {
    /*default void accept(ProgramCodeVisitor visitor) {
    }

    default void accept(ClassCodeVisitor visitor) {
    }

    default void accept(MethodCodeVisitor visitor) {
    }*/

    TypeCheckResult accept(SemanticVisitor visitor);
}
