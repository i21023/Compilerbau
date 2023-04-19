package mmc.ast.main;

import mmc.ast.statements.Statement;

import java.util.List;

public class Method {
    Type type;
    String name;
    List<Parameter> parameters;
    Statement statement;
}
