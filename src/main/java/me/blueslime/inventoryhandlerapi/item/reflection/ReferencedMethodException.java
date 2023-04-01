package me.blueslime.inventoryhandlerapi.item.reflection;

public class ReferencedMethodException extends Exception{
    public ReferencedMethodException(MinecraftEnum minecraft, String version) {
        super("You are using an incompatible version because the methods for '" + minecraft.toString() + "' was not found in this version '" + version + "'");
    }

    public ReferencedMethodException(BukkitEnum bukkit, String version) {
        super("You are using an incompatible version because the methods for '" + bukkit.toString() + "' was not found in this version '" + version + "'");
    }
}
