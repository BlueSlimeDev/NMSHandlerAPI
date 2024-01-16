package me.blueslime.nmshandlerapi.method;

public class MethodResult {

    private final MethodData result;
    private final int identifier;

    public MethodResult(int identifier, MethodData result) {
        this.identifier = identifier;
        this.result = result;
    }

    public MethodData getResult() {
        return result;
    }

    public int getIdentifier() {
        return identifier;
    }
}
