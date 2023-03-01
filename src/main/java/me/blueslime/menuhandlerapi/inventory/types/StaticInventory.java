package me.blueslime.menuhandlerapi.inventory.types;

import me.blueslime.menuhandlerapi.InventoryHandlerAPI;
import me.blueslime.menuhandlerapi.inventory.CustomInventory;
import me.blueslime.menuhandlerapi.item.InventoryItem;
import me.blueslime.menuhandlerapi.item.nbt.ItemNBT;

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
