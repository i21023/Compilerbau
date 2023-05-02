package mmc.ast.statements;

import mmc.semantikcheck.SemanticVisitor;
import mmc.semantikcheck.TypeCheckResult;

import java.util.List;

public class Block implements IStatement{
    public List<IStatement> statements;

 @Override
    public TypeCheckResult accept(SemanticVisitor visitor) {
        return visitor.typeCheck(this);
    }
}
