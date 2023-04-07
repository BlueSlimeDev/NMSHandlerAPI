package me.blueslime.inventoryhandlerapi.listener;

import me.blueslime.inventoryhandlerapi.InventoryHandlerAPI;
import me.blueslime.inventoryhandlerapi.event.CustomInventoryClickEvent;
import me.blueslime.inventoryhandlerapi.inventory.CustomInventory;
import me.blueslime.inventoryhandlerapi.item.InventoryItem;
import me.blueslime.inventoryhandlerapi.item.nbt.ItemNBT;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class PlayerInteractListener implements Listener {
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.PHYSICAL)) {
            return;
        }

        ItemStack item = event.getPlayer().getItemInHand();

        String tag = ItemNBT.fromString(item, "iha-blockedItem");
        if (tag != null && !tag.isEmpty()) {
            event.setCancelled(true);
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void executeAction(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.PHYSICAL)) {
            return;
        }

        ItemStack current = event.getPlayer().getItemInHand();

        String invId = ItemNBT.fromString(current, "iha-name");

        if (invId == null || invId.isEmpty()) {
            return;
        }

        CustomInventory customInventory = InventoryHandlerAPI.getInventories().get(invId);

        String tag = ItemNBT.fromString(current, "ihi-" + customInventory.getId());

        if (tag != null && !tag.isEmpty()) {

            InventoryItem inventoryItem = customInventory.getItemStorage().get(tag);

            if (inventoryItem != null && inventoryItem.getAction() != null) {

                Predicate<CustomInventoryClickEvent> predicate = inventoryItem.getAction().getClickEvent();

                if (predicate != null) {
                    event.setCancelled(
                            predicate.test(
                                    new CustomInventoryClickEvent(
                                            event.getPlayer(),
                                            tag
                                    )
                            )
                    );
                }
            }
        }
    }
}
