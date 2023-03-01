package me.blueslime.menuhandlerapi.inventory;

import me.blueslime.menuhandlerapi.inventory.item.DefaultItemBuilder;
import me.blueslime.menuhandlerapi.item.InventoryItem;
import me.blueslime.menuhandlerapi.utils.storage.PluginStorage;
import org.bukkit.entity.Player;

import java.util.Collection;

public abstract class CustomInventory {
    private final PluginStorage<String, InventoryItem> itemStorage = PluginStorage.initAsHash();
    private InventoryItemBuilder itemBuilder = new DefaultItemBuilder();

    private final String id;

    public CustomInventory(String id) {
        this.id = id;
    }

    public void setItemBuilder(InventoryItemBuilder itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public abstract void fillBorders();
    public abstract void fillRows();

    /**
     * Remove all items from the inventory.
     */
    public void removeItems() {
        itemStorage.clear();
    }

    public void addItem(InventoryItem inventoryItem) {
        itemStorage.set(
                inventoryItem.getIdentifier(),
                inventoryItem
        );
    }

    public PluginStorage<String, InventoryItem> getItemStorage() {
        return itemStorage;
    }

    public Collection<InventoryItem> getItemList() {
        return itemStorage.getValues();
    }

    public abstract void setInventory(Player player, boolean clearInventory);

    public InventoryItemBuilder getItemBuilder() {
        return itemBuilder;
    }

    public String getId() {
        return id;
    }
}
