package me.blueslime.inventoryhandlerapi.inventory.item;

import me.blueslime.inventoryhandlerapi.inventory.InventoryItemBuilder;
import me.blueslime.inventoryhandlerapi.item.InventoryItem;
import org.bukkit.entity.Player;

public class DefaultItemBuilder implements InventoryItemBuilder {
    @Override
    public InventoryItem processItem(Player player, InventoryItem item) {
        return item;
    }
}
