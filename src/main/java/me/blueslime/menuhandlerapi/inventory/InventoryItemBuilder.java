package me.blueslime.menuhandlerapi.inventory;

import me.blueslime.menuhandlerapi.item.InventoryItem;
import org.bukkit.entity.Player;

public interface InventoryItemBuilder {
    InventoryItem processItem(Player player, InventoryItem item);
}
