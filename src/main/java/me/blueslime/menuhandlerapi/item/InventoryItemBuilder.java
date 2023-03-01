package me.blueslime.menuhandlerapi.item;

import me.blueslime.menuhandlerapi.item.action.InventoryItemAction;
import org.bukkit.inventory.ItemStack;

public class InventoryItemBuilder {
    private InventoryItemAction action = null;

    private ItemStack itemStack = null;

    private boolean blocked = false;

    private final String identifier;

    private int slot;

    public InventoryItemBuilder(String identifier, int slot) {
        this.identifier = identifier;
        this.slot = slot;
    }

    public InventoryItemBuilder slot(int slot) {
        this.slot = slot;
        return this;
    }

    public InventoryItemBuilder action(InventoryItemAction action) {
        this.action = action;
        return this;
    }

    public InventoryItemBuilder item(ItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public InventoryItemBuilder cancelClick(boolean blocked) {
        this.blocked = blocked;
        return this;
    }

    public InventoryItem build() {
        return InventoryItem.fromItem(
                identifier,
                slot,
                itemStack,
                blocked,
                action
        );
    }
}
