package me.blueslime.inventoryhandlerapi.inventory;

import me.blueslime.inventoryhandlerapi.inventory.types.DynamicInventory;
import me.blueslime.inventoryhandlerapi.inventory.types.StaticInventory;

public class CustomInventoryBuilder {
    private boolean perPlayer;
    private String identifier;

    private CustomInventoryBuilder(String identifier, boolean perPlayer) {
        this.identifier   = identifier;
        this.perPlayer    = perPlayer;
    }

    /**
     * Customize if the plugin creates a new inventory
     * per player, toggle this option if you want to use
     * variables per-item with plugins like PlaceholdersAPI
     * or with your own plugin
     * @param perPlayer {@link org.bukkit.inventory.Inventory}
     */
    public CustomInventoryBuilder perPlayer(boolean perPlayer) {
        this.perPlayer = perPlayer;
        return this;
    }

    public CustomInventoryBuilder identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public boolean isPerPlayer() {
        return perPlayer;
    }

    public static CustomInventoryBuilder builder(String identifier) {
        return builder(
                identifier, false
        );
    }

    public static CustomInventoryBuilder builder(String identifier, boolean perPlayer) {
        return new CustomInventoryBuilder(identifier, perPlayer);
    }

    public CustomInventory build() {
        if (perPlayer) {
            return new DynamicInventory(
                    identifier
            );
        }
        return new StaticInventory(
                identifier
        );
    }
}
