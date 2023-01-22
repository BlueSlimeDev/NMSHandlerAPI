package me.blueslime.menuhandlerapi.listener;

import me.blueslime.menuhandlerapi.MenuHandlerAPI;
import me.blueslime.menuhandlerapi.inventory.MenuInventory;
import me.blueslime.menuhandlerapi.item.MenuItem;
import me.blueslime.menuhandlerapi.item.nbt.ItemNBT;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class InventoryClickListener implements Listener {


    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            ItemStack current = event.getCurrentItem();
            String tag = ItemNBT.fromString(current, "mha-blockedItem");
            if (tag != null && !tag.isEmpty()) {
                event.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void executeAction(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            ItemStack current = event.getCurrentItem();

            String menuId = ItemNBT.fromString(current, "mhm-name");

            if (menuId == null || menuId.isEmpty()) {
                return;
            }

            MenuInventory menu = MenuHandlerAPI.getMenus().get(menuId);

            if (event.getSlot() != event.getRawSlot() && !menu.canIntroduceItems()) {
                event.setCancelled(true);
            }

            String tag = ItemNBT.fromString(current, "mhi-" + menu.getId());

            if (tag != null && !tag.isEmpty()) {

                MenuItem menuItem = menu.getItemStorage().get(tag);

                if (menuItem != null && menuItem.getAction() != null) {

                    Predicate<InventoryClickEvent> predicate = menuItem.getAction().getClickEvent();

                    if (predicate != null) {
                        event.setCancelled(predicate.test(event));
                    }
                }
            }
        }

    }
}
