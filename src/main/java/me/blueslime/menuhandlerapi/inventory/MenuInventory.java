package me.blueslime.menuhandlerapi.inventory;

import me.blueslime.menuhandlerapi.inventory.item.DefaultItemBuilder;
import me.blueslime.menuhandlerapi.item.MenuItem;
import me.blueslime.menuhandlerapi.utils.storage.PluginStorage;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

import java.util.Collection;

public abstract class MenuInventory implements InventoryHolder {
    private final PluginStorage<String, MenuItem> itemStorage = PluginStorage.initAsHash();
    private InventoryItemBuilder itemBuilder = new DefaultItemBuilder();

    private final String id;

    public MenuInventory(String id) {
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

    public void addItem(MenuItem menuItem) {
        itemStorage.set(
                menuItem.getIdentifier(),
                menuItem
        );
    }

    public PluginStorage<String, MenuItem> getItemStorage() {
        return itemStorage;
    }

    public Collection<MenuItem> getItemList() {
        return itemStorage.getValues();
    }

    public abstract void openInventory(Player player);

    public InventoryItemBuilder getItemBuilder() {
        return itemBuilder;
    }

    public abstract String getTitle();

    public abstract int getRows();

    public abstract boolean canIntroduceItems();

    public String getId() {
        return id;
    }
}
