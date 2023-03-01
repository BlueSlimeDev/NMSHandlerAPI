package me.blueslime.menuhandlerapi.inventory.item;

import me.blueslime.menuhandlerapi.inventory.InventoryItemBuilder;
import me.blueslime.menuhandlerapi.item.InventoryItem;
import org.bukkit.entity.Player;

public class DefaultItemBuilder implements InventoryItemBuilder {
    @Override
    public InventoryItem processItem(Player player, InventoryItem item) {
        return item;
    }
}
