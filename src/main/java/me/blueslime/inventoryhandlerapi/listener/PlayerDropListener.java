package me.blueslime.inventoryhandlerapi.listener;

import me.blueslime.inventoryhandlerapi.InventoryHandlerAPI;
import me.blueslime.inventoryhandlerapi.item.nbt.ItemNBT;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDropListener implements Listener {
    @EventHandler
    public void on(PlayerDropItemEvent event) {
        ItemStack itemStack = event.getItemDrop().getItemStack();

        String tag = ItemNBT.fromString(itemStack, InventoryHandlerAPI.getCustomIdentifierPrefix() + "blockedItem");
        if (tag != null && !tag.isEmpty()) {
            event.setCancelled(true);
        }
    }
}
