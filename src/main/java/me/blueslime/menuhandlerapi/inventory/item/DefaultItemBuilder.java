package me.blueslime.menuhandlerapi.inventory.item;

import me.blueslime.menuhandlerapi.inventory.InventoryItemBuilder;
import me.blueslime.menuhandlerapi.item.MenuItem;
import org.bukkit.entity.Player;

public class DefaultItemBuilder implements InventoryItemBuilder {
    @Override
    public MenuItem processItem(Player player, MenuItem item) {
        return item;
    }
}
