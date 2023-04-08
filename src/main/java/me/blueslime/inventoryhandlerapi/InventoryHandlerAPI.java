package me.blueslime.inventoryhandlerapi;

import me.blueslime.inventoryhandlerapi.inventory.CustomInventory;
import me.blueslime.inventoryhandlerapi.listener.InventoryClickListener;
import me.blueslime.inventoryhandlerapi.listener.PlayerDropListener;
import me.blueslime.inventoryhandlerapi.listener.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
public final class InventoryHandlerAPI {
    private final ConcurrentHashMap<String, CustomInventory> menuMap = new ConcurrentHashMap<>();

    private static final InventoryHandlerAPI INVENTORY_HANDLER_API = new InventoryHandlerAPI();

    private static String CUSTOM_IDENTIFIER_PREFIX = "iha-";
    private static String CUSTOM_PREFIX = "ihi-";

    public static void register(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(
                new InventoryClickListener(),
                plugin
        );
        plugin.getServer().getPluginManager().registerEvents(
                new PlayerDropListener(),
                plugin
        );
        plugin.getServer().getPluginManager().registerEvents(
                new PlayerInteractListener(),
                plugin
        );
    }

    public static void setCustomPrefix(String newPrefix) {
        CUSTOM_PREFIX = newPrefix;
    }

    public static String getCustomPrefix() {
        return CUSTOM_PREFIX;
    }

    public static ConcurrentHashMap<String, CustomInventory> getInventories() {
        return INVENTORY_HANDLER_API.menuMap;
    }

    public static String getCustomIdentifierPrefix() {
        return CUSTOM_IDENTIFIER_PREFIX;
    }

    public static void setCustomIdentifierPrefix(String customIdentifierPrefix) {
        CUSTOM_IDENTIFIER_PREFIX = customIdentifierPrefix;
    }
}
