package me.blueslime.menuhandlerapi.inventory.types;

import me.blueslime.menuhandlerapi.MenuHandlerAPI;
import me.blueslime.menuhandlerapi.inventory.MenuInventory;
import me.blueslime.menuhandlerapi.item.MenuItem;
import me.blueslime.menuhandlerapi.item.nbt.ItemNBT;
import me.blueslime.menuhandlerapi.utils.SlotHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Collections;

import static org.bukkit.Bukkit.createInventory;

public class StaticInventory extends MenuInventory {
    private final Inventory inventory;

    private final String title;

    private final boolean introduce;
    private final int rows;

    public StaticInventory(String identifier, String title, int size, boolean introduce) {
        super(identifier);
        this.inventory = createInventory(
                null,
                SlotHandler.fromSize(size),
                title
        );
        this.introduce = introduce;
        this.title = title;
        this.rows = SlotHandler.fromSize(size);

        MenuHandlerAPI.getMenus().put(
                identifier,
                this
        );
    }

    private void load() {
        inventory.clear();

        for (MenuItem item : getItemStorage().getValues()) {
            MenuItem menuItem = getItemBuilder().processItem(
                    null,
                    item
            );

            ItemStack itemStack = menuItem.getItemStack();

            itemStack = ItemNBT.addString(
                    itemStack, "mhm-identifier",
                    getId()
            );

            itemStack = ItemNBT.addString(
                    itemStack, "mhi-" + getId(),
                    menuItem.getIdentifier()
            );

            itemStack = ItemNBT.addString(
                    itemStack, "mhm-name",
                    getId()
            );

            if (menuItem.isBlocked()) {
                itemStack = ItemNBT.addString(
                        itemStack,
                        "mha-blockedItem",
                        "true"
                );
            }

            inventory.setItem(
                    menuItem.getSlot(),
                    itemStack
            );
        }
    }

    public boolean canIntroduceItems() {
        return introduce;
    }


    @Override
    public void fillBorders() {

    }

    @Override
    public void fillRows() {

    }

    @Override
    public void openInventory(Player player) {
        load();
        player.openInventory(inventory);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getRows() {
        return rows;
    }

}
