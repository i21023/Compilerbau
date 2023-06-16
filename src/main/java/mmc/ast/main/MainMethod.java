package mmc.ast.main;

import mmc.Visitable;
import mmc.ast.AccessModifier;
import mmc.ast.BasicType;
import mmc.ast.Type;
import mmc.ast.statements.Block;
import mmc.codegen.visitors.IMethodCodeVisitor;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;
import java.util.ArrayList;
import java.util.List;

public class MainMethod extends Method implements Visitable {

    public MainMethod (Block block, int pStartLine, int pStopLine) {
        super(BasicType.VOID, "main",
                new ArrayList<>(),
                block, AccessModifier.PUBLIC, true,
                pStartLine, pStopLine);
    }

    public MainMethod (Block block) {
        super(BasicType.VOID, "main",
                new ArrayList<>(),
                block, AccessModifier.PUBLIC, true);
    }

    @Override
    public void accept(IMethodCodeVisitor visitor) {
        visitor.visit(this);
    }
}