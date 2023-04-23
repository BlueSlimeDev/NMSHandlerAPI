package me.blueslime.nmshandlerapi.method;

public class MethodExecutor {

    private final Object[] parameters;
    private final Object invoker;

    private MethodExecutor(Object invoker, Object... parameters) {
        this.parameters = parameters;
        this.invoker = invoker;
    }

    private MethodExecutor(Object invoker) {
        this.parameters = null;
        this.invoker = invoker;
    }

    public static MethodExecutor fromData(Object invoker, Object... parameters) {
        return new MethodExecutor(invoker, parameters);
    }

    public static MethodExecutor fromData(Object invoker) {
        return new MethodExecutor(invoker);
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Object getInvoker() {
        return invoker;
    }
}
