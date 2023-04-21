package me.blueslime.nmshandlerapi;

import me.blueslime.nmshandlerapi.method.MethodData;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SpecifiedClass {
    private Class<?> result = null;

    private SpecifiedClass(boolean debugs, String... locations) {
        String name = Bukkit.getServer().getClass().getPackage().getName();

        String version = name.substring(
                name.lastIndexOf(".") + 1
        );

        ConsoleCommandSender sender = Bukkit.getConsoleSender();

        for (String location : locations) {
            location = location.replace(
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
            );

            try {
                result = Class.forName(
                        location
                );
            } catch (Exception ignored) {
                if (debugs) {
                    sender.sendMessage("[NMSHandlerAPI] [Class] Class located at '" + location + "' was not found.");
                }
            }
        }
    }

    public void showMethods(MethodData.SearchMethod searchMethod) {
        if (exists()) {

            ConsoleCommandSender sender = Bukkit.getConsoleSender();

            sender.sendMessage("[NMSHandlerAPI] [Class] Showing methods in category '" + searchMethod + "'");

            if (searchMethod == MethodData.SearchMethod.DEFAULT) {
                for (Method method : result.getMethods()) {
                    display(sender, method);
                }
            } else {
                for (Method method : result.getDeclaredMethods()) {
                    display(sender, method);
                }
            }
        }
    }

    private void display(ConsoleCommandSender sender, Method method) {
        String parameters = "";

        if (method.getParameters() != null) {
            parameters = Arrays.stream(method.getParameters()).map(clazz -> clazz.getClass().getSimpleName() + ".class").collect(Collectors.joining(", "));
        }

        sender.sendMessage("[NMSHandlerAPI] [Class] Method '" + method.getName() + "(" + parameters + ")" + "' of class '" + result.getSimpleName() + ".class'");
    }

    public Class<?> getResult() {
        return result;
    }

    public boolean exists() {
        return result != null;
    }

    public Object convert(Object cast) {
        if (result != null) {
            try {
                return result.cast(cast);
            } catch (ClassCastException ignored) {
                return null;
            }
        }
        return null;
    }

    public static SpecifiedClass build(boolean debugs, String... locations) {
        return new SpecifiedClass(debugs, locations);
    }

    public static SpecifiedClass build(String... locations) {
        return build(true, locations);
    }
}
