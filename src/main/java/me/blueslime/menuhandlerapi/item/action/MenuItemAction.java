package me.blueslime.menuhandlerapi.item.action;

import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Predicate;

public class MenuItemAction {

    private Predicate<InventoryClickEvent> clickEvent;

    public MenuItemAction(Predicate<InventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public void setClickEvent(Predicate<InventoryClickEvent> clickEvent) {
        this.clickEvent = clickEvent;
    }

    public Predicate<InventoryClickEvent> getClickEvent() {
        return clickEvent;
    }
}
