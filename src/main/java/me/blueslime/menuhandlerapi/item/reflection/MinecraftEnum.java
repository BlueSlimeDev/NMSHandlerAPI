package me.blueslime.menuhandlerapi.item.reflection;

import java.util.Arrays;
import java.util.List;

public enum MinecraftEnum {
    NBT_COMPOUND("[path].[version].NBTTagCompound", "net.minecraft.nbt.NBTTagCompound");

    MinecraftEnum(String... path) {
        this.path = path;
    }

    private final String[] path;

    public String[] getPath() {
        return path;
    }

    public List<String> getPathList() {
        return Arrays.asList(path);
    }

    /**
     * obtain the class provided from this reflection
     * @return {@link java.lang.Class}
     */
    public Class<?> getBukkitProvided() {
        return ReflectionHandlerCache.getReference(this);
    }
}
