import java.util.*;

class SymbolTable {
    private Stack<Map<String, VariableSymbol>> scopes;
    private Map<String, MethodVariableSymbol> methods;
    private MethodVariableSymbol currentMethod;
    private String currentClassName;


    public SymbolTable() {
        scopes = new Stack<>();
        methods = new HashMap<>();
        scopes.push(new HashMap<>());
        currentMethod = null;
        currentClassName = null;
    }

    public MethodVariableSymbol getCurrentMethod() {
        return currentMethod;
    }

    public void setCurrentMethod(MethodVariableSymbol currentMethod) {
        this.currentMethod = currentMethod;
    }

    public void setCurrentClassName(String className) {
        this.currentClassName = className;
    }

    public String getCurrentClassName() {
        return this.currentClassName;
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        if (!scopes.isEmpty()) {
            scopes.pop();
        }
    }

    public void addVariable(String name, VariableSymbol variableSymbol) throws SemanticException {
        Map<String, VariableSymbol> currentScope = scopes.peek();
        if (currentScope.containsKey(name) || methods.containsKey(name)) {
            String errorLocation = "class<" + currentClassName + ">: " ;
            throw new SemanticException(errorLocation + "Variable '" + name + "' already declared in this scope or used as a method name");
        }
        currentScope.put(name, variableSymbol);
    }

    public VariableSymbol lookupVariable(String name) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, VariableSymbol> scope = scopes.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return null;
    }
    public void addMethod(String name, MethodVariableSymbol methodSymbol) throws SemanticException {
        if (methods.containsKey(name)) {
            String errorLocation = "class<" + currentClassName + ">: ";
            throw new SemanticException(errorLocation + "Method '" + name + "' already defined");
        }
        for (Map<String, VariableSymbol> scope : scopes) {
            if (scope.containsKey(name)) {
                String errorLocation = "class<" + currentClassName + ">: ";
                throw new SemanticException(errorLocation + "Method name '" + name + "' conflicts with a variable name " + name + " in the scope");
            }
        }
        methods.put(name, methodSymbol);
    }

    public void enterMethod(String methodName) {
        this.currentMethod = methods.get(methodName);
        enterScope();
        if (currentMethod != null) {
            for (VariableSymbol param : currentMethod.getParameters()) {
                scopes.peek().put(param.getName(), param);
            }
        }
    }

    public void exitMethod() {
        exitScope();
        this.currentMethod = null;
    }

    public String getCurrentMethodReturnType() {
        if (currentMethod != null) {
            return currentMethod.getReturnType();
        }
        return null;
    }

    public MethodVariableSymbol lookupMethod(String name) {
        return methods.get(name);
    }
}

class MethodVariableSymbol {
    String name;
    String returnType;

    List<VariableSymbol> parameters;

    public MethodVariableSymbol(String name, String returnType, List<VariableSymbol> parameters) {
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<VariableSymbol> getParameters() {
        return parameters;
    }

    public void setParameters(List<VariableSymbol> parameters) {
        this.parameters = parameters;
    }
}
