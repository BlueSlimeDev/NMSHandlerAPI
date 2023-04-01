package me.blueslime.inventoryhandlerapi.inventory;

import me.blueslime.inventoryhandlerapi.item.InventoryItem;
import org.bukkit.entity.Player;

public interface InventoryItemBuilder {
    InventoryItem processItem(Player player, InventoryItem item);
}
