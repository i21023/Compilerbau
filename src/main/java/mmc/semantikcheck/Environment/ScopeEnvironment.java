package mmc.semantikcheck.Environment;

import mmc.ast.Type;
import mmc.ast.main.Parameter;
import mmc.ast.statements.LocalVarDecl;
import mmc.semantikcheck.Exception;

import java.util.HashMap;
import java.util.Stack;

public class ScopeEnvironment {
    private Stack<HashMap<String, Type>> localVars;

    public ScopeEnvironment() {
        localVars = new Stack<HashMap<String, Type>>();
    }

    public void addLocalVar(String name, Type type) {
        if (this.contains(name)) {
            throw new Exception("Variable " + name + " already exists in this scope");
        }
        localVars.peek().put(name, type);
    }

    public void clear() {
        localVars.clear();
    }

    public void pushScope() {
        localVars.push(new HashMap<String, Type>());
    }

    public void popScope() {
        localVars.pop();
    }

    public Type getLocalVar(String name) {
        for (HashMap<String, Type> map : localVars) {
            if (map.containsKey(name)) {
                return map.get(name);
            }
        }
        return null;
    }

    public boolean contains(String name) {
        for (HashMap<String, Type> map : localVars) {
            if (map.containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    public void addLocalVar(LocalVarDecl localVarDecl) {
        addLocalVar(localVarDecl.name, localVarDecl.getType());
    }

    public void addLocalVar(Parameter parameter) {
        addLocalVar(parameter.name, parameter.getType());
    }
}
