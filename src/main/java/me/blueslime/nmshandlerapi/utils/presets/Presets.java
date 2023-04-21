package me.blueslime.nmshandlerapi.utils.presets;

import me.blueslime.nmshandlerapi.SpecifiedClass;

@SuppressWarnings("unused")
public class Presets {

    public static SpecifiedClass PACKET_PLAY_OUT_SPAWN_ENTITY_LIVING = SpecifiedClass.build(
            false,
            "[minecraft].[version].PacketPlayOutSpawnEntityLiving"
    );

    public static SpecifiedClass PACKET_PLAY_OUT_ENTITY_DESTROY = SpecifiedClass.build(
            false,
            "[minecraft].[version].PacketPlayOutEntityDestroy"
    );

    public static SpecifiedClass PACKET_PLAY_OUT_TITLE = SpecifiedClass.build(
            false,
            "[minecraft].[version].PacketPlayOutTitle"
    );

    public static SpecifiedClass PACKET_PLAY_OUT_CHAT = SpecifiedClass.build(
            false,
            "[minecraft].[version].PacketPlayOutChat"
    );

    public static SpecifiedClass CHAT_BASE_COMPONENT = SpecifiedClass.build(
            false,
            "[minecraft].[version].IChatBaseComponent"
    );

    public static SpecifiedClass CHAT_SERIALIZER = SpecifiedClass.build(
            false,
            "[minecraft].[version].ChatSerializer",
            "[minecraft].[version].ChatComponentText"
    );

    public static SpecifiedClass ENTITY_LIVING = SpecifiedClass.build(
            false,
            "[minecraft].[version].EntityLiving"
    );

    public static SpecifiedClass WORLD_SERVER = SpecifiedClass.build(
            false,
            "[minecraft].[version].WorldServer"
    );

    public static SpecifiedClass NBT_COMPOUND = SpecifiedClass.build(
            false,
            "[minecraft].[version].NBTTagCompound",
            "net.minecraft.nbt.NBTTagCompound"
    );

    public static SpecifiedClass CRAFT_PLAYER = SpecifiedClass.build(
            false,
            "[craftbukkit].[version].entity.CraftPlayer",
            "[craftbukkit].entity.CraftPlayer",
            "[craftbukkit].CraftPlayer"
    );

    public static SpecifiedClass CRAFT_WORLD = SpecifiedClass.build(
            false,
            "[craftbukkit].[version].CraftWorld"
    );

    public static SpecifiedClass CRAFT_ITEM = SpecifiedClass.build(
            false,
            "[craftbukkit].[version].inventory.CraftItemStack"
    );

    public static SpecifiedClass WITHER = SpecifiedClass.build(
            false,
            "[minecraft].[version].EntityWither"
    );

    public static SpecifiedClass PACKET = SpecifiedClass.build(
            false,
            "[minecraft].[version].Packet"
    );

    public static SpecifiedClass ENTITY = SpecifiedClass.build(
            false,
            "[minecraft].[version].Entity"
    );

    public static SpecifiedClass WORLD = SpecifiedClass.build(
            false,
            "[minecraft].[version].World"
    );

}
