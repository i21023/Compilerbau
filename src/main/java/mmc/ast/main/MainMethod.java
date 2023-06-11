package mmc.ast.main;

import mmc.ast.AccessModifier;
import mmc.ast.Type;
import mmc.ast.statements.Block;

import java.util.ArrayList;
import java.util.List;

public class MainMethod extends Method {

    public MainMethod (Block block) {
        super(null, "main",
                new ArrayList<>(),
                block, AccessModifier.PUBLIC, true);
    }


}