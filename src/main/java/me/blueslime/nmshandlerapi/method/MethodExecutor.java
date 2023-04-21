package me.blueslime.nmshandlerapi.method;

public class MethodExecutor {

    private final Object[] parameters;
    private final Object invoker;

    public MethodExecutor(Object invoker, Object... parameters) {
        this.parameters = parameters;
        this.invoker = invoker;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Object getInvoker() {
        return invoker;
    }
}
