package me.blueslime.menuhandlerapi.inventory;

import me.blueslime.menuhandlerapi.inventory.types.DynamicInventory;
import me.blueslime.menuhandlerapi.inventory.types.StaticInventory;

public class MenuInventoryBuilder {
    private boolean canIntroduce;
    private boolean perPlayer;
    private String identifier;
    private String title;
    private int slots;

    private MenuInventoryBuilder(String identifier, int slots, String title, boolean perPlayer, boolean canIntroduce) {
        this.canIntroduce = canIntroduce;
        this.identifier   = identifier;
        this.perPlayer    = perPlayer;
        this.title        = title;
        this.slots        = slots;
    }

    /**
     * Toggle if players can add items to the inventory
     * or disable it using false
     * @param canIntroduce {@link org.bukkit.inventory.ItemStack}
     */
    public void setCanIntroduce(boolean canIntroduce) {
        this.canIntroduce = canIntroduce;
    }

    /**
     * Customize if the plugin creates a new inventory
     * per player, toggle this option if you want to use
     * variables per-item with plugins like PlaceholdersAPI
     * or with your own plugin
     * @param perPlayer {@link org.bukkit.inventory.Inventory}
     */
    public MenuInventoryBuilder perPlayer(boolean perPlayer) {
        this.perPlayer = perPlayer;
        return this;
    }

    public MenuInventoryBuilder title(String title) {
        this.title = title;
        return this;
    }

    public MenuInventoryBuilder slots(int slots) {
        this.slots = slots;
        return this;
    }

    public MenuInventoryBuilder identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public boolean canIntroduceItems() {
        return canIntroduce;
    }

    public boolean isPerPlayer() {
        return perPlayer;
    }

    public String getTitle() {
        return title;
    }

    public int getSlots() {
        return slots;
    }

    public static MenuInventoryBuilder builder(String identifier, String title, int slots) {
        return new MenuInventoryBuilder(
                identifier, slots, title, false, false
        );
    }

    public static MenuInventoryBuilder builder(String identifier, String title) {
        return builder(identifier, title, 3);
    }

    public static MenuInventoryBuilder builder(String identifier, int slots) {
        return builder(
                identifier, "Inventory", slots
        );
    }

    public static MenuInventoryBuilder builder(String identifier) {
        return builder(
                identifier, "Inventory", 3
        );
    }

    public MenuInventory build() {
        if (perPlayer) {
            return new DynamicInventory(
                    identifier,
                    title,
                    slots,
                    canIntroduce
            );
        }
        return new StaticInventory(
                identifier,
                title,
                slots,
                canIntroduce
        );
    }
}
