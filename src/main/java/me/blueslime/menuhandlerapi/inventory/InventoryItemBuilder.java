package me.blueslime.menuhandlerapi.inventory;

import me.blueslime.menuhandlerapi.item.MenuItem;
import org.bukkit.entity.Player;

public abstract class InventoryItemBuilder {
    public abstract MenuItem processItem(Player player, MenuItem item);
}
