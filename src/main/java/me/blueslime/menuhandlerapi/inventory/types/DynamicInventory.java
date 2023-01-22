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

import static org.bukkit.Bukkit.createInventory;

public class DynamicInventory extends MenuInventory {
    private final String title;
    private final boolean introduce;
    private final int rows;

    public DynamicInventory(String identifier, String title, int size, boolean introduce) {
        super(identifier);

        this.introduce = introduce;
        this.title     = title;
        this.rows      = SlotHandler.fromSize(size);

        MenuHandlerAPI.getMenus().put(
                identifier,
                this
        );
    }

    private Inventory load(Player player) {
        Inventory inventory = createInventory(
                null,
                rows,
                title
        );

        for (MenuItem item : getItemStorage().getValues()) {
            MenuItem menuItem = getItemBuilder().processItem(
                    player,
                    item
            );

            ItemStack itemStack = menuItem.getItemStack();

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
        return inventory;
    }

    @Override
    public void fillBorders() {

    }

    @Override
    public void fillRows() {

    }

    @Override
    public Collection<MenuItem> getItemList() {
        return getItemStorage().getValues();
    }

    @Override
    public void openInventory(Player player) {
        player.openInventory(
                load(player)
        );
    }

    public boolean canIntroduceItems() {
        return introduce;
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
