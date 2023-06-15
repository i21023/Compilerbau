package mmc.semantikcheck.Environment;

import mmc.ast.Type;
import mmc.ast.main.Parameter;
import mmc.ast.statements.LocalVarDecl;
import mmc.semantikcheck.Exception;

import java.util.HashMap;
import java.util.Stack;

public class ScopeEnvironment {
    private Stack<HashMap<String, ScopeInitialized>> localVars;

    public ScopeEnvironment() {
        localVars = new Stack<HashMap<String, ScopeInitialized>>();
    }

    public void addLocalVar(String name, Type type, boolean isInitialized) {
        if (this.contains(name)) {
            throw new Exception("Variable " + name + " already exists in this scope");
        }
        localVars.peek().put(name, new ScopeInitialized(type, isInitialized));
    }

    public void clear() {
        localVars.clear();
    }

    public void pushScope() {
        localVars.push(new HashMap<String, ScopeInitialized>());
    }

    public void popScope() {
        localVars.pop();
    }

    public boolean contains(String name) {
        for (HashMap<String, ScopeInitialized> map : localVars) {
            if (map.containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    public void addLocalVar(LocalVarDecl localVarDecl, boolean isInitialized) {
        addLocalVar(localVarDecl.name, localVarDecl.getType(), isInitialized);
    }

    public void addLocalVar(Parameter parameter) {
        addLocalVar(parameter.name, parameter.getType(), true);
    }
    public ScopeInitialized getLocalVar(String name) {
        for (HashMap<String, ScopeInitialized> map : localVars) {
            if (map.containsKey(name)) {
                return map.get(name);
            }
        }
        return null;
    }
}
