package me.blueslime.inventoryhandlerapi.listener;

import me.blueslime.inventoryhandlerapi.InventoryHandlerAPI;
import me.blueslime.inventoryhandlerapi.event.CustomInventoryClickEvent;
import me.blueslime.inventoryhandlerapi.inventory.CustomInventory;
import me.blueslime.inventoryhandlerapi.item.InventoryItem;
import me.blueslime.inventoryhandlerapi.item.nbt.ItemNBT;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class InventoryClickListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            ItemStack current = event.getCurrentItem();
            String tag = ItemNBT.fromString(current, "iha-blockedItem");
            if (tag != null && !tag.isEmpty()) {
                event.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void executeAction(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            ItemStack current = event.getCurrentItem();

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
                                                (Player)event.getWhoClicked(),
                                                tag
                                        )
                                )
                        );
                    }
                }
            }
        }

    }
}
