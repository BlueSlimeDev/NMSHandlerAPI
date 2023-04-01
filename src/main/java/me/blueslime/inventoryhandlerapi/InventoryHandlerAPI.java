package me.blueslime.inventoryhandlerapi;

import me.blueslime.inventoryhandlerapi.inventory.CustomInventory;
import me.blueslime.inventoryhandlerapi.listener.InventoryClickListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ConcurrentHashMap;

public final class InventoryHandlerAPI {
    private final ConcurrentHashMap<String, CustomInventory> menuMap = new ConcurrentHashMap<>();

    private static final InventoryHandlerAPI INVENTORY_HANDLER_API = new InventoryHandlerAPI();

    public static void register(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(
                new InventoryClickListener(),
                plugin
        );
    }

    public static ConcurrentHashMap<String, CustomInventory> getInventories() {
        return INVENTORY_HANDLER_API.menuMap;
    }
}
