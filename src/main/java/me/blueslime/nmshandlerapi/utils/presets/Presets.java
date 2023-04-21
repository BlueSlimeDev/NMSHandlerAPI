package me.blueslime.nmshandlerapi.utils.presets;

import me.blueslime.nmshandlerapi.SpecifiedClass;

@SuppressWarnings("unused")
public class Presets {

    public static SpecifiedClass PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING = SpecifiedClass.build(
            "[minecraft].[version].PacketPlayOutSpawnEntityLiving"
    );

    public static SpecifiedClass PACKET_PLAY_OUT_ENTITY_DESTROY = SpecifiedClass.build(
            "[minecraft].[version].PacketPlayOutEntityDestroy"
    );

    public static SpecifiedClass PACKET_PLAY_OUT_TITLE = SpecifiedClass.build(
            "[minecraft].[version].PacketPlayOutTitle"
    );

    public static SpecifiedClass PACKET_PLAY_OUT_CHAT = SpecifiedClass.build(
            "[minecraft].[version].PacketPlayOutChat"
    );

    public static SpecifiedClass CHAT_BASE_COMPONENT = SpecifiedClass.build(
            "[minecraft].[version].IChatBaseComponent"
    );

    public static SpecifiedClass CHAT_SERIALIZER = SpecifiedClass.build(
            "[minecraft].[version].ChatSerializer",
            "[minecraft].[version].ChatComponentText"
    );

    public static SpecifiedClass ENTITY_LIVING = SpecifiedClass.build(
            "[minecraft].[version].EntityLiving"
    );

    public static SpecifiedClass WORLD_SERVER = SpecifiedClass.build(
            "[minecraft].[version].WorldServer"
    );

    public static SpecifiedClass NBT_COMPOUND = SpecifiedClass.build(
            "[minecraft].[version].NBTTagCompound",
            "net.minecraft.nbt.NBTTagCompound"
    );

    public static SpecifiedClass CRAFT_PLAYER = SpecifiedClass.build(
            "[craftbukkit].[version].entity.CraftPlayer",
            "[craftbukkit].entity.CraftPlayer",
            "[craftbukkit].CraftPlayer"
    );

    public static SpecifiedClass CRAFT_WORLD = SpecifiedClass.build(
            "[craftbukkit].[version].CraftWorld"
    );

    public static SpecifiedClass CRAFT_ITEM = SpecifiedClass.build(
            "[craftbukkit].[version].inventory.CraftItemStack"
    );

    public static SpecifiedClass WITHER = SpecifiedClass.build(
            "[minecraft].[version].EntityWither"
    );

    public static SpecifiedClass PACKET = SpecifiedClass.build(
            "[minecraft].[version].Packet"
    );

    public static SpecifiedClass ENTITY = SpecifiedClass.build(
            "[minecraft].[version].Entity"
    );

    public static SpecifiedClass WORLD = SpecifiedClass.build(
            "[minecraft].[version].World"
    );

}
