package me.blueslime.nmshandlerapi.method;

import me.blueslime.nmshandlerapi.SpecifiedClass;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodContainer {
    private final List<MethodData> methodList = new ArrayList<>();

    private MethodData selectedMethod = null;
    private Method reflectedMethod = null;

    private MethodContainer(List<MethodData> methods) {
        methodList.addAll(methods);
    }

    private MethodContainer(MethodData... methods) {
        this.methodList.addAll(Arrays.asList(methods));
    }

    public MethodContainer initIn(boolean debugs, SpecifiedClass specifiedClass) {
        return search(debugs, specifiedClass);
    }

    public MethodContainer search(boolean debugs) {
        return search(debugs, (Class<?>)null);
    }

    public MethodContainer search() {
        return search(false, (Class<?>)null);
    }

    public MethodContainer search(boolean debugs, SpecifiedClass specifiedClass) {
        if (specifiedClass.exists()) {
            return search(debugs, specifiedClass.getResult());
        } else {
            return search(debugs, (Class<?>)null);
        }
    }

    public MethodContainer search(boolean debugs, Class<?> customClazz) {
        String name = Bukkit.getServer().getClass().getPackage().getName();

        String version = name.substring(
                name.lastIndexOf(".") + 1
        );

        ConsoleCommandSender sender = Bukkit.getConsoleSender();

        for (MethodData data : methodList) {
            if (data.getClazz() == null && customClazz == null) continue;


            String location = customClazz == null ? data.getClazz().replace(
                    "[version]",
                    version
            ).replace(
                    "[craftbukkit]",
                    "org.bukkit.craftbukkit"
            ).replace(
                    "[bukkit]",
                    "org.bukkit"
            ).replace(
                    "[minecraft]",
                    "net.minecraft.server"
            ) : "";

            String parameters = "";

            if (data.getParameters() != null) {
                parameters = Arrays.stream(data.getParameters()).map(clazz -> clazz.getSimpleName() + ".class").collect(Collectors.joining(", "));
            }

            Class<?> clazz;

            if (customClazz == null) {
                try {
                    if (data.getLocation() == null && !data.getClazz().isEmpty()) {
                        clazz = Class.forName(
                                location
                        );
                    } else {
                        if (data.getLocation() != null) {
                            clazz = data.getLocation();
                        } else {
                            throw new RuntimeException("You can't call a class without the class location");
                        }
                    }
                } catch (Exception ignored) {
                    if (debugs) {
                        sender.sendMessage("[NMSHandlerAPI] [MethodContainer] Class '" + data.getClazz() + "' was not found :(");
                    }
                    continue;
                }
            } else {
                clazz = customClazz;
            }

            try {
                if (debugs) {
                    sender.sendMessage("[NMSHandlerAPI] [MethodContainer] searching method '" + data.getName() + "(" + parameters + ")' in class '" + data.getClazz() + "'");
                }

                if (data.getSearch() == MethodData.SearchMethod.DEFAULT) {
                     reflectedMethod = clazz.getMethod(
                            data.getName(),
                            data.getParameters()
                    );
                } else {
                    reflectedMethod = clazz.getDeclaredMethod(
                            data.getName(),
                            data.getParameters()
                    );
                }

                selectedMethod = data;
                if (debugs) {
                    sender.sendMessage("[NMSHandlerAPI] Method '" + data.getName() + "(" + parameters + ")' has been found");
                    sender.sendMessage("[NMSHandlerAPI] Using this method registered with id: (" + data.getId() + ")");
                }
                break;
            } catch (Exception ignored) {
                if (debugs) {
                    sender.sendMessage("[NMSHandlerAPI] [MethodContainer] method '" + data.getName() + "(" + parameters + ")' in class '" + data.getClazz() + "' was not found");
                }
            }
        }
        return this;
    }

    public static MethodContainer builder(List<MethodData> methods) {
        return new MethodContainer(methods);
    }

    public static MethodContainer builder(MethodData... methods) {
        return new MethodContainer(methods);
    }

    public Object execute(Object invoker, Object... parameters) {
        if (exists()) {
            try {
                if (parameters != null && parameters.length >= 1) {
                    return reflectedMethod.invoke(
                            invoker,
                            parameters
                    );
                }
                return reflectedMethod.invoke(
                        invoker
                );
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public Object execute(MethodExecutor executor) {
        if (exists()) {
            try {
                if (executor.getParameters() != null && executor.getParameters().length >= 1) {
                    return reflectedMethod.invoke(
                            executor.getInvoker(),
                            executor.getParameters()
                    );
                }
                return reflectedMethod.invoke(
                        executor.getInvoker()
                );
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public int getCurrentId() {
        return selectedMethod.getId();
    }

    public MethodResult getResult() {
        return new MethodResult(getCurrentId(), selectedMethod);
    }

    public boolean exists() {
        return selectedMethod != null;
    }
}
