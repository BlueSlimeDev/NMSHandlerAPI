package me.blueslime.nmshandlerapi.method;

public class MethodData {
    private final Class<?>[] parameters;
    private final SearchMethod search;
    private final Class<?> location;
    private final String clazz;
    private final String name;
    private final int id;

    private MethodData(int id, SearchMethod search, String clazz, String name, Class<?>... parameters) {
        this.parameters = parameters;
        this.location = null;
        this.search = search;
        this.clazz = clazz;
        this.name = name;
        this.id = id;
    }

    private MethodData(int id, SearchMethod search, Class<?> clazz, String name, Class<?>... parameters) {
        this.parameters = parameters;
        this.location = clazz;
        this.search = search;

        if (clazz != null) {
            this.clazz = clazz.getName();
        } else {
            this.clazz = "";
        }

        this.name = name;
        this.id = id;
    }

    public Class<?> getLocation() {
        return location;
    }

    public Class<?>[] getParameters() {
        return parameters;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public SearchMethod getSearch() {
        return search;
    }

    public static MethodData build(String clazz, SearchMethod search, int id, String name, Class<?>... parameters) {
        return new MethodData(id, search, clazz,  name, parameters);
    }

    public static MethodData build(String clazz, int id, String name, Class<?>... parameters) {
        return new MethodData(id, SearchMethod.DEFAULT, clazz,  name, parameters);
    }

    public static MethodData build(Class<?> clazz, SearchMethod search, int id, String name, Class<?> parameters) {
        return new MethodData(id, search, clazz, name, parameters);
    }

    public static MethodData build(Class<?> clazz, int id, String name, Class<?> parameters) {
        return new MethodData(id, SearchMethod.DEFAULT, clazz, name, parameters);
    }

    public enum SearchMethod {
        DECLARED,
        DEFAULT;
    }

    public String getClazz() {
        return clazz;
    }
}
