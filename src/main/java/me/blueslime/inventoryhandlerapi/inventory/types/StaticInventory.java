package me.blueslime.inventoryhandlerapi.inventory.types;

import me.blueslime.inventoryhandlerapi.InventoryHandlerAPI;
import me.blueslime.inventoryhandlerapi.inventory.CustomInventory;
import me.blueslime.inventoryhandlerapi.item.InventoryItem;
import me.blueslime.inventoryhandlerapi.item.nbt.ItemNBT;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StaticInventory extends CustomInventory {
    public StaticInventory(String identifier) {
        super(identifier);

        InventoryHandlerAPI.getInventories().put(
                identifier,
                this
        );
    }

    private void load(Player player, boolean clearInventory) {
        if (clearInventory) {
            player.getInventory().clear();
        }
        for (InventoryItem item : getItemStorage().getValues()) {
            InventoryItem inventoryItem = getItemBuilder().processItem(
                    null,
                    item
            );

            ItemStack itemStack = inventoryItem.getItemStack();

            itemStack = ItemNBT.addString(
                    itemStack, "iha-identifier",
                    getId()
            );

            itemStack = ItemNBT.addString(
                    itemStack, "ihi-" + getId(),
                    inventoryItem.getIdentifier()
            );

            itemStack = ItemNBT.addString(
                    itemStack, "iha-name",
                    getId()
            );

            if (inventoryItem.isBlocked()) {
                itemStack = ItemNBT.addString(
                        itemStack,
                        "iha-blockedItem",
                        "true"
                );
            }
            player.getInventory().setItem(
                    inventoryItem.getSlot(),
                    itemStack
            );
        }
        player.updateInventory();
    }


    @Override
    public void fillBorders() {

    }

    @Override
    public void fillRows() {

    }

    @Override
    public void setInventory(Player player, boolean clearInventory) {
        load(player, clearInventory);
    }

}
