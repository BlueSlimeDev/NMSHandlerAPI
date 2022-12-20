package me.blueslime.menuhandlerapi;

import me.blueslime.menuhandlerapi.inventory.MenuInventory;
import me.blueslime.menuhandlerapi.listener.InventoryClickListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ConcurrentHashMap;

public final class MenuHandlerAPI {
    private final ConcurrentHashMap<String, MenuInventory> menuMap = new ConcurrentHashMap<>();

    private static final MenuHandlerAPI MENU_HANDLER_API = new MenuHandlerAPI();

    public static void register(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(
                new InventoryClickListener(),
                plugin
        );
    }

    public static ConcurrentHashMap<String, MenuInventory> getMenus() {
        return MENU_HANDLER_API.menuMap;
    }
}
