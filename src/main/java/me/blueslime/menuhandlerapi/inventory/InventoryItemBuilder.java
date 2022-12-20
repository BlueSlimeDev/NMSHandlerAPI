package me.blueslime.menuhandlerapi.inventory;

import me.blueslime.menuhandlerapi.item.MenuItem;
import org.bukkit.entity.Player;

public interface InventoryItemBuilder {
    MenuItem processItem(Player player, MenuItem item);
}
