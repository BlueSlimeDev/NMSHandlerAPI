package me.blueslime.menuhandlerapi.item;

import me.blueslime.menuhandlerapi.item.action.MenuItemAction;
import org.bukkit.inventory.ItemStack;

public class MenuItemBuilder {
    private MenuItemAction action = null;

    private ItemStack itemStack = null;

    private boolean blocked = false;

    private final String identifier;

    private int slot;

    public MenuItemBuilder(String identifier, int slot) {
        this.identifier = identifier;
        this.slot = slot;
    }

    public MenuItemBuilder slot(int slot) {
        this.slot = slot;
        return this;
    }

    public MenuItemBuilder action(MenuItemAction action) {
        this.action = action;
        return this;
    }

    public MenuItemBuilder item(ItemStack itemStack) {
        this.itemStack = itemStack;
        return this;
    }

    public MenuItemBuilder cancelClick(boolean blocked) {
        this.blocked = blocked;
        return this;
    }

    public MenuItem build() {
        return MenuItem.fromItem(
                identifier,
                slot,
                itemStack,
                blocked,
                action
        );
    }
}
